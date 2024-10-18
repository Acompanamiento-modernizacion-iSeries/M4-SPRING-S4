package com.taller4.william.bancolombia.app.excepciones;

public class ExcepcionesPersonalizadas {
    public static class SaldoInsuficienteExcepcion extends RuntimeException {
        public SaldoInsuficienteExcepcion(String message) {
            super(message);
        }
    }

    public static class DepositoInvalidoExcepcion extends RuntimeException {
       public DepositoInvalidoExcepcion(String message) {
            super(message);
        }
    }

    public static class CuentaNoEncontradaExcepcion extends RuntimeException {
        public CuentaNoEncontradaExcepcion(String message) {
            super(message);
        }
    }
}
