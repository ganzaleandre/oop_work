public abstract class ConstructionMaterial {

    protected Constructor contractor;

    public ConstructionMaterial(Constructor construction) {
        this.contractor = construction;
    }

    public abstract void receiveMaterial();

    public abstract void useMaterial();

    public abstract void estimateCost();
}
