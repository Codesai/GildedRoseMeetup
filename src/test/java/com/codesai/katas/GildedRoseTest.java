package com.codesai.katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test void
    items_quality_and_sellIn_decreases_once_per_day() {
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
    when_the_sellIn_has_passed_quality_decreases_twice_as_fast() {
        final Item item = new ItemBuilder()
                .setName("foo")
                .setSellIn(0)
                .setQuality(2)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(0);
    }

    @Test public void
    the_quality_of_an_item_is_never_negative() {
        final Item item = new ItemBuilder()
                .setName("foo")
                .setSellIn(0)
                .setQuality(0)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(0);
    }

    @Test public void
    quality_of_an_item_is_never_more_than_50() {
        final Item item = new ItemBuilder()
                .setName("Aged Brie")
                .setSellIn(1)
                .setQuality(50)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(50);
    }

    @Test public void
    aged_brie_increases_in_quality_the_older_its_gets() {
        final Item item = new ItemBuilder()
                .setName("Aged Brie")
                .setSellIn(1)
                .setQuality(0)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(1);
    }

    @Test public void
    aged_brie_increases_twice_as_fast_when_the_sellIn_date_has_passed() {
        final Item item = new ItemBuilder()
                .setName("Aged Brie")
                .setSellIn(0)
                .setQuality(0)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(2);
    }

    @Test public void
    sulfuras_never_change() {
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
    backstage_passes_increase_by_one_when_sellIn_is_approaching() {
        final Item item = new ItemBuilder()
                .setName("Backstage passes to a TAFKAL80ETC concert")
                .setSellIn(12)
                .setQuality(0)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(1);
    }

    @Test public void
    backstage_passes_increase_by_two_when_sellIn_is_less_than_10() {
        final Item item = new ItemBuilder()
                .setName("Backstage passes to a TAFKAL80ETC concert")
                .setSellIn(9)
                .setQuality(0)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(2);
    }

    @Test public void
    backstage_passes_increase_by_three_when_sellIn_is_less_than_5() {
        final Item item = new ItemBuilder()
                .setName("Backstage passes to a TAFKAL80ETC concert")
                .setSellIn(4)
                .setQuality(0)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(3);
    }

    @Test public void
    backstage_passes_decreased_to_zero_when_sellIn_has_passed() {
        final Item item = new ItemBuilder()
                .setName("Backstage passes to a TAFKAL80ETC concert")
                .setSellIn(0)
                .setQuality(10)
                .createItem();

        new GildedRose(new Item[] {item}).updateQuality();

        assertThat(item.quality).isEqualTo(0);
    }
}