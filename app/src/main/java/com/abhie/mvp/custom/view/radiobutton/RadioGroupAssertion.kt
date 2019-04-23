package com.med.kipinschool.ui.onboard.step1.view

import android.widget.RadioGroup
import com.afollestad.vvalidator.assertion.Assertion

class RadioGroupAssertion : Assertion<RadioGroup, RadioGroupAssertion>() {
    override fun defaultDescription(): String = "Choose one of those, dammit!"

    override fun isValid(view: RadioGroup): Boolean {
        return view.checkedRadioButtonId != -1
    }
}