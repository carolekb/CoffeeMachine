import java.util.Scanner;
public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCups = -1, availableWater, availableMilk, availableCoffebeans;
        int numberOfPossibleCups;
        String wpis;
        do {
            System.out.println("Write how many ml of water the coffee machine has:");
        }while((availableWater = checkInput(scanner.nextLine())) == -1);
        do{
            System.out.println("Write how many ml of milk the coffee machine has:");
        }while((availableMilk = checkInput(scanner.nextLine())) == -1);
        do {
            System.out.println("Write how many grams of coffee beans the coffee machine has:");
        }while((availableCoffebeans = checkInput(scanner.nextLine())) == -1);
        do{
            System.out.println("Write how many cups of coffee you will need: ");
        }while((numberOfCups = checkInput(scanner.nextLine())) == -1);

        numberOfPossibleCups = howManyPossibleCups(availableWater, availableMilk, availableCoffebeans);
        if(numberOfPossibleCups > numberOfCups){
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", numberOfPossibleCups);
        }else if(numberOfPossibleCups == numberOfCups) {
            System.out.println("Yes, I can make that amount of coffee");
        }else {
            System.out.printf("No, I can make only %d cup(s) of coffee\n", numberOfPossibleCups);
        }
    }

    public static int checkInput(String wpis){
        int number = 0;
        for(int i = 0 ; i < wpis.length() ; i++){
            if(wpis.charAt(i) < 48 || wpis.charAt(i) > 57 ){
                System.out.printf("Error: \"%s\" isn't a valid number.\n", wpis);
                number = -1;
                break;
            }
        }
        if(number == -1) return -1;
        for(int i = 0 ; i < wpis.length() ; i++){
            number = number * 10;
            number = number + wpis.charAt(i) - 48;
        }
        return number;
    }
    public static int howManyPossibleCups(int availableWater, int availableMilk, int availableCoffebeans){
        int numberOfPossibleCups = 0;
        while(availableWater / 200 > numberOfPossibleCups
                && availableMilk / 50 > numberOfPossibleCups
                && availableCoffebeans / 15 > numberOfPossibleCups){
            numberOfPossibleCups++;
        }
        return numberOfPossibleCups;
    }
}
