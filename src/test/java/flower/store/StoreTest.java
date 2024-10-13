package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;

public class StoreTest {
    private static final Double PRICE = 10.0;
    private static final Double SEPAL = 1.0;
    private static final int QUANTITY_ONE = 10;
    private static final int QUANTITY_TWO = 7;
    private static final int QUANTITY_THREE = 5;
    private Store store;
    private FlowerBucket bucketOne;
    private FlowerBucket bucketTwo;
    private Flower flowerOne;
    private Flower flowerTwo;
    private Flower flowerThree;
    private FlowerPack packOne;
    private FlowerPack packTwo;
    private FlowerPack packThree;

    @BeforeEach
    public void setUp() {
        store = new Store();
        flowerOne = new Flower(SEPAL, FlowerColor.RED,
        PRICE, FlowerType.ROSE);
        flowerTwo = new Flower(SEPAL, FlowerColor.BLUE,
        PRICE, FlowerType.TULIP);
        flowerThree = new Flower(SEPAL, FlowerColor.RED,
        PRICE, FlowerType.TULIP);

        packOne = new FlowerPack(flowerOne, QUANTITY_ONE);
        packTwo = new FlowerPack(flowerTwo, QUANTITY_THREE);
        packThree = new FlowerPack(flowerThree, QUANTITY_TWO);

        bucketOne = new FlowerBucket();
        bucketTwo = new FlowerBucket();

        bucketOne.add(packOne);
        bucketOne.add(packTwo);

        bucketTwo.add(packThree);
    }

    @Test
    public void testAddFlowerBucket() {
        store.addFlowerBucket(bucketOne);
        store.addFlowerBucket(bucketTwo);

        ArrayList<FlowerBucket> flowerBuckets 
        = store.search(new Flower(SEPAL, FlowerColor.RED,
        PRICE, FlowerType.ROSE));
        Assertions.assertEquals(1, flowerBuckets.size());
    }

    @Test
    public void testSearchFlowerBucketByColorAndType() {
        store.addFlowerBucket(bucketOne);
        store.addFlowerBucket(bucketTwo);

        Flower searchFlower = new Flower(SEPAL, FlowerColor.RED, 
        PRICE, FlowerType.ROSE);
        ArrayList<FlowerBucket> result = store.search(searchFlower);

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(bucketOne));

        searchFlower = new Flower(SEPAL, FlowerColor.BLUE, 
        PRICE, FlowerType.TULIP);
        result = store.search(searchFlower);

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(bucketOne));

        searchFlower = new Flower(SEPAL, FlowerColor.RED, 
        PRICE, FlowerType.TULIP);
        result = store.search(searchFlower);

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(bucketTwo));
    }

    @Test
    public void testSearchNoMatchingBucket() {
        store.addFlowerBucket(bucketOne);
        store.addFlowerBucket(bucketTwo);

        Flower searchFlower = new Flower(SEPAL, FlowerColor.BLUE, 
        PRICE, FlowerType.ROSE);
        ArrayList<FlowerBucket> result = store.search(searchFlower);

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testSearchEmptyStore() {
        Flower searchFlower = new Flower(SEPAL, FlowerColor.RED,
        PRICE, FlowerType.ROSE);
        ArrayList<FlowerBucket> result = store.search(searchFlower);

        Assertions.assertTrue(result.isEmpty());
    }
}
