/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nerenchi;

import java.util.Scanner;
import masmt2.agent.MaSMTAbstractAgent;
import masmt2.agent.MaSMTAgent;
import masmt2.message.MaSMTMessage;

/**
 *
 * @author Shehan
 */
public class UpdateStringAgent extends MaSMTAgent {

    Game g;
    long newString;
    MaSMTMessage tempmes;
    //String y="";
    
   // static int[] c = new int[24];
    static String c;

    public UpdateStringAgent() {
        super();
    }
    
    public UpdateStringAgent(String gp, String role, int id) {
        super(gp, role, id);
    }
    
     public static void searcharray(String a){
        
         c = a;  
         
        
         
    }
    @Override
        public void active() {            
        
        MaSMTMessage m;

        MaSMTAbstractAgent sender = new MaSMTAbstractAgent("masmt", "nerenchi", 1);
        MaSMTAbstractAgent reader =new MaSMTAbstractAgent("masmt", "nerenchi",2);
     
        m = new MaSMTMessage(sender, reader,sender, "next_move", "" +c, "none", "broadcast");    

        sendMessage(m);       
        
    }

    @Override
    public void live() {
        tempmes = waitForMessage();
        System.out.println(""+tempmes);
        
        
    }

    @Override
    public void end() {
        
    }

    
    
}
