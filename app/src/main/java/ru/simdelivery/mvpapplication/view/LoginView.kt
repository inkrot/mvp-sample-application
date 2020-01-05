package ru.simdelivery.mvpapplication.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface LoginView: MvpView {
    fun showLoginLoading()
    fun onLoginError(message: String)
    fun onLoginSuccess()
}