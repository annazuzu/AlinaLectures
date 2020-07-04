package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class TestArrays {

    public static void main(String[] args) throws Exception {

        Animal an1 = new Animal("tiger", 15, true);
        Animal an2 = new Animal("rabbit", 8, true);
        Animal an3 = new Animal("rabbit", 9, true);
        Animal an4 = new Animal("tiger", 15, true);
        Animal an5 = new Animal("fox", 10, true);
        Animal an6 = new Animal("mouse", 2, true);

        HashSet<Animal> hs = new HashSet<Animal>();
        hs.add(an3);
        hs.add(an4);

//        for(Animal an : hs) {
//            System.out.println("Info: \n" + an.getInfo());
//        }

        HashMap<Integer, Animal> hb = new HashMap<Integer, Animal>(); // herbivore
        hb.put(1, an2);
        hb.put(2, an3);
        hb.put(3, an6);

        HashMap<Integer, Animal> pd = new HashMap<Integer, Animal>(); // predator

        pd.put(new Integer(1), an1);
        pd.put(new Integer(2), an4);
        pd.put(new Integer(3), an5);

        //Animal r = hb.iterator().next();
        //int rnd = RandomValue(pd);
        Animal t = pd.get(RandomValue(pd));
        Animal r = hb.get(RandomValue(hb));
        r.randomValueDeadAlive1_4();

        // если во множестве есть хоть одно мертвое животное, то хищник не ест никого:
        EatOnlyAlive(hb, t);

        // посчитать, сколько осталось живых:
        CountLiveAnimals(hb);
    }

    public static int RandomValue(HashMap<Integer, Animal> pd){
        int Min = 1;
        int Max = pd.size();

        return Min + (int)(Math.random() * ((Max - Min) + 1));
    }

    public static void EatOnlyAlive(HashMap<Integer, Animal> hb, Animal t) throws Exception {
        int count = 0;
        for (Animal a : hb.values()){
            if (!a.getLivingState()) {
                count++;
                if(count != 0){
                    System.out.println("Есть падаль! Хищник никого не съел");
                    return;
                } else {
                    break;
                }
            }
        }
            for (Animal a : hb.values()){
                t.eat(a);
            }
    }

    public static void CountLiveAnimals (HashMap<Integer, Animal> hb) {
        int count = 0;
        for(Animal an : hb.values()){
            if(an.getLivingState()){
                count++;
            }
        }
        System.out.println(count);
    }
}

