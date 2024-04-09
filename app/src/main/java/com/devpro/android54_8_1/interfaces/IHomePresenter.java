package com.devpro.android54_8_1.interfaces;

import com.devpro.android54_8_1.objects.AllProductResponse;

public interface IHomePresenter {
    void getAllProductSuccess(AllProductResponse response);
    void getAllProductError(String error);

}
