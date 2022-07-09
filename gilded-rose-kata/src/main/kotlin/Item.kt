data class Item(
    val name: String,
    var sellIn: Int,
    var quality: Int,
    val degrade: Int = 1,
    val type: ItemType = ItemType.Normal
) {

    init {
        require(quality >= 0)
        if (quality > 50 && name.contains("sulfuras").not()) {
            error("only special items can have more than 50 of quality")
        }
    }

    override fun toString() = "$name / sell in $sellIn / quality of $quality"

}

enum class ItemType {
    Sulfuras,
    Conjured,
    Passes,
    Normal
}