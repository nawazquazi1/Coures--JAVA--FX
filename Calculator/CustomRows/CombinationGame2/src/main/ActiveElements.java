package main;

import java.util.LinkedList;
import java.util.List;

import elements.Element;

public class ActiveElements {

    private static ActiveElements instance;
    private final LinkedList<Element> elements;

    private ActiveElements() {
        elements = new LinkedList<>();
    }

    public static ActiveElements getInstance(){
        if(instance == null){
            instance = new ActiveElements();
        }
        return instance;
    }

    public LinkedList<Element> getElements() {
        return elements;
    }

    public Element getElement(int index){
        return elements.get(index);
    }

    public void removeElements(List<Element> elements){
        this.elements.removeAll(elements);
    }

    public void addElement(Element element){
        elements.add(element);
    }

    public int getSize(){
        return elements.size();
    }
}