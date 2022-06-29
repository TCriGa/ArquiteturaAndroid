package br.com.zup.exercicioaula55.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.zup.exercicioaula55.databinding.ActivityHomeBinding
import br.com.zup.exercicioaula55.model.HomeModel
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
        observable()

    }


    private fun observable(){

        viewModel.response.observe(this){
            binding.editDados.setText(it.information)
            binding.switchInformacoes.isChecked = viewModel.getFavoriteInformation(it.information)
            binding.switchInformacoes.setOnCheckedChangeListener { _, isChecked ->
                viewModel.saveInformation(it.information,isChecked)

            }
        }
    }
}