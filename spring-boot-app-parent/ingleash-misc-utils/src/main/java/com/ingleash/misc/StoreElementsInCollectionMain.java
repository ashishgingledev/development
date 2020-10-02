package com.ingleash.misc;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Supplier;

class StoreElementsInCollection {
    static void storeElements(String input) {
        //corn sandwich,mix veg sandwich,cheese sandwich,mix veg sandwich,cheese sandwich


        Supplier<String> cornSandwich = () -> "corn sandwich";
        Supplier<String> mixvegsandwich = () -> "mix veg sandwich";
        Supplier<String> cheesesandwich = () -> "cheese sandwich";
        Supplier<String> incorrect = () -> "Incorrect Input";

        List<Supplier<String>> supplierList = Arrays.asList(cornSandwich, mixvegsandwich, cheesesandwich);

        Consumer<String> storeStringConsumer = str -> {
        if (Arrays
                .asList(str.split(","))
                .stream()
                .filter(e -> !supplierList.stream().anyMatch(eachSupplier -> eachSupplier.get().equals(e)))
                .count() > 0) {
            System.out.print(incorrect.get());
        } else {

            Arrays.asList(str.split(",")).forEach(eEach -> {
                supplierList.forEach(eachSupp -> {
                            if (eachSupp.get().equals(eEach)) {
                                System.out.println(eachSupp.get());
                            }

                        }
                );
            });


        }
        };

        storeStringConsumer.accept(input);

    }
}

public class StoreElementsInCollectionMain {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StoreElementsInCollection.storeElements(input);
    }
}
