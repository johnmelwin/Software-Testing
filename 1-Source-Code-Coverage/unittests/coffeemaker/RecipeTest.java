package coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coffeemaker.exceptions.RecipeException;

public class RecipeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// Name
	@Test
	public void testRecipeInitialName() {
		Recipe recipe = new Recipe();
		assertEquals("", recipe.getName());
	}
	
	@Test
	public void testSetName() {
		Recipe recipe = new Recipe();
		recipe.setName("testName");
		assertEquals("testName", recipe.getName());
	}
	
	@Test
	public void testSetNameNull() {
		Recipe recipe = new Recipe();
		recipe.setName(null);
		assertEquals("", recipe.getName());
	}
	
	@Test
	public void testSetNameThenSetNull() {
		Recipe recipe = new Recipe();
		recipe.setName("testName");
		recipe.setName(null);
		assertEquals("testName", recipe.getName());
	}
	
	// Chocolate
	@Test
	public void testRecipeInitialAmountChocolate() {
		Recipe recipe = new Recipe();
		assertEquals(0, recipe.getAmtChocolate());
	}
	
	@Test
	public void testSetAmtChocolate() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("1");
		assertEquals(1, recipe.getAmtChocolate());
	}
	
	@Test
	public void testSetAmtChocolateNegativeInteger() {
		Recipe recipe = new Recipe();
		Exception exception = assertThrows(RecipeException.class, () -> {
			recipe.setAmtChocolate("-1");
		});
		String actualMessage = exception.getMessage();
		String expectedMessage = "Units of chocolate must be a positive integer";
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	@Test
	public void testSetAmtChocolateNonInteger() {
		Recipe recipe = new Recipe();
		Exception exception = assertThrows(RecipeException.class, () -> {
			recipe.setAmtChocolate("test");
		});
		String actualMessage = exception.getMessage();
		String expectedMessage = "Units of chocolate must be a positive integer";
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	@Test
	public void testSetAmtChocolateDouble() {
		Recipe recipe = new Recipe();
		Exception exception = assertThrows(RecipeException.class, () -> {
			recipe.setAmtChocolate("2.7");
		});
		String actualMessage = exception.getMessage();
		String expectedMessage = "Units of chocolate must be a positive integer";
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	// Coffee
	@Test
	public void testRecipeInitialAmountCoffee() {
		Recipe recipe = new Recipe();
		assertEquals(0, recipe.getAmtCoffee());
	}
	
	@Test
	public void testSetAmtCoffee() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtCoffee("1");
		assertEquals(1, recipe.getAmtCoffee());
	}
	
	@Test
	public void testSetAmtCoffeeNegativeInteger() {
		Recipe recipe = new Recipe();
		Exception exception = assertThrows(RecipeException.class, () -> {
			recipe.setAmtCoffee("-1");
		});
		String actualMessage = exception.getMessage();
		String expectedMessage = "Units of coffee must be a positive integer";
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	@Test
	public void testSetAmtCoffeeNonInteger() {
		Recipe recipe = new Recipe();
		Exception exception = assertThrows(RecipeException.class, () -> {
			recipe.setAmtCoffee("test");
		});
		String actualMessage = exception.getMessage();
		String expectedMessage = "Units of coffee must be a positive integer";
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	@Test
	public void testSetAmtCoffeeDouble() {
		Recipe recipe = new Recipe();
		Exception exception = assertThrows(RecipeException.class, () -> {
			recipe.setAmtCoffee("2.7");
		});
		String actualMessage = exception.getMessage();
		String expectedMessage = "Units of coffee must be a positive integer";
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	// milk
	@Test
	public void testRecipeInitialAmountMilk() {
		Recipe recipe = new Recipe();
		assertEquals(0, recipe.getAmtMilk());
	}
	
	@Test
	public void testSetAmtMilk() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtMilk("1");
		assertEquals(1, recipe.getAmtMilk());
	}
	
	@Test
	public void testSetAmtMilkNegativeInteger() {
		Recipe recipe = new Recipe();
		Exception exception = assertThrows(RecipeException.class, () -> {
			recipe.setAmtMilk("-6");
		});
		String actualMessage = exception.getMessage();
		String expectedMessage = "Units of milk must be a positive integer";
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	@Test
	public void testSetAmtMilkNonInteger() {
		Recipe recipe = new Recipe();
		Exception exception = assertThrows(RecipeException.class, () -> {
			recipe.setAmtMilk("test");
		});
		String actualMessage = exception.getMessage();
		String expectedMessage = "Units of milk must be a positive integer";
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	@Test
	public void testSetAmtMilkDouble() {
		Recipe recipe = new Recipe();
		Exception exception = assertThrows(RecipeException.class, () -> {
			recipe.setAmtMilk("2.99");
		});
		String actualMessage = exception.getMessage();
		String expectedMessage = "Units of milk must be a positive integer";
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	// sugar
	@Test
	public void testRecipeInitialAmountSugar() {
		Recipe recipe = new Recipe();
		assertEquals(0, recipe.getAmtSugar());
	}
	
	@Test
	public void testSetAmtSugar() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtSugar("99");
		assertEquals(99, recipe.getAmtSugar());
	}
	
	@Test
	public void testSetAmtSugarNegativeInteger() {
		Recipe recipe = new Recipe();
		Exception exception = assertThrows(RecipeException.class, () -> {
			recipe.setAmtSugar("-99");
		});
		String actualMessage = exception.getMessage();
		String expectedMessage = "Units of sugar must be a positive integer";
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	@Test
	public void testSetAmtSugarNonInteger() {
		Recipe recipe = new Recipe();
		Exception exception = assertThrows(RecipeException.class, () -> {
			recipe.setAmtSugar("test");
		});
		String actualMessage = exception.getMessage();
		String expectedMessage = "Units of sugar must be a positive integer";
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	@Test
	public void testSetAmtSugarDouble() {
		Recipe recipe = new Recipe();
		Exception exception = assertThrows(RecipeException.class, () -> {
			recipe.setAmtSugar("19.8");
		});
		String actualMessage = exception.getMessage();
		String expectedMessage = "Units of sugar must be a positive integer";
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	// price
	@Test
	public void testRecipeInitialPrice() {
		Recipe recipe = new Recipe();
		assertEquals(0, recipe.getPrice());
	}
	
	@Test
	public void testSetAmtPrice() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setPrice("21");
		assertEquals(21, recipe.getPrice());
	}
	
	@Test
	public void testSetAmtPriceNegativeInteger() {
		Recipe recipe = new Recipe();
		Exception exception = assertThrows(RecipeException.class, () -> {
			recipe.setPrice("-99");
		});
		String actualMessage = exception.getMessage();
		String expectedMessage = "Price must be a positive integer";
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	@Test
	public void testSetAmtPriceNonInteger() {
		Recipe recipe = new Recipe();
		Exception exception = assertThrows(RecipeException.class, () -> {
			recipe.setPrice("test");
		});
		String actualMessage = exception.getMessage();
		String expectedMessage = "Price must be a positive integer";
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	@Test
	public void testSetAmtPriceDouble() {
		Recipe recipe = new Recipe();
		Exception exception = assertThrows(RecipeException.class, () -> {
			recipe.setPrice("19.8");
		});
		String actualMessage = exception.getMessage();
		String expectedMessage = "Price must be a positive integer";
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	// to string
	@Test
	public void testEmptyToString() {
		Recipe recipe = new Recipe();
		String actualMessage = recipe.toString();
		String expectedMessage = "";
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	@Test
	public void testNonEmptyToString() {
		Recipe recipe = new Recipe();
		recipe.setName("Test Recipe Name");
		String actualMessage = recipe.toString();
		String expectedMessage = "Test Recipe Name";
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	//HashCode
	@Test
	public void testHashCode() {
		Recipe recipe = new Recipe();
		int hash = recipe.hashCode();
		assertEquals(31, hash);
	}
	
	// equals
	@Test
	public void testObjectEquals() {
		Recipe recipe = new Recipe();
		assertTrue(recipe.equals(recipe));
	}
	
	@Test
	public void testObjectEqualsNull() {
		Recipe recipe = new Recipe();
		assertFalse(recipe.equals(null));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testObjectEqualsDifferentClassType() {
		Recipe recipe = new Recipe();
		assertFalse(recipe.equals(new Inventory()));
	}
	
	@Test
	public void testObjectEqualsSameName1() {
		Recipe recipe = new Recipe();
		Recipe recipe2 = new Recipe();
		assertTrue(recipe.equals(recipe2));
	}
	
	@Test
	public void testObjectEqualsSameName2() {
		Recipe recipe = new Recipe();
		recipe.setName("Cake");
		Recipe recipe2 = new Recipe();
		recipe2.setName("Cake");
		assertTrue(recipe.equals(recipe2));
	}
	
	@Test
	public void testObjectNotEquals1() {
		Recipe recipe = new Recipe();
		recipe.setName("Cake");
		Recipe recipe2 = new Recipe();
		recipe2.setName("Not Cake");
		assertFalse(recipe.equals(recipe2));
	}
	
	@Test
	public void testObjectNotEquals2() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Cake");
		Recipe recipe2 = new Recipe();
		recipe2.setName("Cake");
		recipe.setAmtChocolate("1");
		assertFalse(recipe.equals(recipe2));
	}
	
	@Test
	public void testObjectNotEquals3() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Cake");
		recipe.setAmtChocolate("1");
		Recipe recipe2 = new Recipe();
		recipe2.setName("Note Cake");
		recipe.setAmtChocolate("1");
		assertFalse(recipe.equals(recipe2));
	}
	
	@Test
	public void testObjectNotEquals4() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("5");
		Recipe recipe2 = new Recipe();
		recipe.setAmtChocolate("1");
		recipe.setAmtSugar("1");
		recipe.setAmtMilk("1");
		recipe.setPrice("5");
		assertFalse(recipe.equals(recipe2));
	}
	
	@Test
	public void testObjectNotEquals5() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtSugar("5");
		Recipe recipe2 = new Recipe();
		recipe.setAmtSugar("1");
		assertFalse(recipe.equals(recipe2));
	}
	
	@Test
	public void testObjectNotEquals6() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtCoffee("5");
		Recipe recipe2 = new Recipe();
		recipe.setAmtCoffee("1");
		assertFalse(recipe.equals(recipe2));
	}
	
	@Test
	public void testObjectNotEquals7() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtMilk("5");
		Recipe recipe2 = new Recipe();
		recipe.setAmtMilk("1");
		assertFalse(recipe.equals(recipe2));
	}
	
	@Test
	public void testObjectNotEquals8() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setPrice("5");
		Recipe recipe2 = new Recipe();
		recipe.setPrice("1");
		assertFalse(recipe.equals(recipe2));
	}
 }
