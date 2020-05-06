package com.kaungmyatmin.customrecycleradapter

import android.view.View

interface MyAdapter<M> {

    fun createViewHolder(view: View): BaseViewHolder<M>?

    fun createViewHolderByFactory(view: View): BaseViewHolder<M>?

    fun createViewHolderByReflection(view: View?): BaseViewHolder<M>

    fun getLayoutId(): Int
}