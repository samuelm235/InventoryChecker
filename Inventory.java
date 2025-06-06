import java.util.ArrayList;




public class Inventory
{
   private ArrayList<Appliance> itemCollection;
   private static int storageSpace;
   private int usedStorage  = 0;
   public Inventory(ArrayList<Appliance> preList, int size)
   {
       itemCollection = preList;
       storageSpace = size;
       for(Appliance t : preList)
       {
           usedStorage += t.getQuant();
       }
   }


   public Inventory(int size)
   {
       storageSpace = size;
   }


  
   public ArrayList<Appliance> getRawList()
   {
       return itemCollection;
   }


   public void addItem(Appliance newEquipment)
   {
       int amount = newEquipment.getQuant();
       for(Appliance t : itemCollection)
       {
           if(t.getName().equals(newEquipment.getName())) //If item is a copy,
           {
               if(usedStorage + amount < storageSpace) //and there is space
               {
                   t.changeStock(amount); //change quantity of item
                   usedStorage += amount;
                   break;
               }
           }
       }
       if(usedStorage + amount < storageSpace)// otherwise, if there is space
       {
           itemCollection.add(newEquipment); //add new item
           usedStorage += amount;
       }
       else{System.out.println("STORAGE TOO FULL");} // otherwise, return error
   }




   public void removeItem(int index, int amount)
   {
       itemCollection.get(index).changeStock(-amount); //remove specified quantity
   }
  
   public void checkCollection() //removes items of quanitity 0 or less
   {
       for(int i = 0; i < itemCollection.size(); i++)
       {
           if(itemCollection.get(i).getQuant() <= 0)
           {
               itemCollection.remove(i);
           }
       }
   }


   public String toString()
   {
       String s = "";
       for(Appliance t : itemCollection)
       {
           s += t.toString() + "\n";
       }
       return s;
   }


}
