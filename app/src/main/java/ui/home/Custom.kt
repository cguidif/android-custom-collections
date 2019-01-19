package cu.challenges.jesus.shopifychallenge.ui.home

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import cu.challenges.jesus.shopifychallenge.domain.Identifiable
import cu.challenges.jesus.shopifychallenge.models.CustomViewHolder

abstract class CustomAdapter<T : Identifiable, VH : CustomViewHolder>
    : ListAdapter<T, VH> (
        object : DiffUtil.ItemCallback<T>() {
            override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
                return  oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
                return areItemsTheSame(oldItem, newItem)
            }

        }
){}
