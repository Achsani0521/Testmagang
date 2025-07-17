package com.example.suitmediamagang
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.suitmediamagang.databinding.KeduaBinding

class activity2 : AppCompatActivity() {

    private lateinit var binding: KeduaBinding

    companion object {
        const val EXTRA_NAME = "EXTRA_NAME"
    }

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == activity3.RESULT_CODE && result.data != null) {
            val selectedUserName = result.data?.getStringExtra(activity3.EXTRA_SELECTED_USER)
            binding.tvSelectedUser.text = selectedUserName
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = KeduaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener { finish() }

        binding.tvName.text = intent.getStringExtra(EXTRA_NAME)

        binding.btnChooseUser.setOnClickListener {
            val intent = Intent(this, activity3::class.java)
            resultLauncher.launch(intent)
        }
    }
}