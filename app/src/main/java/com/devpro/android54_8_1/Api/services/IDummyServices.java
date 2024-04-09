package com.devpro.android54_8_1.Api.services;

import androidx.constraintlayout.widget.ConstraintSet;

import com.devpro.android54_8_1.objects.AllProductResponse;
import com.devpro.android54_8_1.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IDummyServices {
    @GET(Constant.GET_ALL_PRODUCT_API)
    Call<AllProductResponse> getAllProduct();
}
