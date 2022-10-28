package com.gildedrose;

import static com.gildedrose.GildedRoseType.MAX_QUALITY;
import static com.gildedrose.GildedRoseType.MIN_QUALITY;

public abstract class GildedRoseItem {
    Item item;

    protected GildedRoseItem(Item item) {
        this.item = item;
    }

    public void update() {
        handleQuality();
        decrementSellIn();
        handleSellIn();
    }

    abstract void handleQuality();

    abstract void handleSellIn();

    protected boolean isItemExpired() {
        return isSellInBelowThan(0);
    }

    protected boolean isItemQualityAboveMinimumQuality() {
        return item.quality > MIN_QUALITY;
    }

    protected boolean isItemQualityBelowMaximumQuality() {
        return item.quality < MAX_QUALITY;
    }

    protected boolean isSellInBelowThan(int threshold) {
        return item.sellIn < threshold;
    }

    protected void incrementQuality() {
        if (isItemQualityBelowMaximumQuality()) item.quality++;
    }

    protected void decrementQuality() {
        if (isItemQualityAboveMinimumQuality()) item.quality--;
    }

    protected void decrementSellIn() {
        item.sellIn--;
    }
}
