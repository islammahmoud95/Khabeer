package com.task.khabeer.app

import android.app.Application
import com.task.data.api.APIEndPoint
import com.task.domain.repositories.PayRollRepository
import com.task.domain.usecases.PayRollUseCases
import com.task.khabeer.di.ServiceLocator


class ApplicationApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    val apiEndPoint : APIEndPoint get() = ServiceLocator.CreateApiEndPoint()
    val payRollRepository : PayRollRepository get()= ServiceLocator.providePayRollRepo(apiEndPoint)
    val payRollUseCases : PayRollUseCases get()= PayRollUseCases(payRollRepository)


}