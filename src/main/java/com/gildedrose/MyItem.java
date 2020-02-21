package com.gildedrose;

public class MyItem {
    public final Item item;
    public static Integer MAXQUALITY = new Integer(50);
    public static Integer MINQUALITY = new Integer(0);
    public static Integer DECREMENTBY = new Integer(1);


    public MyItem(Item item) {
        this.item = item;

    }
    public void ageItem_() {
        decrementQuality(this.item);
        this.item.sellIn = this.item.sellIn - 1;
    }

    public void ageItem() {
        handleGeneralItems(this.item);
        handleExpiredItems(this.item);
    }
    public static void handleExpiredItems(Item item) {
        if (sellInLessThanValue(0, item)) {
            if (!isSulfuras(item)) decrementQuality(item);
        }
    }


    public static boolean greaterThanMinQuality(Item item) {
        return item.quality > MINQUALITY;
    }


    public static boolean itemNameEquals(Item item, String s) {
        return item.name.equals(s);
    }


    public static void decrementQuality(Item item) {
        int decrementBy = DECREMENTBY;
        if (greaterThanMinQuality(item)){
            item.quality = item.quality - decrementBy;
        }
    }

    public static boolean sellInLessThanValue(int i2, Item item) {
        return (item.sellIn < i2);
    }

    public static boolean qualityIsLessMaxQuality(Item item) {
        return (item.quality < MAXQUALITY);
    }


    public static void incrementQuality(Item item) {
        item.quality = item.quality + 1;
    }

    public static boolean isSulfuras(Item item) {
        return itemNameEquals(item, "Sulfuras, Hand of Ragnaros");
    }

    public static void handleGeneralItems(Item item) {
        if (!isSulfuras(item)) {
            item.sellIn = item.sellIn - 1;
            decrementQuality(item);
        }
    }

}



