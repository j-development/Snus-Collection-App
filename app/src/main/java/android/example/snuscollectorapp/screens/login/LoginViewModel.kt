package android.example.snuscollectorapp.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


enum class LoginState {
    NONE,
    LOGIN,
    CREATE,

}
class LoginViewModel: ViewModel() {
    private var _actionState = MutableLiveData<LoginState>()
    val actionState : LiveData<LoginState>
        get() = _actionState

    init {
        _actionState.value = LoginState.NONE
    }
    fun onLogin() {
        _actionState.value = LoginState.LOGIN
    }
    fun onCreateLogin(){
        _actionState.value = LoginState.CREATE

    }
    fun onLoginStateActionComplete() {
        _actionState.value = LoginState.NONE
    }
}

