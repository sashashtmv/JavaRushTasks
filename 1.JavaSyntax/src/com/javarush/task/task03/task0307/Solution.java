package com.javarush.task.task03.task0307;

/* 
Привет Starcraft!
*/

public class Solution {
    public static void main(String[] args) {
        // Zerg zerg1 = new Zerg();
        //zerg1.name = "a";
        Zerg[] zerg = new Zerg[10];
        Protoss[] protoss = new Protoss[5];
        Terran[] terran = new Terran[12];
        for (int i = 0; i < 12; i++) {
            if (i < 10) {
                zerg[i] = new Zerg();
                zerg[i].name = "Zerg" + i;
            }

            if (i < 5) {
                protoss[i] = new Protoss();
                protoss[i].name = "Protoss" + i;
            }

            if (i < 12) {
                terran[i] = new Terran();
                terran[i].name = "Terran" + i;
            }
        }
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
