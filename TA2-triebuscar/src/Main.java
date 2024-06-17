
import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        /*
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/palabras1.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        trie.imprimir();
         */


        /*
         TArbolTrie trie = new TArbolTrie();


        String[] lineas = ManejadorArchivosGenerico.leerArchivo("palabras.txt");
        for (String linea : lineas) {
            trie.insertar(linea);
        }


        trie.imprimir();


        System.out.println("Buscar 'casa': " + trie.buscar("casa"));
        System.out.println("Buscar 'casamiento': " + trie.buscar("casamiento"));
        System.out.println("Buscar 'arbol': " + trie.buscar("arbol"));
        System.out.println("Buscar 'grito': " + trie.buscar("grito"));
        System.out.println("Buscar 'casamientos': " + trie.buscar("casamientos"));
         */
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasIndice = ManejadorArchivosGenerico.leerArchivo("PalabrasIndice.txt");
        for (String palabra : palabrasIndice) {
            trie.insertar(palabra);
        }

        trie.indizarLibro("libro.txt");

        trie.imprimirIndice();

    }


}