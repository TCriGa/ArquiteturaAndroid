package br.com.zup.movieflix.register.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.zup.movieflix.*
import br.com.zup.movieflix.databinding.ActivityRegisterBinding
import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.viewModel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this)[RegisterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bvLogin.setOnClickListener {
            observables()
        }


    }

    private fun getData(): RegisterModel {
        return RegisterModel(
            name = binding.etUserNameRegister.text.toString(),
            password = binding.etPasswordRegister.text.toString(),
            email = binding.etEmailRegister.text.toString(),
            confirmEmail = binding.etConfirmPasswordRegister.text.toString()
        )
    }

    private fun observables() {
        viewModel.authentication(getData())
        viewModel.response.observe(this) {
            if (binding.checkRegister())
                if (binding.etPasswordRegister.text.contentEquals(binding.etConfirmPasswordRegister.text)){
                    Toast.makeText(this, getString(R.string.cadastro_sucesso), Toast.LENGTH_SHORT)
                        .show()
                    clearEditFields()
                }



        }
    }

    private fun ActivityRegisterBinding.checkRegister(): Boolean {

        when {
            etUserNameRegister.text.isEmpty() -> {
                etUserNameRegister.error = NAME_ERROR_MESSAGE
                return false
            }
            etEmailRegister.text.isEmpty() -> {
                etEmailRegister.error = EMAIL_ERROR_MESSAGE
                return false
            }
            etPasswordRegister.text.isEmpty() -> {
                etPasswordRegister.error = PASSWORD_ERROR_MESSAGE
                return false
            }
            etConfirmPasswordRegister.text.isEmpty() -> {
                etConfirmPasswordRegister.error = CONFIRM_PASSWORD_ERROR_MESSAGE
                return false
            }
            !etPasswordRegister.text.contentEquals(etConfirmPasswordRegister.text) -> {
                etPasswordRegister.error = PASSWORDS_DO_NOT_MATCH
                etConfirmPasswordRegister.error = PASSWORDS_DO_NOT_MATCH
            }
        }
        return true
    }

    private fun clearEditFields(){
        binding.etUserNameRegister.text.clear()
        binding.etEmailRegister.text.clear()
        binding.etPasswordRegister.text.clear()
        binding.etConfirmPasswordRegister.text.clear()
    }
}
