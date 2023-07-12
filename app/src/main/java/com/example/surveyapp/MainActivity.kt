package com.example.surveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.surveyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            btnGiris.setOnClickListener {
                val nameAndSurname = edtNameSurname.text.toString()
                if (nameAndSurname.isNotEmpty()) {
                    val intent = Intent(this@MainActivity, PersonalActivity::class.java)
                    intent.putExtra("nameAndSurname",nameAndSurname)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this@MainActivity, "Ad soyad kısmı boş geçilemez!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}