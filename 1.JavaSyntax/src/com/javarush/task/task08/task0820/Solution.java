package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();
        for(int i = 0; i < 4; i++){
            result.add(new Cat());
        }
        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> dogs = new HashSet<>();
        for(int i = 0; i < 3; i++){
            dogs.add(new Dog());
        }
        //напишите тут ваш код
        return dogs;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        HashSet union = new HashSet();
        union.addAll(cats);
        union.addAll(dogs);
        //напишите тут ваш код
        return union;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        for (Cat cat : cats){
            Iterator<Object> iterator = pets.iterator();
            while (iterator.hasNext()) {
                if (cat.equals(iterator.next())) iterator.remove();
            }

        }
        //pets.removeAll(cats);
        //тоже рабочий вариант.
    }

    public static void printPets(Set<Object> pets) {
        for(Object o : pets) System.out.println(o);
        //напишите тут ваш код
    }
    public static class Cat{}
    public static class Dog{}
    //напишите тут ваш код
}
