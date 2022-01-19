package com.task.data.api.model

import com.squareup.moshi.Json
import com.task.data.api.model.response.allowences.Allowences
import com.task.data.api.model.response.user.User

data class DPayRollResponse (
    @field:Json(name = "Activation")
    val Activation : Boolean?,
    @field:Json(name = "Success")
    val Success :Boolean?,
    @field:Json(name = "Payroll")
    val Payroll : Payroll?,


)

data class Payroll (
    @field:Json(name = "Employee")
    val Employee : List<User>?,
    @field:Json(name = "Allowences")
    val Allowences : List<Allowences>?,
    @field:Json(name = "Deduction")
    val Deduction : List<Allowences>?,
    @field:Json(name = "Date")
    val Date : String?,

    )



