/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerenchi;

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import masmt2.agent.MaSMTAgent;
import masmt2.message.MaSMTMessage;

/**
 *
 * @author Shehan
 */
public class NerenchiAgent extends MaSMTAgent {

    int position1;
    int position2;
    int position3;

    private static String response = null;
    private static String data = null;

    Game g;
    MaSMTMessage tempmes;

    NerenchiAgentManager nm = new NerenchiAgentManager();

    public static String getResponse() {
        return response;
    }

    public static void setResponse(String response) {
        NerenchiAgent.response = response;
    }

    public static String getData() {
        return data;
    }

    public static void setData(String data) {
        NerenchiAgent.data = data;
    }

    public NerenchiAgent() {
        super();
    }

    public NerenchiAgent(String gp, String role, int id) {
        super(gp, role, id);
    }

    public NerenchiAgent(int a, int b, int c, String gp, String role, int id) {
        super(gp, role, id);
        position1 = a;
        position2 = b;
        position3 = c;
        response = null;

    }

    @Override
    public void active() {
        System.out.println("[Active] .... " + super.agent);
    }

    @Override
    public void live() {

        if (response != null) {
            setResponse(response);
            nm.stop();
            nm.end();

            // stop();
        }
        tempmes = waitForMessage();
        g = new Game();

        String str = tempmes.content;

        char v1 = str.charAt(position1);
        char v2 = str.charAt(position2);
        char v3 = str.charAt(position3);

        try {
            if ((v1 == '2' && v2 == '0' && v3 == '0') || (v1 == '0' && v2 == '2' && v3 == '0') || (v1 == '0' && v2 == '0' && v3 == '2')) {

                String m1 = "" + agent + " NERENCHI RULE 1(Normal)==> " + position1 + " " + position2 + " " + position3 + "";
                System.out.println(m1);

                if (v1 == '2') {
                    try {
//                        NerenchiAgentManager.resultlist.add("one" + position2);
//                        NerenchiAgentManager.resultlist.add("one" + position3);
                        NerenchiAgentManager.resultlist.add("2one" + position2);
                        System.out.println("one" + position2);
                        //NerenchiAgentManager.resultlist.add("one");
                    } catch (Exception e) {
                        System.out.println("exception occured" + e);
                    }
                    setResponse("one");
                    //setData("Place the black counter on:-no:" + position2 + " or no:" + position3 + " positions");
                    setData("a");
                } else if (v2 == '2') {
                    try {
//                        NerenchiAgentManager.resultlist.add("one" + position1);
//                        NerenchiAgentManager.resultlist.add("one" + position3);
                        NerenchiAgentManager.resultlist.add("2one" + position3);
                        System.out.println("one" + position2);
                        //NerenchiAgentManager.resultlist.add("one");
                    } catch (Exception e) {
                        System.out.println("exception occured" + e);
                    }
                    setResponse("one");
                    //setData("Place the black counter on:-no:" + position1 + " or no:" + position3 + " positions");
                    setData("a");
                } else if (v3 == '2') {
                    try {
//                        NerenchiAgentManager.resultlist.add("one" + position1);
//                        NerenchiAgentManager.resultlist.add("one" + position2);
                        NerenchiAgentManager.resultlist.add("2one" + position1);
                        //NerenchiAgentManager.resultlist.add("one");
                    } catch (Exception e) {
                        System.out.println("exception occured" + e);
                    }
                    setResponse("one");
                    //setData("Place the black counter on:-no:" + position1 + " or no:" + position2 + " positions");
                    setData("a");
                }

            }
            if ((v1 == '1' && v2 == '0' && v3 == '0') || (v1 == '0' && v2 == '1' && v3 == '0') || (v1 == '0' && v2 == '0' && v3 == '1')) {

                String m2 = "" + agent + " NERENCHI RULE 2(Hope to get Nerenchi in next round)==> " + position1 + " " + position2 + " " + position3 + "";
                System.out.println(m2);

                if (v1 == '1') {
                    try {
//                        NerenchiAgentManager.resultlist.add("two" + position2);
//                        NerenchiAgentManager.resultlist.add("two" + position3);
                        NerenchiAgentManager.resultlist.add("3two" + position2);
                        // NerenchiAgentManager.resultlist.add("two");
                    } catch (Exception e) {
                        System.out.println("exception occured" + e);
                    }
                    setResponse("two");
                    setData("Place the black counter on:-no:" + position2 + " or no:" + position3 + " positions");

                } else if (v2 == '1') {
                    try {

                        NerenchiAgentManager.resultlist.add("3two" + position1);
                        //NerenchiAgentManager.resultlist.add("two");
                    } catch (Exception e) {
                        System.out.println("exception occured" + e);
                    }
                    setResponse("two");
                    setData("Place the black counter on:-no:" + position1 + " or no:" + position3 + " positions");

                } else if (v3 == '1') {
                    try {

                        NerenchiAgentManager.resultlist.add("3two" + position2);
                        //  NerenchiAgentManager.resultlist.add("two");
                    } catch (Exception e) {
                        System.out.println("exception occured" + e);
                    }
                    setResponse("two");
                    setData("Place the black counter on:-no:" + position1 + " or no:" + position2 + " positions");

                }

            }
            if ((v1 == '2' && v2 == '1' && v3 == '0') || (v1 == '1' && v2 == '2' && v3 == '0') || (v1 == '2' && v2 == '0' && v3 == '1') || (v1 == '1' && v2 == '0' && v3 == '2') || (v1 == '0' && v2 == '2' && v3 == '1') || (v1 == '0' && v2 == '1' && v3 == '2')) {

                String m3 = "" + agent + " NERENCHI RULE 3(Normal)==> " + position1 + " " + position2 + " " + position3 + "";
                System.out.println(m3);

                if ((v1 == '2' && v2 == '1') || (v1 == '1' && v2 == '2')) {
                    try {
                        //NerenchiAgentManager.resultlist.add("three" + position3);
                        NerenchiAgentManager.resultlist.add("1thr" + position3);

                    } catch (Exception e) {
                        System.out.println("exception occured" + e);
                    }
                    setResponse("three");
                    setData("Place the black counter on:-no:" + position3 + " positions");

                } else if ((v1 == '2' && v3 == '1') || (v1 == '1' && v3 == '2')) {
                    try {
//                        NerenchiAgentManager.resultlist.add("three" + position2);
                        NerenchiAgentManager.resultlist.add("1thr" + position2);
                    } catch (Exception e) {
                        System.out.println("exception occured" + e);
                    }
                    setResponse("three");
                    setData("Place the black counter on:-no:" + position2 + " positions");

                } else {
                    try {
                        //                        NerenchiAgentManager.resultlist.add("three" + position1);
                        NerenchiAgentManager.resultlist.add("1thr" + position1);
                    } catch (Exception e) {
                        System.out.println("exception occured" + e);
                    }
                    setResponse("three");
                    setData("Place the black counter on:-no:" + position1 + " positions");
                }

            }
            if ((v1 == '1' && v2 == '1' && v3 == '0') || (v1 == '1' && v2 == '0' && v3 == '1') || (v1 == '0' && v2 == '1' && v3 == '1')) {

                String m4 = "" + agent + " NERENCHI RULE 4(Get a Nerenchi)==> " + position1 + " " + position2 + " " + position3 + "";
                System.out.println(m4);

                if (v1 == '1' && v2 == '1') {
                    try {
//                        NerenchiAgentManager.resultlist.add("five" + position3);
                        NerenchiAgentManager.resultlist.add("4fiv" + position3);
                    } catch (Exception e) {
                        System.out.println("exception occured" + e);
                    }
                    setResponse("five");
                    setData("Place the black counter on:-no:" + position3 + " positions");

                } else if (v1 == '1' && v3 == '1') {
                    try {
                        // NerenchiAgentManager.resultlist.add("five" + position2);
                        NerenchiAgentManager.resultlist.add("4fiv" + position2);
                    } catch (Exception e) {
                        System.out.println("exception occured" + e);
                    }
                    setResponse("five");
                    setData("Place the black counter on:-no:" + position2 + " positions");

                } else {
                    try {
                        //NerenchiAgentManager.resultlist.add("five" + position1);
                        NerenchiAgentManager.resultlist.add("4fiv" + position1);
                    } catch (Exception e) {
                        System.out.println("exception occured" + e);
                    }
                    setResponse("five");
                    setData("Place the black counter on:-no:" + position1 + " positions");

                }

            }
            if ((v1 == '2' && v2 == '2' && v3 == '0') || (v1 == '2' && v2 == '0' && v3 == '2') || (v1 == '0' && v2 == '2' && v3 == '2')) {

                String m5 = "" + agent + " NERENCHI RULE 5(Avoid the Nerenchi in opponent side)==> " + position1 + " " + position2 + " " + position3 + "";
                System.out.println(m5);

                if (v1 == '2' && v2 == '2') {
                    try {
                        //NerenchiAgentManager.resultlist.add("four"+position3);
                        NerenchiAgentManager.resultlist.add("5fou" + position3);
                    } catch (Exception e) {
                        System.out.println("exception occured" + e);
                    }
                    setResponse("four");

//setData("Place the black counter on:-no:" + position3 + " positions");
                    setData("b");
                } else if (v1 == '2' && v3 == '2') {
                    try {
                        //NerenchiAgentManager.resultlist.add("four"+position2);
                        NerenchiAgentManager.resultlist.add("5fou" + position2);
                    } catch (Exception e) {
                        System.out.println("exception occured" + e);
                    }
                    setResponse("four");
                    //setData("Place the black counter on:-no:" + position2 + " positions");
                    setData("b");
                } else if (v2 == '2' && v3 == '2') {
                    try {
                        //NerenchiAgentManager.resultlist.add("four"+position1);
                        NerenchiAgentManager.resultlist.add("5fou" + position1);
                    } catch (Exception e) {
                        System.out.println("exception occured" + e);
                    }
                    setResponse("four");
                    //setData("Place the black counter on:-no:" + position1 + " positions");
                    setData("b");
                }
            }
//            if (v1 == '2' && v2 == '2' && v3 == '2') {
//
//                String m6 = "" + agent + " OPPONEN SIDE WIN NERENCHI " + position1 + " " + position2 + " " + position3 + "";
//                System.out.println(m6);
//                try {
//
//                    NerenchiAgentManager.resultlist.add("six"+position1+position2+position3);
//
//                } catch (Exception e) {
//                    System.out.println("exception occured" + e);
//                }
//
//                setResponse("six");
//                setData("again chance to the opponent side to play game");
//
//            }
//            if (v1 == '1' && v2 == '1' && v3 == '1') {
//
//                String m6 = "" + agent + " MACHINE SIDE WIN NERENCHI " + position1 + " " + position2 + " " + position3 + "";
//                System.out.println(m6);
//                try {
//
//                    NerenchiAgentManager.resultlist.add("sev");
//
//                } catch (Exception e) {
//                    System.out.println("exception occured" + e);
//                }
//
//                setResponse("seven");
//                setData("again chance to the machine side to play game");
//
//            }

        } catch (Exception e) {
            System.out.println("wrong bound" + e);
        }

    }

    @Override
    public void end() {
        // System.out.println("call NerenchiAgent:end()");

    }

}
