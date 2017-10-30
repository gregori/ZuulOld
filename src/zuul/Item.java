/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul;

/**
 *
 * @author rodrigo.gregori
 */
public class Item {
    private String description;
    private int weight;
    
    public Item(String description, int weight) {
        this.description = description;
        this.weight = weight;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getLongDescription() {
        return description + " que pesa " + weight;
    }
}
