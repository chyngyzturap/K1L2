package com.pharos.k1l2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import java.net.URL

class MainActivity : AppCompatActivity() {

    private var images = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSubmit = findViewById<Button>(R.id.button)
        val img = findViewById<ImageView>(R.id.image_view)
        val editText = findViewById<EditText>(R.id.edit_text)
        val btnRandom = findViewById<Button>(R.id.button_random)

        btnSubmit.setOnClickListener {
            if (!editText?.text.toString().isNullOrBlank()) {
                images.add(editText?.text.toString())
                showToast(editText?.text.toString())
            }
        }

        btnRandom.setOnClickListener {
            if (!images.isNullOrEmpty()) {
                val url = images.random()
                img.loadImage(this, url)
            }
        }
    }
}