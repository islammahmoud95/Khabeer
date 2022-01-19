package com.task.domain.usecases

import com.task.domain.repositories.PayRollRepository

class PayRollUseCases (val repository: PayRollRepository) {

    suspend operator fun invoke() = repository.GetPayroll()


}