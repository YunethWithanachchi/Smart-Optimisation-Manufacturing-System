package SupplyChainAnalysis;

class ProductMovement {
    private int productId;
    private String destination;
    private int quantity;
    private String transportationMode;
    private double transportationCost;
    private String deliveryStatus;
    private int deliveryTime; // in days
    private int deliveryDelay; // in days

    // Constructor
    public ProductMovement(int productId, String destination,
                           int quantity, String transportationMode, double transportationCost,
                           String deliveryStatus, int deliveryTime, int deliveryDelay) {
        this.setProductId(productId);
        this.setDestination(destination);
        this.setQuantity(quantity);
        this.setTransportationMode(transportationMode);
        this.setTransportationCost(transportationCost);
        this.setDeliveryStatus(deliveryStatus);
        this.setDeliveryTime(deliveryTime);
        this.setDeliveryDelay(deliveryDelay);
    }

    // Method to display product movement details
    public void displayDetails() {
        System.out.println("Product Movement Details:");
        System.out.println("Product ID: " + getProductId());
        System.out.println("Destination: " + getDestination());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Transportation Mode: " + getTransportationMode());
        System.out.println("Transportation Cost: $" + getTransportationCost());
        System.out.println("Delivery Status: " + getDeliveryStatus());
        System.out.println("Delivery Time: " + getDeliveryTime() + " days");
        System.out.println("Delivery Delay: " + getDeliveryDelay() + " days\n");
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTransportationMode() {
        return transportationMode;
    }

    public void setTransportationMode(String transportationMode) {
        this.transportationMode = transportationMode;
    }

    public double getTransportationCost() {
        return transportationCost;
    }

    public void setTransportationCost(double transportationCost) {
        this.transportationCost = transportationCost;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getDeliveryDelay() {
        return deliveryDelay;
    }

    public void setDeliveryDelay(int deliveryDelay) {
        this.deliveryDelay = deliveryDelay;
    }
    @Override
    public String toString() {
        return "ProductMovement{" +
                "productId=" + productId +
                ", destination='" + destination + '\'' +
                ", quantity=" + quantity +
                ", transportationMode='" + transportationMode + '\'' +
                ", transportationCost=" + transportationCost +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", deliveryDelay=" + deliveryDelay +
                '}';
    }
}
