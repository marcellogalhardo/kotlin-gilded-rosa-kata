class Conjured(item: Item) : Default(item) {

    override fun updateQuality() {
        if (item.quality > 0) {
            if (item.sellIn <= 0) {
                item.quality = item.quality - 2
            }
            item.quality = item.quality - 2
        }
    }
}