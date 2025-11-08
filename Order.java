
public class Order {
    private int orderID ;
    private int customerRef ;
    private LinkedList<Integer> products=new LinkedList<>();;
    private double totalPrice ;
    private String orderDate ; //in yyyy-mm-dd
    private String status ;

    public Order(int orderID, int customerRef,Integer[] productsIDs, double totalPrice, String orderDate, String status) {
        this.orderID = orderID;
        this.customerRef = customerRef;  
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.status = status;
        
        for(int i=0 ; i< productsIDs.length ;i++ )
        products.insert(productsIDs[i]);
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(int customerRef) {
        this.customerRef = customerRef;
    }

    public LinkedList<Integer> getProducts() {
        return products;
    }

    public void setProducts(int pID) {
        this.products.insert(pID);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String str = "Order ID: " + "orderID=" + orderID + ", customer  ID : =" + customerRef + 
                "\nproducts=" + products + " |totalPrice= " + totalPrice + " |orderDate= " + orderDate + " |status= " + status ;
        if(!products.empty()){
            str+="\n Products List :";
            products.findFirst();
            while(!products.last()){
                str+=products.retrieve()+"|";
                products.findNext();
            }
             str+=products.retrieve();      
        }
           return str;
    }
    
    
    
}
