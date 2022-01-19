package com.task.data.api.model.response.allowences

import com.squareup.moshi.Json

data class Allowences(
    @field:Json(name = "EMP_ID")
    val EMP_ID :Int?,
    @field:Json(name = "SAL_COMP_CODE")
    val SAL_COMP_CODE :String?,
    @field:Json(name = "COMP_DESC_AR")
    val COMP_DESC_AR :String?,
    @field:Json(name = "COMP_DESC_EN")
    val COMP_DESC_EN :String?,
    @field:Json(name = "SAL_VALUE")
    val SAL_VALUE :String?,
    @field:Json(name = "SAL_COMP_TYPE")
    val SAL_COMP_TYPE :String?
)
