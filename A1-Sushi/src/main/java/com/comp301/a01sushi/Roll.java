package com.comp301.a01sushi;

public class Roll implements Sushi {

  private String name;
  private IngredientPortion[] ingredients;
  private int cals;
  private double cost;
  private boolean hasRice;
  private boolean hasShellfish;
  private boolean isVegetarian;

  public Roll(String _name, IngredientPortion[] _roll_ingredients) {
    if (_roll_ingredients == null) {
      throw new IllegalArgumentException("the ingredients array is null");
    }
    for (int i = 0; i < _roll_ingredients.length; i++) {
      if (_roll_ingredients[i] == null) {
        throw new IllegalArgumentException("one of the ingredients is NULL");
      }
    }
    name = _name;
    ingredients = _roll_ingredients.clone();

    //        JEDI CODE STARTS HERE
    jediCode();
    //        JEDI CODE ENDS HERE

  }
  //    private void oldjediCode(IngredientPortion[] _roll_ingredients) {
  //        //build array of indices to delete if duplicate
  //        int[] indexToDel = new int[0];
  //        int count = 0;
  //        for(int i=0; i<_roll_ingredients.length; i++){
  //            IngredientPortion tempPort = _roll_ingredients[i];
  //            for(int j=0; j<_roll_ingredients.length; j++){
  //                if(i!=j){
  //                    if(tempPort == _roll_ingredients[j]){
  //                        count+=2;
  //                        int[] copyITD = indexToDel;
  //                        indexToDel = new int[count];
  //                        for(int k=0; k<copyITD.length; k++){
  //                            indexToDel[k] = copyITD[k];
  //                        }
  //                        indexToDel[count-2] = i;
  //                        indexToDel[count-1] = j;
  //                    }
  //                }
  //            }
  //        }
  //        IngredientPortion[] combinedIngredients = new IngredientPortion[count/2];
  //        for(int i=0; i<count;i+=2){
  //            combinedIngredients[i/2] =
  // ingredients[indexToDel[i]].combine(ingredients[indexToDel[i+1]]);
  //        }
  //        // delete ingredients
  //        for(int i=0; i<indexToDel.length; i++){
  //            ingredients[indexToDel[i]] = null;
  //        }
  //        // make a new array with ingredients
  //        IngredientPortion finalIngredientsWithoutCheckingSeaweed[] = new
  // IngredientPortion[ingredients.length-(count/2)];
  //        int newCount = 0;
  //        for(int i=0; i<ingredients.length; i++){
  //            if(ingredients[i] != null) {
  //                finalIngredientsWithoutCheckingSeaweed[newCount] = ingredients[i];
  //                newCount++;
  //            }
  //        }
  //        for(int i=0; i<combinedIngredients.length; i++){
  //            finalIngredientsWithoutCheckingSeaweed[newCount] = combinedIngredients[i];
  //            newCount++;
  //        }
  //        //run previous code a couple times to ensure all seaweeds are combined
  //        //check seaweed
  //        boolean enoughSeaweed = false;
  //        int seaweedIndex;
  //        IngredientPortion testSeaweed = new SeaweedPortion(0.1);
  //        for(int i=0; i<finalIngredientsWithoutCheckingSeaweed.length; i++) {
  //
  // if(finalIngredientsWithoutCheckingSeaweed[i].getIngredient().equals(testSeaweed.getIngredient())) {
  //                if(!(finalIngredientsWithoutCheckingSeaweed[i].getAmount() >=
  // testSeaweed.getAmount())){
  //                    finalIngredientsWithoutCheckingSeaweed[i] = testSeaweed;
  //                    enoughSeaweed = true;
  //                } else {
  //                    enoughSeaweed = true;
  //                }
  //            }
  //        }
  //        if(!enoughSeaweed) {
  //            ingredients = new
  // IngredientPortion[finalIngredientsWithoutCheckingSeaweed.length+1];
  //            for(int i=0; i< ingredients.length-1; i++){
  //                ingredients[i] = finalIngredientsWithoutCheckingSeaweed[i];
  //            }
  //            ingredients[ingredients.length-1] = testSeaweed;
  //        }
  //    }
  private void jediCode() {
    jediCodeCombineDuplicates();
    jediCodeSeaweed();
  }

  private void jediCodeCombineDuplicates() {
    // COMBINE DUPLICATES
    int nullCount = 0;
    // recurse through each ingredient
    for (int i = 0; i < ingredients.length; i++) {
      for (int j = 0; j < ingredients.length; j++) {
        if (i != j && ingredients[j] != null && ingredients[i] != null) {
          // for each ingredient, if there is another, combine them
          if (ingredients[i].getIngredient().equals(ingredients[j].getIngredient())) {
            // replace the first with the combination and turn the second into null
            ingredients[i] = ingredients[i].combine(ingredients[j]);
            ingredients[j] = null;
            nullCount++;
          }
        }
      }
    }
    // after all recursion, shrink the array ridding all the nulls
    IngredientPortion[] newArr = new IngredientPortion[ingredients.length - nullCount];
    int indexCount = 0;
    for (int i = 0; i < ingredients.length; i++) {
      if (ingredients[i] != null) {
        newArr[indexCount] = ingredients[i];
        indexCount++;
      }
    }
    ingredients = newArr;
  }

  private void jediCodeSeaweed() {
    // CHECK SEAWEED
    // make bool set to false
    boolean hasSW = false;
    // check if seaweed exists
    //    IngredientPortion testSW = new SeaweedPortion(0.1);
    for (int i = 0; i < ingredients.length; i++) {
      if (ingredients[i].getName().equals("seaweed")) {
        hasSW = true;
        // if it exists, check if the amount is less than 0.1
        if (ingredients[i].getAmount() < (0.1)) {
          // if amount is less than 0.1, replace it with new instance of seaweed portion with 0.1
          double amountToAdd = (new SeaweedPortion(0.1)).getAmount() - ingredients[i].getAmount();
          ingredients[i] = ingredients[i].combine(new SeaweedPortion(amountToAdd + 0.01));
        }
        // set bool to true in either above cases
      }
    }
    // if bool is false, add new ingredient of seaweed 0.1
    if (!hasSW) {
      IngredientPortion[] newArr2 = new IngredientPortion[ingredients.length + 1];
      System.arraycopy(ingredients, 0, newArr2, 0, ingredients.length);
      //      for (int i = 0; i < ingredients.length; i++) {
      //        newArr[i] = ingredients[i];
      //      }
      newArr2[ingredients.length] = new SeaweedPortion(0.11);
      ingredients = newArr2;
    }
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public IngredientPortion[] getIngredients() {
    //        IngredientPortion[] listPortions = ingredients;
    return ingredients;
  }

  @Override
  public int getCalories() {
    double calTotal = 0;
    for (int i = 0; i < ingredients.length; i++) {
      calTotal += ingredients[i].getCalories();
    }
    return (int) calTotal;
  }

  @Override
  public double getCost() {
    double costTotal = 0;
    for (int i = 0; i < ingredients.length; i++) {
      costTotal += ingredients[i].getCost();
    }
    return Math.round(costTotal * 100.0) / 100.0;
  }

  @Override
  public boolean getHasRice() {
    for (int i = 0; i < ingredients.length; i++) {
      if (ingredients[i].getIsRice()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getHasShellfish() {
    for (int i = 0; i < ingredients.length; i++) {
      if (ingredients[i].getIsShellfish()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getIsVegetarian() {
    for (int i = 0; i < ingredients.length; i++) {
      if (ingredients[i].getIsVegetarian()) {
        return true;
      }
    }
    return false;
  }
}
