package co.dh.salttest.data.repository

import co.dh.salttest.data.api.LoginApi
import co.dh.salttest.data.api.model.User
import co.dh.salttest.data.modal.LoginModal
import com.google.gson.Gson
import kotlinx.serialization.json.JsonObject
import javax.inject.Inject

class LoginRepo @Inject constructor(
    private val loginApi: LoginApi
) {
    suspend fun login(email: String, password: String): User {
        val dataModal: LoginModal = LoginModal(email, password)
        return loginApi.login(dataModal)
    }
}