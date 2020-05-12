package com.codesai.katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseShould {

    @Test void
    decreases_items_quality_and_sellIn_once_per_day() {
        final Item item = new ItemBuilder()
                .setName("foo")
                .setSellIn(1)
                .setQuality(1)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(0);
        assertThat(item.sellIn).isEqualTo(0);
    }

    @Test public void
    decreases_twice_as_fast_when_the_sellIn_has_passed_quality() {
        final Item item = new ItemBuilder()
                .setName("foo")
                .setSellIn(0)
                .setQuality(2)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(0);
    }

    @Test public void
    ensure_that_the_quality_of_an_item_is_never_negative() {
        final Item item = new ItemBuilder()
                .setName("foo")
                .setSellIn(0)
                .setQuality(0)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(0);
    }

    @Test public void
    ensure_that_quality_of_an_item_is_never_more_than_50() {
        final Item item = new ItemBuilder()
                .setName("Aged Brie")
                .setSellIn(1)
                .setQuality(50)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(50);
    }

    @Test public void
    increases_aged_brie_quality_the_older_its_gets() {
        final Item item = new ItemBuilder()
                .setName("Aged Brie")
                .setSellIn(1)
                .setQuality(0)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(1);
    }

    @Test public void
    increases_twice_as_fast_aged_brie_quality_when_the_sellIn_date_has_passed() {
        final Item item = new ItemBuilder()
                .setName("Aged Brie")
                .setSellIn(0)
                .setQuality(0)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(2);
    }

    @Test public void
    ensure_that_sulfuras_never_change() {
        final Item item = new ItemBuilder()
                .setName("Sulfuras, Hand of Ragnaros")
                .setSellIn(1)
                .setQuality(80)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(80);
        assertThat(item.sellIn).isEqualTo(1);
    }

    @Test public void
    increase_by_one_backstage_passes_quality_when_sellIn_is_approaching() {
        final Item item = new ItemBuilder()
                .setName("Backstage passes to a TAFKAL80ETC concert")
                .setSellIn(12)
                .setQuality(0)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(1);
    }

    @Test public void
    increase_by_two_backstage_passes_quality_when_sellIn_is_less_than_10() {
        final Item item = new ItemBuilder()
                .setName("Backstage passes to a TAFKAL80ETC concert")
                .setSellIn(9)
                .setQuality(0)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(2);
    }

    @Test public void
    increase_by_three_backstage_passes_quality_when_sellIn_is_less_than_5() {
        final Item item = new ItemBuilder()
                .setName("Backstage passes to a TAFKAL80ETC concert")
                .setSellIn(4)
                .setQuality(0)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(3);
    }

    @Test public void
    set_to_zero_backstage_passes_quality_when_sellIn_has_passed() {
        final Item item = new ItemBuilder()
                .setName("Backstage passes to a TAFKAL80ETC concert")
                .setSellIn(0)
                .setQuality(10)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(0);
    }
}