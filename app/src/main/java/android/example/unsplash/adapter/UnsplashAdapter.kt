package android.example.unsplash.adapter

import android.example.unsplash.R
import android.example.unsplash.fragments.ListFragment
import android.example.unsplash.models.UnsplashResponseItem
import android.example.unsplash.models.Urls
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UnsplashAdapter: RecyclerView.Adapter<UnsplashAdapter.MyViewHolder>() {

    private var myPhotosList = listOf<UnsplashResponseItem>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var userName: TextView =itemView.findViewById(R.id.tvName)
        var author: TextView =itemView.findViewById(R.id.tvAuthor)
        var image: ImageView =itemView.findViewById(R.id.ivProfileImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.author.text = "${myPhotosList[position].user.firstName} " +
                "${myPhotosList[position].user.lastName }"
        holder.userName.text = myPhotosList[position].user.username
        Glide.with(holder.itemView.context)
            .load(myPhotosList[position].urls.smallS3)
            .dontAnimate()
            .into(holder.image)
        holder.itemView.apply {
            setOnClickListener{
                onItemClickListener?.let {it(myPhotosList[position].urls)}
            }
        }
    }

    override fun getItemCount(): Int {
        return myPhotosList.size
    }

    fun setData(newList: List<UnsplashResponseItem>){
        myPhotosList = newList
        notifyDataSetChanged()
    }

    private var onItemClickListener: ((Urls) -> Unit)? = null

    fun setOnItemClickListener(listener: (Urls) -> Unit){
        onItemClickListener = listener
    }



}