/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author
 */
public class Attack {
  
    /**
     * Shuffle the list
     * @param listEdge
     * @return 
     */
    public static List<String> randomizeTheList(List<String> listEdge)
    {
       Collections.shuffle(listEdge);
        return listEdge;
    }    
}
