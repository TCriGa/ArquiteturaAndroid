package br.com.zup.movieflix.register.repository

import br.com.zup.movieflix.register.model.RegisterModel

class RegisterRepository {

    fun getData(register: RegisterModel): RegisterModel? {
      if (register.name.isNotEmpty() &&
            register.password.isNotEmpty() &&
            register.email.isNotEmpty() &&
            register.confirmEmail.isNotEmpty()
        ){
          return register
      }
         return null
    }

}
