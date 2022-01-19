package com.task.data.api

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("Accept", "application/json")
        request.addHeader("Authorization", "Bearer "
                +"KW4dg3PfeWmKL46R1QRjSpzRFq3Vh_MuLRH9CUScVqL5mR3K7m86GypCcvlY1OvIgCehV_BumyvaFUhuxt8Tp94XW2njXC76Zafmlft8cKrpY9AxsS7ubk4SNSzWWFu7kVcqINNuu50lev5nxWv679OqGRNwrewre0YnQTqCq7nTpm_V3H4OuM36lnJyl_D5H71VjZw4uALdWtmvDjKQd9A79KkdAdvmldsw2BxKNzCAWKKvisQ5ufliloHANYBqkxNZleu2kH2hHiMArU6Nsq1vyV-X9WvUpcUBc8KVq48k0Hku1INF8y7RhDtVLB_K1MPub8rRKEuVl7PTw8g0b_-wEvTRcquboGcEpDE9qzaOwXIcM7Iv9j9mMm-FpEKm484doWCKZj56-ORD4zWhCqo4Ty5L4g32dbVdU7SmDmZLcM3f4MEEUbE7Cm1sw5kzGggXhnu8obVhFKqkXYsU1Vw6gQRggKP56B8NLAYcwm0zrzvQDNaChJPrK6GmcIv4")
        return chain.proceed(request.build())
    }
}