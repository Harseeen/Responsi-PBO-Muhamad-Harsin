/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_pbo_muhamad.harsin;

/**
 *
 * @author Lenovo
 */
public class mainTabel {

    /**
     * @param args the command line arguments
     */
    public static void mainTabel(String[] args) {
        
        ViewTabel vm = new ViewTabel();
        ModelTabel mm = new ModelTabel();
        ControlerTabel cm = new ControlerTabel(mm, vm);
        
    }
    
}
