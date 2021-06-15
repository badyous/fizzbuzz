package fr.mappy.fizzbuzz.domain.form

import fr.mappy.fizzbuzz.data.FormError

object FormControllerHelper {

    fun generateErrorIfExists(
        input1Int: Int?,
        input2Int: Int?,
        input1Str: String?,
        input2Str: String?,
        limit: Int?
    ): FormError? {
        return if (input1Int == null || input2Int == null || input1Str?.isEmpty() == true || input2Str?.isEmpty() == true || limit == null) {
            FormError.EMPTY_FIELD
        } else if (limit == 0) {
            FormError.INPUT_LIMIT_LOWER_OR_EQUALS_ZERO
        } else if (input1Int <= 0 || input2Int <= 0) {
            FormError.INPUT_INT_LOWER_OR_EQUALS_ZERO
        } else if (input1Int == input2Int) {
            FormError.INPUT_INT_EQUALS
        } else if (input1Str == input2Str) {
            FormError.INPUT_STRING_EQUALS
        } else {
            null
        }
    }
}