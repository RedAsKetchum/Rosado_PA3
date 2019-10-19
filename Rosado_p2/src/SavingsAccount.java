public class SavingsAccount {

    //Field Variables //attributes
    static private double annualInterestRate;
    private double savingsBalance;

    //Constructor
    public SavingsAccount(double savingBalance){
        this.savingsBalance = savingBalance; //private instance variable
    }
    //METHODS
    //Getter
    public double getSavingBalance()
    {
        return this.savingsBalance;
    }
   //Setter
   public void setSavingBalance(double newBalance){
        this.savingsBalance = newBalance;
   }

    public static void modifyInterestRate(double newValue){
        annualInterestRate = newValue/100.0; //to convert from percent to decimal
    }

    public double calculateMonthlyInterest()
    {
        double monthlyInterest;
        monthlyInterest= (this.savingsBalance*annualInterestRate/12); //calculates ANNUAL interest
        this.savingsBalance= this.savingsBalance + monthlyInterest ;  //2000 plus like 6.66 dollars

        return this.savingsBalance;
    }

}

