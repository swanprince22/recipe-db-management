package model;

import utils.Unit;

// Pantry entity in recipes_db
public class Pantry {
    /*
        Based on pantry relation on proposed DB design:
        ingredient_id - int (COMPOSITE PRIMARY KEY)
        user_id - int (COMPOSITE PRIMARY KEY)
        quantity - double
        unit - enum (selected units in the Metric system)
    */
    private int ingredientId;
    private int userId;
    private double quantity;
    private Unit unit; // Using enums in Java for "Unit"

    public Pantry(int ingredientId, int userId, double quantity, Unit unit) {
        this.ingredientId = ingredientId;
        this.userId = userId;
        this.quantity = quantity;
        this.unit = unit;
    }

    // Getters and setters for Pantry class
    // To be improved/removed from as needed
    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}
