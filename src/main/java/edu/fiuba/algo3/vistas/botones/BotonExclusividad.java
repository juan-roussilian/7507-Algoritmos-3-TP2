package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorModificador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.vistas.EstilosApp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;

public class BotonExclusividad extends Button {

    public BotonExclusividad(ArrayList<Exclusividad> exclusividades) {
        super.setText("Usar Exclusividad");
        super.setFont(Font.font(EstilosApp.FUENTE, 20));
        super.setTextFill(Color.BLACK);
        Exclusividad exclusividad = exclusividades.get(0);
        super.setOnAction(new ControladorModificador(this,exclusividad));
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, EstilosApp.BORDE_CURVO, EstilosApp.GROSOR_BORDE)));
        Background unFondo = new Background(new BackgroundFill(Color.web(EstilosApp.AMARILLO), EstilosApp.BORDE_CURVO, new Insets(1)));
        super.setBackground(unFondo);
        super.setAlignment(Pos.CENTER);
    }
}
