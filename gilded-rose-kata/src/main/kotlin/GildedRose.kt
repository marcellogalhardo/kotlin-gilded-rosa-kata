class GildedRose(val items: List<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            ItemsModifierFactory.make(item).apply {
                updateQuality()
                updateSellIn()
            }
        }
    }

}
