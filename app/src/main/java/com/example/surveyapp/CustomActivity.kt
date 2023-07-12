package com.example.surveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.surveyapp.databinding.ActivityCustomBinding
import com.example.surveyapp.model.Info
import com.example.surveyapp.model.Person

class CustomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding=ActivityCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            val person = intent.getParcelableExtra("person") as Person?

            textView.text =person?.nameSurname
            btnKydt.setOnClickListener {
            val aktivite =edtAktivite .text.toString()
            val yemek =edtYemek.text.toString()
            val renk = edtRenk.text.toString()

                if (aktivite.isNotEmpty() && yemek.isNotEmpty() && renk.isNotEmpty()) {
                    val info = Info(person, aktivite, yemek, renk)
                    val intent = Intent(this@CustomActivity, ResultsActivity::class.java)
                  intent.putExtra("info", info)
                    startActivity(intent)

               } else {
                    Toast.makeText(this@CustomActivity, "boş geçilemez!", Toast.LENGTH_SHORT).show()
               }
            }
        }
    }
}