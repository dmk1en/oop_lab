package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton pen, eraser;
    
    private boolean isEraserSelected = false;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Color color = isEraserSelected ? Color.WHITE : Color.BLACK;
    	Circle newCircle = new Circle(event.getX(),event.getY(),4,color);
    	drawingAreaPane.getChildren().add(newCircle);    	
    }
    
    @FXML
    void penChoose() {
    	isEraserSelected = false;
    }
    
    @FXML
    void eraserChoose() {
    	isEraserSelected = true;
    }

}
