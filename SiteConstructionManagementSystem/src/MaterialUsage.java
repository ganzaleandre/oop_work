public class MaterialUsage extends ConstructionMaterial {

    public MaterialUsage(Constructor contractor) {
        super(contractor);
    }

    @Override
    public void useMaterial() {
        double quantityToUse = contractor.getMaterialQuantity();
        double currentBalance = contractor.getMaterialBalance();

        if (currentBalance - quantityToUse >= 2) {
            contractor.setMaterialBalance(currentBalance - quantityToUse);
            System.out.println("Material used: " + quantityToUse + " tons.");
            System.out.println("Remaining material balance: " + contractor.getMaterialBalance() + " tons.");
        } else {
            System.out.println("Error: Not enough material available. Must retain at least 2 tons in stock.");
        }
    }

    @Override public void receiveMaterial() {}
    
    @Override public void estimateCost() {}
}
