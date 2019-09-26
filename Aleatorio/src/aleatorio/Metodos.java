/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Joaquin
 */
public class Metodos {
    
    Libreria a1 = new Libreria();
    
    /*public void iniciar() throws IOException {
        escribirfichero();
        ver(a1.excepcionint());
        Modificar(a1.excepcionint(), a1.excepciondouble());
        ver(1);
    }*/
    
    public void escribirfichero() throws FileNotFoundException, IOException {
        
        File f = new File ("personas.txt");
        RandomAccessFile fichero = new RandomAccessFile(f, "rw");
        
        int id[] = {1,2,3,4};
        String apellido[] = {"villegas", "rodriguez", "sanz", "antunez"};
        int departamento[] = {10,20,30,40};
        Double salario[] = {900.0, 1000.0, 1500.5, 2100.0};
        StringBuffer buffer = null;
        int n = apellido.length;
        
        for(int i = 0; i<n; i++){
            fichero.writeInt(i+1);
            buffer = new StringBuffer(apellido[i]);
            buffer.setLength(10);
            fichero.writeChars(buffer.toString());
            fichero.writeInt(departamento[i]);
            fichero.writeDouble(salario[i]);
        }
        fichero.close();
    }
    
    public boolean ver(int id) throws FileNotFoundException, IOException{
        File fichero = new File("personas.txt");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        int dep, posicion = 0;
        double salario;
        char apellido[] = new char[10], aux;
        boolean z = false;
        
        posicion = (id-1)*36;
        if(posicion >= file.length()){
            System.out.println(id +" no existe");
            file.close();
            z = false;
        }else {
            z = true;
            file.seek(posicion);
            id = file.readInt();
            if (id <= 0) {
                System.out.println("No se ha encontrado el empleado");
            }else{
                for(int i = 0; i < apellido.length; i++){
                aux = file.readChar();
                apellido[i] = aux;
                }
                String apellidos = new String(apellido);
                dep = file.readInt();
                salario = file.readDouble();
                System.out.println("ID: "+id+", apellido: "+apellidos+",departamento: "+dep+ ",Salario:"+ salario);
            }
        }
        file.close();
        return z;
    }
    
    void insertar(int id,String apellido,int departamento,double salario) throws IOException{
     File fichero = new File("personas.txt");
     RandomAccessFile file= new RandomAccessFile(fichero,"rw");
     long posicion = file.length();
     file.seek(posicion);
    if(ver(id) == false){
        StringBuffer buffer=null;
        String ape=apellido;
        double sal=salario;
        int ident =id;
        int dep = departamento;
        posicion=(ident-1)*36;
        file.seek(posicion);
        file.writeInt(ident);
        buffer= new StringBuffer(apellido);
        buffer.setLength(10);
        file.writeChars(buffer.toString());
        file.writeInt(departamento);
        file.writeDouble(sal);
        System.out.println("Se ha introducido el empleado correctamente.");
        
    
    }else{
    
        System.out.println("El empleado ya existe.");
    }
        
     file.close();
    
    }

    
    public void modificar(int id, double importe) throws FileNotFoundException, IOException, IOException{
        //System.out.println(importe);
        File fichero = new File("personas.txt");
        RandomAccessFile file= new RandomAccessFile(fichero,"rw");
        int dep, posicion = 0;
        
        char apellido[] = new char[10], aux;
        
        posicion=(id-1)*36;
        
        if(posicion >= file.length()){
            System.out.println(id +" vacio");
            file.close();
        }else{
            id = file.readInt();
            posicion=posicion+28;
            file.seek(posicion);
            double salario = file.readDouble();
            double total = importe + salario;
            //System.err.println("salario"+salario);
            //System.out.println("total"+total);
            file.seek(posicion);
            file.writeDouble(total);
            }
            file.close();
    }
    
    public void eliminar(int id) throws FileNotFoundException, IOException{
        File fichero = new File("personas.txt");
        RandomAccessFile file= new RandomAccessFile(fichero,"rw");
        int posicion = 0;
        
        char apellido[] = new char[10], aux;
        
        posicion=(id-1)*36;
        
        if(posicion >= file.length()){
            System.out.println(id +" inválida");
            file.close();
        }else{
            file.seek(posicion);
            file.writeInt(-1);
            }
            file.close();
    }
    
    void menu() throws IOException{
       // Scanner teclado = new Scanner(System.in);
        int z = 0;
        do{
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Ver empleado");
            System.out.println("2. Insertar empleado");
            System.out.println("3. Modificar salario empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Salir");
            
            
            z = a1.excepcionint();
            switch(z){
                case 1: 
                    ver(a1.excepcionintcontexto("Introduce el ID de empleado"));
                    break;
                case 2:
                    insertar(a1.excepcionintcontexto("Inserte ID de empleado"), a1.excepcionstringcontexto("Inserte apellido"), a1.excepcionintcontexto("Inserte departamento"), a1.excepciondoublecontexto("Inserte salario"));
                    break;
                case 3:
                    modificar(a1.excepcionintcontexto("Introduce ID de empleado"), a1.excepciondoublecontexto("Introduce cantidad a añadir"));
                    break;
                case 4:
                    eliminar(a1.excepcionintcontexto("Introduce la ID del empleado a eliminar"));
                    break;
                    
                
        }
        }while(z!=5);
        
    }

}
