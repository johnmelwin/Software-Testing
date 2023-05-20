package coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecipeBookTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDefaultConstructor() {
		RecipeBook recipeBook = new RecipeBook();
		Recipe[] recipeArray = recipeBook.getRecipes();
		
		assertEquals(4, recipeArray.length);
	}
	
	@Test
	public void testGetRecipes() {
		RecipeBook recipeBook = new RecipeBook();
		Recipe[] recipeArray = recipeBook.getRecipes();
		
		assertArrayEquals(recipeArray, recipeBook.getRecipes());
	}
	
	@Test
	public void testAddRecipe() {
		RecipeBook recipeBook = new RecipeBook();
		Recipe testRecipe = new Recipe();
		
		assertTrue(recipeBook.addRecipe(testRecipe));
	}
	
	@Test
	public void testAddRecipeAlreadyExists() {
		RecipeBook recipeBook = new RecipeBook();
		Recipe testRecipe = new Recipe();
		recipeBook.addRecipe(testRecipe);
		
		assertFalse(recipeBook.addRecipe(testRecipe));
	}
	
	@Test
	public void testDeleteRecipe() {
		RecipeBook recipeBook = new RecipeBook();
		Recipe testRecipe = new Recipe();
		testRecipe.setName("Recipe 1");
		recipeBook.addRecipe(testRecipe);
		
		assertEquals("Recipe 1", recipeBook.deleteRecipe(0));
	}
	
	@Test
	public void testDeleteRecipeDoesNotExist() {
		RecipeBook recipeBook = new RecipeBook();
		assertNull(recipeBook.deleteRecipe(0));
	}
	
	@Test
	public void testDeleteOutofBounds() {
		RecipeBook recipeBook = new RecipeBook();
		assertNull(recipeBook.deleteRecipe(5));
	}
	
	@Test
	public void testEditRecipe() {
		RecipeBook recipeBook = new RecipeBook();
		Recipe testRecipe = new Recipe();
		testRecipe.setName("Recipe 1");
		recipeBook.addRecipe(testRecipe);
		
		Recipe newRecipe = new Recipe();
		newRecipe.setName("New Recipe");
		
		assertEquals("Recipe 1", recipeBook.editRecipe(0, newRecipe));
	}
	
	@Test
	public void testEditRecipeDoesNotExist() {
		RecipeBook recipeBook = new RecipeBook();
		
		Recipe newRecipe = new Recipe();
		newRecipe.setName("New Recipe");
		
		assertNull(recipeBook.editRecipe(0, newRecipe));
	}
	
	@Test
	public void testEditRecipeOutofBounds() {
		RecipeBook recipeBook = new RecipeBook();
		
		Recipe newRecipe = new Recipe();
		newRecipe.setName("New Recipe");
		recipeBook.addRecipe(newRecipe);
		
		assertNull(recipeBook.editRecipe(5, newRecipe));
	}
	
	@Test
	public void testAddRecipeToFullBook() {
		RecipeBook recipeBook = new RecipeBook();
		recipeBook.addRecipe(new Recipe());
		recipeBook.addRecipe(new Recipe());
		recipeBook.addRecipe(new Recipe());
		recipeBook.addRecipe(new Recipe());
		
		assertFalse(recipeBook.addRecipe(new Recipe()));
	}
	
	@Test
	  public void testFillAndDeleteAllRecipes() {
		RecipeBook recipeBook = new RecipeBook();
		RecipeBook recipeBookTest = new RecipeBook();
		Recipe recipe1 = new Recipe();
		Recipe recipe2 = new Recipe();
		Recipe recipe3 = new Recipe();
		Recipe recipe4 = new Recipe();
		
		recipeBook.addRecipe(recipe1);
		recipeBook.addRecipe(recipe2);
		recipeBook.addRecipe(recipe3);
		recipeBook.addRecipe(recipe4);
		
		recipeBook.deleteRecipe(0);
		recipeBook.deleteRecipe(1);
		recipeBook.deleteRecipe(2);
		recipeBook.deleteRecipe(3);
		
		assertEquals(recipeBookTest.getRecipes()[0], recipeBook.getRecipes()[0]);
	  }
	
	@Test
	public void testEditRecipeNegative() {
		RecipeBook recipeBook = new RecipeBook();
		
		Recipe newRecipe = new Recipe();
		newRecipe.setName("New Recipe");
		recipeBook.addRecipe(newRecipe);
		assertNull(recipeBook.editRecipe(-1, newRecipe));
	}

}
