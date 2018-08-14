/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileWriter;
import java.util.LinkedList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;

import org.jdom2.output.XMLOutputter;

/**
 *
 * @author jhon.acevedo
 */
public class Estudiante extends Persona{
    
    private String codigo;
    private String carrera;

    public Estudiante(String codigo, String carrera, String nombre, String telefono, String correo) {
        super(nombre, telefono, correo);
        this.codigo = codigo;
        this.carrera = carrera;
    }

    public Estudiante() {
        
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCarrera() {
        return carrera;
    }

   

    @Override
    public String toString() {
        return "Estudiante" + super.toString() + "codigo=" + codigo + ", carrera=" + carrera + '}';
    }

    public boolean crearArchivoXml(LinkedList<Estudiante> listaEstudiantes) {
        
        boolean g =false;
        
        try {
            
            Element estudiante = new Element("estudiante");
            Document doc = new Document(estudiante);
            for (int i = 0; i < listaEstudiantes.size(); i++) {
                
                Element estudiantes = new Element("estudiante");
                estudiantes.addContent(new Element("nombre").setText(listaEstudiantes.get(i).getNombre()));
                estudiantes.addContent(new Element("correo").setText(listaEstudiantes.get(i).getCorreo()));
                estudiantes.addContent(new Element("Telefono").setText(listaEstudiantes.get(i).getTelefono()));
                estudiantes.addContent(new Element("codigo").setText(listaEstudiantes.get(i).getCodigo()));
                estudiantes.addContent(new Element("Carrera").setText(listaEstudiantes.get(i).getCarrera()));
                
                doc.getRootElement().addContent(estudiantes);
                
            }
            
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat (Format.getPrettyFormat());
            xmlOutput.output (doc, new FileWriter("universidad.xml"));
                    
                   g = true; 
              
            } catch ( Exception e){
                
                
                
                System.out.println(e.getMessage());
            
            g = false;
         
            
        }
            
            return g;  
        
    }
    
   
    
}
