package com.example.surveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.surveyapp.databinding.ActivityResultsBinding
import com.example.surveyapp.model.Info

class ResultsActivity : AppCompatActivity() {
private lateinit var binding: ActivityResultsBinding
    private var backButtonPressedOnce = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val info = intent.getParcelableExtra("info") as Info?
        with(binding) {
            textViewNameValue.text = info?.person?.nameSurname
            textViewAgeValue.text = info?.person?.age.toString()
            textViewCityValue.text = info?.person?.city
            textViewEmailValue.text = info?.person?.email
            textViewResponse1Value.text = info?.aktivite
            textViewResponse2Value.text = info?.renk
            textViewResponse3Value.text = info?.yemek
            buttonSubmit.setOnClickListener {
                val intent = Intent(this@ResultsActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }

    }
    private var backPressedCount = 0
        override fun onBackPressed() {

            backPressedCount++

            if (backPressedCount == 1) {
                // İlk kez geri tuşuna basıldı
                Toast.makeText(this, "anasayfaya gitmek için tekrar basın", Toast.LENGTH_SHORT).show()
            } else if (backPressedCount == 2) {
                // İkinci kez geri tuşuna basıldı
                // İstediğiniz işlemleri burada yapabilirsiniz
                super.onBackPressed()
                val intent = Intent(this@ResultsActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }
}