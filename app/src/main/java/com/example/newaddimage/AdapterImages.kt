package com.example.newaddimage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newaddimage.databinding.ActivityImagesBinding

class AdapterImages: RecyclerView.Adapter<AdapterImages.ImageHolder>() {
    val arrayImage = ArrayList<Images>()
    class ImageHolder(item: View): RecyclerView.ViewHolder(item) {
        var binding = ActivityImagesBinding.bind(item)
        fun bind(image: Images) = with(binding) {
            imId.setImageResource(image.imageId)
            tvText.text = image.nameImages
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_images, parent, false)
        return ImageHolder(view)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(arrayImage[position])
    }

    override fun getItemCount(): Int {
        return arrayImage.size
    }


    fun add(image: Images) {
        arrayImage.add(image)
        notifyDataSetChanged()
    }

    fun remove() {
        arrayImage.clear()
        notifyDataSetChanged()
    }
}