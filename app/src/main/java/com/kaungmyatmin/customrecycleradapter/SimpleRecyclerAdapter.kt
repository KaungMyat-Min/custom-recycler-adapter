package com.kaungmyatmin.customrecycleradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


open class SimpleRecyclerAdapter<M>(
    private val inferredClass: Class<*>,
    private val delegate: BaseDelegate? = null,
    private val factory: ((view: View) -> BaseViewHolder<M>)? = null
) : BaseAdapter<M>()
    , MyAdapter<M> by MyAdapterImpl<M>(inferredClass, delegate, factory) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<M> {
        val resId = getLayoutId()
        val view = LayoutInflater.from(parent.context).inflate(resId, parent, false)

        return createViewHolder(view)
            ?: createViewHolderByFactory(view)
            ?: createViewHolderByReflection(view)

    }

}
