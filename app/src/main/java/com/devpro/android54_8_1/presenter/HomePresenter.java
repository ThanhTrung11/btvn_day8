package com.devpro.android54_8_1.presenter;

import com.devpro.android54_8_1.interactor.HomeInteractor;
import com.devpro.android54_8_1.interfaces.IHomePresenter;
import com.devpro.android54_8_1.interfaces.IHomeView;
import com.devpro.android54_8_1.objects.AllProductResponse;

public class HomePresenter implements IHomePresenter {
    private IHomeView mHomeView;
    private HomeInteractor mHomeInteractor;

    public HomePresenter(IHomeView iHomeView){
        this.mHomeView = iHomeView;
        mHomeInteractor = new HomeInteractor(this);
    }

    public void getAllProduct(){
        mHomeInteractor.getAllProduct();
    }


    @Override
    public void getAllProductSuccess(AllProductResponse response) {
        if (mHomeView != null){
            mHomeView.getAllProductSuccess(response);
        }
    }

    @Override
    public void getAllProductError(String error) {
        if (mHomeView != null){
            mHomeView.getAllProductError(error);
        }
    }

}
