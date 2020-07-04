package com.company;

public class TestExceptions {

    public static void main(String[] args) {

        // ошибки компиляции не будет:
        Animal animal = new Animal("tiger", 10);

        try
        {
            if (animal.getM() < Animal.Max_M){
                // наличие try-catch-finally, либо блоков throws обязательно! Иначе будет ошибка компиляции:
                animal.kill();
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            System.out.println("Info: \n" + animal.getInfo());
        }
        System.out.println("Исключительная ситуация обработана");
    }
}

