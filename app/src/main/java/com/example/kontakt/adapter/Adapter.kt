package com.example.kontakt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kontakt.databinding.ItemRvBinding
import com.example.kontakt.models.User

class Adapter(val list : ArrayList<User>):RecyclerView.Adapter<Adapter.Vh>(){
inner class Vh(var item:ItemRvBinding):ViewHolder(item.root) {

    fun onBind(user: User) {
        item.txtName.text = user.name
        item.txtNumber.text = user.number
    }
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
    return  Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
}