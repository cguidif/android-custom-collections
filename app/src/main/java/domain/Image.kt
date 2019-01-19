package cu.challenges.jesus.shopifychallenge.domain

import java.net.URI
import java.util.*

//{
//  "created_at":"2018-12-17T13:51:57-05:00",
//  "alt":null,
//  "width":300,
//  "height":300,
//  "src":"https://cdn.shopify.com/s/files/1/1000/7970/collections/Aerodynamic_20Cotton_20Keyboard_grande_b213aa7f-9a10-4860-8618-76d5609f2c19.png?v=1545072718"
//}

class Image {
    var id : Long = -1
    var created_at : Date = Date()
    var updated_at : Date? = null
    var alt : String? = null
    var width : Int = 0
    var height : Int = 0
    var src : URI = URI.create("")
    var admin_graphql_api_id : URI? = null
    var variant_ids : Array<String>? = null
    var position : Int? = null
}