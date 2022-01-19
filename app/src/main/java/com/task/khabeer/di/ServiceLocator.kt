package com.task.khabeer.di

import com.task.data.api.APIEndPoint
import com.task.data.api.NetworkModule
import com.task.data.mapper.APIResponseMapper
import com.task.data.repistories.PayRollRepositoryImp
import com.task.domain.repositories.PayRollRepository


object ServiceLocator {



    val networkModule by lazy {
        NetworkModule()
    }

    @Volatile
    var payRollRepository: PayRollRepository? = null

    fun CreateApiEndPoint(): APIEndPoint {
        synchronized(this) {
            return networkModule!!.createApi()
        }
    }


    fun providePayRollRepo(apiEndPoint: APIEndPoint): PayRollRepositoryImp {
        // useful because this method can be accessed by multiple threads
        synchronized(this) {
            return (payRollRepository ?: CreatePayRollRepository(apiEndPoint)) as PayRollRepositoryImp
        }
    }

    private fun CreatePayRollRepository(apiEndPoint: APIEndPoint): PayRollRepositoryImp {
       //
        val authRepo =
            PayRollRepositoryImp(
                apiEndPoint,
                APIResponseMapper()
            )
        payRollRepository = authRepo
        return authRepo
    }

//


}