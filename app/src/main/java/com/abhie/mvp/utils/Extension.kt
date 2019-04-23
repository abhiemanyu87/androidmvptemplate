package com.abhie.mvp.utils

import android.widget.RadioGroup
import androidx.annotation.IdRes
import com.abhie.mvp.custom.view.radiobutton.RadioGroupField
import com.afollestad.vvalidator.checkAttached
import com.afollestad.vvalidator.field.FieldBuilder
import com.afollestad.vvalidator.form.Form
import com.afollestad.vvalidator.getViewOrThrow

/**
 * Extension for validating radio group
 */
fun Form.radiogroup(
    view: RadioGroup,
    name: String? = null,
    builder: FieldBuilder<RadioGroupField>
){
    val newField = RadioGroupField(
        container = container.checkAttached(),
        view = view,
        name = name!!
    )
    builder(newField)
    appendField(newField)
}

fun Form.radiogroup(
    @IdRes id: Int,
    name: String? =null,
    builder: FieldBuilder<RadioGroupField>
) = radiogroup(
    view = container.getViewOrThrow(id),
    name = name,
    builder = builder
)