package ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cu.challenges.jesus.shopifychallenge.R
import cu.challenges.jesus.shopifychallenge.models.CollectionVM
import cu.challenges.jesus.shopifychallenge.ui.home.DetailsAdapter
import cu.challenges.jesus.shopifychallenge.ui.home.HomeViewModel

const val ARG_collectionId = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [CollectionDetails.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CollectionDetails : Fragment() {
    private var collectionId: Long = -1
    private var viewModel : HomeViewModel? = null
    private var collectionVM : CollectionVM? = null
    private val adapter = DetailsAdapter()
    private var recyclerView :  RecyclerView? = null
    private lateinit var loading : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            collectionId = it.getLong(ARG_collectionId, -1)
        }
        HomeViewModel.Details.changeDetails(collectionId)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        HomeViewModel.Details.products.observe(this, Observer {
            adapter.submitList(it)
            val recyclerView = this.recyclerView
            if(recyclerView != null){
                if(it.isEmpty()) {
                    recyclerView.visibility =  View.GONE
                    loading.visibility = View.VISIBLE
                }
                else {
                    recyclerView.visibility =  View.VISIBLE
                    loading.visibility = View.GONE
                }
            }

        })
        viewModel.collections.observe(this, Observer {
            val collectionVm = this.collectionVM
            if(collectionVm != null) {
                val c = it.first { coll -> coll.id == collectionId }
                collectionVm.image = c.image.src
                collectionVm.title.text = c.title
                collectionVm.content.text = c.body_html
                collectionVm.content.maxLines = 10
                collectionVm.date = c.update_at
            }
        })
        this.viewModel = viewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_collection_details, container, false)
        val recyclerView : RecyclerView = v.findViewById(R.id.details_items)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)
        recyclerView.adapter = adapter
        recyclerView.visibility = View.GONE
        this.recyclerView = recyclerView
        loading = v.findViewById(R.id.progress)
        //--------------------collection-----------------
        collectionVM = CollectionVM(v)
        //--------------------collection-----------------
        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param collectionId the id of the collection to display details.
         * @return A new instance of fragment CollectionDetails.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(collectionId: Int) =
                CollectionDetails().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_collectionId, collectionId)
                    }
                }
    }
}
