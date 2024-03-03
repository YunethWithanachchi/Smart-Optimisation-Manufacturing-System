package SupplyChainManager;

public class Good {
    String name;

   double price;

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void showDetails(){
       System.out.println("name : "+name);
       System.out.println("price : "+price);
   }
}
