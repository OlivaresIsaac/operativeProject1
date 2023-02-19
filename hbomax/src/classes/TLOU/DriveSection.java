/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.TLOU;

/**
 *
 * @author dsre1
 */
public class DriveSection {
    private String id;

    private double limit;
    private double current;
    
    public DriveSection(String id, double limit) {
        this.id = id;
        this.limit = limit;
        this.current = 0;
    }
    
    public String getId() {
        return id;
    }
}
