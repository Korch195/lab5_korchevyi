package flower.store;
import java.util.ArrayList;
public class Store {
    private ArrayList<FlowerBucket> flowerBuckets = new ArrayList<>();
    public void addFlowerBucket(FlowerBucket bucket) {
        flowerBuckets.add(bucket);
    }
    public ArrayList<FlowerBucket> search(Flower flower) {
        ArrayList<FlowerBucket> bag = new ArrayList<>();
        for (FlowerBucket bucket : flowerBuckets) {
            for (FlowerPack pack : bucket.getFlowerPacks()) {
                if (pack.getFlower().getColor().equalsIgnoreCase(flower.getColor()) && 
                pack.getFlower().getFlowerType().equals(flower.getFlowerType())) {
                    bag.add(bucket);
                    break;
                }
            }
        }
        return bag;

    }
}
