/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto.utils;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import sv.edu.udb.proyecto.modelo.Bitacora;

/**
 *
 * @author josed
 */
public class BitacoraListModel extends AbstractListModel{
 
    private ArrayList<Bitacora> lista = new ArrayList<>();
 
    @Override
    public int getSize() {
        return lista.size();
    }
 
    @Override
    public Object getElementAt(int index) {
        Bitacora p = lista.get(index);
        return p.getDetalle() + " %"+p.getPorcentaje();
    }
    public void addBitacora(Bitacora p){
        lista.add(p);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    public void eliminarBitacora(int index0){
        lista.remove(index0);
        this.fireIntervalRemoved(index0, getSize(), getSize()+1);
    }
    public Bitacora getBitacora(int index){
        return lista.get(index);
    }
}