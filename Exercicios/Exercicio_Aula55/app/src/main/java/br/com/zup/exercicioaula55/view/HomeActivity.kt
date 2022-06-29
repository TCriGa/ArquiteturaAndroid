package br.com.zup.exercicioaula55.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.zup.exercicioaula55.databinding.ActivityHomeBinding
import br.com.zup.exercicioaula55.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindingView()
        binding.buttonSalvar.setOnClickListener {
            viewModel.saveInformation(
                binding.editLogin.text.toString(),
                binding.editPassword.text.toString()
            )
            Toast.makeText(this, "Mensagem Salva", Toast.LENGTH_SHORT).show()
        }
    }

    private fun bindingView() {
        binding.editLogin.setText(viewModel.getLogin())
        binding.editPassword.setText(viewModel.getPassoword())
    }
}