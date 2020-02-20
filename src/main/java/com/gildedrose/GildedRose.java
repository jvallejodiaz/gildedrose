package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private final Integer MAXQUALITY = new Integer(50);
    private final Integer MINQUALITY = new Integer(0);

    public void updateQuality() {
        for (Item item : items) {
            handleBackstageAndAgedBrie(item);
            if(!isAgedBrieOrBackStagePasses(item)){
                decrementQualityForNonSulfuras(item);
            }
            decrementSellInForNonSulfuras(item);
            handleExpiredItems(item);
        }
    }

    private void handleExpiredItems(Item item) {
        if (sellInLessThanValue(0, item)) {
            new AgedBrie(item).invoke();
            if (!itemNameEquals(item, "Aged Brie")) {
                if (!itemNameEquals(item, "Backstage passes to a TAFKAL80ETC concert")) {
                    decrementQualityForNonSulfuras(item);
                }
            }

        }
    }

    private boolean isAgedBrieOrBackStagePasses(Item item) {
        return itemNameEquals(item, "Aged Brie")
                || itemNameEquals(item, "Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean greaterThanMinQuality(Item item) {
        return item.quality > MINQUALITY;
    }

    private void handleBackstageAndAgedBrie(Item item) {
        if (isAgedBrieOrBackStagePasses(item)) {
            if (qualityIsLessMaxQuality(item)) {
                incrementQuality(item);

                if (itemNameEquals(item, "Backstage passes to a TAFKAL80ETC concert")) {
                    if (sellInLessThanValue(11, item) && qualityIsLessMaxQuality(item)){
                        incrementQuality(item);
                    }
                    if (sellInLessThanValue(6, item) && qualityIsLessMaxQuality(item)){
                        incrementQuality(item);
                    }
                }
            }
        }
    }

    private boolean itemNameEquals(Item item, String s) {
        return item.name.equals(s);
    }


    private void decrementQuality(Item item) {
        if (greaterThanMinQuality(item)){
        item.quality = item.quality - 1;
        }
    }

    private boolean sellInLessThanValue(int i2, Item item) {
        return (item.sellIn < i2);
    }

    private boolean qualityIsLessMaxQuality(Item item) {
        return (item.quality < MAXQUALITY);
    }


    private void incrementQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private void decrementQualityForNonSulfuras(Item item) {
        if (!itemNameEquals(item, "Sulfuras, Hand of Ragnaros")) {
            decrementQuality(item);
        }
    }

    private void decrementSellInForNonSulfuras(Item item) {
        if (!itemNameEquals(item, "Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }


    public class AgedBrie implements ItemInterface{
        private Item item;

        public AgedBrie(Item item) {
            this.item = item;
        }

        public void invoke() {
            if(itemNameEquals(item, "Aged Brie")){
                if (qualityIsLessMaxQuality(item)) {
                    incrementQuality(item);
                }
            }
        }

        @Override
        public void decrement() {

        }

        @Override
        public void increment() {

        }
    }
}