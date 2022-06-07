package RRSP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookingClass {

    private int alb,amb,aub;
    private int RAC;
    private int waiting;
    private Map<String, ArrayList<String>> Kids_info;
    private Map<String, ArrayList<String>> Tickets;
    private Map<String, ArrayList<String>> RAC_Tickets;
    private Map<String, ArrayList<String>> Waiting_Tickets;


    public BookingClass() {
        alb = 0;
        amb = 0;
        aub = 0;
        RAC = 0;
        waiting = 0;
        Kids_info = new HashMap<String, ArrayList<String>>();
        Tickets = new HashMap<String, ArrayList<String>>();
        RAC_Tickets = new HashMap<String, ArrayList<String>>();
        Waiting_Tickets = new HashMap<String, ArrayList<String>>();
    }

    public void Book(){
        if(waiting >= 2){
            System.out.println("No tickets available");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Name: ");
            String Name = sc.nextLine();
            System.out.println("Enter Age: ");
            int age = sc.nextInt();
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Enter Gender: ");
            String gender = sc1.nextLine();
            System.out.println("Enter Berth Preference: ");
            String pref = sc1.nextLine();

            ArrayList temp = new ArrayList();
            temp.add(Name);
            temp.add(age);
            temp.add(gender);
            temp.add(pref);

            if(age<=5){
                System.out.println("Ticket cannot be allocated to user with age below 5");
                Kids_info.put(Integer.toString(alb), temp);
                Kids_info.put(Integer.toString(amb),temp);
                Kids_info.put(Integer.toString(aub),temp);

            } else {
                if(alb < 2){
                    alb += 1;
                    System.out.println("Your seat #" + alb + " is confirmed");
                    Tickets.put(Integer.toString(alb), temp);
                } else if (amb < 2) {
                    amb += 1;
                    System.out.println("Your seat #" + amb + " is confirmed");
                    Tickets.put(Integer.toString(amb), temp);
                } else if (aub < 2) {
                    aub += 1;
                    System.out.println("Your seat #" + aub + " is confirmed");
                    Tickets.put(Integer.toString(aub), temp);
                }
               else {
                    if(RAC < 2){
                        RAC += 1;
                        System.out.println("You are added to RAC #" + RAC);
                        RAC_Tickets.put(Integer.toString(RAC), temp);
                    } else {
                        waiting += 1;
                        System.out.println("You are added to wating list #" + waiting);
                        Waiting_Tickets.put(Integer.toString(waiting), temp);
                    }
               }
            }
        }
    }

    public void Cancel(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Seat Number to Cancel: ");
        int tn = sc.nextInt();

        if (Tickets.containsKey(Integer.toString(tn))) {
            Tickets.remove(Integer.toString(tn));
            if(RAC > 0){
                RAC -= 1;
                Tickets.put(Integer.toString(tn), RAC_Tickets.get(Integer.toString(RAC_Tickets.size())));
                RAC_Tickets.remove(Integer.toString(RAC_Tickets.size()));
                if (waiting > 0){
                    waiting -= 1;
                    RAC_Tickets.put(Integer.toString(tn), Waiting_Tickets.get(Integer.toString(Waiting_Tickets.size())));
                    Waiting_Tickets.remove(Integer.toString(Waiting_Tickets.size()));
                }
            }
            System.out.println("Your ticket is canclled");
        } else {
            System.out.println("Invalid Ticket Number");
        }
    }

    public void printBooked() {
        for (Map.Entry<String, ArrayList<String>> entry : Tickets.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> val = entry.getValue();

            System.out.println("Seat #" + key);
            System.out.println("Details: " + val);
        }
    }

    public void printAvail() {
        int rem = 2 - Tickets.size();
        System.out.println(rem + " tickets available");
    }
}