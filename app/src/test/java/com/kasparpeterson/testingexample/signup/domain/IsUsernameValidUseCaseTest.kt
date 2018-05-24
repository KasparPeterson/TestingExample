package com.kasparpeterson.testingexample.signup.domain

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by kaspar on 24/05/2018.
 */
class IsUsernameValidUseCaseTest {

    private lateinit var useCase: IsUsernameValidUseCase

    @Before
    fun setUp() {
        useCase = IsUsernameValidUseCase()
    }

    @Test
    fun execute_empty_returnsFalse() {
        assertFalse(useCase.execute(""))
    }

    @Test
    fun execute_tooShort_returnsFalse() {
        assertFalse(useCase.execute("abcde"))
    }

    @Test
    fun execute_blank6_returnsFalse() {
        assertFalse(useCase.execute("      "))
    }

    @Test
    fun execute_tooLong_returnsFalse() {
        assertFalse(useCase.execute("abcdabcdabcde"))
    }

    @Test
    fun execute_valid_returnsTrue() {
        assertTrue(useCase.execute("abcdef"))
    }

}
