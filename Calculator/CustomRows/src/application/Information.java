package application;

import javafx.scene.control.ListView;

public class Information {

    private String name;
    private ListView data;

    public Information(String name, ListView data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public ListView getData() {
        return data;
    }
}