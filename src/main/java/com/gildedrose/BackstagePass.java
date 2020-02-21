package com.gildedrose;

public class BackstagePass extends MyItem {
    public Item item;

    public BackstagePass(Item item) {
        super(item);
        this.item = item;
    }

    public void ageItem() {

        handleBackstage(this.item);
        item.sellIn = item.sellIn - 1;
    }

    public static void handleBackstage(Item item) {
        if (qualityIsLessMaxQuality(item)) {
            incrementQuality(item);

            if (sellInLessThanValue(11, item) && qualityIsLessMaxQuality(item)) {
                incrementQuality(item);
            }
            if (sellInLessThanValue(6, item) && qualityIsLessMaxQuality(item)) {
                incrementQuality(item);
            }
        }
    }
}

