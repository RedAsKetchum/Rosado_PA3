import java.text.DecimalFormat;
public class Application {

    static DecimalFormat df = new DecimalFormat("#.00");  //Set Savings to two decimal places
                                                                  //since we are dealing with money
    //TEST PROGRAM
    public static void main(String args[]){
int totalMonths =12;
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

   //set annual interest to 4%
        SavingsAccount.modifyInterestRate (4);  //modify interest in class SavingsAccount
        System.out.println("Savings at 4% Annual Interest Rate for Saver 1:  ");
        System.out.println("");

        //Calculate Monthly Interest
        for(int i=1;i<=totalMonths;i++)
        {
            double monthlyInterest = saver1.calculateMonthlyInterest();  //calculates monthly interest and adds it to current saver1 balance //at 4%
            saver1.setSavingBalance(monthlyInterest);

            System.out.println("Month "+i+": Balance = $"+df.format(saver1.getSavingBalance()));
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Savings at 4% Annual Interest Rate for Saver 2: ");
        System.out.println("");

        for(int i=1;i<=totalMonths;i++)
        {
            double monthlyInterest = saver2.calculateMonthlyInterest();  //calculates monthly interest and adds it to current saver2 balance // at 4%
            saver2.setSavingBalance(monthlyInterest);

            System.out.println("Month "+i+": Balance = $"+df.format(saver2.getSavingBalance()));

        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("");

        System.out.println("Savings at 5% Annual Interest Rate for Saver 1: ");
        System.out.println("");

        //sets Annual Interest Rate to 5%
        SavingsAccount.modifyInterestRate (5);  //modify interest in class SavingsAccount

        //Reset Saving values for Saver1 and Saver2
        saver1.setSavingBalance(2000.00);
        saver2.setSavingBalance(3000.00);

        //Calculate Monthly Interest
        for(int i=1;i<=totalMonths;i++)
        {
            double monthlyInterest = saver1.calculateMonthlyInterest();  //calculates monthly interest and adds it to current saver1 balance //at 4%
            saver1.setSavingBalance(monthlyInterest);

            System.out.println("Month "+i+": Balance = $"+df.format(saver1.getSavingBalance()));
            //monthlyI_month[i]=this.savingBalance;    Could use array to store balance for each month
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Savings at 5% Annual Interest Rate for Saver 2: ");
        System.out.println("");

        for(int i=1;i<=totalMonths;i++)
        {
            double monthlyInterest = saver2.calculateMonthlyInterest();  //calculates monthly interest and adds it to current saver2 balance // at 4%
            saver2.setSavingBalance(monthlyInterest);

            System.out.println("Month "+i+": Balance = $"+df.format(saver2.getSavingBalance()));
            //monthlyI_month[i]=this.savingBalance;    Could use array to store balance for each month
        }

    }

}
