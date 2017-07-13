package cr.ac.ucr.ecci.ci1310.wiki.ui;

import com.sun.org.apache.xpath.internal.SourceTree;
import cr.ac.ucr.ecci.ci1310.wiki.core.wiki.service.WikiService;
import cr.ac.ucr.ecci.ci1310.wiki.core.wiki.service.impl.WikiServiceImpl;
import cr.ac.ucr.ecci.ci1310.wiki.tests.Tester;

import java.util.Scanner;

/**
 * Created by Rodrigo on 7/11/2017.
 */
public class ui {
    public static void main(String[] args){
        WikiService wikiService;
        Scanner scanner = new Scanner(System.in);
        int actividad;
        int cacheType=0;
        int tipoDeConsulta=0;
        String consulta;
        boolean exit = false;
        while(!exit){
            System.out.println("Bienvenido A la aplicación de Busqueda en Wiki.\nIngrese el número con lo que desea hacer:");
            System.out.println("\t\t1.Realizar pruebas al cache.\n\t\t2.Realizar Consultas a la base de Wikipedia Local.\n\t\t3.Salir.");
            actividad = scanner.nextInt();
            switch (actividad){
                case 1:
                    Tester tester = new Tester();
                    break;
                case 2:
                    while(cacheType<1 || cacheType>4){
                        System.out.println("Seleccione el tipo de cache que desea utilizar");
                        System.out.println("\t\t1.RandomCache.\n\t\t2.LRUCache.\n\t\t3.FIFOCache.\n\t\t4.LIFOCache.");
                        cacheType = scanner.nextInt();
                    }
                    //wikiService = new WikiServiceImpl(cacheType);
                    while(!exit){
                        System.out.println("Ingrese como desea consultar la base de Datos");
                        System.out.println("\t\t1.Consulta por título.\n\t\t2.Consulta por Id.\n\t\t3.Salir");
                        tipoDeConsulta = scanner.nextInt();
                        switch (tipoDeConsulta){
                            case 1:
                                String title = null;
                                while(title==null) {
                                    System.out.println("Ingrese el título por el cual desea buscar:");
                                    title = scanner.next();
                                }
                                //wikiService.findByTitle(title);
                                break;
                            case 2:
                                int id = 0;
                                while(id<1){
                                    System.out.println("Ingrese el id por el cual desea buscar:");
                                    id = scanner.nextInt();
                                    if(id<0){
                                        System.out.println("Número invalido,ingrese un número mayor que 0.");
                                    }
                                }
                                //wikiService.findById(id);
                                break;
                            case 3:
                                exit = true;
                                break;
                        }
                    }
                    break;
                case 3:
                    exit = true;
                    break;
            }

        }
        System.out.println("Gracias por usar la aplicación.");

    }
}