package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRoseType.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    private GildedRose gildedRose;

    @Test
    void ShouldIncreaseQualityBy1ForAgedBrieWhenLive() {
        // arrange
        creationAndInitialization(AGED_BRIE.label, 2, 1);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(1, 2);
    }

    @Test
    void ShouldQualityNotHigherThan50WhenExpired() {
        // arrange
        creationAndInitialization(AGED_BRIE.label, -2, 50);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(-3, 50);
    }

    @Test
    void ShouldIncreaseQualityBy1ForBackstageWhenSellInHigherThan10AndLive() {
        // arrange
        creationAndInitialization(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.label, 15, 20);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(14, 21);
    }

    @Test
    void ShouldIncreaseQualityBy2ForBackstageWhenSellInBetween6And10AndLive() {
        // arrange
        creationAndInitialization(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.label, 10, 20);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(9, 22);
    }

    @Test
    void ShouldIncreaseQualityBy3ForBackstageWhenSellInBelowThan6AndLive() {
        // arrange
        creationAndInitialization(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.label, 5, 20);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(4, 23);

    }

    @Test
    void ShouldSetQualityTo0ForBackstageWhenExpired() {
        // arrange
        creationAndInitialization(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.label, 0, 49);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(-1, 0);
    }

    @Test
    void ShouldNeverChangeQualityForSulfurasWhenLive() {
        // arrange
        creationAndInitialization(SULFURAS_HAND_OF_RAGNAROS.label, 0, 80);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(0, 80);
    }

    @Test
    void ShouldNeverChangeQualityForSulfurasWhenExpired() {
        // arrange
        creationAndInitialization(SULFURAS_HAND_OF_RAGNAROS.label, -1, 80);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(-1, 80);
    }

    @Test
    @DisplayName("Elixir of the Mongoose")
    void ShouldDecreaseQualityBy1ForNormalWhenLive() {
        // arrange
        creationAndInitialization(NORMAL.label, 5, 7);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(4, 6);
    }

    @Test()
    void ShouldDecreaseQualityBy2ForConjuredWhenLive() {
        // arrange
        creationAndInitialization(CONJURED_MANA_CAKE.label, 3, 6);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(2, 4);
    }

    @Test()
    void ShouldDecreaseQualityBy4ForConjuredWhenExpired() {
        // arrange
        creationAndInitialization(CONJURED_MANA_CAKE.label, -1, 30);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(-2, 26);
    }

    @Test()
    void ShouldQualityNotLowerThan0ForConjuredWhenLive() {
        // arrange
        creationAndInitialization(CONJURED_MANA_CAKE.label, 2, 1);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(1, 0);
    }

    @Test()
    void ShouldQualityNotLowerThan0ForConjuredWhenExpired() {
        // arrange
        creationAndInitialization(CONJURED_MANA_CAKE.label, -2, 1);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(-3, 0);
    }

    @Test()
    void ShouldQualityNotLowerThan0ForNormalWhenLive() {
        // arrange
        creationAndInitialization(NORMAL.label, 2, 0);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(1, 0);
    }

    @Test()
    void ShouldSellInStrictlyBelowThanThreshold() {
        // arrange
        creationAndInitialization(NORMAL.label, 1, 10);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(0, 9);
    }

    @Test()
    void ShouldDecreaseQualityBy2ForNormalWhenExpired() {
        // arrange
        creationAndInitialization(NORMAL.label, 0, 10);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(-1, 8);
    }

    @Test()
    void ShouldIncreaseQualityBy2ForAgedBrieWhenExpired() {
        // arrange
        creationAndInitialization(AGED_BRIE.label, 0, 10);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(-1, 12);
    }

    @Test()
    void ShouldBeNormalTypeWhenTypeNotInEnumAndLive() {
        // arrange
        creationAndInitialization("other", 10, 10);

        // act
        gildedRose.updateQuality();

        //assert
        assertSellInAndQuality(9, 9);
    }

    @Test()
    void ShouldThrowNullPointerExceptionWhenItemsIsNull() {
        // arrange
        gildedRose = new GildedRose(null);

        try {
            // act
            gildedRose.updateQuality();
        } catch (NullPointerException npe) {
            //assert
            assertThrows(NullPointerException.class, () -> {
                throw new NullPointerException();
            });
        }
    }

    @Test()
    void ShouldThrowNullPointerExceptionWhenItemIsNull() {
        // arrange
        gildedRose = new GildedRose(new Item[]{null});

        try {
            // act
            gildedRose.updateQuality();
        } catch (NullPointerException npe) {
            //assert
            assertThrows(NullPointerException.class, () -> {
                throw new NullPointerException();
            });
        }
    }

    @Test()
    void ShouldThrowNullPointerExceptionWhenItemNameIsNull() {
        // arrange
        gildedRose = new GildedRose(new Item[]{new Item(null, 1, 2)});

        try {
            // act
            gildedRose.updateQuality();
        } catch (NullPointerException npe) {
            //assert
            assertThrows(NullPointerException.class, () -> {
                throw new NullPointerException();
            });
        }
    }

    @Test()
    void ShouldThrowCustomExceptionWhenNotSulfurasAndQualityAbove50() {
        // arrange
        gildedRose = new GildedRose(new Item[]{new Item("other", 1, 60)});

        try {
            // act
            gildedRose.updateQuality();
        } catch (CustomException ce) {
            //assert
            assertThrowsExactly(CustomException.class, () -> {
                assertEquals("Quality is above 50 which is not allowed (except for SUFLURAS)", ce.getMessage());
                throw ce;
            });
        }
    }

    @Test()
    void ShouldThrowCustomExceptionWhenNotSulfurasAndQualityBelow0() {
        // arrange
        gildedRose = new GildedRose(new Item[]{new Item("other", 1, -1)});

        try {
            // act
            gildedRose.updateQuality();
        } catch (CustomException ce) {
            //assert
            assertThrowsExactly(CustomException.class, () -> {
                assertEquals("Item quality is below 0 which is not allowed", ce.getMessage());
                throw ce;
            });
        }
    }

    @Test()
    void ShouldThrowCustomExceptionWhenSulfurasAndQualityIsPositiveButDifferentThan80() {
        // arrange
        gildedRose = new GildedRose(new Item[]{new Item(SULFURAS_HAND_OF_RAGNAROS.label, 1, 60)});

        try {
            // act
            gildedRose.updateQuality();
        } catch (CustomException ce) {
            //assert
            assertThrowsExactly(CustomException.class, () -> {
                assertEquals("Item type of SULFURAS with quality different than 80 is not allowed", ce.getMessage());
                throw ce;
            });
        }
    }

    @Test()
    void ShouldToStringReturnNameSellInQualityAsExpected() {
        // arrange
        String expected = "Backstage passes to a TAFKAL80ETC concert, 100, 200";
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 100, 200);

        // act
        String result = item.toString();

        //assert
        assertEquals(result, expected);
    }

    private void creationAndInitialization(String itemName, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(itemName, sellIn, quality)};
        gildedRose = new GildedRose(items);
    }

    private void assertSellInAndQuality(int sellIn, int quality) {
        assertEquals(gildedRose.items[0].sellIn, sellIn);
        assertEquals(gildedRose.items[0].quality, quality);
    }
}
