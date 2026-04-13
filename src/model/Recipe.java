package model;

// Recipe entity in recipes_db
public class Recipe {
    /*
        Based on recipe relation on proposed DB design:
        recipe_id - int (PRIMARY KEY)
        user_id - int (FOREIGN KEY)
        title - VARCHAR(100)
        category - VARCHAR(50)
        prep_time - int (in minutes)
        procedure - TEXT
    */
    private int recipeId;
    private int userId;
    private String title;
    private String category;
    private int prepTime; // in minutes
    private String procedure;

    public Recipe(int recipeId, int userId, String title, String category, int prepTime, String procedure) {
        this.recipeId = recipeId;
        this.userId = userId;
        this.title = title;
        this.category = category;
        this.prepTime = prepTime;
        this.procedure = procedure;
    }

    // Getters and Setters
    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", prepTime=" + prepTime +
                ", procedure='" + procedure + '\'' +
                '}';
    }
}
