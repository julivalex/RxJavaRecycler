package com.kotlin.note.rxjavarecycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_list.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListHolder>() {

    val subject = PublishSubject.create<String>()

    private val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7",
        "Item 8", "Item 9", "Item 10")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() =  items.size

    inner class ListHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                subject.onNext(items[layoutPosition])
            }
        }

        fun bind(text: String) {
            itemView.tvItemText.text = text
        }
    }
}