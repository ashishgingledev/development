package com.ingleash.misc;

import java.io.*;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class PrimeComposite_Factorial {
    void primeOrComposite(int n) {
        String prime = "Prime";
        String composite = "Composite";
        String nPnorc = "Neither prime Nor Composite";

        IntPredicate primeOrCompoIntPredicate = (e) -> {
            return IntStream.range(2, e / 2).anyMatch(eachE -> e % eachE == 0);
        };

        Consumer<String> printStringConsumer = System.out::println;


        Consumer<Integer> primeOrNonPrimeIntegerConsumer = (e) -> {
            if (e == 1) {
                printStringConsumer.accept(nPnorc);
            } else if (e  == 0) {
                printStringConsumer.accept(composite);
            }
            else if (primeOrCompoIntPredicate.test(e)) {
                 printStringConsumer.accept(composite);
            } else {
                printStringConsumer.accept(prime);
            }
        };

        primeOrNonPrimeIntegerConsumer.accept(n);
    }

    void findFactorial(int n) {
        Consumer<Long> printStringConsumer = System.out::print;
        if (n ==0) {
            printStringConsumer.accept(Long.valueOf(1L));
        } else {
            LongStream.rangeClosed(1, n).reduce((previous, current) -> current * previous).ifPresent(e -> printStringConsumer.accept(e));
        }
    }
}

public class PrimeComposite_FactorialMain {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        PrimeComposite_Factorial xyz = new PrimeComposite_Factorial();

        xyz.primeOrComposite(n);
        xyz.findFactorial(n);

    }
}
