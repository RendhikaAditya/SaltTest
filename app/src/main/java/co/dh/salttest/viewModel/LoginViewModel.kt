package co.dh.salttest.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.dh.salttest.data.api.model.User
import co.dh.salttest.data.repository.LoginRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepo: LoginRepo
) : ViewModel() {
    val _state = MutableStateFlow<User?>(null)
    val state: StateFlow<User?> get() = _state

    fun fetchLogin(email: String, password: String) = viewModelScope.launch {
        val login = loginRepo.login(email, password)
        _state.value = login
    }
}