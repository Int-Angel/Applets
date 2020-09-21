/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applets;

/**
 *
 * Fraccion
 * 
 * Esta clase es un POJO que representa una fraccion, tambien contiene
 * las operaciones basicas de las fracciones(suma, resta, mult, div)
 * 
 * @author Angel
 */
public class Fraccion {
    private int numerador;
    private int denominador;

    /**
     * Constructor con datos
     * @param numerador de la fraccion
     * @param denominador de la fraccion
     */
    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }
    /**
     * Constructor sin datos
     * este constructor crea una fraccion con numerador y denominador con
     * valores = 0
     */
    public Fraccion(){
        this.denominador = 0;
        this.numerador = 0;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
    
    /**
     * Multiplicacion de fracciones
     * @param B es la fraccion por la que se va a multiplicar esta misma 
     * fraccion
     * @return retorna el resultado de la multiplicacion
     */
    public Fraccion Multiplicacion(Fraccion B){
        Fraccion res = new Fraccion(numerador * B.getNumerador(), denominador * B.getDenominador());
       
        if(res.denominador == 0){
            //System.out.println("Division entre cero");
            return null;
        }else{
            return res;
        }
    }
    
    
    /**
     * Division de fracciones
     * @param B es la fraccion por la que se va a dividir esta misma fraccion
     * @return retorna el resultado de la division
     */
    public Fraccion Division(Fraccion B){
        Fraccion res = new Fraccion(numerador * B.getDenominador(), denominador * B.getNumerador());
        if(res.denominador == 0){
            //System.out.println("Division entre cero");
            return null;
        }else{
            return res;
        }
    }
    /**
     * Suma de fracciones
     * @param B fraccion con la que se va a sumar esta fraccion
     * @return retorna el resultado de la suma
     */
    public Fraccion Suma(Fraccion B){
        Fraccion res;
        if(B.getDenominador() != denominador)
            res = new Fraccion((denominador * B.getNumerador()) + (numerador * B.getDenominador()),denominador * B.getDenominador());
        else
            res =  new Fraccion(numerador + B.getNumerador(),denominador);
        
         if(res.denominador == 0){
            //System.out.println("Division entre cero");
            return null;
        }else{
            return res;
        }
        
    }
    /**
     * Resta de farcciones
     * @param B fraccion que se le va a restar a esta fraccion
     * @return retorna el resultado de la resta
     */
     public Fraccion Resta(Fraccion B){
         Fraccion res;
        if(B.getDenominador() != denominador)
            res = new Fraccion((denominador * B.getNumerador()) - (numerador * B.getDenominador()),denominador * B.getDenominador());
        else
            res = new Fraccion(numerador - B.getNumerador(),denominador);
        
        if(res.denominador == 0){
            //System.out.println("Division entre cero");
            return null;
        }else{
            return res;
        }
    }
     
    @Override
    public String toString() { 
        return numerador + "/" + denominador;
    } 
}
