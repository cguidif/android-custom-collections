package data

import androidx.paging.PositionalDataSource
import cu.challenges.jesus.shopifychallenge.data.getCollectionsResponse
import cu.challenges.jesus.shopifychallenge.domain.Collection

class CollectionDataSource : PositionalDataSource<Collection>() {
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Collection>) {
        val  wrapper = getCollectionsResponse(params.startPosition)
                ?: return
        callback.onResult(wrapper.custom_collections.toList())
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Collection>) {
        val wrapper = getCollectionsResponse(null) ?: return

        callback.onResult(wrapper.custom_collections.toList(), wrapper.page)
    }

}