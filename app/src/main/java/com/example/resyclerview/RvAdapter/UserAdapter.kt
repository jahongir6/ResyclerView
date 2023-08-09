package com.example.resyclerview.RvAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resyclerview.databinding.ItemRvBinding
import com.example.resyclerview.model.User

class UserAdapter(var list: ArrayList<User>,var rvClick: RvClick) :
    RecyclerView.Adapter<UserAdapter.Vh>() {

    inner class Vh(val itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {
        fun onBind(user: User) {
            itemRvBinding.tvName.text = user.name
            itemRvBinding.tvNumber.text = user.number.toString()

            itemRvBinding.root.setOnClickListener {
                rvClick.onClick(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface RvClick{
        fun onClick(user: User)
    }
}
