package ejercicio_1_y_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class DecoradorRegistrar extends DecoradorClima{

    private File registro;
    public DecoradorRegistrar(ClimaOnline clima,String path) {
        super(clima);
        this.registro = new File(path);
    }

    public void registrar() {

        try{
            if(registro.exists()){
                registro.createNewFile();
            }

            String registrar = this.formato(this.temperatura());

            FileWriter writer = new FileWriter(registro, true);
            writer.write(registrar + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String formato(String data){
        String fecha = LocalDate.now().toString();

        return data + fecha;
    }
}
