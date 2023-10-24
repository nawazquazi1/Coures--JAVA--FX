package main;

import java.util.Arrays;

import elements.Bluish;
import elements.Element;
import elements.ElementType;
import elements.Iron;
import elements.Wood;
import javafx.scene.layout.AnchorPane;

public class MatchHandler {

    private ActiveElements activeElements = ActiveElements.getInstance();
    private AnchorPane scene;

    public MatchHandler(AnchorPane scene) {
        this.scene = scene;
    }

    public void createWood(){
        Wood wood = new Wood(scene);
        activeElements.addElement(wood);
    }

    public void createIron(){
        Iron iron = new Iron(scene);
        activeElements.addElement(iron);
    }

    private void createBluish() {
        Bluish bluish = new Bluish(scene);
        activeElements.addElement(bluish);
    }


    public void checkMatches(){
        for (int i = 0; i < activeElements.getSize(); i++) {
            for (int k = 0; k < activeElements.getSize(); k++) {
                if( i != k){
                    Element element1 = activeElements.getElement(i);
                    Element element2 = activeElements.getElement(k);

                    if(checkCollision(element1,element2)){
                        if(element1.getElementType() == ElementType.WOOD
                                && element2.getElementType() == ElementType.IRON){
                            element1.remove();
                            element2.remove();

                            activeElements.removeElements(Arrays.asList(element1, element2));

                            ironWoodCombination();
                        }
                    }
                }
            }
        }
    }

    public boolean checkCollision(Element element1, Element element2){
        return element1.getCircle().getBoundsInParent().intersects(element2.getCircle().getBoundsInParent());
    }

    private void ironWoodCombination(){
        createBluish();
    }
}