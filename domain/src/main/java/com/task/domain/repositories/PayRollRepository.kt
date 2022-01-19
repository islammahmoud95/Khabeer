package com.task.domain.repositories

import com.task.domain.common.Result
import com.task.domain.entities.model.response.payrollrespons.PayRollResponse

import kotlinx.coroutines.flow.Flow

interface PayRollRepository {
    suspend fun GetPayroll() : Result<PayRollResponse>
}