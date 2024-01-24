/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerenchi;

import java.util.ArrayList;
import masmt2.agent.MaSMTAgent;
import masmt2.agent.MaSMTManager;
import masmt2.message.MaSMTMessage;

/**
 *
 * @author Shehan
 */
public class NerenchiAgentManager extends MaSMTManager {

    MaSMTMessage tempmes;
    public static int count;
    public static int counta;
    public static ArrayList<String> resultlist = null;
    Game g = new Game();

    public NerenchiAgentManager() {
        super();
       count =0;
       counta=0;
        // System.out.println("call Nerenchi Agent Manager:construction");

    }

    @Override
    public void active() {
        // System.out.println("call NerenchiAgentManager:active()");
        setNumberofClients(21);

        agents[0] = new UpdateStringAgent("masmt", "updatestring", 1);

        agents[1] = new NerenchiAgent(0, 1, 2, "masmt", "nerenchi", 2);
        agents[2] = new NerenchiAgent(2, 3, 4, "masmt", "nerenchi", 3);
        agents[3] = new NerenchiAgent(4, 5, 6, "masmt", "nerenchi", 4);
        agents[4] = new NerenchiAgent(6, 7, 0, "masmt", "nerenchi", 5);
        agents[5] = new NerenchiAgent(8, 9, 10, "masmt", "nerenchi", 6);
        agents[6] = new NerenchiAgent(10, 11, 12, "masmt", "nerenchi", 7);
        agents[7] = new NerenchiAgent(12, 13, 14, "masmt", "nerenchi", 8);
        agents[8] = new NerenchiAgent(14, 15, 8, "masmt", "nerenchi", 9);
        agents[9] = new NerenchiAgent(16, 17, 18, "masmt", "nerenchi", 10);
        agents[10] = new NerenchiAgent(18, 19, 20, "masmt", "nerenchi", 11);
        agents[11] = new NerenchiAgent(20, 21, 22, "masmt", "nerenchi", 12);
        agents[12] = new NerenchiAgent(22, 23, 16, "masmt", "nerenchi", 13);
        agents[13] = new NerenchiAgent(0, 8, 16, "masmt", "nerenchi", 14);
        agents[14] = new NerenchiAgent(1, 9, 17, "masmt", "nerenchi", 15);
        agents[15] = new NerenchiAgent(2, 10, 18, "masmt", "nerenchi", 16);
        agents[16] = new NerenchiAgent(3, 11, 19, "masmt", "nerenchi", 17);
        agents[17] = new NerenchiAgent(4, 12, 20, "masmt", "nerenchi", 18);
        agents[18] = new NerenchiAgent(5, 13, 21, "masmt", "nerenchi", 19);
        agents[19] = new NerenchiAgent(6, 14, 22, "masmt", "nerenchi", 20);
        agents[20] = new NerenchiAgent(7, 15, 23, "masmt", "nerenchi", 21);
        
        
        
        activeAllClients();
        activeMessageParsing();

    }

    @Override
    public void live() {

    }

    @Override
    public void end() {
      System.out.println("call NerenchiAgentManager:end()");
//      if (NerenchiAgentManager.resultlist.contains("four")) {
//            System.out.println("FIRST WEIGHTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
//            //responseOne(NerenchiAgent.getData());
//        } else if (NerenchiAgentManager.resultlist.contains("five")) {
//            System.out.println("SDECOND WEIGHTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
//            //responseThree(NerenchiAgent.getData());
//        } else if (NerenchiAgentManager.resultlist.contains("three")) {
//            System.out.println("THREE WEIGHTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
//            //responseFive(NerenchiAgent.getData());
//        } else if (NerenchiAgentManager.resultlist.contains("one")) {
//            System.out.println("FOUR WEIGHTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
//            //responseTwo(NerenchiAgent.getData());
//        } else if (NerenchiAgentManager.resultlist.contains("two")) {
//            System.out.println("TWO WEIGHTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
//            //responseFour(NerenchiAgent.getData());
//
//        }
//     
//        try {
//            for (String names : resultlist) {
//                System.out.println("values of the RESPONSES from arrayList:" + names);
//
//            }
//        } catch (Exception e) {
//            System.out.println("Exception occure" + e);
//        }
//        System.out.println("-------------------------------------------------ARRAYLIST SIZE:"+resultlist.size());
//        for (String agent : resultlist) {
//            System.out.println("------------------arraylist-----"+agent);
//        }
       stop();
        //g.finalResponse();
    }

}
