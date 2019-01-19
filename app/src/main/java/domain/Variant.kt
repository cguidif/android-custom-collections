package cu.challenges.jesus.shopifychallenge.domain

import java.net.URI
import java.util.*

class Variant : Identifiable {
    override var id : Long = -1
    var product_id : Long = -1
    var title : String = ""
    var price : Float = 0F
    var sku : String = ""
    var position : Int = -1
    var inventory_policy : String = ""
    var compare_at_price : String? = null
    var fulfillment_service : String = ""
    var inventory_management : String? = ""
    var option1 : String? = null
    var option2 : String? = null
    var option3 : String? = null
    var created_at : Date = Date()
    var updated_at : Date = Date()
    var taxable : Boolean = false
    var barcode : String? = null
    var grams : Int = 0
    var image_id : Long? = null
    var weight : Float = 0F
    var weight_unit : String = ""
    var inventory_item_id : Long = 0
    var inventory_quantity : Long = 0
    var old_inventory_quantity : Long = 0
    var requires_shipping : Boolean = false
    var admin_graphql_api_id : URI = URI.create("")
}
