package cu.challenges.jesus.shopifychallenge.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import cu.challenges.jesus.shopifychallenge.R
import cu.challenges.jesus.shopifychallenge.domain.Collection
import cu.challenges.jesus.shopifychallenge.models.CollectionVM
import ui.home.ARG_collectionId

class CollectionAdapter : PagedListAdapter<Collection, CollectionVM>(
        object : DiffUtil.ItemCallback<Collection>() {
            override fun areItemsTheSame(oldItem: Collection, newItem: Collection): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Collection, newItem: Collection): Boolean {
                return areItemsTheSame(oldItem, newItem)
            }
        }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionVM {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.collection_list_item, parent,false)
        return CollectionVM(view)
    }

    override fun onBindViewHolder(holder: CollectionVM, position: Int) {
        val c = currentList!![position] ?: return
        holder.content.text = c.body_html
        holder.title.text = c.title
        holder.date = c.update_at
        holder.image = c.image.src
        val b = Bundle()
        b.putLong(ARG_collectionId, c.id)
        holder.itemView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_collectionDetails, b))
    }

}