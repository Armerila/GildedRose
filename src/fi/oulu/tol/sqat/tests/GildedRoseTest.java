package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
    
	@Test
	public void testUpdateEndOfDay_AgedBrie_Sellin_2_1() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(1, itemBrie.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_QualityAfterSellIn_2_5() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 1, 2) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(5, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_NegativeQuality() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("TestItem", 1, 1) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
			
		// Assert
		List<Item> items = store.getItems();
		Item test = items.get(0);
		assertEquals(0, test.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_QualityOver50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 0, 49) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
			
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_SulfurasQUalityImmutable() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 10, 80) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
			
		// Assert
		List<Item> items = store.getItems();
		Item sulfuras = items.get(0);
		assertEquals(80, sulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_SulfurasSellinImmutable() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 10, 80) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
			
		// Assert
		List<Item> items = store.getItems();
		Item sulfuras = items.get(0);
		assertEquals(10, sulfuras.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_BackPass_10_18() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
			
		// Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(18, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackPass_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
			
		// Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(0, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_DoubleDegrade() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("TestItem", 0, 10) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
			
		// Assert
		List<Item> items = store.getItems();
		Item test = items.get(0);
		assertEquals(4, test.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_QualityDouble() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 0, 0) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
			
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(6, itemBrie.getQuality());
	}
	
	
	
	
}
