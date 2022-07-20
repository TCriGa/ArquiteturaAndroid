package br.com.zup.movieflix

import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.repository.RegisterRepository
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RegisterRepositoryUnitTest {

    lateinit var registerModel: RegisterModel
    lateinit var registerRepository: RegisterRepository
    val userName = "Felipe"
    val email = "felipe.dearaujo@zup.com.br"
    val password = "melhorProfessorDoMundo"

    @Before
    fun beforeView() {
        registerModel =
            RegisterModel(confirmEmail = email, name = userName, password = password, email = email)
        registerRepository = RegisterRepository()
    }

    @Test
    fun `Check validation of RegisterModel Object `() {
        assertEquals(email, registerModel.email)
        assertEquals(userName, registerModel.name)
        assertEquals(password, registerModel.password)
        assertEquals(email, registerModel.confirmEmail)

    }

    @Test
    fun `Check validation of GetData`() {
        assertEquals(registerModel, registerRepository.getData(registerModel))
    }


}