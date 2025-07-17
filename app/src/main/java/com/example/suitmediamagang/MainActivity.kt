package com.example.suitmediamagang

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import com.example.suitmediamagang.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCheck.setOnClickListener {
            val text = binding.etPalindrome.text.toString()
            if (text.isBlank()) {
                showAlert("Palindrome text cannot be empty.")
                return@setOnClickListener
            }

            val sanitizedText = text.replace("\\s".toRegex(), "").lowercase()
            val isPalindrome = sanitizedText == sanitizedText.reversed()
            val message = if (isPalindrome) "isPalindrome" else "not palindrome"
            showAlert(message)
        }

        binding.btnNext.setOnClickListener {
            val name = binding.etName.text.toString()
            if (name.isBlank()) {
                binding.etName.error = "Name cannot be empty"
                return@setOnClickListener
            }

            val intent = Intent(this, activity2::class.java).apply {
                putExtra(activity2.EXTRA_NAME, name)
            }
            startActivity(intent)
        }
    }

    private fun showAlert(message: String) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}