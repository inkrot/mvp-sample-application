package ru.simdelivery.mvpapplication.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.simdelivery.mvpapplication.view.LoginView

@InjectViewState
class LoginPresenter: MvpPresenter<LoginView>() {

    fun login(login: String, password: String) {
        if (login.isEmpty()) {
            viewState.onLoginError("Введите логин")
            return
        }
        if (password.isEmpty()) {
            viewState.onLoginError("Введите пароль")
            return
        }

        if (login == "admin" && password == "123") {
            viewState.onLoginSuccess()
        } else viewState.onLoginError("Неправильный логин или пароль")
    }

}