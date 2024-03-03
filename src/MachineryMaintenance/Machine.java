package MachineryMaintenance;

public class Machine {
    private String prevServiceDate;
    private String nextServiceDate;
    private String brand;
    private String manufactureDate;
    private String serialNo;

    public Machine(String prevServiceDate, String nextServiceDate, String brand, String manufactureDate, String serialNo) {
        this.prevServiceDate = prevServiceDate;
        this.nextServiceDate = nextServiceDate;
        this.brand = brand;
        this.manufactureDate = manufactureDate;
        this.serialNo = serialNo;
    }

    public String getPrevServiceDate() {
        return prevServiceDate;
    }

    public void setPrevServiceDate(String prevServiceDate) {
        this.prevServiceDate = prevServiceDate;
    }

    public String getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(String nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    @Override
    public String toString() {
        return
                 serialNo + "\t\t\t"+
                 brand + "\t\t" +
                 manufactureDate + "\t\t\t" +
                 prevServiceDate + "\t\t\t" +
                 nextServiceDate
                ;
    }
}
