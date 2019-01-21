package cu.cyrbes;

import java.util.Iterator;
import java.util.Set;


public class App
{
    public static void main(String[] args)
    {
        try {
            Set result = excecute(args);

            Iterator iterator = result.iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (Exception e) {
            if(e instanceof AppException){
                System.out.println(e.getMessage());
            }
            else{
                System.out.println("Sorry, an error has happened");
            }
        }
    }

    /**
     * Valida las entradas del comando y crea la respuesta del mismo
     *
     * @param args: argumentos recibidos en el comando
     * @return SET
     */
    private static Set excecute(String[] args) throws Exception{
        if(args.length != 3){
            throw new AppException("Invalid number of arguments");
        }

        if(!args[1].equals(VisitRecordService.CITY_QUERY_TYPE) && !args[1].equals(VisitRecordService.ID_QUERY_TYPE)){
            throw new AppException("Invalid query type param");
        }

        VisitRecordService visitRecordService = new VisitRecordService();

        return visitRecordService.answerRequest(args[0], args[1], args[2]);
    }
}
