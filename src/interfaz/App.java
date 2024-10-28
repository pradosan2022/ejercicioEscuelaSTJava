package interfaz;

import entidad.Alumno;

public class App {
    public static void main(String[] args) {
        String nombre, apellido, dirección, curso;
        double notas[];
        int edad;

        Alumno alumno = null;

        int opción;
        do{
            System.out.println("-------------Escuela ST. Java--------------");
            System.out.println("-----------1) Registrar Alumno-------------");
            System.out.println("-------2) Calcular Peor Nota Alumno--------");
            System.out.println("------3) Calcular Mejor Nota Alumno--------");
            System.out.println("--------4) Promedio Notas Alumno-----------");
            System.out.println("---5) Evaluar Situación Académica Alumno---");
            System.out.println("-----------------6) Salir------------------");
            System.out.println("-------------------------------------------");
            System.out.println("Por favor ingrese una opción para Continuar. Ej: 1");

            opción = Leer.datoInt();

            switch (opción){
                case 1:
                    //opción 1 (Ingreso)
                    System.out.println("Por favor ingrese el nombre del Alumno");
                    nombre = Leer.dato();
                    System.out.println("Por favor ingrese el apellido del Alumno");
                    apellido = Leer.dato();
                    System.out.println("Por favor ingrese la dirección del Alumno");
                    dirección = Leer.dato();
                    System.out.println("Por favor ingrese la edad del Alumno");
                    edad = Leer.datoInt();

                    int cantidadNotas; //> entre 3 y 7 <
                    do{
                        System.out.println("Por favor indique la cantidad de notas del alumno (mínimo 3 notas y 7 notas máximo)");
                        cantidadNotas = Leer.datoInt(); //5

                    }while (cantidadNotas < 3 || cantidadNotas > 7);

                    notas = new double[cantidadNotas];

                    for(int i=0; i< notas.length; i++){

                        do{
                            System.out.println("Ingrese nota nro "+(i+1));
                            notas[i] = Leer.datoDouble();
                        }while (notas[i] < 1 || notas[i] > 10);
                    }

                    System.out.println("Por favor ingrese el curso");
                    curso = Leer.dato();

                    alumno = new Alumno(nombre,apellido,dirección,edad,notas,curso);

                    System.out.println("El alumno "+alumno.getNombre() + " " + alumno.getApellido() + " se registró correctamente");

                    break;
                case 2:
                    //opción 2 (Peor nota)
                    if(alumno == null){
                        System.out.println("El alumno no está registrado. Por favor ingrese alumno");
                    }else {
                        System.out.println("La Peor nota del alumno "+alumno.getNombre() + " " +alumno.getApellido() + " es: "+alumno.peorNota());
                    }
                    break;
                case 3:
                    //opción 3 (Mejor nota)
                    if(alumno == null){
                        System.out.println("El alumno no está registrado. Por favor ingrese alumno");
                    }else {
                        System.out.println("La Mejor nota del alumno "+alumno.getNombre() + " " +alumno.getApellido() + " es: "+alumno.mejorNota());
                    }
                    break;
                case 4:
                    //opción 4 (Promedio)
                    if(alumno == null){
                        System.out.println("Por favor registre alumno para continuar...");
                    }else {
                        System.out.println("El Promedio del alumno "+alumno.getNombre() + " " +alumno.getApellido() + " es: "+alumno.promedio());
                    }
                    break;
                case 5:
                    //opción 5 (Situación Académica)
                    if(alumno == null){
                        System.out.println("Por favor registre alumno para continuar...");
                    }else {
                        System.out.println(alumno.evaluarSituaciónAcadémica());
                    }
                    break;

            }

        }while (opción != 6);
    }
}
