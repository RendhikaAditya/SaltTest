package co.dh.salttest.data.api

import co.dh.salttest.data.api.model.User
import co.dh.salttest.data.modal.LoginModal
import kotlinx.serialization.json.JsonObject
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginApi {
    @POST(ApiConstans.LOGIN_END_POINTS)
    suspend fun login(
        @Body loginModal: LoginModal
    ): User


}