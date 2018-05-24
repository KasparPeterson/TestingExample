package com.kasparpeterson.testingexample.signup.domain

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by kaspar on 24/05/2018.
 */
class IsPasswordValidUseCaseTest {

    private lateinit var useCase: IsPasswordValidUseCase

    @Before
    fun setUp() {
        useCase = IsPasswordValidUseCase()
    }

    @Test
    fun execute_empty_returnsFalse() {
        assertFalse(useCase.execute(""))
    }

    @Test
    fun execute_noDigit_returnsFalse() {
        assertFalse(useCase.execute("Validd"))
    }

    @Test
    fun execute_noUpperCase_returnsFalse() {
        assertFalse(useCase.execute("valid1"))
    }

    @Test
    fun execute_tooShort_returnsFalse() {
        assertFalse(useCase.execute("Vali1"))
    }

    @Test
    fun execute_tooLong_returnsFalse() {
        assertFalse(useCase.execute("Abcdabcdabcd1"))
    }

    @Test
    fun execute_valid_returnsTrue() {
        assertTrue(useCase.execute("Valid1"))
    }

}
