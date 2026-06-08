package ejercicio_1_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class RegistroTemperatura implements Observer {

    private File registro;

    public RegistroTemperatura (String path){
        this.registro = new File(path);
    }


    @Override
    public void update(String data) {

        try{
            if(registro.exists()){
                registro.createNewFile();
            }

            String registrar = this.formato(data);

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
