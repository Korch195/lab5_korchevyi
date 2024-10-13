package flower.store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FlowerBucketTest {

    private FlowerBucket flowerBucket;
    private Flower flower;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
        flower = new Flower();
        flower.setPrice(50);
        flower.setFlowerType(FlowerType.ROSE);
        flower.setColor(FlowerColor.RED);
    }

    @Test
    public void testGetPriceSinglePack() {
        FlowerPack flowerPack = new FlowerPack(flower, 3);
        flowerBucket.addFlowerPack(flowerPack);
        Assertions.assertEquals(150, flowerBucket.getPrice());
    }

    @Test
    public void testGetPriceMultiplePacks() {
        FlowerPack flowerPack1 = new FlowerPack(flower, 3); // 150
        FlowerPack flowerPack2 = new FlowerPack(flower, 2); // 100
        flowerBucket.addFlowerPack(flowerPack1);
        flowerBucket.addFlowerPack(flowerPack2);

        Assertions.assertEquals(250, flowerBucket.getPrice());
    }

    @Test
    public void testPriceAfterFlowerPriceChange() {
        flower.setPrice(30);
        FlowerPack flowerPack1 = new FlowerPack(flower, 3); // 90
        FlowerPack flowerPack2 = new FlowerPack(flower, 2); // 60
        flowerBucket.addFlowerPack(flowerPack1);
        flowerBucket.addFlowerPack(flowerPack2);

        Assertions.assertEquals(150, flowerBucket.getPrice());

        flower.setPrice(50);

        Assertions.assertEquals(150, flowerBucket.getPrice());
    }
}
