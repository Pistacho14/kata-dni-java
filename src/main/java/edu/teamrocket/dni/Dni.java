package edu.teamrocket.dni;

import org.apache.commons.lang3.math.NumberUtils;

public class Dni {

    private final String dni;
    private String parteNumericaDni;
    private String parteAlfabeticaDni;
    private boolean numeroSano;
    private boolean letraSana;
    private final TablaAsignacion tablaAsignacion;
    private static final Integer LONGITUD_NUMEROS_DNI = 8;

    public Dni(String dni) {

        this.dni = dni;
        this.parteAlfabeticaDni = "";
        this.parteNumericaDni = "";
        this.numeroSano = false;
        this.letraSana = false;
        this.tablaAsignacion = new TablaAsignacion();
    }

    public String getDni() {
        return dni;
    }

    public String getParteNumericaDni() {
        return parteNumericaDni;
    }

    public void setParteNumericaDni(String parteNumericaDni) {
        this.parteNumericaDni = parteNumericaDni;
    }

    public String getParteAlfabeticaDni() {
        return parteAlfabeticaDni;
    }

    public void setParteAlfabeticaDni(String parteAlfabeticaDni) {
        this.parteAlfabeticaDni = parteAlfabeticaDni;
    }

    public boolean isNumeroSano() {
        return numeroSano;
    }

    public void setNumeroSano(boolean numeroSano) {
        this.numeroSano = numeroSano;
    }

    public boolean isLetraSana() {
        return letraSana;
    }

    public void setLetraSana(boolean letraSana) {
        this.letraSana = letraSana;
    }

    public String extraerParteAlfabeticaDni(){
        this.separarDni();
        return this.parteAlfabeticaDni;
    }

    public String extraerParteNumericaDni(){
        this.separarDni();
        return this.parteNumericaDni;
    }

    private void separarDni() {
        this.setParteAlfabeticaDni(
            String.valueOf(this.getDni().charAt(this.getDni().length() - 1))
        );
        this.setParteNumericaDni(
            this.getDni().substring(0, this.getDni().length() - 1)
        );
    }

    public boolean checkLetra(){
        try {
            return this.checkNumeroDni() && String.valueOf(this.tablaAsignacion.calcularLetra(this.parteNumericaDni)).equals(this.parteAlfabeticaDni);
        } catch (NumberFormatException letraIncorrecta) {
            return false;
        }
        
    }

    public boolean checkLongitud(){
        return this.parteNumericaDni.length() == LONGITUD_NUMEROS_DNI;
    }

    public boolean checkCif(){
        return this.checkNumeroDni() && this.checkLetra() && this.checkLongitud();
    }

    public boolean checkDni(){
        return this.checkNumeroDni() && this.checkLetra() && this.checkLongitud();
    }

    public String obtenerLetra(){
        return this.parteAlfabeticaDni;
    }

    public boolean isDniNumero(String numero){
        return numero.length() == 8 && NumberUtils.isDigits(numero);
    }

    public boolean checkNumeroDni(){
        this.separarDni();
        try {
            assert isDniNumero(parteNumericaDni);
            return true;
        } catch (AssertionError notNumeric) {
            return false;
        }
    }

    public String toString(){
        return this.dni;
    }
}