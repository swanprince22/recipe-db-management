package model;

// Ingredient entity in recipes_db
public class Ingredient {
    /*
        Based on ingredient relation on proposed DB design:
        ingredient_id - int (PRIMARY KEY)
        name - VARCHAR(100)
    */
    private int ingredientId;
    private String name;

    public Ingredient(int ingredientId, String name) {
        this.ingredientId = ingredientId;
        this.name = name;
    }

    // Getters and Setters
    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", name='" + name + '\'' +
                '}';
    }
}
