open class Default(val item: Item) : ItemModifier {

    override fun updateQuality() {
        if (item.quality > 0) {
            if (item.sellIn <= 0) {
                item.quality--
                if (item.name == "Conjured Mana Cake") item.quality--
            }
            item.quality--
            if (item.name == "Conjured Mana Cake") item.quality--
        }
    }

    override fun updateSellIn() {
        item.sellIn--
    }
}