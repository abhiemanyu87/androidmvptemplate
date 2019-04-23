package com.abhie.mvp.custom.view.radiobutton

import android.widget.RadioGroup
import com.afollestad.vvalidator.ValidationContainer
import com.afollestad.vvalidator.field.FieldValue
import com.afollestad.vvalidator.field.FormField
import com.afollestad.vvalidator.field.TextFieldValue
import com.med.kipinschool.ui.onboard.step1.view.RadioGroupAssertion

class RadioGroupField(container: ValidationContainer,
                      view: RadioGroup,
                      name: String) : FormField<RadioGroupField, RadioGroup, CharSequence>(container, view, name) {

    init {
        onErrors{view, errors ->
            val firstError = errors.firstOrNull()
            firstError?.let {

            }
        }
    }

    fun Assertion() = assert(RadioGroupAssertion())


    override fun obtainValue(id: Int, name: String): FieldValue<CharSequence>? {
        val currentValue = view.checkedRadioButtonId
        return TextFieldValue(id = id, name = name, value = currentValue.toString())
    }
}