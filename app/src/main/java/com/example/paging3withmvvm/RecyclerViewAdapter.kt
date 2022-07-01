package com.example.paging3withmvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paging3withmvvm.databinding.RecyclerListBinding

class RecyclerViewAdapter : PagingDataAdapter<CharacterData,RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack()) {


    class MyViewHolder(binding: RecyclerListBinding) : RecyclerView.ViewHolder(binding.root){

        val imageView = binding.imageView
        val Name = binding.textTitle
        val Content = binding.textContent


        fun bind(data : CharacterData){
            Name.text = data.name
            Content.text = data.species

            Glide.with(imageView)
                .load(data.image)
                .circleCrop()
                .into(imageView)
        }
    }

    class DiffUtilCallBack: DiffUtil.ItemCallback<CharacterData>() {
        override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name == newItem.name
                    && oldItem.species == newItem.species
        }

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecyclerListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MyViewHolder(binding)
    }

}