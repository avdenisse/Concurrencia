package com.example.concurrencia;

public class Main {


    public static void main(String[] args) throws InterruptedException{

        // Se crea una única caja compartida por los vendedores.
        Caja caja = new Caja();

        // Se define la tarea que realizará cada vendedor.
        Runnable vendedor1 = crearVendedor("Vendedor 1", caja);
        Runnable vendedor2 = crearVendedor("Vendedor 2", caja);
        Runnable vendedor3 = crearVendedor("Vendedor 3", caja);

        // Se crean los hilos asociados a cada vendedor.
        Thread hilo1 = new Thread(vendedor1);
        Thread hilo2 = new Thread(vendedor2);
        Thread hilo3 = new Thread(vendedor3);

        // Se inician los tres hilos concurrentemente.
        hilo1.start();
        hilo2.start();
        hilo3.start();

        // El hilo principal espera a que terminen los tres vendedores.
        hilo1.join();
        hilo2.join();
        hilo3.join();


        System.out.println("\n--- CIERRE DE CAJA ---");
        System.out.println(
                "Cantidad de ventas: " + caja.getVentas()
        );
        System.out.println(
                "Recaudación total: C$" + caja.getTotal()
        );
    }

    // Crea la tarea que ejecutará cada vendedor.
    static Runnable crearVendedor(String nombre, Caja caja) {

        return () -> {

            // Cada vendedor debe procesar cinco ventas.
            for (int i = 1; i <= 5; i++) {

                try {
                    // Simula el tiempo de procesamiento de cada venta.
                    Thread.sleep(100);

                } catch (InterruptedException e) {

                    // Restaura el estado de interrupción del hilo.
                    Thread.currentThread().interrupt();

                    // Finaliza la tarea si el hilo es interrumpido.
                    return;
                }

                // Registra una venta de C$100 en la caja compartida.
                caja.registrarVenta(nombre, 100);
            }
        };
    }

}

