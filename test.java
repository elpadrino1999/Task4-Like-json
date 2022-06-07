package RRSP;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        boolean loop = true;
        BookingClass bc = new BookingClass();
        System.out.println("Enter 1.Book 2.printbooked 3.printavailable 4.Cancel");
        while (loop){
            Scanner sc = new Scanner(System.in);
            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    bc.Book();
                    break;
                case 2:
                    bc.printBooked();
                    break;
                case 3:
                    bc.printAvail();
                    break;
                case 4:
                    bc.Cancel();
                    break;
                case 5:
                    loop = false;
                    break;
                default:
                    System.out.println("Please provide valid input");
                    break;
            }

        }
    }
}