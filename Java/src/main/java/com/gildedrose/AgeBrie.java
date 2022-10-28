package com.gildedrose;

public class AgeBrie extends GildedRoseItem {

    public AgeBrie(Item item) {
        super(item);
    }

    protected void handleQuality() {
        incrementQuality();
    }

    @Override
    void handleSellIn() {
        if (isItemExpired()) incrementQuality();
    }
}
