package com.kaungmyatmin.customrecycleradapter

import android.view.View
import kotlinx.android.synthetic.main.item_test.view.*

@Layout(resId = R.layout.item_test)
class MyViewHolder(
    private val view: View,
    private val delegate: BaseDelegate
) : BaseViewHolder<Info>(view) {
    override fun populateUi(data: Info) {
        view.apply {
            tvTest.text = data.text
        }
    }

    override fun setListeners(data: Info) {

    }
}