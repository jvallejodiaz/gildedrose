package com.gildedrose;

public class AgedBrie extends MyItem{
    public Item item;

    public AgedBrie(Item item) {
        super(item);
        this.item = item;
    }
    public void ageItem() {

        handleBrie(this.item);
        item.sellIn = item.sellIn - 1;
        handleExpiredItems(this.item);
    }
    public static void handleBrie(Item item){
        if (qualityIsLessMaxQuality(item)) {
            incrementQuality(item);
        }
    }
    public static void handleExpiredItems(Item item) {
        if (sellInLessThanValue(0, item)) {
            handleBrie(item);
        }
    }

}
