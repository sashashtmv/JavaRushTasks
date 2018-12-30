package com.javarush.task.task31.task3112;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        //должен создать временный файл с помощью метода Files.createTempFile
        Path tempFile = Files.createTempFile("sashashtmv",".tmp");
        //должен скачать файл по ссылке во временный файл, используя метод Files.copy
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        //создаем файл, в котором будет хранится скаченный файл из интернета
        Path file = null;
        if (!Files.exists(Paths.get(downloadDirectory.toString() + urlString.substring(urlString.lastIndexOf("/"), urlString.length())))) {
            file = Files.createFile(Paths.get(downloadDirectory.toString() + urlString.substring(urlString.lastIndexOf("/"), urlString.length())));
        }
        //должен переместить файл из временной директории в пользовательскую, используя метод Files.move
        Files.move(tempFile, file, StandardCopyOption.REPLACE_EXISTING);
        inputStream.close();
        return file;
        // implement this method
    }
}
