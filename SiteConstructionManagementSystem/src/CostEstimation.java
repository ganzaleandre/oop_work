public class CostEstimation extends ConstructionMaterial {

    public CostEstimation(Constructor contractor) {
        super(contractor);
    }

    @Override
    public void estimateCost() {
        double quantity = contractor.getMaterialQuantity();
        double costPerTon;

        if (quantity >= 5 && quantity <= 15) {
            costPerTon = 200000;
        } else if (quantity > 15) {
            costPerTon = 180000;
        } else {
            System.out.println("Cost estimation is only available for quantities ≥ 5 tons.");
            return;
        }

        double totalCost = quantity * costPerTon;

        System.out.println("\n--- Cost Estimation ---");
        System.out.println("Contractor ID   : " + contractor.getContractorId());
        System.out.println("Contractor Name : " + contractor.getContractorName());
        System.out.println("Material Used   : " + quantity + " tons");
        System.out.printf("Total Cost      : %, .2f\n", totalCost);
    }

    @Override
    public void receiveMaterial() {
    }

    @Override
    public void useMaterial() {
    }
}
