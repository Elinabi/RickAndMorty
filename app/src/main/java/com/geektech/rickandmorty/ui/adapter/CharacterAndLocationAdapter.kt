package com.geektech.rickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android4lesson1dz.databinding.ItemCharacterAndLocationBinding
import com.geektech.rickandmorty.base.BaseDiffUtilItemCallback
import com.geektech.rickandmorty.model.CharacterAndLocationModel

class CharacterAndLocationAdapter :
    ListAdapter<CharacterAndLocationModel, CharacterAndLocationAdapter.ViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

    class ViewHolder(private val binding: ItemCharacterAndLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: CharacterAndLocationModel) {

            Glide.with(binding.itemCharacterImage).load(item.character.image)
                .into(binding.itemCharacterImage)
            binding.itemCharacterName.text = item.character.name
            binding.itemCharacterStatus.text = item.character.status
            binding.itemCharacterGender.text = item.location.dimension
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position  ))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterAndLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

//    object CharacterAndLocationDiffCallBack : DiffUtil.ItemCallback<CharacterModel>() {
//        override fun areItemsTheSame(
//            oldItem: CharacterModel,
//            newItem: CharacterModel,
//        ): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(
//            oldItem: CharacterModel,
//            newItem: CharacterModel,
//        ): Boolean {
//            return oldItem.id == newItem.id
//        }
//    }
}