package com.kasparpeterson.testingexample.signup

import com.kasparpeterson.testingexample.R
import com.kasparpeterson.testingexample.signup.domain.IsPasswordValidUseCase
import com.kasparpeterson.testingexample.signup.domain.IsUsernameValidUseCase

/**
 * Created by kaspar on 24/05/2018.
 */
class SignUpPresenter(
        private val view: SignUpView,
        private val isUsernameValidUseCase: IsUsernameValidUseCase,
        private val isPasswordValidUseCase: IsPasswordValidUseCase
) {

    fun onSignUpClicked(username: String, password: String) {
        if (!isUsernameValidUseCase.execute(username)) {
            view.showToast(R.string.error_username_invalid)
        } else if (!isPasswordValidUseCase.execute(password)) {
            view.showToast(R.string.error_password_invalid)
        } else {
            view.showToast(R.string.sign_up_successful)
        }
    }

}
