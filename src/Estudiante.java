import java.util.HashSet;

public class Estudiante {
    private String cedula;
    private String nombre;
    private HashSet<Materia> materias;

    public Estudiante(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.materias = new HashSet<>();
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean adicionarMateria(String codigo, String nombre) {
        Materia newMateria = new Materia(codigo, nombre);
        this.materias.add(newMateria);
        return true;
    }

    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", materias=" + this.materias.size() + "]";
    }

}
