package edu.teamrocket.dni;

public class TablaAsignacion {

    private final char[] tabla = { 'T', 'R', 'W', 'A',
            'G', 'M', 'Y', 'F',
            'P', 'D', 'X', 'B',
            'N', 'J', 'Z', 'S',
            'Q', 'V', 'H', 'L',
            'C', 'K', 'E' };

    public char getLetra(int posicion) {

        try {
            return this.tabla[posicion];
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new ArrayIndexOutOfBoundsException("Posición fuera de límite");
        }
    }

    public char calcularLetra(String cifras) {

        int dni = Integer.parseInt(cifras);
        int posicion = dni % this.tabla.length;

        return this.tabla[posicion];
    }

    public boolean isLetraPermitida(char letra) {

        return new String(this.tabla).indexOf(letra) != -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char caracter : this.tabla) {
            sb.append(caracter);
        }
        return sb.toString();
    }
}