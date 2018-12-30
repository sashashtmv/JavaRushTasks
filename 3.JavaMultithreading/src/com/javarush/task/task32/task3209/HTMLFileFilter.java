package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

//Для открытия или сохранения файла мы будем использовать JFileChooser из библиотеки swing.
//Объекты этого типа поддерживают фильтры, унаследованные от FileFilter. Напишем свой фильтр

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if (f.isDirectory() || f.getName().toLowerCase().endsWith(".html") || f.getName().toLowerCase().endsWith(".htm"))
            return true;
        else
            return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
