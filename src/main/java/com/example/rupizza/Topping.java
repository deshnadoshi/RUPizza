package com.example.rupizza;

public enum Topping {
    GREEN_PEPPER(0),
    ONION(1),
    PINEAPPLE(2),
    BLACK_OLIVE(3),
    MUSHROOM(4),
    SAUSAGE(5),
    CHICKEN(6),
    BEEF(7),
    HAM(8),
    CRAB_MEATS(9),
    PEPPERONI(10),
    SQUID(11),
    SHRIMP(12);

    private final int CODE;

    Topping(int code) {
        this.CODE = code;
    }

    public int getCode() {
        return CODE;
    }
}
