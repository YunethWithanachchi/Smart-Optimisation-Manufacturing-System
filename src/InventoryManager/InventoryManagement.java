package InventoryManager;

import java.util.HashMap;
import java.util.Map;

public class InventoryManagement{

    private  int totalStorageCapacity;
    private Map<String, Integer> rawMaterialsInventory;
    Map<String, Integer> finishedGoodsInventory;

    public InventoryManagement(int totalStorageCapacity) {
        this.totalStorageCapacity = totalStorageCapacity;
        this.rawMaterialsInventory = new HashMap<>();
        this.finishedGoodsInventory = new HashMap<>();
    }

    // Concrete class for raw materials
    public static class RawMaterial implements InventoryItem {
        private final String name;

        public RawMaterial(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    // Concrete class for finished goods
    public static class FinishedGood implements InventoryItem {
        private final String name;

        public FinishedGood(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    // Method to add any type of inventory item (polymorphic)
    public void addInventory(InventoryItem item, int quantity) {
        if (isStockOverloaded(getTotalInventory() + quantity)) {
            System.out.println("The stock is overloaded");
            return;
        }

        if (item instanceof RawMaterial) {
            addRawMaterial(((RawMaterial) item).getName(), quantity);
        } else if (item instanceof FinishedGood) {
            addFinishedGoods(((FinishedGood) item).getName(), quantity);
        } else {
            throw new IllegalArgumentException("Unsupported inventory item type");
        }
    }

    // Existing methods renamed to private for encapsulation
    void addRawMaterial(String materialName, int quantity) {
        rawMaterialsInventory.put(materialName, rawMaterialsInventory.getOrDefault(materialName, 0) + quantity);
    }

    void removeRawMaterial(String materialName, int quantity) {
        int currentQuantity = rawMaterialsInventory.getOrDefault(materialName, 0);
        if (currentQuantity >= quantity) {
            rawMaterialsInventory.put(materialName, currentQuantity - quantity);
        } else {
            System.out.println("Insufficient quantity of " + materialName + " in inventory.");
        }
    }

    void addFinishedGoods(String productName, int quantity) {
        finishedGoodsInventory.put(productName, finishedGoodsInventory.getOrDefault(productName, 0) + quantity);
    }

    void removeFinishedGoods(String productName, int quantity) {
        int currentQuantity = finishedGoodsInventory.getOrDefault(productName, 0);
        if (currentQuantity >= quantity) {
            finishedGoodsInventory.put(productName, currentQuantity - quantity);
        } else {
            System.out.println("Insufficient quantity of " + productName + " in inventory.");
        }
    }

    private int getTotalInventory() {
        int total = 0;
        for (int quantity : rawMaterialsInventory.values()) {
            total += quantity;
        }
        for (int quantity : finishedGoodsInventory.values()) {
            total += quantity;
        }
        return total;
    }

    private boolean isStockOverloaded(int totalQuantity) {
        return totalQuantity >= totalStorageCapacity;
    }
}


