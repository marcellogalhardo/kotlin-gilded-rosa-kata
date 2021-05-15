object ItemsModifierFactory {

    fun make(item: Item): ItemModifier {
        return when (item.name) {
            "Sulfuras, Hand of Ragnaros" -> Sulfuras(item)
            "Backstage passes to a TAFKAL80ETC concert" -> Backstage(item)
            "Aged Brie" -> Aged(item)
            "Conjured Mana Cake" -> Conjured(item)
            else -> Default(item)
        }
    }
}