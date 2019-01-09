package com.javarush.task;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class TestClass {
    public static void main(String[] args) throws IOException
    {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;
        //серриализация объекта
        StringWriter writer = new StringWriter();

        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(writer, cat);

        String result = writer.toString();
        System.out.println(result);
        //дессериализация объекта

        StringReader reader = new StringReader(result);

        ObjectMapper mapper1 = new ObjectMapper();

        Cat cat1 = mapper.readValue(reader, Cat.class);
        System.out.println(cat1.age + " - " + cat1.weight + " - " + cat1.name);
    }
}

@JsonAutoDetect
class Cat
{
    @JsonProperty("alias")
    public String name;
    public int age;
    @JsonIgnore
    public int weight;

    Cat() {
    }
}
