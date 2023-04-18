package com.example.newaddimage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newaddimage.databinding.ActivityEdImagesBinding

class EdImages : AppCompatActivity() {
    lateinit var binding: ActivityEdImagesBinding
    private var countImage = 0;
    private var imageId = R.drawable.img0
    private val array = listOf(
        R.drawable.img0,
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5,
        R.drawable.img6,
        R.drawable.img7,
        R.drawable.img8,
        R.drawable.img9,
        R.drawable.img10,
        R.drawable.img11,
        R.drawable.img12,
        R.drawable.img13,
        R.drawable.img14,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEdImagesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButton()
    }

    private fun initButton() = with(binding){
        btnNextImage.setOnClickListener {
            countImage++
            if (countImage > array.size - 1) countImage = 0
            imageId = array[countImage]
            imNext.setImageResource(imageId)
        }

        btnDone.setOnClickListener {
            val image = Images(imageId, edTitle.text.toString(), edDesc.text.toString())
            val intent = Intent().apply {
                putExtra("image", image)
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}