
import java.io.File;
import java.util.Scanner;
public class Orders {
    public static Scanner input = new Scanner(System.in);
    public static LinkedList<Order> orders = new LinkedList<>();

    public static LinkedList getOrders() {
        return orders;
    }
    
    public Orders(String fileName){
        try{
           File inputFile = new File(fileName);
           Scanner fileScanner = new Scanner (inputFile);
           String line = fileScanner.nextLine(); 
           
           while(fileScanner.hasNext()){
               line = fileScanner.nextLine();
               String[] data = line.split(",");
               int orID = Integer.parseInt(data[0]);
               int cRef = Integer.parseInt(data[1]);
               String  pp =  data[2].replaceAll("\"", "");
               String [] p = pp.split(";");
                Integer [] pids = new Integer [p.length];
                for ( int i = 0 ; i< pids.length ; i++)
                    pids[i] = Integer.parseInt(p[i].trim());
                double price = Double.parseDouble(data[3]);
                String date = data[4];
                String status = data[5];
                Order order = new Order(orID, cRef, pids, price, date, status );
                    orders.insert(order);
           }
           fileScanner.close();
        }
        
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }   
    }
    
    public boolean cancelOrder(int orID){
        Order corder = searchByID(orID);
            if(corder!=null){
                if(corder.getStatus().equalsIgnoreCase("cancelled")){
                    System.out.println("Order with ID: "+corder.getOrderID()+" was canelled before");
                    return false ;}
            corder.setStatus("cancelled");
            return true ;
            }                 
            return false ;
        
    }
    
    
    public boolean updateOrderState(int orID , String status){
        Order order = searchByID(orID);
        if(order!=null){
            if(order.getStatus().equalsIgnoreCase("cancelled")){
                System.out.println("Could not change cancelled order state");
                return false;}
            order.setStatus(status);
            System.out.println("Status for order: "+orID+" changed to "+status);
            return true ;
        }
      return false ;
    }
    
    
    
    public Order searchByID(int orID){
        
        if(orders.empty())
            return null ;
        orders.findFirst();
        while(!orders.last()){
            if(orders.retrieve().getOrderID()==orID)
                return orders.retrieve();
            orders.findNext();
        }
        if(orders.retrieve().getOrderID()==orID)
                return orders.retrieve();
        
        System.out.println("Order not found!");
        return null;
        
        
    }
    
   public LinkedList<Order> getOrdersBetweenTwoDates(String date1 , String date2){ //for yyyy-mm-dd format
       LinkedList<Order> OrdersBetweenDates = new LinkedList<>();
       if(orders.empty())
           return OrdersBetweenDates ;
       orders.findFirst();
       while(!orders.last()){
         Order order = orders.retrieve();
         if(order.getOrderDate().compareTo(date1)>=0&&order.getOrderDate().compareTo(date2)<=0)
             OrdersBetweenDates.insert(order);
         orders.findNext();
       }
       //for the last :
       Order order = orders.retrieve();
         if(order.getOrderDate().compareTo(date1)>=0&&order.getOrderDate().compareTo(date2)<=0)
             OrdersBetweenDates.insert(order);
         
        return OrdersBetweenDates ;
   }
}
