package cu.challenges.jesus.shopifychallenge.models

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import cu.challenges.jesus.shopifychallenge.R
import java.net.URI

class VariantVM(item : View) : CustomViewHolder(item) {
    private val _image : ImageView = item.findViewById(R.id.variant_image)
    val onStock : TextView = item.findViewById(R.id.variant_onStock)
    val title : TextView = item.findViewById(R.id.variant_title)
    val weight : TextView = item.findViewById(R.id.variant_weight)
    val price : TextView = item.findViewById(R.id.variant_price)

    var image : URI?
        get() = null
        set(value) {
            Picasso.get().load(Uri.parse(value.toString())).into(_image)
        }
}