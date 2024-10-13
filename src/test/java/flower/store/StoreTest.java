package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;

public class StoreTest {
    private static final Double PRICE = 10.0;
    private static final Double SEPAL = 1.0;
    private Store store;
    private FlowerBucket bucket1;
    private FlowerBucket bucket2;
    private Flower flower1;
    private Flower flower2;
    private Flower flower3;
    private FlowerPack pack1;
    private FlowerPack pack2;
    private FlowerPack pack3;

    @BeforeEach
    public void setUp() {
        store = new Store();
        flower1 = new Flower(SEPAL, FlowerColor.RED,
        PRICE, FlowerType.ROSE);
        flower2 = new Flower(SEPAL, FlowerColor.BLUE,
        PRICE, FlowerType.TULIP);
        flower3 = new Flower(SEPAL, FlowerColor.RED,
        PRICE, FlowerType.TULIP);

        pack1 = new FlowerPack(flower1, 10);
        pack2 = new FlowerPack(flower2, 5);
        pack3 = new FlowerPack(flower3, 7);

        bucket1 = new FlowerBucket();
        bucket2 = new FlowerBucket();

        bucket1.add(pack1);
        bucket1.add(pack2);

        bucket2.add(pack3);
    }

    @Test
    public void testAddFlowerBucket() {
        store.addFlowerBucket(bucket1);
        store.addFlowerBucket(bucket2);

        ArrayList<FlowerBucket> flowerBuckets 
        = store.search(new Flower(SEPAL, FlowerColor.RED,
        PRICE, FlowerType.ROSE));
        Assertions.assertEquals(1, flowerBuckets.size());
    }

    @Test
    public void testSearchFlowerBucketByColorAndType() {
        store.addFlowerBucket(bucket1);
        store.addFlowerBucket(bucket2);

        Flower searchFlower = new Flower(SEPAL, FlowerColor.RED, 
        PRICE, FlowerType.ROSE);
        ArrayList<FlowerBucket> result = store.search(searchFlower);

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(bucket1));

        searchFlower = new Flower(SEPAL, FlowerColor.BLUE, 
        PRICE, FlowerType.TULIP);
        result = store.search(searchFlower);

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(bucket1));

        searchFlower = new Flower(SEPAL, FlowerColor.RED, 
        PRICE, FlowerType.TULIP);
        result = store.search(searchFlower);

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(bucket2));
    }

    @Test
    public void testSearchNoMatchingBucket() {
        store.addFlowerBucket(bucket1);
        store.addFlowerBucket(bucket2);

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
