package cu.challenges.jesus.shopifychallenge.domain

class Option {
    var id : Long = -1
    var product_id : Long = -1
    var name : String = ""
    var position : Int = 0
    var values : Array<String> = emptyArray()
}