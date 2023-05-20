package coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coffeemaker.exceptions.InventoryException;
import coffeemaker.exceptions.RecipeException;

public class InventoryTest {

	Inventory i = null;
	
	@Before
	public void setUp() throws Exception {
		i = new Inventory();
	}

	@After
	public void tearDown() throws Exception {
		i = null;
	}

	@Test
	public void testGetChocolate() {
		assertEquals(i.getChocolate(), 15);
	}
	
	@Test
	public void testGetMilk() {
		assertEquals(i.getMilk(), 15);
	}

	@Test
	public void testGetCoffee() {
		assertEquals(i.getCoffee(), 15);
	}
	
	@Test
	public void testGetSugar() {
		assertEquals(i.getSugar(), 15);
	}
	
	@Test
	public void testToString() {
		String expectedString = 
				"Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
		assertEquals(i.toString(), expectedString);
	}
	
	@Test
	public void testSetChocolateZero() {
		i.setChocolate(0);
		assertEquals(i.getChocolate(), 0);
	}
	
	@Test
	public void testSetMilkZero() {
		i.setMilk(0);
		assertEquals(i.getMilk(), 0);
	}
	
	@Test
	public void testSetSugarZero() {
		i.setSugar(0);
		assertEquals(i.getSugar(), 0);
	}
	
	@Test
	public void testSetCoffeeZero() {
		i.setCoffee(0);
		assertEquals(i.getCoffee(), 0);
	}
	
	@Test
	public void testSetChocolateNegative() {
		i.setChocolate(-1);
		assertNotEquals(i.getChocolate(), -1);
	}
	
	@Test
	public void testSetMilkNegative() {
		i.setMilk(-1);
		assertNotEquals(i.getMilk(), -1);
	}
	
	@Test
	public void testSetSugarNegative() {
		i.setSugar(-1);
		assertNotEquals(i.getSugar(), -1);
	}
	
	@Test
	public void testSetCoffeeNegative() {
		i.setCoffee(-1);
		assertNotEquals(i.getCoffee(), -1);
	}
	
	@Test
	public void testAddChocolatePositive() {
		try {
			i.addChocolate("1");
		} catch (InventoryException e) {
			fail("Inventory exception caught");
		}
		assertEquals(i.getChocolate(), 16);
	}
	
	@Test
	public void testAddChocolateNegative() {
		assertThrows(InventoryException.class, () -> i.addChocolate("-1"));
	}
	
	@Test
	public void testAddChocolateNotInteger() {
		assertThrows(InventoryException.class, () -> i.addChocolate("ONE"));
	}
	
	@Test
	public void testAddCoffeePositive() {
		try {
			i.addCoffee("1");
		} catch (InventoryException e) {
			fail("Inventory exception caught");
		}
		assertEquals(i.getCoffee(), 16);
	}
	
	@Test
	public void testAddCoffeeNegative() {
		assertThrows(InventoryException.class, () -> i.addCoffee("-1"));
	}
	
	@Test
	public void testAddCoffeeNotInteger() {
		assertThrows(InventoryException.class, () -> i.addCoffee("ONE"));
	}
	
	@Test
	public void testAddMilkPositive() {
		try {
			i.addMilk("1");
		} catch (InventoryException e) {
			fail("Inventory exception caught");
		}
		assertEquals(i.getMilk(), 16);
	}
	
	@Test
	public void testAddMilkNegative() {
		assertThrows(InventoryException.class, () -> i.addMilk("-1"));
	}
	
	@Test
	public void testAddMilkNotInteger() {
		assertThrows(InventoryException.class, () -> i.addMilk("ONE"));
	}
	
	@Test
	public void testAddSugarPositive() {
		try {
			i.addSugar("1");
		} catch (InventoryException e) {
			fail("Inventory exception caught");
		}
		assertEquals(i.getSugar(), 16);
	}
	
	@Test
	public void testAddSugarNegative() {
		assertThrows(InventoryException.class, () -> i.addSugar("-1"));
	}
	
	@Test
	public void testAddSugarNotInteger() {
		assertThrows(InventoryException.class, () -> i.addSugar("ONE"));
	}
	
	@Test
	public void testEnoughIngredientsAll() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("10");
			r.setAmtMilk("10");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		assert(i.enoughIngredients(r));
	}
	
	@Test
	public void testEnoughIngredientsNotChocolate() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("100");
			r.setAmtCoffee("10");
			r.setAmtMilk("10");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.enoughIngredients(r));
	}
	
	@Test
	public void testEnoughIngredientsNotCoffee() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("100");
			r.setAmtMilk("10");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.enoughIngredients(r));
	}
	
	@Test
	public void testEnoughIngredientsNotMilk() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("10");
			r.setAmtMilk("100");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.enoughIngredients(r));
	}
	
	@Test
	public void testEnoughIngredientsNotSugar() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("10");
			r.setAmtMilk("10");
			r.setAmtSugar("100");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.enoughIngredients(r));
	}
	
	@Test
	public void testEnoughIngredientsNotChocolateMilk() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("100");
			r.setAmtCoffee("10");
			r.setAmtMilk("100");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.enoughIngredients(r));
	}
	
	@Test
	public void testEnoughIngredientsNotChocolateMilkSugar() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("100");
			r.setAmtCoffee("10");
			r.setAmtMilk("100");
			r.setAmtSugar("100");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.enoughIngredients(r));
	}
	
	@Test
	public void testEnoughIngredientsNotChocolateCoffee() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("100");
			r.setAmtCoffee("100");
			r.setAmtMilk("10");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.enoughIngredients(r));
	}
	
	@Test
	public void testEnoughIngredientsNotChocolateCoffeeMilk() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("100");
			r.setAmtCoffee("100");
			r.setAmtMilk("100");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.enoughIngredients(r));
	}
	
	@Test
	public void testEnoughIngredientsNotAll() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("100");
			r.setAmtCoffee("100");
			r.setAmtMilk("100");
			r.setAmtSugar("100");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.enoughIngredients(r));
	}
	
	@Test
	public void testEnoughIngredientsNotCoffeeMilkSugar() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("100");
			r.setAmtMilk("100");
			r.setAmtSugar("100");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.enoughIngredients(r));
	}

	@Test
	public void testEnoughIngredientsNotMilkSugar() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("10");
			r.setAmtMilk("100");
			r.setAmtSugar("100");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.enoughIngredients(r));
	}

	@Test
	public void testEnoughIngredientsNotCoffeeMilk() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("100");
			r.setAmtMilk("100");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.enoughIngredients(r));
	}

	@Test
	public void testEnoughIngredientsNotCoffeeChocolateSugar() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("100");
			r.setAmtCoffee("100");
			r.setAmtMilk("10");
			r.setAmtSugar("100");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.enoughIngredients(r));
	}

	@Test
	public void testEnoughIngredientsNotCoffeeSugar() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("100");
			r.setAmtMilk("10");
			r.setAmtSugar("100");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.enoughIngredients(r));
	}

	@Test
	public void testEnoughIngredientsNotChocolateSugar() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("100");
			r.setAmtCoffee("10");
			r.setAmtMilk("10");
			r.setAmtSugar("100");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.enoughIngredients(r));
	}
	
	@Test
	public void testUseIngredientsNotEnough() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("100");
			r.setAmtCoffee("100");
			r.setAmtMilk("100");
			r.setAmtSugar("100");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.useIngredients(r));
	}
	
	@Test
	public void testUseIngredientsNotEnoughChocolate() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("100");
			r.setAmtCoffee("10");
			r.setAmtMilk("10");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.useIngredients(r));
	}

	@Test
	public void testUseIngredientsNotEnoughCoffee() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("100");
			r.setAmtMilk("10");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.useIngredients(r));
	}

	@Test
	public void testUseIngredientsNotEnoughMilk() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("10");
			r.setAmtMilk("100");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.useIngredients(r));
	}

	@Test
	public void testUseIngredientsNotEnoughSugar() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("10");
			r.setAmtMilk("10");
			r.setAmtSugar("100");
		} catch (RecipeException e) {
			fail();
		}
		assertFalse(i.useIngredients(r));
	}
	
	@Test
	public void testUseIngredientsUsed() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("10");
			r.setAmtMilk("10");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		assert(i.useIngredients(r));
	}
	
	@Test
	public void testUseIngredientsSugar() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("10");
			r.setAmtMilk("10");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		i.useIngredients(r);
		assertEquals(5, i.getSugar());
	}
	
	@Test
	public void testUseIngredientsMilk() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("10");
			r.setAmtMilk("10");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		i.useIngredients(r);
		assertEquals(5, i.getMilk());
	}
	
	@Test
	public void testUseIngredientsCoffee() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("10");
			r.setAmtMilk("10");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		i.useIngredients(r);
		assertEquals(5, i.getCoffee());
	}
	
	@Test
	public void testUseIngredientsChocolate() {
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate("10");
			r.setAmtCoffee("10");
			r.setAmtMilk("10");
			r.setAmtSugar("10");
		} catch (RecipeException e) {
			fail();
		}
		i.useIngredients(r);
		assertEquals(5, i.getChocolate());
	}
	
}
