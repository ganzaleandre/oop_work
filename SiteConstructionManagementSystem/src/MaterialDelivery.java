public class MaterialDelivery extends ConstructionMaterial {

    public MaterialDelivery(Constructor contractor) {
        super(contractor);
    }

    @Override
    public void receiveMaterial() {
        double quantity = contractor.getMaterialQuantity();
        if (quantity >= 1 && quantity <= 10) {
            contractor.setMaterialBalance(contractor.getMaterialBalance() + quantity);
            System.out.println("Material delivered successfully. New balance: " + contractor.getMaterialBalance() + " tons.");
        } else {
            System.out.println("Error: Delivery quantity must be between 1 and 10 tons.");
        }
    }

    @Override public void useMaterial() {}
    
    @Override public void estimateCost() {}
}
