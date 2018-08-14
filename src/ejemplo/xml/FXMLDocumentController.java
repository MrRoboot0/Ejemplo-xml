/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.xml;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import modelo.Estudiante;

/**
 *
 * @author juan_f.rodriguez_c
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField Txcor;

    @FXML
    private TextField Txcar;

    @FXML
    private Button agregar;

    @FXML
    private TextField txcod;

    @FXML
    private TextField Txnom;

    @FXML
    private TextField Txtel;
    
    LinkedList<Estudiante> listaEstudiantes;
           
    @FXML
    void agregar(ActionEvent event) {
        
           String nombre = Txnom.getText();
           String telefono = Txtel.getText();
           String correo = Txcor.getText();
           String codigo = txcod.getText();
           String carrera = Txcar.getText();
           
           Estudiante objE = new Estudiante(codigo, carrera, nombre, telefono, correo);
           listaEstudiantes.add(objE);
           
          
           JOptionPane.showMessageDialog(null, "Estudiante guardado de forma exitosa");
           Txcar.setText(null);
           Txcor.setText(null);
           Txnom.setText(null);
           Txtel.setText(null);
           txcod.setText(null);

    }
    
    @FXML
    private void guardar(ActionEvent event) {
        Estudiante objeV = new Estudiante();
        boolean guardar = objeV.crearArchivoXml(listaEstudiantes);
        
        
        JOptionPane.showMessageDialog(null, "Elemento guardado de forma exitosa");
    }
    
    @FXML
    void limpiar(ActionEvent event) {
        
        Txcar.setText(null);
           Txcor.setText(null);
           Txnom.setText(null);
           Txtel.setText(null);
           txcod.setText(null);
        
        
        

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listaEstudiantes = new LinkedList<>();
       
    }    
    
}
