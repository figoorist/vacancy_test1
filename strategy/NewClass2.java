/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author lazurenko_vv
 */
public class NewClass2 {
    public NewClass2() 
    {
        JavaApplication1._map.get("arg1").DoWork("arg1"); 
        System.out.println(Singleton.getInstance());
    }
}
