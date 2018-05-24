package com.kasparpeterson.testingexample.signup.domain

/**
 * Created by kaspar on 24/05/2018.
 */
class IsPasswordValidUseCase {

    fun execute(password: String): Boolean {
        return password.trim().length in 6..12
                && password.any { it.isDigit() }
                && password.any { it.isUpperCase() }
    }

}
