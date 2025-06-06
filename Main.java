import java.util.ArrayList;
import java.util.Scanner;


public class Main
{
   public static void main(String[] args)
   {
       String returnMenu = "yes";
       String waiter = "";
       String scale1 = "Very Good"; String scale2 = "Good"; String scale3 = "Fair"; String scale4 = "Poor"; String scale5 = "DEMOLISHED";


       Appliance a = new Appliance("Couch", 1, scale5, 50, "Two legs fallen off, stiches ripped");
       Appliance b = new Appliance("3D Printer", 5, scale3, 200, "soooo hard to fix these thingys");
       Appliance c = new Appliance("Chairs", 5, scale2, 20, "Spare classroom chairs");
       Appliance d = new Appliance("Monitors", 3, scale1, 500, "Brand new monitors");
       Appliance e = new Appliance("Toaster", 1, scale4, 10, "Toast always comes burnt");
       ArrayList<Appliance> items = new ArrayList<Appliance>();
       items.add(a); items.add(b); items.add(c); items.add(d); items.add(e); //preset array


       Scanner inputStr = new Scanner(System.in); //Seperate scanners for int/String
       Scanner inputint = new Scanner(System.in);
       while(returnMenu.equals("yes"))
       {
       System.out.println("Welcome to your Inventory! " + "\n" + "1: Print Inventory" + "\n" + "2: Add Items" + "\n" + "3: Remove Items" + "\n");
       int decision = inputint.nextInt();
       Inventory storage = new Inventory(items, 50);
       if(decision == 1)
       {
           storage.checkCollection(); //make sure its good before each print
           System.out.println("NAME / QUANTITY / QUALITY / REPLACE COST / NOTES");
           System.out.println(storage);
           System.out.println("Go main menu? yes or no.");
           returnMenu = inputStr.next();
       }
       if(decision == 2)
       {
           System.out.println("Appliance name: ");
           String name = inputStr.next();


           System.out.println("Quantity: ");
           int quantity = inputint.nextInt();


           System.out.println("Condition: ");
           String condition = inputStr.next();


           System.out.println("Replacement Cost: ");
           int rc = inputint.nextInt();


           System.out.println("Notes: ");
           String note = inputStr.next();


           storage.addItem(new Appliance(name, quantity, condition, rc, note));
           System.out.println("Go main menu? yes or no.");
           returnMenu = inputStr.next();
          
       }
       if(decision == 3)
       {
           System.out.println("What index? ");
           int index = inputint.nextInt();


           while(index >= storage.getRawList().size())
           {
               System.out.println("Try again. ");
               index = inputint.nextInt();
           }


           System.out.println("How many to remove? ");
           int amount = inputint.nextInt();
           while(amount > storage.getRawList().get(index).getQuant())
           {
               System.out.println("Try again. ");
               amount = inputint.nextInt();
           }
           storage.removeItem(index, amount);
           System.out.println("Go main menu? yes or no.");
           returnMenu = inputStr.next();
       }
       waiter = "waiting"; //buffer
      
   }
   System.out.println("Closing inventory....");
   inputint.close();
   inputStr.close();
   }


}
