package cu.challenges.jesus.shopifychallenge.domain

import java.net.URI
import java.util.*

class Product : Identifiable {
    override var id : Long = -1
    var title :  String = ""
    var body_html : String = ""
    var vendor : String = ""
    var product_type : String = ""
    var created_at : Date = Date()
    var handle : String = ""
    var updated_at : Date = Date()
    var published_at : Date = Date()
    var template_suffix : String? = null
    var tags : String = ""
    var published_scope : String = ""
    var admin_graphql_api_id : URI = URI.create("")
    var variants : Array<Variant> = emptyArray()
    var options : Array<Option> = emptyArray()
    var images : Array<Image> = emptyArray()
    var image : Image = Image()
}

class ProductWrapper {
    var products : Array<Product> = emptyArray()
}