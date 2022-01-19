package com.task.data.repistories

import com.task.domain.repositories.PayRollRepository
import com.task.data.api.APIEndPoint
import com.task.data.mapper.APIResponseMapper
import com.task.domain.common.Result
import com.task.domain.entities.model.response.payrollrespons.PayRollResponse

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import kotlinx.coroutines.flow.Flow


class PayRollRepositoryImp (val apiEndPoint: APIEndPoint,
                            val mapper: APIResponseMapper,
                         )
             : PayRollRepository{
    override suspend fun GetPayroll(): Result<PayRollResponse>
            =  withContext(Dispatchers.IO) {

        try {
            val response = apiEndPoint.GetPayroll()
            if (response.isSuccessful) {
                //     Log.e("xxxxxxxxx",response.body()!!.code.toString())
                return@withContext Result.Success(mapper.ToData(response.body()!!,PayRollResponse::class.java) as PayRollResponse)
            } else {
                return@withContext Result.Error(Exception(response.message()))
            }
        }catch (e:Exception){
            return@withContext Result.Error(e)
        }
    }


}

