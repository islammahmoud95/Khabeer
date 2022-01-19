package com.task.domain.entities.model.response.payrollrespons

import com.task.domain.entities.model.response.allowences.Allowences
import com.task.domain.entities.model.response.user.User


data class PayRollResponse (
    val Activation : Boolean?,
    val Success :Boolean?,
    val Payroll : Payroll?,


)

data class Payroll (
    val Employee : List<User>?,
    val Allowences : List<Allowences>?,
    val Deduction : List<Allowences>?,
    val Date : String?=""
    )



