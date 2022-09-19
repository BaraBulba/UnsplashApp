package android.example.unsplash.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UnsplashResponseItem(
    @SerializedName("alt_description")
    val altDescription: Any,
    @SerializedName("blur_hash")
    val blurHash: String,
    val categories: List<Any>,
    val color: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("current_user_collections")
    val currentUserCollections: List<Any>,
    val description: String,
    val height: Int,
    val id: String,
    @SerializedName("liked_by_user")
    val likedByUser: Boolean,
    val likes: Int,
    val links: Links,
    @SerializedName("promoted_at")
    val promotedAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    val urls: Urls,
    val user: User,
    val width: Int
): Serializable {

//    override fun hashCode(): Int {
//        var result = id.hashCode()
//        if (urls.isNullOrEmpty()){
//            result = 31 * result + url.hashCode()
//        }
//        return result
//    }
}

