import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    public void insertarConPagina(String palabra, int pagina) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertarConPagina(palabra, pagina);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        if (raiz == null) {
            return 0; // El trie está vacío, así que la palabra no se encuentra
        }
        return raiz.buscar(palabra);
    }

    public LinkedList<Integer> obtenerPaginas(String palabra) {
        if (raiz == null) {
            return null;
        }
        return raiz.obtenerPaginas(palabra);
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> palabras = new LinkedList<>();
        if (raiz != null) {
            raiz.predecir(prefijo, palabras);
        }
        return palabras;
    }

    public void indizarLibro(String archivoLibro) {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(archivoLibro);
        int pagina = 1;
        int lineasPorPagina = 50;
        int lineasLeidas = 0;

        for (String linea : lineas) {
            String[] palabras = linea.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
            for (String palabra : palabras) {
                if (!palabra.isEmpty()) {
                    insertarConPagina(palabra, pagina);
                }
            }
            lineasLeidas++;
            if (lineasLeidas >= lineasPorPagina) {
                pagina++;
                lineasLeidas = 0;
            }
        }
    }

    public void imprimirIndice() {
        imprimir();
    }
}