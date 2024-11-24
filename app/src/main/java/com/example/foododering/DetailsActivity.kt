package com.example.foododering

import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.foododering.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private var foodName: String? = null
    private var foodPrice: String? = null
    private var foodImage: String? = null
    private var foodDescription: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBackDetails.setOnClickListener{
            finish()
        }
        foodName = intent.getStringExtra("foodName")
        foodPrice = intent.getStringExtra("foodPrice")
        foodImage = intent.getStringExtra("foodImage")
        foodDescription = intent.getStringExtra("foodDescription")
        with(binding) {
            tvFoodNameDetail.text = foodName
            Glide.with(this@DetailsActivity).load(Uri.parse(foodImage)).into(imageViewfoodImage)
            tvDesciption.text = foodDescription
        }
    }
}