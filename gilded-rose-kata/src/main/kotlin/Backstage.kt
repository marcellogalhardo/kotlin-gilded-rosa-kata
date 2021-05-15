class Backstage(item: Item): Default(item) {

    override fun updateQuality() {
        if (item.sellIn <= 0) {
            item.quality = 0
            return
        }

        if (item.sellIn <= 5) {
            item.quality++
        }

        if (item.sellIn <= 10) {
            item.quality++
        }

        item.quality++
    }
}