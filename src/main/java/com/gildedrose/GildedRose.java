package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            itemFactory(item).ageItem();
        }
    }

    public MyItem itemFactory(Item item) {
        if(item.name.equals("Aged Brie")){
            return new AgedBrie(item);
        }
        else if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
            return new BackstagePass(item);
        }
        else if(item.name.equals("Sulfuras, Hand of Ragnaro")){
            return new Sulfuras(item);
        }

        return new MyItem(item);
    }

}