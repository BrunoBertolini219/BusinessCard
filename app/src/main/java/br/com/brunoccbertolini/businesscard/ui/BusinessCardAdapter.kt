package br.com.brunoccbertolini.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.brunoccbertolini.businesscard.R
import br.com.brunoccbertolini.businesscard.data.BusinessCard
import br.com.brunoccbertolini.businesscard.databinding.CardItemBinding

class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}


    inner class ViewHolder(
        private val binding: CardItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BusinessCard) {
            binding.tvName.text = item.nome
            binding.tvEmail.text = item.email
            binding.tvCompanyName.text = item.empresa
            binding.tvPhone.text = item.telefone
            binding.mcvBusinessCard.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.mcvBusinessCard.setOnClickListener {
                listenerShare(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CardItemBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffCallback : DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard): Boolean {
        return oldItem.id == newItem.id
    }

}