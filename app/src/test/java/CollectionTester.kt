package cu.challenges.jesus.shopifychallenge

import cu.challenges.jesus.shopifychallenge.data.createJsonObject
import cu.challenges.jesus.shopifychallenge.data.getCollectionsResponse
import cu.challenges.jesus.shopifychallenge.data.getProducts
import cu.challenges.jesus.shopifychallenge.domain.CollectionWrapper
import cu.challenges.jesus.shopifychallenge.domain.Product
import org.junit.Assert.*
import org.junit.Test
import java.io.File

class CollectionTester {

    @Test
    fun testGson(){
        val json = File("./src/androidTest/assets/custom_collections.json").readText()
        val g = createJsonObject()
        val wrapper = g.fromJson<CollectionWrapper>(json, CollectionWrapper::class.java)
        assertNotNull(wrapper)
        assertEquals(wrapper.custom_collections.size, 17)
    }

    @Test
    fun testNetwork(){
        val wrapper = getCollectionsResponse(null) ?: return fail()
        wrapper.custom_collections.forEach { println(Pair(it.image.height, it.image.width)) }
        assertNotNull(wrapper)
        assertEquals(wrapper.custom_collections.size, 17)
    }

    @Test
    fun testProduct() {
        val json = createJsonObject()
        val obj = " {  \n" +
                "         \"id\":2759137027,\n" +
                "         \"title\":\"Aerodynamic Concrete Clock\",\n" +
                "         \"body_html\":\"Transition rich vortals\",\n" +
                "         \"vendor\":\"Jenkins, Orn and Blick\",\n" +
                "         \"product_type\":\"Clock\",\n" +
                "         \"created_at\":\"2015-09-23T20:48:54-04:00\",\n" +
                "         \"handle\":\"aerodynamic-concrete-clock\",\n" +
                "         \"updated_at\":\"2018-12-17T13:52:16-05:00\",\n" +
                "         \"published_at\":\"2015-09-23T20:48:54-04:00\",\n" +
                "         \"template_suffix\":null,\n" +
                "         \"tags\":\"Aerodynamic, Clock, Concrete\",\n" +
                "         \"published_scope\":\"web\",\n" +
                "         \"admin_graphql_api_id\":\"gid:\\/\\/shopify\\/Product\\/2759137027\",\n" +
                "         \"variants\":[  \n" +
                "            {  \n" +
                "               \"id\":8041741187,\n" +
                "               \"product_id\":2759137027,\n" +
                "               \"title\":\"Mint green\",\n" +
                "               \"price\":\"4.32\",\n" +
                "               \"sku\":\"\",\n" +
                "               \"position\":1,\n" +
                "               \"inventory_policy\":\"deny\",\n" +
                "               \"compare_at_price\":null,\n" +
                "               \"fulfillment_service\":\"manual\",\n" +
                "               \"inventory_management\":null,\n" +
                "               \"option1\":\"Mint green\",\n" +
                "               \"option2\":null,\n" +
                "               \"option3\":null,\n" +
                "               \"created_at\":\"2015-09-23T20:48:54-04:00\",\n" +
                "               \"updated_at\":\"2018-12-17T13:52:15-05:00\",\n" +
                "               \"taxable\":true,\n" +
                "               \"barcode\":null,\n" +
                "               \"grams\":4917,\n" +
                "               \"image_id\":null,\n" +
                "               \"weight\":4.917,\n" +
                "               \"weight_unit\":\"kg\",\n" +
                "               \"inventory_item_id\":6015629699,\n" +
                "               \"inventory_quantity\":134,\n" +
                "               \"old_inventory_quantity\":134,\n" +
                "               \"requires_shipping\":true,\n" +
                "               \"admin_graphql_api_id\":\"gid:\\/\\/shopify\\/ProductVariant\\/8041741187\"\n" +
                "            },\n" +
                "            {  \n" +
                "               \"id\":8041741251,\n" +
                "               \"product_id\":2759137027,\n" +
                "               \"title\":\"Violet\",\n" +
                "               \"price\":\"76.67\",\n" +
                "               \"sku\":\"\",\n" +
                "               \"position\":2,\n" +
                "               \"inventory_policy\":\"deny\",\n" +
                "               \"compare_at_price\":null,\n" +
                "               \"fulfillment_service\":\"manual\",\n" +
                "               \"inventory_management\":null,\n" +
                "               \"option1\":\"Violet\",\n" +
                "               \"option2\":null,\n" +
                "               \"option3\":null,\n" +
                "               \"created_at\":\"2015-09-23T20:48:54-04:00\",\n" +
                "               \"updated_at\":\"2018-12-17T13:52:16-05:00\",\n" +
                "               \"taxable\":true,\n" +
                "               \"barcode\":null,\n" +
                "               \"grams\":8081,\n" +
                "               \"image_id\":null,\n" +
                "               \"weight\":8.081,\n" +
                "               \"weight_unit\":\"kg\",\n" +
                "               \"inventory_item_id\":931603459,\n" +
                "               \"inventory_quantity\":112,\n" +
                "               \"old_inventory_quantity\":112,\n" +
                "               \"requires_shipping\":true,\n" +
                "               \"admin_graphql_api_id\":\"gid:\\/\\/shopify\\/ProductVariant\\/8041741251\"\n" +
                "            }\n" +
                "         ],\n" +
                "         \"options\":[  \n" +
                "            {  \n" +
                "               \"id\":3321582851,\n" +
                "               \"product_id\":2759137027,\n" +
                "               \"name\":\"Title\",\n" +
                "               \"position\":1,\n" +
                "               \"values\":[  \n" +
                "                  \"Mint green\",\n" +
                "                  \"Violet\"\n" +
                "               ]\n" +
                "            }\n" +
                "         ],\n" +
                "         \"images\":[  \n" +
                "            {  \n" +
                "               \"id\":5641966979,\n" +
                "               \"product_id\":2759137027,\n" +
                "               \"position\":1,\n" +
                "               \"created_at\":\"2015-09-23T20:48:54-04:00\",\n" +
                "               \"updated_at\":\"2015-09-23T20:48:54-04:00\",\n" +
                "               \"alt\":null,\n" +
                "               \"width\":300,\n" +
                "               \"height\":300,\n" +
                "               \"src\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1000\\/7970\\/products\\/Aerodynamic_20Concrete_20Clock.png?v=1443055734\",\n" +
                "               \"variant_ids\":[  \n" +
                "\n" +
                "               ],\n" +
                "               \"admin_graphql_api_id\":\"gid:\\/\\/shopify\\/ProductImage\\/5641966979\"\n" +
                "            }\n" +
                "         ],\n" +
                "         \"image\":{  \n" +
                "            \"id\":5641966979,\n" +
                "            \"product_id\":2759137027,\n" +
                "            \"position\":1,\n" +
                "            \"created_at\":\"2015-09-23T20:48:54-04:00\",\n" +
                "            \"updated_at\":\"2015-09-23T20:48:54-04:00\",\n" +
                "            \"alt\":null,\n" +
                "            \"width\":300,\n" +
                "            \"height\":300,\n" +
                "            \"src\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1000\\/7970\\/products\\/Aerodynamic_20Concrete_20Clock.png?v=1443055734\",\n" +
                "            \"variant_ids\":[  \n" +
                "\n" +
                "            ],\n" +
                "            \"admin_graphql_api_id\":\"gid:\\/\\/shopify\\/ProductImage\\/5641966979\"\n" +
                "         }\n" +
                "      }"
        val product = json.fromJson<Product>(obj, Product::class.java)
        assertNotNull(product)
        assertNotNull(product.variants)
        assertEquals(product.variants.size, 2)
        assertEquals(product.images.size, 1)
    }

    @Test
    fun testProductsArray() {
        val collections  = getCollectionsResponse(null)
        val idSet = HashSet<Long>()
        collections!!.custom_collections.forEach { c ->
            val products = getProducts(c.id, null)

            products!!.products.forEach {p ->
                assertFalse(idSet.contains(p.id))
                idSet.add(p.id)
                assertNotNull(p)
                assertNotNull(p.variants)
            }
        }
    }
}