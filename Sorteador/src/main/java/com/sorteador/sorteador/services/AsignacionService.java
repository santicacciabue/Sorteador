package main.java.com.sorteador.sorteador.services;

public interface AsignacionService {
    List<Asignacion> listarAsignaciones();
    Optional<Asignacion> listarAsignacionId(int id);
    Asignacion agregarAsignacion(Asignacion asignacion);
    void borrarAsignacion(int id);
}
