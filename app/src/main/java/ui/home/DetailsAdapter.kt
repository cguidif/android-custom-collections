package cu.challenges.jesus.shopifychallenge.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import cu.challenges.jesus.shopifychallenge.R
import cu.challenges.jesus.shopifychallenge.domain.Product
import cu.challenges.jesus.shopifychallenge.models.DetailsVM

class DetailsAdapter : CustomAdapter<Product, DetailsVM> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsVM {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.details_list_item, parent,false)
        return DetailsVM(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DetailsVM, position: Int) {
        val p = getItem(position)
        holder.mainImage = p.image.src
        holder.name.text = p.title
        holder.updated = p.updated_at
        holder.onStock.text = holder.getString(R.string.onStock) +  p.variants.fold(0L){s, v -> s + v.inventory_quantity}.toString()
        if(holder.images.adapter == null) holder.images.adapter = VariantAdapter(p.image, p.images)
        val adapter = holder.images.adapter as VariantAdapter
        adapter.images = p.images
        adapter.parentImage = p.image
        adapter.submitList(p.variants.toList())
    }
}