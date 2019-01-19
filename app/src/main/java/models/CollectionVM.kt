package cu.challenges.jesus.shopifychallenge.models

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import cu.challenges.jesus.shopifychallenge.R
import java.net.URI
import java.text.SimpleDateFormat
import java.util.*

class CollectionVM(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    val title : TextView = itemView.findViewById(R.id.item_title)
    val content: TextView = itemView.findViewById(R.id.item_description)

    var date : Date
        set(value) {
            _date.text = dateFormatter.format(value)
        }
        get() {
            return dateFormatter.parse(_date.text.toString())
        }
    companion object {
        val dateFormatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                Locale.US)

    }

    var image : URI? = null
        set(value) {
            Picasso.get().load(Uri.parse(value.toString())).into(_image)
        }


    private val _image : ImageView = itemView.findViewById(R.id.item_image)
    private val _date : TextView = itemView.findViewById(R.id.item_date)
}
