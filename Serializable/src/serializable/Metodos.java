/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Joaquin
 */
public class Metodos {
    
    Libreria a1 = new Libreria();
    
    ArrayList<Departamentos> a = new ArrayList<>();
    
    public void insertar(Departamentos dep) throws FileNotFoundException, IOException{
        File fichero = new File("Departamentos.dat");
        FileOutputStream fileout = new FileOutputStream(fichero);
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
        a.add(dep);
        dataOS.writeObject(a);
        dataOS.close();
        System.out.println("Se ha introducido correctamente el departamento");

    }
    
    public void visualizar() throws FileNotFoundException, IOException, ClassNotFoundException{
        File fichero = new File("Departamentos.dat");
        FileInputStream filein;
        filein = new FileInputStream(fichero);
        ObjectInputStream dataIN = new ObjectInputStream(filein);
        a = (ArrayList<Departamentos>) dataIN.readObject();
        for(Departamentos d : a){
            System.out.println(d);
        }
        dataIN.close();
    }
    
    public void modificar(int numdep) throws FileNotFoundException, IOException {
        boolean fin = false;
        File fichero = new File("Departamentos.dat");
        FileInputStream filein;
        filein = new FileInputStream(fichero);
        ObjectInputStream dataIN = new ObjectInputStream(filein);
        for(Departamentos d : a){
            if (d.getNdep()==numdep) {
                fin = true;
                d.setNdep(numdep);
                d.setNombre(a1.excepcionstringcontexto("Introduce nuevo nombre"));
                d.setLocalidad(a1.excepcionstringcontexto("Introduce la nueva localidad"));
                FileOutputStream fileout = new FileOutputStream(fichero);
                ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
                dataOS.writeObject(a);
                dataOS.close();
                break;
            }
        }
        if(fin){
            System.out.println("No encontrado");
        }
        dataIN.close();
        
    }
    
    public void eliminar(int numdep) throws FileNotFoundException, IOException {
        boolean fin = false;
        int total = 0;
        File fichero = new File("Departamentos.dat");
        FileInputStream filein;
        filein = new FileInputStream(fichero);
        ObjectInputStream dataIN = new ObjectInputStream(filein);
        for(Departamentos d : a){
            if (d.getNdep()==numdep) {
                fin = true;
                a.remove(d);
                FileOutputStream fileout = new FileOutputStream(fichero);
                ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
                dataOS.writeObject(a);
                dataOS.close();
                break;
            }
        }
        for(Departamentos d : a){
            total++;
        }
        System.out.println("Número de departamentos: "+total);
        if(fin){
            System.out.println("No encontrado");
        }
        dataIN.close();
    }
    
    /*public void insertar(Departamentos dep) throws FileNotFoundException, IOException{
        File fichero = new File("Departamentos.dat");
        FileOutputStream fileout = new FileOutputStream(fichero);
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
        dataOS.writeObject(dep);
        dataOS.close();
        System.out.println("Se ha introducido correctamente el departamento");

    }*/
    
    /*public void visualizar() throws FileNotFoundException, IOException, ClassNotFoundException{
        File fichero = new File("Departamentos.dat");
        FileInputStream filein;
        filein = new FileInputStream(fichero);
        ObjectInputStream dataIN = new ObjectInputStream(filein);
        try{
            Object aux = dataIN.readObject();
        while(aux!=null){

            if(aux instanceof Departamentos){
            System.out.println(aux);
            aux= dataIN.readObject();
            }
        }

        }catch(Exception e){

            dataIN.close();
        }


    }*/
    
    void menu() throws IOException, FileNotFoundException, ClassNotFoundException{
        int z = 0;
        do{
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Ver departamento");
            System.out.println("2. Insertar departamento");
            System.out.println("3. Modificar departamento");
            System.out.println("4. Eliminar departamento");
            System.out.println("5. Salir");
            
            
            z = a1.excepcionint();
            switch(z){
                case 1: 
                    visualizar();
                    break;
                case 2:
                    int numdep = a1.excepcionintcontexto("Introduce el número de departamento");
                    String nombre = a1.excepcionstringcontexto("Introduce el nombre de departamento");
                    String localidad = a1.excepcionstringcontexto("Introduce la localidad");
                    Departamentos dep = new Departamentos(numdep,nombre,localidad);
                    insertar(dep);
                    break;
                case 3:
                    modificar(a1.excepcionintcontexto("Introduce número de departamento"));
                    break;
                case 4:
                    eliminar(a1.excepcionintcontexto("Introduce número de departamento"));
                    break;
                    
                
            }
        }while(z!=5);
        
    }
}
