import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivoTexto {
    private String nombreArchivo;

    public LectorArchivoTexto(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public List<String> obtenerLineas() {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            return null;
        }

        List<String> lineasArchivo = new ArrayList<>();
        Path rutaFormal = Paths.get(nombreArchivo);
        try (BufferedReader lector = Files.newBufferedReader(rutaFormal)) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                lineasArchivo.add(linea);
            }
        } catch (IOException errorLectura) {
            return null;
        }
        return lineasArchivo;
    }
}
