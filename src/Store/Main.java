package Store;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        toyStore.addToy(new Toy(1, "Batman Toy", 0.3));
        toyStore.addToy(new Toy(2, "Terminator Toy", 0.4));
        toyStore.addToy(new Toy(3, "Pistol Toy", 0.3));
        toyStore.addToy(new Toy(4, "Uno Card game", 0.4));
        toyStore.addToy(new Toy(5, "Airplaine", 0.2));


        try {
            FileWriter writer = new FileWriter("/home/pablo/IdeaProjects/ToyStore/src/Store/output.txt");

            int counter = 0;
            int maxToys = 10;
            while (counter < maxToys) {
                Toy toy = toyStore.getRandomToy();

                if (toy != null) {
                    counter++;
                    writer.write(counter + ". " + "Selected toy: " + toy.getName() + " (Chance of win" + " " + toy.getChance() +  "%" + ")\n");
                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}