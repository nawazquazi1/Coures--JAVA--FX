package application;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ModeButton extends Button {

    private final StringProperty activeText = new SimpleStringProperty("Active");
    private final StringProperty inactiveText = new SimpleStringProperty("Inactive");
    private final BooleanProperty state = new SimpleBooleanProperty(false);

    private EventHandler<? super MouseEvent> activationHandler;

    public ModeButton() {
        StringBinding buttonText = Bindings.when(state)
                .then(activeText)
                .otherwise(inactiveText);
        textProperty().bind(buttonText);

        setOnMouseClicked(e -> {
            state.set(!state.get());
            if(activationHandler != null){
                activationHandler.handle(e);
            }
        });
    }

    public void setOnActivation(EventHandler<? super MouseEvent> eventHandler) {
        activationHandler = eventHandler;
    }

    public String getActiveText() {
        return activeText.get();
    }

    public void setActiveText(String activeText) {
        this.activeText.set(activeText);
    }

    public String getInactiveText() {
        return inactiveText.get();
    }

    public void setInactiveText(String inactiveText) {
        this.inactiveText.set(inactiveText);
    }

    public boolean isState() {
        return state.get();
    }
}