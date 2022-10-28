package com.gildedrose;

public class Normal extends GildedRoseItem {

    public Normal(Item item) {
        super(item);
    }

    @Override
    protected void handleQuality() {
        decrementQuality();
    }

    @Override
    protected void handleSellIn() {
        if (isItemExpired()) decrementQuality();
    }
}
