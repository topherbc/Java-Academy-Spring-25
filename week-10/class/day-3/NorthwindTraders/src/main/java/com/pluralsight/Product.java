package com.pluralsight;

/**
 * Product model class representing the Products table
 */
class Product {
    private int productId;
    private String productName;
    private Integer supplierId;
    private Integer categoryId;
    private String quantityPerUnit;
    private java.math.BigDecimal unitPrice;
    private Short unitsInStock;
    private Short unitsOnOrder;
    private Short reorderLevel;
    private boolean discontinued;

    // Constructors
    public Product() {}

    public Product(String productName, Integer supplierId, Integer categoryId,
                   String quantityPerUnit, java.math.BigDecimal unitPrice,
                   Short unitsInStock, Short unitsOnOrder, Short reorderLevel,
                   boolean discontinued) {
        this.productName = productName;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;
    }

    // Getters and Setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public Integer getSupplierId() { return supplierId; }
    public void setSupplierId(Integer supplierId) { this.supplierId = supplierId; }

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public String getQuantityPerUnit() { return quantityPerUnit; }
    public void setQuantityPerUnit(String quantityPerUnit) { this.quantityPerUnit = quantityPerUnit; }

    public java.math.BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(java.math.BigDecimal unitPrice) { this.unitPrice = unitPrice; }

    public Short getUnitsInStock() { return unitsInStock; }
    public void setUnitsInStock(Short unitsInStock) { this.unitsInStock = unitsInStock; }

    public Short getUnitsOnOrder() { return unitsOnOrder; }
    public void setUnitsOnOrder(Short unitsOnOrder) { this.unitsOnOrder = unitsOnOrder; }

    public Short getReorderLevel() { return reorderLevel; }
    public void setReorderLevel(Short reorderLevel) { this.reorderLevel = reorderLevel; }

    public boolean isDiscontinued() { return discontinued; }
    public void setDiscontinued(boolean discontinued) { this.discontinued = discontinued; }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', unitPrice=%s, unitsInStock=%s, discontinued=%s}",
                productId, productName, unitPrice, unitsInStock, discontinued);
    }
}