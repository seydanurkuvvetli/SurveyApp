package com.example.surveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.surveyapp.databinding.ActivityPersonalBinding
import com.example.surveyapp.model.Person

class PersonalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersonalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityPersonalBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding){
            val message = intent.getStringExtra("nameAndSurname")
            txtName.text=message
           btnSave.setOnClickListener {
               val email = edtEmail.text.toString()
               val city = edtCity.text.toString()
               val age = edtAge.text.toString()
               val namesurname = message.toString()
               if (email.isNotEmpty()  && city.isNotEmpty() && age.isNotEmpty()) {
                   val person = Person(namesurname, email, city, age.toInt())
                   val intent = Intent(this@PersonalActivity, CustomActivity::class.java)
                   intent.putExtra("person", person)
                   startActivity(intent)
               }
              else{
                   Toast.makeText(this@PersonalActivity, "alanlar boş geçilemez!", Toast.LENGTH_SHORT).show()
               }
           }
        }
    }
}