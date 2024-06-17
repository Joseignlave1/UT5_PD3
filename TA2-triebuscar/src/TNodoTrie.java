import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private LinkedList<Integer> paginas;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        paginas = new LinkedList<>();
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        unaPalabra = unaPalabra.toLowerCase().replaceAll("[^a-z]", ""); // Aseguramos que solo tenga caracteres válidos
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (indice < 0 || indice >= CANT_CHR_ABECEDARIO) {
                continue; // Ignorar caracteres no válidos
            }
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    public void insertarConPagina(String unaPalabra, int pagina) {
        TNodoTrie nodo = this;
        unaPalabra = unaPalabra.toLowerCase().replaceAll("[^a-z]", ""); // Aseguramos que solo tenga caracteres válidos
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (indice < 0 || indice >= CANT_CHR_ABECEDARIO) {
                continue; // Ignorar caracteres no válidos
            }
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        nodo.paginas.add(pagina);
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s + " " + nodo.paginas.toString());
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    @Override
    public int buscar(String s) {
        TNodoTrie nodo = this;
        int comparaciones = 0;

        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            comparaciones++;

            if (nodo.hijos[indice] == null) {
                return 0; // La clave no se encuentra en el trie
            }
            nodo = nodo.hijos[indice];
        }

        if (nodo.esPalabra) {
            return comparaciones; // La clave se encuentra en el trie
        } else {
            return 0; // La clave no se encuentra en el trie
        }
    }

    public boolean existe(String s) {
        TNodoTrie nodo = this;

        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';

            if (nodo.hijos[indice] == null) {
                return false; // La clave no se encuentra en el trie
            }
            nodo = nodo.hijos[indice];
        }

        return nodo.esPalabra;
    }

    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;

        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';

            if (nodo.hijos[indice] == null) {
                return null; // Nodo no encontrado
            }
            nodo = nodo.hijos[indice];
        }

        return nodo;
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {

    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    predecir(s + (char) (c + 'a'), prefijo, palabras, nodo.hijos[c]);
                }
            }
        }
    }

    public LinkedList<Integer> obtenerPaginas(String palabra) {
        TNodoTrie nodo = buscarNodoTrie(palabra);
        if (nodo != null && nodo.esPalabra) {
            return nodo.paginas;
        }
        return null;
    }
}
