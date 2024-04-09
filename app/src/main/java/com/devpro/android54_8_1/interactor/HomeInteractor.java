package com.devpro.android54_8_1.interactor;

import com.devpro.android54_8_1.Api.ApiUtils;
import com.devpro.android54_8_1.Api.services.IDummyServices;
import com.devpro.android54_8_1.interfaces.IHomePresenter;
import com.devpro.android54_8_1.objects.AllProductResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeInteractor {
    private IHomePresenter mHomePresenter;
    private IDummyServices mDummyServices;
    public HomeInteractor(IHomePresenter homePresenter){
            this.mHomePresenter = homePresenter;
            mDummyServices = ApiUtils.getDummyServices();
        }

        public void getAllProduct() {
            mDummyServices.getAllProduct().enqueue(new Callback<AllProductResponse>() {
                @Override
                public void onResponse(Call<AllProductResponse> call, Response<AllProductResponse> response) {
                    if (response.isSuccessful() && response.code() == 200) {
                        if (mHomePresenter != null) {
                            mHomePresenter.getAllProductSuccess(response.body());
                        }
                    } else {
                        if (mHomePresenter != null) {
                            mHomePresenter.getAllProductError(response.message());
                        }
                    }
                }

                @Override
                public void onFailure(Call<AllProductResponse> call, Throwable throwable) {
                    if (mHomePresenter != null) {
                        mHomePresenter.getAllProductError(throwable.getMessage());
                    }
                }
            });
    }
}
