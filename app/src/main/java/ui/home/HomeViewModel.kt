package cu.challenges.jesus.shopifychallenge.ui.home

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import cu.challenges.jesus.shopifychallenge.data.getProducts
import data.CollectionDataSourceFactory
import cu.challenges.jesus.shopifychallenge.domain.Collection
import cu.challenges.jesus.shopifychallenge.domain.Product

class HomeViewModel : ViewModel() {
    val collections: LiveData<PagedList<Collection>> = LivePagedListBuilder(CollectionDataSourceFactory(),
            (PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(17)
                    .setInitialLoadSizeHint(17)
                    .build()
                    )).build()

    object Details {
        val products : MutableLiveData<List<Product>> = MutableLiveData()
        var selected : Long = 0
            private set

        fun changeDetails(id : Long){
            if(selected == id) return

            Details.products.postValue(emptyArray<Product>().toList())

            object : AsyncTask<Void, Void, Void>(){
                override fun doInBackground(vararg params: Void?): Void? {
                    val products = getProducts(id, null) ?: return null
                    if(products.products.isNullOrEmpty()) return null

                    Details.products.postValue(products.products.toList())
                    return null
                }
            }.execute()
        }
    }


}
