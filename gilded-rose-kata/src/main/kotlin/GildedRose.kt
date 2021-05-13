class GildedRose(val items: List<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            if (item.name == "Sulfuras, Hand of Ragnaros") return

            item.sellIn--

            if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                if (item.sellIn < 0) {
                    item.quality = 0
                    return
                }

                if (item.sellIn < 5) {
                    item.quality++
                }

                if (item.sellIn < 10) {
                    item.quality++
                }

                item.quality++

                return
            }

            if (item.name == "Aged Brie") {
                if (item.quality == 50) return
                if (item.sellIn < 0) {
                    item.quality++
                }
                item.quality++
            } else if (item.quality > 0) {
                if (item.sellIn < 0) {
                    item.quality--
                    if (item.name == "Conjured Mana Cake") item.quality--
                }
                item.quality--
                if (item.name == "Conjured Mana Cake") item.quality--
            }
        }
    }

}
