package fr.mappy.fizzbuzz.domain

import fr.mappy.fizzbuzz.data.FormError
import org.junit.Assert
import org.junit.Test

class FormControllerHelperTest {

    @Test
    fun checkGeneratedErrors_empty_fields() {
        val error =
            FormControllerHelper.generateErrorIfExists(null, 2, null, "test", 100)
        Assert.assertEquals(error, FormError.EMPTY_FIELD)
    }

    @Test
    fun checkGeneratedErrors_limit_zero() {
        val error =
            FormControllerHelper.generateErrorIfExists(1, 2, "sd", "test", 0)
        Assert.assertEquals(error, FormError.INPUT_LIMIT_LOWER_OR_EQUALS_ZERO)
    }

    @Test
    fun checkGeneratedErrors_input_int_zero() {
        val error =
            FormControllerHelper.generateErrorIfExists(0, 2, "sd", "test", 10)
        Assert.assertEquals(error, FormError.INPUT_INT_LOWER_OR_EQUALS_ZERO)
    }

    @Test
    fun checkGeneratedErrors_input_int_equals() {
        val error =
            FormControllerHelper.generateErrorIfExists(2, 2, "sd", "test", 10)
        Assert.assertEquals(error, FormError.INPUT_INT_EQUALS)
    }

    @Test
    fun checkGeneratedErrors_input_string_equals() {
        val error =
            FormControllerHelper.generateErrorIfExists(1, 2, "test", "test", 10)
        Assert.assertEquals(error, FormError.INPUT_STRING_EQUALS)
    }

    @Test
    fun checkGeneratedErrors_no_error() {
        val error =
            FormControllerHelper.generateErrorIfExists(1, 2, "abc", "test", 10)
        Assert.assertNull(error)
    }
}