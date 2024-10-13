package flower.store;
import java.util.ArrayList;
public class Store {
    private ArrayList<FlowerBucket> flowerBuckets = new ArrayList<>();
    public void addFlowerBucket(FlowerBucket bucket) {
        flowerBuckets.add(bucket);
    }
    public ArrayList<FlowerBucket> search(Flower flower) {
        String flowerColor = flower.getColor();
        FlowerType flowerType = flower.getFlowerType();
        ArrayList<FlowerBucket> bag = new ArrayList<>();
        for (FlowerBucket bucket : flowerBuckets) {
            for (FlowerPack pack : bucket.getFlowerPacks()) {
                String packColor = pack.getFlower().getColor();
                FlowerType packType = pack.getFlower().getFlowerType();
                if (packColor.equalsIgnoreCase(flowerColor) 
                && packType.equals(flowerType)) {
                    bag.add(bucket);
                    break;
                }
            }
        }
        return bag;

    }
}
