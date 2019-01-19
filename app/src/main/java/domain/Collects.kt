package cu.challenges.jesus.shopifychallenge.domain

class Collects {
    var id : Long = -1
    var product_id : Long = -1
}

class CollectsWrapper {
    var collects : Array<Collects> = emptyArray()
}