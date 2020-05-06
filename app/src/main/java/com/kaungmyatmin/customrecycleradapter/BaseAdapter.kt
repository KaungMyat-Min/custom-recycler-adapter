package com.kaungmyatmin.customrecycleradapter

import androidx.recyclerview.widget.RecyclerView


abstract class BaseAdapter<M> : RecyclerView.Adapter<BaseViewHolder<M>>() {

    private var mData: MutableList<M>? = null

    override fun onBindViewHolder(holder: BaseViewHolder<M>, position: Int) {
        holder.bindData(mData!![position])
    }

    override fun getItemCount(): Int {
        return mData?.size ?: 0
    }

    fun setNewData(newData: List<M>) {
        mData = newData.toMutableList()
        notifyDataSetChanged()
    }

    fun appendNewData(vararg newData: M): Boolean {
        return mData?.let {
            val oldSize = it.size
            it.addAll(newData)
            notifyItemRangeInserted(oldSize, newData.size)
            true
        } ?: false
    }

    fun getItemAt(position: Int): M? {
        return mData?.get(position)
    }

    fun removeData(data: M): Boolean {
        return mData?.let {
            val index = it.indexOfFirst { element -> element?.equals(data) == true }
            removeDataAt(index)
        } ?: false
    }

    fun removeDataAt(index: Int): Boolean {
        return mData?.let {
            if (index >= 0) {
                it.removeAt(index)
                notifyItemRemoved(index)
                true
            } else {
                false
            }
        } ?: false
    }

    fun insertItemAt(data: M, position: Int = 0): Boolean {
        return mData?.let {
            it.add(position, data)
            notifyItemInserted(position)
            true
        } ?: false
    }

    fun clearData() {
        mData?.let {
            val oldSize = it.size
            it.clear()
            notifyItemRangeRemoved(0, oldSize)
        }
    }

    fun getDataList(): List<M>? {
        return mData
    }

}