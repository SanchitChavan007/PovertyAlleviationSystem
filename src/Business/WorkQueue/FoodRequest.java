/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Rahul Zore
 */
public class FoodRequest extends WorkRequest {

    private String foodResult;
    private String foodName;
    private int foodQty;
    private String foodType;

    public String getFoodResult() {
        return foodResult;
    }

    public void setFoodResult(String foodResult) {
        this.foodResult = foodResult;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodQty() {
        return foodQty;
    }

    public void setFoodQty(int foodQty) {
        this.foodQty = foodQty;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

}
