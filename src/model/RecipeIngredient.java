package model;

import utils.Unit;

// RecipeIngredient entity in recipes_db
public class RecipeIngredient {
    /*
        Based on recipe_ingredient relation on proposed DB design:
        recipe_id - int (COMPOSITE PRIMARY KEY)
        ingredient_id - int (COMPOSITE PRIMARY KEY)
        quantity - double
        unit - enum (selected units in the Metric system)
    */
    private int recipeId;
    private int ingredientId;
    private double quantity;
    private Unit unit;

    public RecipeIngredient(int recipeId, int ingredientId, double quantity, Unit unit) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.quantity = quantity;
        this.unit = unit;
    }

    // Getters and Setters
    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeId=" + recipeId +
                ", ingredientId=" + ingredientId +
                ", quantity=" + quantity +
                ", unit=" + unit +
                '}';
    }
}
