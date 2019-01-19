package data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import cu.challenges.jesus.shopifychallenge.domain.Collection

class CollectionDataSourceFactory() :
        DataSource.Factory<Int, Collection>() {
    private val sourceLiveData = MutableLiveData<CollectionDataSource>()
    override fun create(): DataSource<Int, Collection> {
        val source = CollectionDataSource()
        sourceLiveData.postValue(source)
        return source
    }
}