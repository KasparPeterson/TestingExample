package com.kasparpeterson.testingexample.signup.domain

/**
 * Created by kaspar on 24/05/2018.
 */
class IsUsernameValidUseCase {

    fun execute(username: String): Boolean {
        return username.trim().length in 6..12
    }

}
