package com.devpro.android54_8_1.Api;

import com.devpro.android54_8_1.Api.services.IDummyServices;

public class ApiUtils {



    public static IDummyServices getDummyServices() {

        return RetrofitClient.getInstances().create(IDummyServices.class);
    }
}
