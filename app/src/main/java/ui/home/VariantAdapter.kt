package cu.challenges.jesus.shopifychallenge.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import cu.challenges.jesus.shopifychallenge.R
import cu.challenges.jesus.shopifychallenge.domain.Image
import cu.challenges.jesus.shopifychallenge.domain.Variant
import cu.challenges.jesus.shopifychallenge.models.VariantVM

class VariantAdapter(
        var parentImage : Image,
        var images : Array<Image>)
    : CustomAdapter<Variant, VariantVM>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VariantVM {
        return VariantVM(LayoutInflater.from(parent.context)
                .inflate(R.layout.variants_item, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: VariantVM, position: Int) {
        val v = getItem(position)
        if(v.image_id == null)
            holder.image = parentImage.src
        else {
            val image = images.find { i -> i.id == v.image_id }
            if(image == null) holder.image = parentImage.src
            else holder.image = image.src
        }
        holder.title.text = v.title
        holder.onStock.text = holder.getString(R.string.onStock) + v.inventory_quantity
        holder.price.text = holder.getString(R.string.price) + v.price
        holder.weight.text = holder.getString(R.string.weight) + v.weight + v.weight_unit
    }
}