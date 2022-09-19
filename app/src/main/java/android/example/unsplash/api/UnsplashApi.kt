package android.example.unsplash.api

import android.example.unsplash.models.UnsplashResponse
import android.example.unsplash.models.UnsplashResponseItem
import android.example.unsplash.utils.Constants.ACCESS_TOKEN
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.ArrayList

interface UnsplashApi {

    @GET("photos")
    suspend fun getRandomPhotos(
        @Query("client_id")
        access: String = ACCESS_TOKEN,
        @Query("page")
        page: Int,
        @Query("per_page")
        pageLimit: Int,
        @Query("order_by")
        sort: String
    ): Response<UnsplashResponse>
}