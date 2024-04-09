package com.devpro.android54_8_1;

import android.app.SearchManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devpro.android54_8_1.adapter.ProductAdapter;
import com.devpro.android54_8_1.interfaces.IHomeView;
import com.devpro.android54_8_1.objects.AllProductResponse;
import com.devpro.android54_8_1.objects.Product;
import com.devpro.android54_8_1.presenter.HomePresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IHomeView, ProductAdapter.IOnProductItemClickListener {

    private static final String TAG = "MainActivity";
    private RecyclerView rvProduct;
    private HomePresenter mHomePresenter;
    private ProductAdapter mProductAdapter;
    private ArrayList<Product> mListProduct;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

        getAllProduct();
    }

    private void initData() {
        mHomePresenter = new HomePresenter(this);
        mListProduct = new ArrayList<>();
        mProductAdapter = new ProductAdapter(mListProduct);
        mProductAdapter.setCallback(this);
        rvProduct.setAdapter(mProductAdapter);
    }

    public void getAllProduct(){
        mHomePresenter.getAllProduct();
    }

    private void initView() {
        rvProduct = findViewById(R.id.rvProduct);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        rvProduct.setLayoutManager(layoutManager);
    }

    @Override
    public void getAllProductSuccess(AllProductResponse response) {
        mListProduct.clear();
        mProductAdapter.updateData((ArrayList<Product>) response.getProducts());
    }

    @Override
    public void getAllProductError(String error) {
        Log.d(TAG, "getAllProductError: "+error);
    }

    @Override
    public void onShopNowClick(Product product) {
        Toast.makeText(this, ""+product.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFavorite(int position) {
        Product product = mListProduct.get(position);
        product.setFavorite(!product.isFavorite());

        mListProduct.set(position, product);
        mProductAdapter.notifyItemChanged(position);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        SearchManager searchManager =(SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        return true;
    }

}