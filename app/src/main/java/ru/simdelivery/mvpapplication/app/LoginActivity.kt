package ru.simdelivery.mvpapplication.app

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.arellomobile.mvp.MvpActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import ru.simdelivery.mvpapplication.storage.DatabaseHelper
import ru.simdelivery.mvpapplication.network.NetworkUtils
import ru.simdelivery.mvpapplication.R
import ru.simdelivery.mvpapplication.network.EchoWebSocketListener
import ru.simdelivery.mvpapplication.presenter.LoginPresenter
import ru.simdelivery.mvpapplication.view.LoginView
import javax.inject.Inject


class LoginActivity : MvpActivity(), LoginView {

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    @Inject
    lateinit var databaseHelper: DatabaseHelper

    @Inject
    lateinit var networkUtils: NetworkUtils

    @Inject
    lateinit var echoWebSocketListener: EchoWebSocketListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        App.component.injectsLoginActivity(this)

        loginButton.setOnClickListener {
            loginPresenter.login(loginTextView.text.toString(), passwordTextView.text.toString())
        }

        // Observable
        /*var dataSource = Observable.create<Int>({ subscriber ->
            for (i in 1..100) {
                Thread.sleep(500)
                subscriber.onNext(i)
            }
            subscriber.onComplete()
        })*/

        // Flowable
        var dataSource = Flowable.create<Int>({ subscriber ->
            for (i in 1..100) {
                Thread.sleep(500)
                subscriber.onNext(i)
            }
            subscriber.onComplete()
        }, BackpressureStrategy.MISSING)

        dataSource
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    Log.d("New value", "$it")
                })
    }

    override fun showLoginLoading() {

    }

    override fun onLoginError(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginSuccess() {
        Toast.makeText(applicationContext, "Успешный вход", Toast.LENGTH_SHORT).show()
    }

}
