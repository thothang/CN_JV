package org.example.lab6_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main6_1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("appConfig.xml");

        Product product1 = (Product) context.getBean("product1");
        Product product2 = (Product) context.getBean("product2");
        Product product3_1 = (Product) context.getBean("product3");
        Product product3_2 = (Product) context.getBean("product3");

        System.out.println("Product 1: " + product1);
        System.out.println("Product 2: " + product2);
        System.out.println("Product 3_1: " + product3_1);
        System.out.println("Product 3_2: " + product3_2);

        System.out.println("\nChecking bean scopes:");
        System.out.println("Product 1 is prototype: " + (product1 != context.getBean("product1")));
        System.out.println("Product 2 is prototype: " + (product2 != context.getBean("product2")));
        System.out.println("Product 3 is singleton: " + (product3_1 == product3_2));
    }
}
