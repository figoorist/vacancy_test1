/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lazurenko_vv
 */
public class JavaApplication1 {

    public interface IAction { void DoWork(String o); }
    
    public static Map<String, IAction> _map = new HashMap();
    
    private static void Init()
    {
        _map.put("arg1", (str)->
        {
            System.out.println(str);
        });
        
        _map.put("arg2", (str)->
        {
            System.out.println(str);
        });
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Init();
        for(String arg : args) _map.get(arg).DoWork(arg);
        
        NewClass2 newC = new NewClass2();
    }
    
}
