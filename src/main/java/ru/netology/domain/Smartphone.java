package ru.netology.domain;

public class Smartphone extends ru.netology.domain.Product {
    private String producer;

    public Smartphone(int id, String name, int price, String producer) {
        super( id, name, price );
        this.producer = producer;
    }


}