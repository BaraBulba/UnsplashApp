package android.example.unsplash.fragments

import android.example.unsplash.models.UnsplashResponse
import android.example.unsplash.repository.PhotosRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class ListViewModel(
     val repository: PhotosRepository
): ViewModel() {

     val myPhotos: MutableLiveData<Response<UnsplashResponse>> = MutableLiveData()
     val page = 1
     val perPage = 30
     val sort = "popular"

     fun getPhotos(){
          viewModelScope.launch {
               val response = repository
                    .getRandomPhotos(page = page, pageLimit = perPage, sort = sort)
               myPhotos.value = response
          }
     }

}