package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.BLACK))

        val btn = findViewById<Button>(R.id.button10)
        btn.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

    }
}