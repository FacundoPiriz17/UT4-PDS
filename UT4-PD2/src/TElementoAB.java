import java.util.LinkedList;
import java.util.List;

public class TElementoAB<T> implements IElementoAB<T> {
    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq, hijoDer;
    private T dato;

    public TElementoAB(Comparable unaEtiqueta, T unDato) {
        this.etiqueta = unaEtiqueta;
        this.dato = unDato;
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (this.etiqueta.compareTo(unaEtiqueta) == 0) {
            return this;
        } else if (this.etiqueta.compareTo(unaEtiqueta) > 0 && hijoIzq != null) {
            return hijoIzq.buscar(unaEtiqueta);
        } else if (hijoDer != null) {
            return hijoDer.buscar(unaEtiqueta);
        }
        return null;
    }

    public boolean insertar(TElementoAB<T> elemento){
        if (elemento.getEtiqueta().compareTo(this.etiqueta) < 0) {
            if (hijoIzq == null) {
                hijoIzq = elemento;
                return true;
            } else {
                return hijoIzq.insertar(elemento);
            }
        } else if (elemento.getEtiqueta().compareTo(this.etiqueta) > 0) {
            if (hijoDer == null) {
                hijoDer = elemento;
                return true;
            } else {
                return hijoDer.insertar(elemento);
            }
        }
        return false;
    }

    public String preOrden() {
        String res = this.getDatos() + "-";
        if (hijoIzq != null) {
            res += hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            res += hijoDer.preOrden();
        }
        return res;
    }

    public String inOrden() {
        String res = "";
        if (hijoIzq != null) {
            res += hijoIzq.inOrden();
        }
        res += this.getDatos() + "-";
        if (hijoDer != null) {
            res += hijoDer.inOrden();
        }
        return res;
    }

    public String postOrden() {
        String res = "";
        if (hijoIzq != null) {
            res += hijoIzq.postOrden();
        }
        if (hijoDer != null) {
            res += hijoDer.postOrden();
        }
        res += this.getDatos() + "-";
        return res;
    }

    public T getDatos() {
        return dato;
    }

    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (hijoIzq != null) {
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
        } else if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            if (hijoDer != null) {
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
        } else {
            
            if (hijoIzq == null) {
                return hijoDer;
            }
            if (hijoDer == null) {
                return hijoIzq;
            }
            
            IElementoAB<T> predecesor = hijoIzq;
            IElementoAB<T> padrePredecesor = this;
    
            while (predecesor.getHijoDer() != null) {
                padrePredecesor = predecesor;
                predecesor = predecesor.getHijoDer();
            }
    
            this.etiqueta = predecesor.getEtiqueta();
            this.dato = predecesor.getDatos();
    
            if (padrePredecesor == this) {
                hijoIzq = predecesor.getHijoIzq();
            } else {
                padrePredecesor.setHijoDer(predecesor.getHijoIzq());
            }
        }
        return this;
    }
}