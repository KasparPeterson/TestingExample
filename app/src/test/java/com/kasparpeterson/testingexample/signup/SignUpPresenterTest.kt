package com.kasparpeterson.testingexample.signup

import com.kasparpeterson.testingexample.R
import com.kasparpeterson.testingexample.signup.domain.IsPasswordValidUseCase
import com.kasparpeterson.testingexample.signup.domain.IsUsernameValidUseCase
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by kaspar on 24/05/2018.
 */
@RunWith(MockitoJUnitRunner::class)
class SignUpPresenterTest {

    companion object {
        private val USERNAME = "username"
        private val PASSWORD = "password"
    }

    @Mock
    private lateinit var view: SignUpView

    @Mock
    private lateinit var isUsernameValidUseCase: IsUsernameValidUseCase

    @Mock
    private lateinit var isPasswordValidUseCase: IsPasswordValidUseCase

    private lateinit var presenter: SignUpPresenter

    @Before
    fun setUp() {
        presenter = SignUpPresenter(view, isUsernameValidUseCase, isPasswordValidUseCase)
    }

    @Test
    fun onSignUpClicked_invalidUsername_showsInvalidUsername() {
        `when`(isUsernameValidUseCase.execute(USERNAME)).thenReturn(false)

        presenter.onSignUpClicked(USERNAME, PASSWORD)

        verify(view).showToast(R.string.error_username_invalid)
    }

    @Test
    fun onSignUpCLicked_usernameValidAndPasswordInvalid_showsPasswordInvalid() {
        `when`(isUsernameValidUseCase.execute(USERNAME)).thenReturn(true)
        `when`(isPasswordValidUseCase.execute(PASSWORD)).thenReturn(false)

        presenter.onSignUpClicked(USERNAME, PASSWORD)

        verify(view).showToast(R.string.error_password_invalid)
    }

    @Test
    fun onSignUpCLicked_bothFieldsValid_showsSuccess() {
        `when`(isUsernameValidUseCase.execute(USERNAME)).thenReturn(true)
        `when`(isPasswordValidUseCase.execute(PASSWORD)).thenReturn(true)

        presenter.onSignUpClicked(USERNAME, PASSWORD)

        verify(view).showToast(R.string.sign_up_successful)
    }

}
