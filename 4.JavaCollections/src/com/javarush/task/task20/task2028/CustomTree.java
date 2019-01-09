package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    List<Entry> entryList = new ArrayList<>();

    int n = 0;

    public CustomTree() {
        this.root = new Entry<>("elementName");
        root.lineNumber = 1;
        entryList.add(root);
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String elementName) {
        Entry newEntry = new Entry(elementName);
        for (Entry element : entryList) {
            if(element.isAvailableToAddChildren()) {
                    newEntry.parent = element;
                if (element.availableToAddLeftChildren) {
                    element.leftChild = newEntry;
                }
                else  {
                    element.rightChild = newEntry;
                }
                    newEntry.lineNumber = element.lineNumber++;
                    entryList.add(newEntry);
                    n++;
                    element.checkChildren();
                    break;
            }
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(o instanceof String){
            String nameElement = (String) o;
            for(int i = 0; i < entryList.size(); i++){
                if(entryList.get(i).elementName.equals(nameElement)){
                    if(entryList.get(i).parent.rightChild == entryList.get(i)){
                        entryList.get(i).parent.availableToAddRightChildren = true;
                    }
                    if(entryList.get(i).parent.leftChild == entryList.get(i)){
                        entryList.get(i).parent.availableToAddLeftChildren = true;
                    }
                    if(entryList.get(i).leftChild != null)
                    entryList.get(i).leftChild.parent.elementName = null;
                    if(entryList.get(i).rightChild != null)
                    entryList.get(i).rightChild.parent.elementName = null;

                    entryList.remove(i);
                    n--;
                    for(int j = 1; j < entryList.size(); j++){
                        if(getParent(entryList.get(j).elementName) == null){
                            if(entryList.get(j).leftChild != null)
                            entryList.get(j).leftChild.parent.elementName = null;
                            if(entryList.get(j).rightChild != null)
                            entryList.get(j).rightChild.parent.elementName = null;

                            entryList.remove(j);
                            j--;
                            n--;
                        }
                    }
                    break;
                }
            }
        }else {
            throw new UnsupportedOperationException();
        }
        return true;
    }

    public String getParent(String s) {
        String parentName = null;
        for (Entry currentEntry : entryList) {
            if (currentEntry.elementName.equals(s)) {
                    parentName = currentEntry.parent.elementName;
                    break;
            }
        }
        return parentName;
    }

    @Override
    public int size() {
        return n;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public void checkChildren() {
            if (leftChild != null) availableToAddLeftChildren = false;
            if (rightChild != null) availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            if (availableToAddRightChildren || availableToAddLeftChildren)
                return true;
            else return false;
        }
    }
}
