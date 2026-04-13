package model;

// MealEntry entity in recipes_db
public class MealEntry {
    /*
        Based on meal_entry relation on proposed DB design:
        recipe_id - int (COMPOSITE PRIMARY KEY)
        user_id - int (COMPOSITE PRIMARY KEY)
        meal_type - VARCHAR(50) (e.g., Breakfast, Lunch, Dinner, Snack)
        scheduled_date - DATE
    */
    private int recipeId;
    private int userId;
    private String mealType;
    private String scheduledDate; // Using String for date (can be changed to java.time.LocalDate if preferred)

    public MealEntry(int recipeId, int userId, String mealType, String scheduledDate) {
        this.recipeId = recipeId;
        this.userId = userId;
        this.mealType = mealType;
        this.scheduledDate = scheduledDate;
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

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    @Override
    public String toString() {
        return "MealEntry{" +
                "recipeId=" + recipeId +
                ", userId=" + userId +
                ", mealType='" + mealType + '\'' +
                ", scheduledDate='" + scheduledDate + '\'' +
                '}';
    }
}
