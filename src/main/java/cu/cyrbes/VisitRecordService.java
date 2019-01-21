package cu.cyrbes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class VisitRecordService {

    static final String CITY_QUERY_TYPE = "CITY";
    static final String ID_QUERY_TYPE = "ID";
    static final String FORMAT_1 = "F1";
    static final String FORMAT_2 = "F2";

    /**
     * Dado el path de un archivo con los datos, el tipo de consulta que se está haciendo
     * CITY o ID y el valor que se desea buscar.
     *
     * @param filepath: camino al archivo de datos
     * @param queryType: tipo de consulta
     * @param query: valor a buscar
     * @return
     */
    public Set answerRequest(String filepath, String queryType, String query) {
        FileInputStream inputStream = null;
        Scanner sc = null;
        String currentFormat = "";
        Set result = new HashSet();
        Person person = null;

        try{
            inputStream = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            throw new AppException("File not found");
        }

        try {
            sc = new Scanner(inputStream, "UTF-8");

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                // Verificando si es una linea de formato o de dato
                if(line.charAt(0) == 'F'){
                    currentFormat = line.substring(0, 2);

                    if(!currentFormat.equals(FORMAT_1) && !currentFormat.equals(FORMAT_2)){
                        throw new AppException("Invalid format");
                    }
                }
                else if(line.charAt(0) == 'D'){
                    person = this.parseRow(line.substring(2), currentFormat);

                    // Si se está buscando el listado de personas dado una ciudad y la ciudad
                    // de la persona que se está analizando es la dada entonces se adiciona al listado
                    if(queryType.equals(CITY_QUERY_TYPE)){
                        if(person.getCity().equals(query)){
                            result.add(person);
                        }
                    }
                    // Si se están buscando las ciudades dado un id se adiciona la ciudad al listado
                    else {
                        if(person.getId().equals(query)){
                            result.add(person.getCity());
                        }
                    }
                }
                else{
                    throw new AppException("Invalid file format");
                }
            }

            // Verificando si hubo error ya que scanner suprime los errores
            if (sc.ioException() != null) {
                throw new AppException("Invalid file");
            }

            return result;

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new AppException("Error to read the file");
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
    }

    /**
     * Parsea la linea dada segun el formato dado y devulve un objeto de
     * tipo Person.
     *
     * @param data: texto de la fila que se está parseando sin tener la D
     * @param format: formato en que está escrito la fila F1 o F2
     * @return
     */
    public Person parseRow(String data, String format){
        Person person = new Person();
        String separator = format.equals(FORMAT_1) ? "," : ";";
        String[] parts = data.split(separator);

        if(format.equals(FORMAT_2)){
            parts[2] = parts[2].replace("-", "");
        }

        person.setId(parts[2].trim());
        person.setName(parts[0].trim());
        person.setCity(parts[1].trim());

        return person;
    }
}
