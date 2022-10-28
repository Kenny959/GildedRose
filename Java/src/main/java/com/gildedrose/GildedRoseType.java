package com.gildedrose;

public enum GildedRoseType {
    BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT("Backstage passes to a TAFKAL80ETC concert"), AGED_BRIE("Aged Brie"), SULFURAS_HAND_OF_RAGNAROS("Sulfuras, Hand of Ragnaros"), CONJURED_MANA_CAKE("Conjured Mana Cake"), NORMAL("normal");

    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;
    public final String label;

    GildedRoseType(String typeLabel) {
        this.label = typeLabel;
    }

    public static GildedRoseType of(String name) {
        for (GildedRoseType type : values()) {
            if (type.label.equals(name)) {
                return type;
            }
        }
        return NORMAL;
    }
}
