class GildedRose(
    val items: List<Item>
) {

    fun updateQuality() {
        for (i in 0..items.size - 1) {
            if (items[i].name != "Aged Brie" && items[i].type != ItemType.Passes) {
                if (items[i].quality > 0 && items[i].sellIn > 0) {
                    if (items[i].name.contains("Sulfuras", ignoreCase = true).not()) {
                        items[i].quality = items[i].quality - items[i].degrade
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1

                    if (items[i].type == ItemType.Passes) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }

            if (items[i].name.contains("Sulfuras", ignoreCase = true).not()) {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {

                if (items[i].type != ItemType.Conjured && items[i].type != ItemType.Normal) {
                    if (items[i].name != "Aged Brie") {
                        if (items[i].type != ItemType.Passes) {
                            if (items[i].quality > 0) {
                                if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                    items[i].quality = items[i].quality - 1
                                }
                            }
                        } else {
                            items[i].quality = items[i].quality - items[i].quality
                        }
                    } else {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1
                        }
                    }
                } else {
                    items[i].quality = items[i].quality - items[i].degrade * 2
                }
            }
        }
    }
}