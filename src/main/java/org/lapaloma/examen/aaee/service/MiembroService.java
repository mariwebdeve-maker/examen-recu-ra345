package org.lapaloma.examen.aaee.service;

import java.util.List;

import org.lapaloma.examen.aaee.dao.IMiembroDAO;
import org.lapaloma.examen.aaee.excepcion.MiembroNoEncontradoException;
import org.lapaloma.examen.aaee.vo.Miembro;
import org.springframework.stereotype.Service;

@Service
public class MiembroService {

    private final IMiembroDAO miembroDAO;

    // Spring inyecta el DAO automáticamente
    public MiembroService(IMiembroDAO miembroDAO) {
        this.miembroDAO = miembroDAO;
    }

    /**
     * Obtiene la lista completa de miembros
     * 
     * @return List<Miembro> lista de todos los miembros
     * @throws RuntimeException si la lista está vacía
     */
    public List<Miembro> obtenerListaMiembros() {

        List<Miembro> lista = miembroDAO.obtenerListaMiembros();

        // Simulamos el caso de lista vacía para probar la excepción
      //  lista=null; este es el error
        
        if (lista == null || lista.isEmpty()) {
            throw new RuntimeException("No hay miembros disponibles");
        }

        return lista;
    }

    /**
     * Obtiene un miembro por su nombre
     * 
     * @param nombre el nombre del miembro a buscar
     * @return Miembro el miembro encontrado
     * @throws MiembroNoEncontradoException si no se encuentra el miembro
     */
    public Miembro obtenerMiembroPorNombre(String nombre) {

        Miembro miembro = miembroDAO.obtenerMiembroPorNombre(nombre);

        // Simulamos el caso de miembro no encontrado para probar la excepción
       //  miembro=null; esto da error
         
         
        if (miembro == null) {
            throw new MiembroNoEncontradoException("Miembro con nombre '" + nombre + "' no encontrado");
        }

        return miembro;
    }

    /**
     * Obtiene un miembro por su alias
     * 
     * @param alias el alias del miembro a buscar
     * @return Miembro el miembro encontrado
     * @throws MiembroNoEncontradoException si no se encuentra el miembro
     */
    public Miembro obtenerMiembroPorAlias(String alias) {

        Miembro miembro = miembroDAO.obtenerMiembroPorAlias(alias);

        if (miembro == null) {
            throw new MiembroNoEncontradoException("Miembro con alias '" + alias + "' no encontrado");
        }

        return miembro;
    }

}
