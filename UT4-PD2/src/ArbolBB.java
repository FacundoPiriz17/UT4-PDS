import java.util.List;
import java.util.LinkedList;
public class ArbolBB<T> implements IArbolBB<T> {
    private IElementoAB<T> raiz;
    
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (raiz == null) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        return (raiz != null) ? raiz.buscar(unaEtiqueta) : null;
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz != null) {
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }

    @Override
    public String preOrden() {
        if (raiz != null) {
            return raiz.preOrden();
        }
        return "";
    }

    @Override
    public String inOrden() {
        if (raiz != null) {
            return raiz.inOrden();
        }
        return "";
    }

    @Override
    public String postOrden() {
        if (esVacio()) {
            return null;
        }
    String res = "";
    if (raiz != null) {
            return raiz.postOrden();
        }
        return null;
    }

    public boolean esVacio() {
        return raiz == null;
    }

}
