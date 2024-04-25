import cashYou.User;
import cashYou.User.Spend;

public class BudgetCalculation {
	double budgetCalculationVal;
	double value;
	double percentage;
	double count;
	
	public double BudgetCalculationVal(){
	
		budgetCalculationVal = getMoneyAllowed();
	}
	
    //percentage for various expenses with 
	//the amount of money that they are allowed to spend.
	public percentage(int value) {
		      if (value < 0 || value > 100) {
		         throw new IllegalArgumentException();
		      } else {
		         this.value = percentage;
		      }
		   }

	public double getPercentage() {
		return value;
	}
	}
	
	public void setMoviePercentage(double value){
		percentage +=value;
		public percentage(double percentage);
		count++;
	}
	
	public double getMovieExpense() {
		return (percentage/100)*(budgetCalculationVal);
	}
	
	public void setFoodPercentage(double value){
		percentage +=value;
		public percentage(double percentage);
		count++;
	}
	
	public double getFoodExpense() {
		return (percentage/100)*(budgetCalculationVal);
	}
	
	public void setShoppingPercentage(double value){
		percentage +=value;
		public percentage(double percentage);
		count++;
	}
	
	public double getShoppingExpense() {
		return (percentage/100)*(budgetCalculationVal);
	}
	
	public void setTravelPercentage(double value){
		percentage +=value;
		public percentage(double percentage);
		count++;
	}
	
	public double getTravelExpense() {
		return (percentage/100)*(budgetCalculationVal);
	}
	
	public void setSavingPercentage(double count, double percentage){
	double saving = budgetCalculationVal - (getPercentage()/100)*(budgetCalculationVal);
	}
	
	public double getSavingExpense() {
		return saving;
	}
	
}
