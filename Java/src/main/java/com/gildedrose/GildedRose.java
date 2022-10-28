package com.gildedrose;

import static com.gildedrose.GildedRoseType.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        if (items == null) throw new NullPointerException("Items array is null");

        for (Item item : items) {
            if (item == null) throw new NullPointerException("Item is null");
            else if (item.name == null) throw new NullPointerException("Item name is null");

            GildedRoseType type = of(item.name);


            if (item.quality < MIN_QUALITY) throw new CustomException("Item quality is below 0 which is not allowed");
            else if (item.quality > MAX_QUALITY && type != SULFURAS_HAND_OF_RAGNAROS)
                throw new CustomException("Quality is above 50 which is not allowed (except for SUFLURAS)");
            else if (type == SULFURAS_HAND_OF_RAGNAROS && item.quality != 80)
                throw new CustomException("Item type of SULFURAS with quality different than 80 is not allowed");

            switch (type) {
                case AGED_BRIE:
                    new AgeBrie(item).update();
                    break;
                case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                    new BackStage(item).update();
                    break;
                case SULFURAS_HAND_OF_RAGNAROS:
                    break;
                case CONJURED_MANA_CAKE:
                    new Conjured(item).update();
                    break;
                case NORMAL:
                default:
                    new Normal(item).update();
                    break;
            }
        }
    }
}
