package cu.challenges.jesus.shopifychallenge.models

import android.annotation.SuppressLint
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import cu.challenges.jesus.shopifychallenge.R
import java.net.URI
import java.util.*

class DetailsVM(itemView: View) : CustomViewHolder(itemView) {
    val name : TextView = itemView.findViewById(R.id.details_title)
    val images : RecyclerView = itemView.findViewById(R.id.details_images)
    val onStock : TextView = itemView.findViewById(R.id.details_onStock)

    var mainImage : URI?
        get() = null
        set(value) {
            Picasso.get().load(Uri.parse(value.toString())).into(_mainImage)
        }

    var updated : Date?
        get() = null
        @SuppressLint("SetTextI18n")
        set(value){
            _updated.text = getString(R.string.updated) + CollectionVM.dateFormatter.format(value)
        }

    init {
        images.layoutManager = LinearLayoutManager(itemView.context, RecyclerView.VERTICAL, false)
    }

    private val _updated : TextView = itemView.findViewById(R.id.details_updated)
    private val _mainImage : ImageView = itemView.findViewById(R.id.details_image)
}
