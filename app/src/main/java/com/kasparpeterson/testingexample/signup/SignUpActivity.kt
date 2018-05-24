package com.kasparpeterson.testingexample.signup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.kasparpeterson.testingexample.R
import com.kasparpeterson.testingexample.signup.domain.IsPasswordValidUseCase
import com.kasparpeterson.testingexample.signup.domain.IsUsernameValidUseCase
import kotlinx.android.synthetic.main.layout.*

/**
 * Created by kaspar on 24/05/2018.
 */
class SignUpActivity: AppCompatActivity(), SignUpView {

    private lateinit var presenter: SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        presenter = SignUpPresenter(this, IsUsernameValidUseCase(), IsPasswordValidUseCase())
        sign_up_button.setOnClickListener { presenter.onSignUpClicked(
                username_edit_text.text.toString(),
                password_edit_text.text.toString()
        ) }
    }

    override fun showToast(stringRes: Int) {
        Toast.makeText(this, stringRes, Toast.LENGTH_LONG).show()
    }
}
