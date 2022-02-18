package Models.linked;

import Models.simple.MovementType;

public class ProdMovement {
    public int Id;
    public int ProductId;
    public int Count;
    public int MovementTypeId;
    public PurchaseHistory PurchaseHistory;
    public Provider Provider;
    public MovementType MovementType;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public int getMovementTypeId() {
        return MovementTypeId;
    }

    public void setMovementTypeId(int movementTypeId) {
        MovementTypeId = movementTypeId;
    }

    public PurchaseHistory getPurchaseHistory() {
        return PurchaseHistory;
    }

    public void setPurchaseHistory(PurchaseHistory purchaseHistory) {
        PurchaseHistory = purchaseHistory;
    }

    public Provider getProvider() {
        return Provider;
    }

    public void setProvider(Provider provider) {
        Provider = provider;
    }

    public MovementType getMovementType() {
        return MovementType;
    }

    public void setMovementType(Models.simple.MovementType movementType) {
        MovementType = movementType;
    }

    public Product getProduct() {
        return Product;
    }

    public void setProduct(Product product) {
        Product = product;
    }

    public Product Product;
}
