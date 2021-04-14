
package com.emergentes.modelo;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VacunaDAO {
    private int correlativo;
    private ArrayList<Vacuna> vacunas;

    public VacunaDAO() {
        vacunas = new ArrayList<Vacuna>();
    }
    public int getCorrelativo() {
        return correlativo;
    }
    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }
    public ArrayList<Vacuna> getVacunas() {
        return vacunas;
    }
    public void setVacunas(ArrayList<Vacuna> vacunas) {
        this.vacunas = vacunas;
    }
    public void insertar (Vacuna item){
        vacunas.add(item);
    }
    public void modificar(int id, Vacuna item){
        int pos = posicion(id);
        vacunas.set(pos, item);
    }
    public void eliminar(int id){
        int pos = posicion(id);
        vacunas.remove(pos);
    }
    public int posicion(int id){
        int i = -1;
        if (vacunas.size() > 0) {
            for (Vacuna item : vacunas) {
                ++i;
                if (item.getId() == id) {
                    break;
                }
            }
        }
        return i;
    }
}
