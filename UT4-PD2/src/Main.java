
public class Main {
    public static void main(String[] args) {
        // Prueba
        ArbolBB<Integer> arbol = new ArbolBB<>();
        String[] claves = ManejadorArchivosGenerico.leerArchivo("src/clavesYconsultaPrueba/clavesPrueba.txt");

        for (String clave : claves) {
            arbol.insertar(new TElementoAB<>(Integer.parseInt(clave), Integer.parseInt(clave)));
        }

        String preorden = arbol.preOrden();
        String inorden = arbol.inOrden();
        String postorden = arbol.postOrden();

        System.out.println("Preorden: " + preorden);
        System.out.println("Inorden: " + inorden);
        System.out.println("Postorden: " + postorden);

        String[] recorridos = {"Preorden: " + preorden.substring(0, preorden.length() - 1), "Inorden: " + inorden.substring(0, inorden.length() - 1), "Postorden: " + postorden.substring(0, postorden.length() - 1)};

        ManejadorArchivosGenerico.escribirArchivo("salida.txt", recorridos);

        int[] clavesBuscadas = {10635, 4567, 12, 8978};
        System.out.println("");

        //Claves1
        ArbolBB<Integer> arbol1 = new ArbolBB<>();
        String[] claves1 = ManejadorArchivosGenerico.leerArchivo("src/claves1/claves1.txt");

        for (String clave1 : claves1) {
            arbol1.insertar(new TElementoAB<>(Integer.parseInt(clave1), Integer.parseInt(clave1)));
        }

        String preorden1 = arbol1.preOrden();
        System.out.println("Preorden: " + preorden1);

        for (int claveBuscada1 : clavesBuscadas) {
            if (arbol.buscar(claveBuscada1) != null) {
                System.out.println("Clave '" + claveBuscada1 + "' encontrada en el árbol.");
            } else {
                System.out.println("Clave '" + claveBuscada1 + "' NO encontrada en el árbol.");
            }
        }

        System.out.println("");

        //Claves2
        ArbolBB<Integer> arbol2 = new ArbolBB<>();
        String[] claves2 = ManejadorArchivosGenerico.leerArchivo("src/claves2/claves2.txt");

        for (String clave2 : claves2) {
            arbol2.insertar(new TElementoAB<>(Integer.parseInt(clave2), Integer.parseInt(clave2)));
        }

        String preorden2 = arbol2.preOrden();
        System.out.println("Preorden: " + preorden2);

        for (int claveBuscada2 : clavesBuscadas) {
            if (arbol.buscar(claveBuscada2) != null) {
                System.out.println("Clave '" + claveBuscada2 + "' encontrada en el árbol.");
            } else {
                System.out.println("Clave '" + claveBuscada2 + "' NO encontrada en el árbol.");
            }
        }
        System.out.println("");

        //Claves3
        ArbolBB<Integer> arbol3 = new ArbolBB<>();
        String[] claves3 = ManejadorArchivosGenerico.leerArchivo("src/claves3/claves3.txt");

        for (String clave3 : claves3) {
            arbol3.insertar(new TElementoAB<>(Integer.parseInt(clave3), Integer.parseInt(clave3)));
        }

        String preorden3 = arbol3.preOrden();
        System.out.println("Preorden: " + preorden3);

        for (int claveBuscada3 : clavesBuscadas) {
            if (arbol.buscar(claveBuscada3) != null) {
                System.out.println("Clave '" + claveBuscada3 + "' encontrada en el árbol.");
            } else {
                System.out.println("Clave '" + claveBuscada3 + "' NO encontrada en el árbol.");
            }
        }
        System.out.println("");

        //Consultaprueba
        String[] consulta = ManejadorArchivosGenerico.leerArchivo("src/clavesYconsultaPrueba/consultaPrueba.txt");
        Integer[] consultaint = new Integer[consulta.length];
        int i = 0;
        for (String claveConsulta : consulta) {
            consultaint[i] = Integer.parseInt(claveConsulta);
            i++;
        }
        for (int claveBuscada4 : consultaint) {
            if (arbol.buscar(claveBuscada4) != null) {
                System.out.println("Clave '" + claveBuscada4 + "' encontrada en el árbol.");
            } else {
                System.out.println("Clave '" + claveBuscada4 + "' NO encontrada en el árbol.");
            }
        }
    }
}