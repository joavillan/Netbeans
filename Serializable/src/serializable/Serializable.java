/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializable;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Joaquin
 */
public class Serializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        // TODO code application logic here
        
        Metodos m = new Metodos();
        
        m.menu();
    }
    
}
