import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsolidadoInscripciones {
    private Map<String, Estudiante> estudiantes;

    public ConsolidadoInscripciones() {
        this.estudiantes = new HashMap<>();
    }

    public List<String> consolidarArchivo(String ruta) {
        LectorArchivoTexto lectorArchivoTexto = new LectorArchivoTexto(ruta);
        List<String> lineas = lectorArchivoTexto.obtenerLineas();
        lineas.forEach(linea -> {
            this.procesarLinea(linea);
        });
        return lineas;
    }

    private void procesarLinea(String linea) {
        // Separar datos de la línea
        String[] datosEstudiante = linea.split(",");

        if (this.buscarEstudiante(datosEstudiante[0]) != null) {
            return;
        }

        // crear estudiante
        Estudiante estudiante = new Estudiante(datosEstudiante[0], datosEstudiante[1]);
        this.estudiantes.put(estudiante.getCedula(), estudiante);
        // agregarle materia
        estudiante.adicionarMateria(datosEstudiante[2], datosEstudiante[3]);
    }

    private Estudiante buscarEstudiante(String cedula) {
        return this.estudiantes.get(cedula);
    }

    public void verCantidadMateriasPorEstudiante(){
        for (Map.Entry<String, Estudiante> entry : this.estudiantes.entrySet()) {
            // String key = entry.getKey();
            Estudiante value = entry.getValue();
            System.out.println(value);
        }
    }
}
