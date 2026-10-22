package com.example.concurrencia;

import java.util.concurrent.atomic.AtomicInteger;

public class Caja {

    // Contador atómico para la cantidad de ventas.
    private final AtomicInteger ventas = new AtomicInteger(0);

    // Contador atómico para  dinero recaudado.
    private final AtomicInteger total = new AtomicInteger(0);

    // Registra una venta y actualiza los contadores de forma atómica.
    public void registrarVenta(String vendedor, int monto) {

        // Incrementa la cantidad de ventas en uno.
        ventas.incrementAndGet();

        // Suma el monto de la venta
        total.addAndGet(monto);

        // Muestra el nombre del vendedor y el monto registrado.
        System.out.println(
                vendedor + " registró una venta de C$" + monto
        );
    }


    public int getVentas() {
        return ventas.get();
    }

    // Devuelve el dinero total recaudado.
    public int getTotal() {
        return total.get();
    }
}
