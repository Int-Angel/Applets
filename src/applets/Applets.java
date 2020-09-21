/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applets;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Applets
 * Es la interfaz grafica que muestra en el navegador donde se muestran
 * las opciones y donde se ingresan los datos de las fracciones
 * @author Angel
 */
public class Applets extends JApplet{

    
    JPanel panelFraccion1 = new JPanel();
    JPanel panelFraccion2 = new JPanel();
    JPanel panelDeOperaciones = new JPanel();
    JPanel mainPanel = new JPanel();
    JButton calcular = new JButton("=");
    JButton suma = new JButton("+");
    JButton resta = new JButton("-");
    JButton multiplicacion = new JButton("x");
    JButton division = new JButton("/");
    JTextField numerador1 = new JTextField();
    JTextField numerador2 = new JTextField();
    JTextField denominador1 = new JTextField();
    JTextField denominador2 = new JTextField();
    
    Fraccion A;
    Fraccion B;
    
    /**
     * init
     * este metodo se encarga de inicializar todos los valores y de colocar
     * los listeners en los botones
     */
    public void init(){
        setSize(300,400);

        
        setLayout(null);
        
       
        
        panelFraccion1.setLayout(new GridLayout(2,1));
        panelFraccion1.add(numerador1);
        panelFraccion1.add(denominador1);
        
        panelFraccion2.setLayout(new GridLayout(2,1));
        panelFraccion2.add(numerador2);
        panelFraccion2.add(denominador2);
        
        mainPanel.setSize(300,400);
        mainPanel.setLocation(0,0);
        mainPanel.setLayout(new GridLayout(1,3));
        
        panelDeOperaciones.setLayout(new GridLayout(4,1));
        panelDeOperaciones.add(suma);
        panelDeOperaciones.add(resta);
        panelDeOperaciones.add(multiplicacion);
        panelDeOperaciones.add(division);
        
        mainPanel.add(panelFraccion1);
        mainPanel.add(panelDeOperaciones);
        mainPanel.add(panelFraccion2);
        
        calcular.setSize(70,45);
        calcular.setLocation(215,130);
        
        add(mainPanel);
        
        
        suma.addActionListener(
                 new ActionListener(){
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            if(obtenerFracciones())
                                mostrarResultado(A.Suma(B).toString());
                        }
                 }
        );
        
        resta.addActionListener(
                 new ActionListener(){
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            if(obtenerFracciones())
                                mostrarResultado(A.Resta(B).toString());
                        }
                 }
        );
        
        division.addActionListener(
                 new ActionListener(){
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            if(obtenerFracciones())
                                mostrarResultado(A.Division(B).toString());
                        }
                 }
        );
        
        multiplicacion.addActionListener(
                 new ActionListener(){
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            if(obtenerFracciones())
                                mostrarResultado(A.Multiplicacion(B).toString());
                        }
                 }
        );
    }
    
    /**
     * obtenerFracciones
     * obtenerFracciones transforma el texto de los JTextField en fracciones
     * @return regresa true en caso de que la obtencion de la fraccion fuera
     * correcta y false si no lo fue
     */
     boolean obtenerFracciones(){
        try{
            A = new Fraccion(Integer.parseInt(numerador1.getText()),Integer.parseInt(denominador1.getText()));
        }catch(java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Solo numeros","Error",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        try{
            B = new Fraccion(Integer.parseInt(numerador2.getText()),Integer.parseInt(denominador2.getText()));
        }catch(java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Solo numeros","Error",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    /**
     * mostrarResultado
     * mostrarResultado muestra el resultado de la operacion en un mensaje
     * @param resultado resultado a mostrar
     */
    void mostrarResultado(String resultado){
        JOptionPane.showMessageDialog(null,resultado,"Resultado",JOptionPane.INFORMATION_MESSAGE);
    }
    

}
