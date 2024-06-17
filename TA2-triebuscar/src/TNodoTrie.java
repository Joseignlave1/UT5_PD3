import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
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

    }
}
