class Aged(item: Item): Default(item) {

    override fun updateQuality() {
        if (item.quality == 50) return
        if (item.sellIn <= 0) {
            item.quality++
        }
        item.quality++
    }
}