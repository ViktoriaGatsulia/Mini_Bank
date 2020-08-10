package ru.miniBank.demo.entity;

/**
 * Список возможных категорий банковских карт
 * @autor ViktoriaGatsulia
 * @version 1.0
 */
public enum CategoryCard {
    /** Карты Мир обслуживаются только на территории России */
    MIR,
    /** Международная карта, обсулживающаяся в 210 странах */
    MASTERCARD,
    /** Международная карта, обслуживающаяся в 200 странах */
    VISA;
}