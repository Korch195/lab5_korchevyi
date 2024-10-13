package flower.store;

public class Store {
    public static void main(String[] args) {
        Flower flower = new Flower();
        flower.setPrice(100);
        flower.setFlowerType(FlowerType.ROSE);

        FlowerBucket flowerBucket = new FlowerBucket();

        FlowerPack flowerPack = new FlowerPack(flower, 5);
        flowerBucket.addFlowerPack(flowerPack);

        FlowerPack flowerPack2 = new FlowerPack(flower, 10);
        flowerBucket.addFlowerPack(flowerPack2);

        System.out.println(flowerBucket.getPrice());
        flower.setPrice(100);
        
        System.out.println(flowerBucket.getPrice());
    }
}
