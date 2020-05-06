package com.kaungmyatmin.customrecycleradapter

import android.view.View

class MyAdapterImpl<M>(
    private val inferredClass: Class<*>,
    private val delegate: BaseDelegate? = null,
    private val factory: ((view: View) -> BaseViewHolder<M>)? = null
) : MyAdapter<M> {

    var resId: Int = -1

    override fun createViewHolder(view: View): BaseViewHolder<M>? {
        return null
    }

    override fun createViewHolderByFactory(view: View) = factory?.run { this(view) }

    override fun createViewHolderByReflection(view: View?): BaseViewHolder<M> {
        val viewHolder = if (delegate != null) {
            inferredClass.getConstructor(View::class.java, BaseDelegate::class.java)
                .newInstance(view, delegate)
        } else {
            inferredClass.getConstructor(View::class.java)
                .newInstance(view)
        }
        return viewHolder as BaseViewHolder<M>
    }

    override fun getLayoutId(): Int {
        if (resId < 0) {
            if (inferredClass.isAnnotationPresent(Layout::class.java)) {
                val annotation = inferredClass.getAnnotation(Layout::class.java)!!
                resId = annotation.resId
            } else throw (Throwable("Layout Annotation must be presented on ViewHolder"))
        }

        return resId
    }
}