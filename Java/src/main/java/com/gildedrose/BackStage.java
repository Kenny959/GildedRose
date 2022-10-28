package com.gildedrose;

public class BackStage extends GildedRoseItem {

    public BackStage(Item item) {
        super(item);
    }

    @Override
    protected void handleQuality() {
        incrementQuality();
        if (isSellInBelowThan(11)) {
            incrementQuality();
        }

        if (isSellInBelowThan(6)) {
            incrementQuality();
        }
    }

    @Override
    protected void handleSellIn() {
        if (isItemExpired()) {
            item.quality = 0;
        }
    }
}
