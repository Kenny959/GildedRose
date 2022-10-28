package com.gildedrose;

public class Conjured extends GildedRoseItem {

    public Conjured(Item item) {
        super(item);
    }

    @Override
    protected void handleQuality() {
        decrementQuality();
        decrementQuality();
    }

    @Override
    protected void handleSellIn() {
        if (isItemExpired()) {
            decrementQuality();
            decrementQuality();
        }
    }
}
