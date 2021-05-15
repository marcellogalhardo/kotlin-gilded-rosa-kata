import org.junit.*
import kotlin.test.Test
import kotlin.test.assertEquals

class GildedRoseTest {

    @Test
    fun `at the end of each day our system lowers sellIn`() {
        val item = Item("Item", 0, 0)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = -1, actual = actualItem.sellIn)
    }

    @Test
    fun `at the end of each day our system lowers quality`() {
        val item = Item("Item", 1, 1)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 0, actual = actualItem.quality)
    }

    @Test
    fun `quality may not be lower than 0`() {
        val item = Item("Item", 0, 0)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 0, actual = actualItem.quality)
    }

    @Test
    fun `once the sellIn date has passed, Quality degrades twice as fast`() {
        val item = Item("Item", 0, 2)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 0, actual = actualItem.quality)
    }

    @Test
    fun `the Quality of an item is never negative`() {
        val item = Item("Item", 1, 0)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 0, actual = actualItem.quality)
    }

    @Test
    fun `Aged Brie actually increases in Quality the older it gets`() {
        val item = Item("Aged Brie", 1, 0)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 1, actual = actualItem.quality)
    }

    @Test
    fun `once the sellIn date has passed, Aged Brie increases in Quality twice as fast`() {
        val item = Item("Aged Brie", 0, 0)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 2, actual = actualItem.quality)
    }

    @Test
    fun `the Quality of Aged Brie is never more than 50`() {
        val item = Item("Aged Brie", 1, 50)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 50, actual = actualItem.quality)
    }

    @Test
    fun `Sulfuras, being a legendary item, never has to be sold`() {
        val item = Item("Sulfuras, Hand of Ragnaros", 1, 1)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 1, actual = actualItem.sellIn)
    }

    @Test
    fun `Sulfuras, being a legendary item, never decreases in Quality`() {
        val item = Item("Sulfuras, Hand of Ragnaros", 1, 1)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 1, actual = actualItem.quality)
    }

    @Test
    fun `Backstage increases in Quality by 1 when there are at least 11 days before the concert`() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 11, 1)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 2, actual = actualItem.quality)
    }

    @Test
    fun `Backstage increases in Quality by 2 when there are 10 days before the concert`() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 10, 1)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 3, actual = actualItem.quality)
    }

    @Test
    fun `Backstage increases in Quality by 2 when there are at least 6 days before the concert`() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 6, 1)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 3, actual = actualItem.quality)
    }

    @Test
    fun `Backstage increases in Quality by 3 when there are 5 days before the concert`() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 5, 1)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 4, actual = actualItem.quality)
    }

    @Test
    fun `Backstage increases in Quality by 3 when there are at least 1 day before the concert`() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 1, 1)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 4, actual = actualItem.quality)
    }

    @Test
    fun `Backstage quality drops to 0 after the concert`() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 0, 1)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 0, actual = actualItem.quality)
    }

    @Test
    fun `Backstage quality stays in 0 after the concert`() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 0, 0)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 0, actual = actualItem.quality)
    }

    @Test
    fun `Conjured items degrade in Quality twice as fast as normal items`() {
        val item = Item("Conjured Mana Cake", 2, 5)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 3, actual = actualItem.quality)
    }

    @Test
    fun `Conjured items degrade in Quality twice as fast as normal items when sellIn is 0`() {
        val item = Item("Conjured Mana Cake", 0, 5)

        val sut = GildedRose(listOf(item))
        sut.updateQuality()

        val actualItem = sut.items.first()

        assertEquals(expected = 1, actual = actualItem.quality)
    }
}