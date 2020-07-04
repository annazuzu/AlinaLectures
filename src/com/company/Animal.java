package com.company;

import java.util.HashMap;

public class Animal {
    int id;
    private String name;
    private float m;
    private boolean isAlive;

    public static final float Max_M = 20;
    public Animal (String name, float m) throws IllegalArgumentException{
        if (m > Max_M){
            throw new IllegalArgumentException("Животное слишком большое");
        } // конструктор класса порождает необрабатываемое исключение, т.к. class IllegalArgumentException extends RuntimeException
        this.name = name;
        this.m = m;
    }

    public Animal (String name, float m, boolean isAlive){
        this.name = name;
        this.m = m;
        this.isAlive = isAlive;
    }

    // а этот метод порождает обрабатываемое исключение:
    public void kill() throws Exception{
        if (!isAlive){
            throw new IllegalStateException("Животное уже умерло");
        }
        this.isAlive = false;
    }

    public void eat(Animal other) throws Exception{
        if (!other.isAlive){
            throw new IllegalStateException("Животное " + other.name + " уже умерло");
        }
        other.isAlive = false;
        System.out.println(this.name + " съел " + other.name );
    }

    public void randomValueDeadAlive1_4(){
        int Min = 1;
        int Max = 4;
        int value = 0;

        value = Min + (int)(Math.random() * ((Max - Min) + 1));
        this.isAlive = value >= 1 && value <= 3;
        System.out.println(value);
    }

    // Геттеры:
    public String getName() {return this.name;}
    public float getM() {return  this.m;}
    public boolean getLivingState() {return this.isAlive;}

    public String getInfo() {return String.format
            ("Имя животного: " + getName() + "\n" +
                    "Вес: " + getM() + "\n" +
                    "Живо: " + getLivingState());}

    // Сеттеры:
}

