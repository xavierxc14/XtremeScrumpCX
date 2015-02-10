package ec.edu.epn.software.entidades;

import java.util.List;

public abstract class TreeNodeHistoria {

    private List<TreeNodeHistoria> hijos;

    public List<TreeNodeHistoria> getHijos() {
        return hijos;
    }

    public void setHijos(List<TreeNodeHistoria> hijos) {
        this.hijos = hijos;
    }

}
