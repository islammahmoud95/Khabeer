package com.task.domain.entities.model.response.allowences


data class Allowences(
    var position :String?=null,
    val EMP_ID :Int?=null,
    val SAL_COMP_CODE :String?=null,
    val COMP_DESC_AR :String?=null,
    val COMP_DESC_EN :String?=null,
    val SAL_VALUE :String?=null,
    val SAL_COMP_TYPE :String?=null,
    val header :Boolean?=false
)
