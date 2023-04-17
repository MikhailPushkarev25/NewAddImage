package com.example.newaddimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.LayoutInflaterCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.newaddimage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var adapter = AdapterImages()
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
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 1)
            rcView.adapter = adapter
            btnId.setOnClickListener {
                if (count > 14) count = 0
                val image = Images(array[count], "Номер фото: $count")
                adapter.add(image)
                count++
            }

            btnRemove.setOnClickListener {
                if (count != 0) adapter.remove()
            }
        }
    }
}