package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Recipe {

	private String name;
	private String ingredientName;
	private String cookingToolName;

	private List<Ingredient> ingredients;

	private List<CookingTool> tools;

	public Recipe() {
		setIngredients(new ArrayList<Ingredient>());
		setTools(new ArrayList<CookingTool>());
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<CookingTool> getTools() {
		return tools;
	}

	public void setTools(List<CookingTool> tools) {
		this.tools = tools;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public String getCookingToolName() {
		return cookingToolName;
	}

	public void setCookingToolName(String cookingToolName) {
		this.cookingToolName = cookingToolName;
	}

	@Override
	public String toString() {
		return "Recipe [name=" + name + ", ingredientName=" + ingredientName + ", cookingToolName=" + cookingToolName
				+ ", ingredients=" + ingredients + ", tools=" + tools + "]";
	}

}
