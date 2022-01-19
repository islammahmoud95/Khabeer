package com.task.data.api

import com.task.data.api.model.DPayRollResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface APIEndPoint {

    @GET("GetPayroll")
    suspend fun GetPayroll(
    ) : Response<DPayRollResponse>


}