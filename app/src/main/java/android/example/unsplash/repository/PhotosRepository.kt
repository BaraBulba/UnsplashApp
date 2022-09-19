package android.example.unsplash.repository

import android.example.unsplash.api.RetrofitInstance
import android.example.unsplash.models.UnsplashResponse
import android.example.unsplash.models.UnsplashResponseItem
import retrofit2.Response

class PhotosRepository {

    suspend fun getRandomPhotos(page: Int, pageLimit: Int, sort: String)
    : Response<UnsplashResponse> {
        return RetrofitInstance.api.getRandomPhotos(page = page, pageLimit = pageLimit, sort = sort)
    }
}