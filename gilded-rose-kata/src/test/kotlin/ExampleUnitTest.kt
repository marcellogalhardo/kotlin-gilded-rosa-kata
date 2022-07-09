import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Example local unit test, which will execute on the development machine (host).
 */
class ExampleUnitTest {

    @Test(expected = IllegalArgumentException::class)
    fun itemQuality_isInvalid() {
        Item("mango", sellIn = 5, quality = -1)
        //primeiro teste foi garantir que a qualidade do item não pode ser negativa como dito no enunciado
        // feito teste adicionei um require quality > 0
    }

    @Test
    fun itemQuality_isCorrect() {
        val result = Item(name = "mango", sellIn = 5, quality = 0)

        assertEquals(expected = result.quality, actual = 0)
        // esse teste corrige o require quality > 0 invés de >= 0
    }

    @Test
    fun sulfurasQuality_neverDecrease() {
        val items = listOf(Item(name = "sulfuras", sellIn = 5, quality = 80))

        val rose = GildedRose(items)
        // ao tentar usar o run For quebrou o teste, alterei para internal
        rose.runFor(3)

        // teste falhou pois não existe só "sulfuras" passei a usar contains
        assertEquals(items.first().quality, 80)
    }

    @Test
    fun sulfurasSellIn_neverDecrease() {
        val items = listOf(Item(name = "sulfuras", sellIn = 5, quality = 80))

        val rose = GildedRose(items)

        rose.runFor(days = 3)

        assertEquals(items.first().sellIn, 5)
    }

    @Test(expected = IllegalStateException::class)
    fun itemQuality_maximum_value_for_normal_item_is50() {
        Item(name = "mango", sellIn = 5, quality = 80)
    }

    @Test
    fun normalItem_after_sellin_degrades_twice_as_fast() {
        // aqui como o teste quebrou inicialmente, adicionei a variavel degrade
        val items = listOf(Item(name = "Normal item", sellIn = 4, quality = 40, degrade = 1))

        val rose = GildedRose(items)

        rose.runFor(days = 8)

        assertEquals(items.first().quality, 28)
    }

    @Test
    fun conjuredItemQuality_degrade_twice_as_fast_as_normal_item() {
        // aqui como o teste quebrou inicialmente, adicionei a variavel degrade
        val items = listOf(Item(name = "conjured", sellIn = 5, quality = 50, degrade = 2))

        val rose = GildedRose(items)

        rose.runFor(days = 5)

        assertEquals(items.first().quality, 40)
    }

    @Test
    fun agedItemQuality_increase_quality_by_one_each_day() {
        val items = listOf(Item(name = "Aged Brie", sellIn = 5, quality = 40, degrade = 2))

        val rose = GildedRose(items)

        rose.runFor(days = 5)

        assertEquals(items.first().quality, 45)
    }

    @Test
    fun passesItem_go_to_zero_quality_after_concert() {

        val items = listOf(
            Item(
                name = "Backstage passes to a TAFKAL80ETC concert",
                sellIn = 4,
                quality = 40,
                type = ItemType.Passes
            )
        )

        val rose = GildedRose(items)

        rose.runFor(days = 5)

        assertEquals(items.first().quality, 0)
    }

    @Test
    fun allPassesItem_go_to_zero_quality_after_concert() {
        // fiz esse p começar o refactor de parar de comparar por string
        val items =
            listOf(Item(name = "Random Backstage passes", sellIn = 4, quality = 40, type = ItemType.Passes))

        val rose = GildedRose(items)

        rose.runFor(days = 5)

        assertEquals(items.first().quality, 0)
    }


    @Test
    fun conjuredItemQuality_degrade_twice_as_fast_as_normal_item_after_sellin() {
        // aqui como o teste quebrou inicialmente, adicionei a variavel degrade
        val items = listOf(Item(name = "conjured", sellIn = 5, quality = 50, degrade = 2, type = ItemType.Conjured))

        val rose = GildedRose(items)

        rose.runFor(days = 10)

        assertEquals(items.first().quality, 20)
    }
}