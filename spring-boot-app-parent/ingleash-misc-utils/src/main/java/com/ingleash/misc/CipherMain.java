package com.ingleash.misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

interface AnonymousInterface {
    void getCipher(ArrayList<String> list);
}

class Cipher_Anonymous {
    void anonymousClass(ArrayList<String> list) {
        AnonymousInterface cyberCreateAndPrint = (e) -> {
            list
                    .stream()
                    .map(each -> each == " " ? "$#" : new StringBuilder(((int) each.charAt(0)) + each.substring(1)).reverse().toString())
                    .collect(Collectors.toList())
                    .forEach(System.out::print);
        };

        cyberCreateAndPrint.getCipher(list);
    }
}

class Cipher_MethodRef {
    void methodReference(ArrayList<String> list) {
        list
                .stream()
                .map(each -> each == " " ? "$#" : new StringBuilder(((int) each.charAt(0)) + each.substring(1)).reverse().toString())
                .collect(Collectors.toList())
                .forEach(System.out::print);
    }
}

class Cipher_LambdaExp {
    void lambdaExpression(ArrayList<String> list) {
        /*String cyphered = (list.stream().map(each -> {
            if (each == " ") {
                each = "#$";
            } else {
                int a = (int) each.charAt(0);
                each = a + each.substring(1);
            }
            return new StringBuilder(each).reverse().toString() ;
    } ).collect(Collectors.toList())).stream()
                .map(Object::toString).collect(Collectors.joining());*/


        String cyphered = list
                .stream()
                .filter(each -> each != " ")
                .map(each -> new StringBuilder(((int) each.charAt(0)) + each.substring(1)).reverse())
                .collect(Collectors.joining("$#"));

        System.out.print(cyphered);


    }
}

public class CipherMain {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        String input = "Hi, how are you?";
        String inputarr[] = input.split(" ");

        list.add(inputarr[0]);
        for (int i = 0; i < inputarr.length - 1; i++) {
            list.add(" ");
            list.add(inputarr[i + 1]);
        }

        Cipher_LambdaExp l1 = new Cipher_LambdaExp();
        System.out.print("Lambda Expression : ");
        l1.lambdaExpression(list);

        Cipher_MethodRef m1 = new Cipher_MethodRef();
        System.out.print("\nMethod Reference : ");
        m1.methodReference(list);

        Cipher_Anonymous a1 = new Cipher_Anonymous();
        System.out.print("\nAnonymous Class : ");
        a1.anonymousClass(list);
    }
}
