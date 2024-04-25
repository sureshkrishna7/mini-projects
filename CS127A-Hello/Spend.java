/*Spend Class
 * 
 * This class deals with all things involving money.
 * It takes values of money that will be spent on necessities and
 * for other reasons. It also determines the total amount of money
 * spent and the money a user can spend, depending on his paycheck 
 * and budget.
 * 
 */
public class Spend {
	private double payCheck;
	private double rent;	
	private double foodCost;	
	private double utilities;	
	private double misc;
	private double totalSpent;
	private double moneyAllowed;
	
    //Constructor sets all values to zero.	
	public Spend(){
		payCheck     = 0.00;
		rent         = 0.00;
		foodCost     = 0.00;
		utilities    = 0.00;
		misc         = 0.00;
		totalSpent   = 0.00;
		moneyAllowed = 0.00;
	}
	
	public double getPayCheck(){
		return payCheck;
	}
	
	public double getRent(){
		return rent;
	}
	
	public double getFoodCost(){
		return foodCost;
	}
	
	public double getUtilities(){
		return utilities;
	}
	
	public double getMisc(){
		return misc;
	}
	
	public double getTotalSpent(){
		return totalSpent;
	}
	
	public double getMoneyAllowed(){
		return moneyAllowed;
	}
	
	public void setPayCheck(double val){
		payCheck = val;
	}
	
	public void setRent(double val){
		rent = val;
		totalSpent += val;
	}
	
	public void setFoodCost(double val){
		foodCost = val;
		totalSpent += val;
	}
	
	public void setUtilities(double val){
		utilities = val;
		totalSpent += val;
	}
	
	public void setMisc(double val){
		misc = val;
		totalSpent += val;
	}
	
	public void setMoneyAllowed(){
		moneyAllowed = payCheck - totalSpent;
	}
}
