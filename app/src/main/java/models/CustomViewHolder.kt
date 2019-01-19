package cu.challenges.jesus.shopifychallenge.models

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class CustomViewHolder(item : View) : RecyclerView.ViewHolder(item) {
    fun getString(id : Int) : String {
        return itemView.context.getString(id)
    }
}