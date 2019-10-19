import java.security.SecureRandom;
import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class Computer_Assisted_Instruction {

    //Field Variables //Class Attributes
    static int difficulty, flag;
    static double inputAnswer,num1, num2, result; //Students answer with double precision floating point
    static double totalQuestions = 10;
    static int i = 1;
    static int run =1;
    static double correct, wrong = 0;
    static int typeOperation;

   static SecureRandom random = new SecureRandom();
   static DecimalFormat df = new DecimalFormat("#.00");

    //Methods
    public static void setMath(){
        int input;
        Scanner scnr = new Scanner (System.in);


        System.out.println("--Arithmetic Problem Type Menu--");
        System.out.println("Enter 1 for addition, 2 for multiplication, " +
                           "3 for substraction, 4 for division or 5 for mixed problems. ");

        input = scnr.nextInt();

      switch(input){
          case 1: typeOperation = 1;
          break;
          case 2: typeOperation = 2;
              break;
          case 3: typeOperation = 3;
              break;
          case 4: typeOperation = 4;
              break;
          case 5: flag = 1;
              break;
      }
    }

    public static void setDifficulty(){   //sets amount of integers of operand

        System.out.println("--Difficulty Menu--");
        System.out.println("Choose from 1 up to 4 total digits.");
        System.out.println("Enter option: ");

        Scanner scnr = new Scanner(System.in);
        difficulty = scnr.nextInt();

    }

    public static int getRand(){   //This method will set the amount of integers for each math operation
        if(difficulty == 1){
            int num = (random.nextInt(9) + 1); //bound to single integers only from 1 to 9
            return num;
        }
        else if(difficulty == 2){
            int num = (random.nextInt(99) + 1);
            return num;
        }
        else if(difficulty == 3){
            int num = (random.nextInt(999) + 1);
            return num;
        }
        else if(difficulty == 4){
            int num = (random.nextInt(9999) + 1);
            return num;
        }
        return 0;
    }

    public static void mixedOperations(){
        num1 = getRand();
        num2 = getRand();

        typeOperation = (random.nextInt(4) + 1); //Randomize operation type

        switch(typeOperation){
            case 1: result =  num1 + num2;
                System.out.println(i + ") How much is " + (int) num1 + " plus " + (int) num2 + "?");
                break;
            case 2: result =  num1 * num2;
                System.out.println(i + ") How much is " + (int)num1 + " times " + (int)num2 + "?");
                break;
            case 3: result =  num1 - num2;
                System.out.println(i + ") How much is " + (int)num1 + " minus " + (int)num2 + "?");
                break;
            case 4: result = num1/num2;
                System.out.println(i + ") How much is " + (int) num1 + " divided by " + (int)num2 + "?");
                //checks for full decimal places
                break;
        }
    }

    public static void Operations(){

        //switch statement for type of operation to run
         num1 = getRand();
         num2 = getRand();

        switch(typeOperation){
            case 1: result = num1 + num2; //result is of double precision floating point
                System.out.println(i + ") How much is " + (int)num1 + " plus " + (int)num2 + "?");
                break;
            case 2: result = num1 * num2;
                System.out.println(i + ") How much is " + (int)num1 + " times " + (int)num2 + "?");
                break;
            case 3: result = num1 - num2;
                System.out.println(i + ") How much is " + (int)num1 + " minus " + (int)num2 + "?");
                break;
            case 4: result = num1 / num2;
                System.out.println(i + ") How much is " + (int) num1 + " divided by " + (int)num2 + "?");
                break;
        }
    }

    public static void newQuestion() {
        int message;

while(run==1) {
    while (i <= totalQuestions) {

        if (flag == 0) {
            Operations(); //sets new numbers for new question
        }
        else if (flag == 1){
            mixedOperations(); //sets new numbers for next question with mixed operators
        }

        Scanner scnr = new Scanner(System.in);
        inputAnswer = scnr.nextDouble();

            if (Math.abs(inputAnswer - result) <0.0001) {//This is how you can compare double values in Java

            message = (random.nextInt(4) + 1);

            switch (message) {
                case 1:
                    System.out.println("Very good!");
                    correct++;
                    break;
                case 2:
                    System.out.println("Excellent!");
                    correct++;
                    break;
                case 3:
                    System.out.println("Nice work!");
                    correct++;
                    break;
                case 4:
                    System.out.println("Keep up the good work!");
                    correct++;
                    break;
            }
            i++;

        } else {
            message = (random.nextInt(4) + 1);

            switch (message) {
                case 1:
                    System.out.println("No. Please try again.");
                    wrong++;
                    break;
                case 2:
                    System.out.println("Wrong. Try once more.");
                    wrong++;
                    break;
                case 3:
                    System.out.println("Don’t give up!");
                    wrong++;
                    break;
                case 4:
                    System.out.println("No. Keep trying.");
                    wrong++;
                    break;
            }
            i++;
        }
    }
    double total = (correct / totalQuestions) * 100;
    System.out.println("Your score is: " + total + "% !");

    if (total < 75.0) {
        System.out.println("Please ask your teacher for extra help.");
    }
    else if(total>=75.0){
        System.out.println("Congratulations, you are ready to go to the next level!");
    }
    System.out.println("");
    System.out.println("Next student's turn.");
    System.out.println("Welcome! Let's learn math!");

    //RESETTING PROGRAM...
    setMath();
    setDifficulty();
    i = 1;
    correct = 0;
    wrong = 0;
    flag=0;
}
    }
    //MAIN
    public static void main (String[] args){

        System.out.println("Welcome! Let's learn math!");
        setMath();
        setDifficulty();
        newQuestion();
    }
}
