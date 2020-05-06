package com.kaungmyatmin.customrecycleradapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<M>(
    private val view: View
) : RecyclerView.ViewHolder(view) {

    fun bindData(data: M) {
        populateUi(data)
        setListeners(data)
    }

    protected abstract fun populateUi(data: M)

    protected abstract fun setListeners(data: M)
}