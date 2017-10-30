package zuul;

import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private Item item;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     * @param item
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        this.item = null;
    }
    
    public Room(String description, Item item)
    {
        this(description);
        this.item = item;    
    }
    
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param direction A direção da saída.
     * @param neighbor A sala vizinha.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Retorna uma das saídas da sala, a partir de uma String.
     * @param direction Uma string com a direção a retornar
     * @return A sala 
     */
    public Room getExit(String direction)
    {    
        return exits.get(direction);
    }
    
    /**
     * Retorna uma descrição das saídas da sala,
     * por exemplo: "Saídas: norte oeste".
     * @return Uma descrição das saídas disponíveis
     */
    public String getExitString()
    {
        String exitString = "Saídas:";
        for(String exit : exits.keySet()) {
            exitString += " " + exit;
        }
        return exitString;
    }
    
    /**
     * Retorna uma descrição longa dessa sala.
     * Na forma
     *   Você está na cozinha.
     *   Saídas: norte oeste
     * @return Uma descrição da sala, incluindo saídas.
     */
    public String getLongDescription()
    {
        String itemStr = (item != null) 
                ? "Que contém " + item.getDescription() + ".\n"
                : "";
        
        return "Você está " + description + ".\n" +
                itemStr + 
                getExitString();
    }
}
