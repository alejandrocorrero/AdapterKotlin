package com.alejandrocorrero.kotlinprimerproyecto

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main_rv_item.view.*


class MainActivityAdapter(val items: ArrayList<Item>, val listener: (Item) -> Unit, val lst2:
(Item) -> Boolean) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_main_rv_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener, lst2)

    override fun getItemCount() = items.size
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Item, listener: (Item) -> Unit, listener2: (Item) -> Boolean) = with(itemView) {
        lblprueba.text = item.prueba
        setOnClickListener { listener(item) }
        setOnLongClickListener { listener2(item) }

    }
}

