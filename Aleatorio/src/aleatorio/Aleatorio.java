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
import static org.omg.CORBA.ORB.init;

/**
 *
 * @author Joaquin
 */
public class Aleatorio {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        Metodos m = new Metodos();
        
        //m.iniciar();
        
        m.menu();
        
        
    }
    
}
