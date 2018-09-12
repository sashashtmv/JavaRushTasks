package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human grandmother = new Human("Mila", false, 74);
        Human grandmother1 = new Human("Jana", false, 90);
        Human grandfather = new Human("Vasja", true, 76);
        Human grandfather1 = new Human("Denis", true, 87);
        Human mother = new Human("Ketty", false, 40, grandfather, grandmother);
        Human father = new Human("Daton", true, 42, grandfather1, grandmother1);
        Human child1 = new Human("Elis", false, 10, father, mother);
        Human child2 = new Human("Barbara", false, 12, father, mother);
        Human child3 = new Human("Lida", false, 14, father, mother);
        System.out.println(grandfather);
        System.out.println(grandmother);
        System.out.println(grandfather1);
        System.out.println(grandmother1);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
        //напишите тут ваш код
    }

    public static class Human {
        Human father;
        Human mother;
        int age;
        String name;
        boolean sex;
        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }//напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















