package cu.challenges.jesus.shopifychallenge.domain

import cu.challenges.jesus.shopifychallenge.data.CustomCollectionPageStart
import java.net.URI
import java.util.*

//{
// "id":68424466488,
// "handle":"aerodynamic-collection",
// "title":"Aerodynamic collection",
// "updated_at":"2018-12-17T13:51:58-05:00",
// "body_html":"The top of the line of aerodynamic products all in the same collection.",
// "published_at":"2018-12-17T13:50:07-05:00",
// "sort_order":"best-selling",
// "template_suffix":"",
// "published_scope":"web",
// "admin_graphql_api_id":"gid://shopify/Collection/68424466488",
// "image":{
//              "created_at":"2018-12-17T13:51:57-05:00",
//              "alt":null,
//              "width":300,
//              "height":300,
//              "src":"https://cdn.shopify.com/s/files/1/1000/7970/collections/Aerodynamic_20Cotton_20Keyboard_grande_b213aa7f-9a10-4860-8618-76d5609f2c19.png?v=1545072718"
//          }
// }

class Collection{
    var id : Long = 0
    var handle : String = ""
    var title : String = ""
    var update_at : Date = Date()
    var body_html : String = ""
    var published_at : Date = Date()
    var sort_order : String = ""
    var template_suffix : String = ""
    var published_scope : String = ""
    var admin_graphql_api_id : URI = URI.create("")
    var image : Image = Image()
}

class CollectionWrapper {
    var custom_collections : Array<Collection> = emptyArray()

    @Transient
    var page = CustomCollectionPageStart
}