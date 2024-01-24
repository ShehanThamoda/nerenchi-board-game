/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerenchi;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import dao.ManageProfileDao;
import java.awt.Color;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shehan
 */
public class Game extends javax.swing.JFrame {

    boolean red = false;
    boolean black = false;
    //int[] arr = new int[24];
    public static String arrnew = "000000000000000000000000";
    StringBuilder sb;
    int val;

    private Color colour = Color.BLACK;

    private String playerOne = "player One";
    private String playerTwo = "player Two";

    private static final String VOICENAME_kevin = "kevin";
    static String texts = "Welcome to the Nerenchi Game.Please enter your name.";
    static String textwin = "Win nerenchi point by machine.Machine have bonous chance.";
    static String humantextwin = "You win nerenchi point.Get your bonous chance.";
    static String textstart = "Start the game.You have only thirty seconds to play in each rounds.";

    public static ArrayList<String> listofresponses = new ArrayList<>();

    Watch t = new Watch();
    Watch t1;

    NerenchiAgentManager nerenman;

    public static int humancount = 0;
    static int machinecount = 0;
    static int humanmovescount = 0;
    static int machinemovescount = 0;
    static boolean flag1 = false;
    static boolean flag2 = false;
    static boolean flag3 = false;
    static boolean flag4 = false;

    static int chance1 = 0;
    static int chance2 = 0;
    static int chance3 = 0;
    static int chance4 = 0;
    static int chance5 = 0;
    static int chance6 = 0;
    static int chance7 = 0;
    static int chance8 = 0;
    static int chance9 = 0;
    static int chance10 = 0;
    static int chance11 = 0;
    static int chance12 = 0;
    static int chance13 = 0;
    static int chance14 = 0;
    static int chance15 = 0;
    static int chance16 = 0;
    static int chance17 = 0;
    static int chance18 = 0;
    static int chance19 = 0;
    static int chance20 = 0;

    public Game() {

        this.initComponents();

    }

    public Game(int num) {

        initComponents();
        icon();
        getPlayerNames();
        setNames();
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICENAME_kevin);
        voice.allocate();
        try {
            voice.speak(playerOne + textstart);
        } catch (Exception e) {
            System.out.println("exception occur:" + e);
        }
        try {
            t.start();
            Thread t = Thread.currentThread();
            t.setName("Thread0");
        } catch (Exception e) {
            System.out.println("exception occur in thread0:" + e);
        }

    }

    private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/nerenchi.png")));
    }

    private void setNames() {
        jLabel_playerone.setText(" Red - " + " " + playerOne);
        jLabel_playertwo.setText(" Black - Machine ");

    }

    private void getPlayerNames() {

        playerOne = JOptionPane.showInputDialog(this, "Enter Name:", "Player Name", JOptionPane.INFORMATION_MESSAGE);
        // playerTwo = JOptionPane.showInputDialog(this, "Player Two Name:", "Player Name", JOptionPane.INFORMATION_MESSAGE);

        if (playerOne.equals("")) {
            playerOne = "player One";
        }
    }

    private void determineWhoseTurn() {

//        if (colour == Color.BLACK) {
//            colour = Color.RED;
//            whoseTurn.setText("Machine");
//        } else {
        // colour = Color.BLACK;
        whoseTurn.setText(playerOne);
        // }

    }

    public void WinNerenchiByHuman() {
        JOptionPane.showMessageDialog(this, playerOne + " get Nerenchi", "Bonus Chance", JOptionPane.INFORMATION_MESSAGE);

    }

    public void WinNerenchiByMachine() {
        JOptionPane.showMessageDialog(this, playerTwo + " get Nerenchi", "Bonus Chance", JOptionPane.INFORMATION_MESSAGE);

    }

    public void increaceHumanCount() {
        humanmovescount++;
        lbl_humancount.setText(Integer.toString(humanmovescount));
    }

    public void increaceMachineCount() {
        machinemovescount++;
        lbl_machinecount.setText(Integer.toString(machinemovescount));
    }

    public void timeReset() {
        if (Thread.currentThread().getName().equals("Thread0")) {
            t.stop();
        } else if (Thread.currentThread().getName().equals("Thread1")) {
            t1.stop();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        btn_dialog_cancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jDialog2 = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DetailTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn9 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn18 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn16 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn24 = new javax.swing.JButton();
        btn19 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn15 = new javax.swing.JButton();
        btn23 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn17 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn14 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_playertwo = new javax.swing.JLabel();
        jLabel_playerone = new javax.swing.JLabel();
        lblseconds = new javax.swing.JLabel();
        lbl_miliseconds = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        winhumannerenchi = new javax.swing.JLabel();
        winmachinenerenchi = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_humancount = new javax.swing.JLabel();
        lbl_machinecount = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        whoseTurn = new javax.swing.JLabel();
        btn_help = new javax.swing.JButton();
        btn_clearAll = new javax.swing.JButton();
        btn_profile = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jDialog1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setBackground(new java.awt.Color(51, 0, 0));
        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" NERENCHI GAME GUIDE");
        jLabel3.setOpaque(true);

        btn_dialog_cancel.setText("Cancel");
        btn_dialog_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dialog_cancelActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guidepic.PNG"))); // NOI18N

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btn_dialog_cancel))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_dialog_cancel)
                .addGap(22, 22, 22))
        );

        jLabel2.setBackground(new java.awt.Color(102, 0, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("                     Nerenchi Winners");
        jLabel2.setOpaque(true);

        jPanel4.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        DetailTable.setBackground(new java.awt.Color(255, 204, 204));
        DetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Player Marks", "Machine Marks"
            }
        ));
        DetailTable.setShowHorizontalLines(false);
        DetailTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(DetailTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NERENCHI BOARD GAME");
        setBackground(new java.awt.Color(204, 255, 204));

        jPanel1.setToolTipText("");
        jPanel1.setLayout(null);

        btn9.setBackground(new java.awt.Color(204, 204, 204));
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel1.add(btn9);
        btn9.setBounds(110, 100, 30, 30);

        btn3.setBackground(new java.awt.Color(204, 204, 204));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel1.add(btn3);
        btn3.setBounds(420, 40, 30, 30);

        btn1.setBackground(new java.awt.Color(204, 204, 204));
        btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn1MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1MouseClicked(evt);
            }
        });
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn1);
        btn1.setBounds(50, 40, 30, 30);

        btn10.setBackground(new java.awt.Color(204, 204, 204));
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });
        jPanel1.add(btn10);
        btn10.setBounds(230, 100, 30, 30);

        btn18.setBackground(new java.awt.Color(204, 204, 204));
        btn18.setForeground(new java.awt.Color(0, 0, 153));
        btn18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn18ActionPerformed(evt);
            }
        });
        jPanel1.add(btn18);
        btn18.setBounds(230, 170, 30, 30);

        btn2.setBackground(new java.awt.Color(204, 204, 204));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn2);
        btn2.setBounds(230, 40, 30, 30);

        btn16.setBackground(new java.awt.Color(204, 204, 204));
        btn16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn16ActionPerformed(evt);
            }
        });
        jPanel1.add(btn16);
        btn16.setBounds(110, 230, 30, 30);

        btn8.setBackground(new java.awt.Color(204, 204, 204));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel1.add(btn8);
        btn8.setBounds(50, 220, 30, 30);

        btn11.setBackground(new java.awt.Color(204, 204, 204));
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });
        jPanel1.add(btn11);
        btn11.setBounds(360, 100, 30, 30);

        btn24.setBackground(new java.awt.Color(204, 204, 204));
        btn24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn24ActionPerformed(evt);
            }
        });
        jPanel1.add(btn24);
        btn24.setBounds(170, 230, 30, 30);

        btn19.setBackground(new java.awt.Color(204, 204, 204));
        btn19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn19ActionPerformed(evt);
            }
        });
        jPanel1.add(btn19);
        btn19.setBounds(300, 170, 30, 30);

        btn7.setBackground(new java.awt.Color(204, 204, 204));
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel1.add(btn7);
        btn7.setBounds(50, 400, 30, 30);

        btn15.setBackground(new java.awt.Color(204, 204, 204));
        btn15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn15ActionPerformed(evt);
            }
        });
        jPanel1.add(btn15);
        btn15.setBounds(110, 340, 30, 30);

        btn23.setBackground(new java.awt.Color(204, 204, 204));
        btn23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn23ActionPerformed(evt);
            }
        });
        jPanel1.add(btn23);
        btn23.setBounds(170, 290, 30, 30);

        btn20.setBackground(new java.awt.Color(204, 204, 204));
        btn20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn20ActionPerformed(evt);
            }
        });
        jPanel1.add(btn20);
        btn20.setBounds(300, 230, 30, 30);

        btn22.setBackground(new java.awt.Color(204, 204, 204));
        btn22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn22ActionPerformed(evt);
            }
        });
        jPanel1.add(btn22);
        btn22.setBounds(230, 290, 30, 30);

        btn6.setBackground(new java.awt.Color(204, 204, 204));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel1.add(btn6);
        btn6.setBounds(230, 410, 30, 30);

        btn17.setBackground(new java.awt.Color(204, 204, 204));
        btn17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn17ActionPerformed(evt);
            }
        });
        jPanel1.add(btn17);
        btn17.setBounds(170, 170, 30, 30);

        btn21.setBackground(new java.awt.Color(204, 204, 204));
        btn21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn21ActionPerformed(evt);
            }
        });
        jPanel1.add(btn21);
        btn21.setBounds(300, 290, 30, 30);

        btn13.setBackground(new java.awt.Color(204, 204, 204));
        btn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn13ActionPerformed(evt);
            }
        });
        jPanel1.add(btn13);
        btn13.setBounds(360, 340, 30, 30);

        btn5.setBackground(new java.awt.Color(204, 204, 204));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel1.add(btn5);
        btn5.setBounds(420, 400, 30, 30);

        btn12.setBackground(new java.awt.Color(204, 204, 204));
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });
        jPanel1.add(btn12);
        btn12.setBounds(370, 230, 30, 30);

        btn4.setBackground(new java.awt.Color(204, 204, 204));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel1.add(btn4);
        btn4.setBounds(430, 230, 30, 30);

        btn14.setBackground(new java.awt.Color(204, 204, 204));
        btn14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn14ActionPerformed(evt);
            }
        });
        jPanel1.add(btn14);
        btn14.setBounds(230, 340, 30, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nerenchi.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 480);

        jPanel2.setBackground(new java.awt.Color(51, 0, 0));

        jLabel_playertwo.setBackground(new java.awt.Color(0, 0, 0));
        jLabel_playertwo.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel_playertwo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_playertwo.setOpaque(true);

        jLabel_playerone.setBackground(new java.awt.Color(255, 0, 0));
        jLabel_playerone.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel_playerone.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_playerone.setOpaque(true);

        lblseconds.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 48)); // NOI18N
        lblseconds.setForeground(java.awt.Color.white);
        lblseconds.setText("00");

        lbl_miliseconds.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lbl_miliseconds.setForeground(java.awt.Color.white);
        lbl_miliseconds.setText("00");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("No of Nerenchi:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("No of Nerenchi:");

        winhumannerenchi.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        winhumannerenchi.setForeground(java.awt.Color.white);
        winhumannerenchi.setText("0");

        winmachinenerenchi.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        winmachinenerenchi.setForeground(java.awt.Color.white);
        winmachinenerenchi.setText("0");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText(" :");

        lbl_humancount.setBackground(new java.awt.Color(204, 0, 0));
        lbl_humancount.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbl_humancount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_humancount.setOpaque(true);

        lbl_machinecount.setBackground(new java.awt.Color(0, 0, 0));
        lbl_machinecount.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbl_machinecount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_machinecount.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(winmachinenerenchi, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(winhumannerenchi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lbl_machinecount, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_humancount, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblseconds)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_miliseconds, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_playertwo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel_playerone, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_miliseconds, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblseconds, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_playertwo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_playerone, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_machinecount, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(lbl_humancount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(winhumannerenchi, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(winmachinenerenchi, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        whoseTurn.setBackground(new java.awt.Color(255, 204, 204));
        whoseTurn.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        whoseTurn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next-button.png"))); // NOI18N
        whoseTurn.setOpaque(true);

        btn_help.setForeground(new java.awt.Color(51, 0, 0));
        btn_help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/question.PNG"))); // NOI18N
        btn_help.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_help.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        btn_help.setMaximumSize(new java.awt.Dimension(812, 812));
        btn_help.setMinimumSize(new java.awt.Dimension(812, 812));
        btn_help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_helpActionPerformed(evt);
            }
        });

        btn_clearAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnrestart.png"))); // NOI18N
        btn_clearAll.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_clearAll.setBorderPainted(false);
        btn_clearAll.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_clearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_btn_clearAllActionPerformed(evt);
            }
        });

        btn_profile.setBackground(new java.awt.Color(204, 255, 204));
        btn_profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quiticon.png"))); // NOI18N
        btn_profile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_profileActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/win.PNG"))); // NOI18N
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btn_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(btn_clearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_help, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(whoseTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(whoseTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_help, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_clearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed

        timeReset();
        btn1.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn1.setBackground(Color.RED);
            redTrue();
        } else {
            btn1.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();
        printString(0);
        callAgentManager();

        machineResult();
        //displayOutput();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }

    }//GEN-LAST:event_btn1ActionPerformed

    private void btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MouseClicked

    }//GEN-LAST:event_btn1MouseClicked

    private void btn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MousePressed

    }//GEN-LAST:event_btn1MousePressed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed

        timeReset();
        btn9.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn9.setBackground(Color.RED);
            redTrue();
        } else {
            btn9.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();

        printString(8);
        callAgentManager();

        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();
                NerenchiAgentManager.count++;
            }
            if (NerenchiAgentManager.count++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn17ActionPerformed

        timeReset();
        btn17.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn17.setBackground(Color.RED);
            redTrue();
        } else {
            btn17.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();

        printString(16);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }

    }//GEN-LAST:event_btn17ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        timeReset();
        // t4.stop();
        btn2.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn2.setBackground(Color.RED);
            redTrue();
        } else {
            btn2.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();
        printString(1);
        callAgentManager();

        machineResult();
        //displayOutput();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        timeReset();
        btn10.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn10.setBackground(Color.RED);
            redTrue();
        } else {
            btn10.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();
        printString(9);
        callAgentManager();
        machineResult();
        // displayOutput();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn18ActionPerformed
        timeReset();
        btn18.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn18.setBackground(Color.RED);
            redTrue();
        } else {
            btn18.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();

        printString(17);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();
                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }

    }//GEN-LAST:event_btn18ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        timeReset();
        btn3.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn3.setBackground(Color.RED);
            redTrue();
        } else {
            btn3.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();

        printString(2);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        timeReset();
        btn11.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn11.setBackground(Color.RED);
            redTrue();
        } else {
            btn11.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();
        printString(10);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn19ActionPerformed
        timeReset();
        btn19.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn19.setBackground(Color.RED);
            redTrue();
        } else {
            btn19.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();

        printString(18);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn19ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        timeReset();
        btn8.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn8.setBackground(Color.RED);
            redTrue();
        } else {
            btn8.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();
        printString(7);
        callAgentManager();
        machineResult();
        //  displayOutput();

        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn16ActionPerformed
        timeReset();
        btn16.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn16.setBackground(Color.RED);
            redTrue();
        } else {
            btn16.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();

        printString(15);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn16ActionPerformed

    private void btn24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn24ActionPerformed
        timeReset();
        btn24.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn24.setBackground(Color.RED);
            redTrue();
        } else {
            btn24.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();

        printString(23);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn24ActionPerformed

    private void btn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn20ActionPerformed
        timeReset();
        btn20.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn20.setBackground(Color.RED);
            redTrue();
        } else {
            btn20.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();

        printString(19);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn20ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        timeReset();
        btn12.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn12.setBackground(Color.RED);
            redTrue();
        } else {
            btn12.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();
        printString(11);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn12ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        timeReset();
        btn4.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn4.setBackground(Color.RED);
            redTrue();
        } else {
            btn4.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();

        printString(3);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn23ActionPerformed
        timeReset();
        btn23.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn23.setBackground(Color.RED);
            redTrue();
        } else {
            btn23.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();

        printString(22);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn23ActionPerformed

    private void btn22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn22ActionPerformed
        timeReset();
        btn22.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn22.setBackground(Color.RED);
            redTrue();
        } else {
            btn22.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();

        printString(21);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();
                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn22ActionPerformed

    private void btn21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn21ActionPerformed
        timeReset();
        btn21.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn21.setBackground(Color.RED);
            redTrue();
        } else {
            btn21.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();

        printString(20);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn21ActionPerformed

    private void btn15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn15ActionPerformed
        timeReset();
        btn15.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn15.setBackground(Color.RED);
            redTrue();
        } else {
            btn15.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();

        printString(14);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn15ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        timeReset();
        btn7.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn7.setBackground(Color.RED);
            redTrue();
        } else {
            btn7.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();
        printString(6);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn14ActionPerformed
        timeReset();
        btn14.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn14.setBackground(Color.RED);
            redTrue();
        } else {
            btn14.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();
        printString(13);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn14ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        timeReset();
        btn6.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn6.setBackground(Color.RED);
            redTrue();
        } else {
            btn6.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();
        printString(5);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn13ActionPerformed
        timeReset();
        btn13.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn13.setBackground(Color.RED);
            redTrue();
        } else {
            btn13.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();
        printString(12);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn13ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        timeReset();
        btn5.setBackground(colour);
        increaceHumanCount();
        if (colour == Color.BLACK) {
            btn5.setBackground(Color.RED);
            redTrue();
        } else {
            btn5.setBackground(Color.BLACK);
            blackTrue();
        }
        determineWhoseTurn();
        printString(4);
        callAgentManager();
        machineResult();
        while (true) {
            if (finalResponse().equals("no") || finalResponse() == null) {
                finalResponse();

                NerenchiAgentManager.counta++;
            }
            if (NerenchiAgentManager.counta++ == 20) {
                displayOutput();
                break;
            }
        }
    }//GEN-LAST:event_btn5ActionPerformed

    public void printString(int id) {

        if (red) {

            sb = new StringBuilder(arrnew);
            sb.setCharAt(id, '2');

            arrnew = sb.toString();

        } else if (black) {
            sb = new StringBuilder(arrnew);
            sb.setCharAt(id, '1');

            arrnew = sb.toString();

        } else {

        }

        UpdateStringAgent.searcharray(arrnew);

        System.out.print("Pass String: " + arrnew);
        System.out.println(" ");

    }

    public void callAgentManager() {
        NerenchiAgentManager nm = new NerenchiAgentManager();
        nm.start();
    }

    public void blackTrue() {
        black = true;
        red = false;
    }

    public void redTrue() {
        black = false;
        red = true;
    }

    public void machineResult() {
        int num;
        NerenchiAgentManager.resultlist = new ArrayList<>();

        while (true) {
            System.out.println("Response from machine:" + NerenchiAgent.getResponse() + "Loading..");
            //NerenchiAgent.getResponse() != null;

            if (NerenchiAgent.getResponse() != null) {
                NerenchiAgentManager.count++;
            }
            if (NerenchiAgentManager.count == 20) {

                break;
            }

        }

    }

    public String finalResponse() {
        String nam = null;
        for (int i = 0; i < NerenchiAgentManager.resultlist.size(); i++) {
            Pattern patternone = Pattern.compile("5fou");
            Matcher matcherone = patternone.matcher(NerenchiAgentManager.resultlist.get(i));

            Pattern patterntwo = Pattern.compile("4fiv");
            Matcher matchertwo = patterntwo.matcher(NerenchiAgentManager.resultlist.get(i));

            Pattern patternthree = Pattern.compile("3two");
            Matcher matcherthree = patternthree.matcher(NerenchiAgentManager.resultlist.get(i));

            Pattern patternfour = Pattern.compile("2one");
            Matcher matcherfour = patternfour.matcher(NerenchiAgentManager.resultlist.get(i));

            Pattern patternfive = Pattern.compile("1thr");
            Matcher matcherfive = patternfive.matcher(NerenchiAgentManager.resultlist.get(i));

            if (matcherone.find()) {
                nam = "5fou";
            } else if (matchertwo.find()) {
                nam = "4fiv";
            } else if (matcherthree.find()) {
                nam = "3two";
            } else if (matcherfour.find()) {
                nam = "2one";
            } else if (matcherfive.find()) {
                nam = "1thr";
            } else {
                nam = "no";
            }
        }
        System.out.println("finalResponse()---------------------------------------------->" + nam);
        return nam;

    }

    //select the best of best position and display it
    public void displayOutput() {

        //  System.out.println("------------------------" + NerenchiAgentManager.resultlist.size());
        if (humanmovescount == 12 || machinemovescount == 12) {
            timeReset();
            System.out.println("-----------------------WIN THE GAME SUCCESSFULLY OCCURED-------------------");
            if (humanmovescount == 12) {
                JOptionPane.showMessageDialog(this, playerOne + " Win the Game!!", "Win the Game", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Machine Win the Game!!", "Win the Game", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            System.out.println("---------------------------------Array list size of main gui interface:" + NerenchiAgentManager.resultlist.size());
            for (String names : NerenchiAgentManager.resultlist) {
                System.out.println("-----------result of array list : main GUI--------" + names);
            }

            //check human player get nerenchi or not
            if (getNerenchi() == true) {

                humancount++;
                winhumannerenchi.setText(Integer.toString(humancount));

                Voice voice;
                VoiceManager voiceManager = VoiceManager.getInstance();
                voice = voiceManager.getVoice(VOICENAME_kevin);
                voice.allocate();
                try {
                    voice.speak(playerOne + humantextwin);
                } catch (Exception e) {
                    System.out.println("exception occur:" + e);
                }

            } else {

                //sort the arraylist in decending order and get highest weight value to the first
                for (int i = 0; i < NerenchiAgentManager.resultlist.size(); i++) {
                    for (int j = 0; j < NerenchiAgentManager.resultlist.size(); j++) {
                        if (Integer.parseInt(NerenchiAgentManager.resultlist.get(j).substring(0, 1))
                                < Integer.parseInt(NerenchiAgentManager.resultlist.get(i).substring(0, 1))) {
                            String temp = NerenchiAgentManager.resultlist.get(i);
                            NerenchiAgentManager.resultlist.set(i, NerenchiAgentManager.resultlist.get(j));
                            NerenchiAgentManager.resultlist.set(j, temp);
                        }
                    }

                }
                for (String names : NerenchiAgentManager.resultlist) {
                    System.out.println("After the sourting::::" + names);
                }
                for (int i = 0; i < NerenchiAgentManager.resultlist.size(); i++) {
                    String record = "";
                    String position = "";
                    // System.out.println("sdsssssssss" + NerenchiAgentManager.resultlist.get(i));

                    Pattern patternone = Pattern.compile("5fou");
                    Matcher matcherone = patternone.matcher(NerenchiAgentManager.resultlist.get(i));

                    Pattern patterntwo = Pattern.compile("4fiv");
                    Matcher matchertwo = patterntwo.matcher(NerenchiAgentManager.resultlist.get(i));

                    Pattern patternthree = Pattern.compile("3two");
                    Matcher matcherthree = patternthree.matcher(NerenchiAgentManager.resultlist.get(i));

                    Pattern patternfour = Pattern.compile("2one");
                    Matcher matcherfour = patternfour.matcher(NerenchiAgentManager.resultlist.get(i));

                    Pattern patternfive = Pattern.compile("1thr");
                    Matcher matcherfive = patternfive.matcher(NerenchiAgentManager.resultlist.get(i));

                    if (matcherone.find()) {
                        System.out.println("FIRST WEIGHT");
                        record = NerenchiAgentManager.resultlist.get(i);
                        System.out.println("-------------------------------record------------------" + record);
                        position = record.substring(4).trim();
                        System.out.println("-------------------------------position------------------" + position);
                        response(position);
                        break;
                    } else if (matchertwo.find()) {
                        System.out.println("SECOND WEIGHT");
                        record = NerenchiAgentManager.resultlist.get(i);
                        System.out.println("-------------------------------record------------------" + record);
                        position = record.substring(4).trim();
                        System.out.println("-------------------------------position------------------" + position);
                        response(position);
                        break;
                    } else if (matcherthree.find()) {
                        System.out.println("THIRD WEIGHT");
                        record = NerenchiAgentManager.resultlist.get(i);
                        System.out.println("-------------------------------record------------------" + record);
                        position = record.substring(4).trim();
                        System.out.println("-------------------------------position------------------" + position);
                        response(position);
                        break;
                    } else if (matcherfour.find()) {
                        System.out.println("FOURTH WEIGHT");
                        record = NerenchiAgentManager.resultlist.get(i);
                        System.out.println("-------------------------------record------------------" + record);
                        position = record.substring(4).trim();
                        System.out.println("-------------------------------position------------------" + position);
                        response(position);
                        break;
                    } else if (matcherfive.find()) {
                        System.out.println("FIFTH WEIGHT");
                        record = NerenchiAgentManager.resultlist.get(i);
                        System.out.println("-------------------------------record------------------" + record);
                        position = record.substring(4).trim();
                        System.out.println("-------------------------------position------------------" + position);
                        response(position);
                        break;
                    }
                }
            }
        }
    }

    //response from machine side
    public void response(String position) {

        selectPosition(position);
        increaceMachineCount();

        try {
            t1 = new Watch();
            t1.start();
            Thread t2 = Thread.currentThread();
            t2.setName("Thread1");
        } catch (Exception e) {
            System.out.println("Exception occur in thread1" + e);
        }

        blackTrue();
        determineWhoseTurn();

        System.out.println("RESPONSE------------------->" + position);
        System.out.println("");

        printString(Integer.parseInt(position));

        if (machinemovescount == 12) {
            System.out.println("-----------------------WIN THE GAME SUCCESSFULLY OCCURED-------------------");
            timeReset();
            JOptionPane.showMessageDialog(this, "Machine Win the Game!!", "Win the Game", JOptionPane.INFORMATION_MESSAGE);
            
        }

        if (getNerenchiMachine() == true) {
            System.out.println("COME TO THE GET NERERNCHI BY MACHINE STATUSS SUCCESSFULLY------------------------");

            machinecount++;
            winmachinenerenchi.setText(Integer.toString(machinecount));

            Voice voice;
            VoiceManager voiceManager = VoiceManager.getInstance();
            voice = voiceManager.getVoice(VOICENAME_kevin);
            voice.allocate();
            try {
                voice.speak(textwin);
            } catch (Exception e) {
                System.out.println("exception occur:" + e);
            }
            whoseTurn.setText("Machine");
            timeReset();
            callAgentManager();
            machineResult();
            while (true) {
                if (finalResponse().equals("no") || finalResponse() == null) {
                    finalResponse();

                    NerenchiAgentManager.counta++;
                }
                if (NerenchiAgentManager.counta++ == 20) {
                    displayOutput();
                    break;
                }
            }

            //btn22.setBackground(Color.BLACK);
            //increaceMachineCount();
           // printString(21);
            whoseTurn.setText(playerOne);
        }
    }

    //detect human get a nerenchi point
    public boolean getNerenchi() {
        System.out.println("call getNerechi method");
        if ((arrnew.charAt(0) == '2') && (arrnew.charAt(1) == '2') && (arrnew.charAt(2) == '2')) {

            if (chance1 == 0) {
                chance1++;
                return true;
            }
        }
        if ((arrnew.charAt(2) == '2') && (arrnew.charAt(3) == '2') && (arrnew.charAt(4) == '2')) {

            if (chance2 == 0) {
                chance2++;
                return true;
            }
        }
        if ((arrnew.charAt(4) == '2') && (arrnew.charAt(5) == '2') && (arrnew.charAt(6) == '2')) {

            if (chance3 == 0) {
                chance3++;
                return true;
            }
        }
        if ((arrnew.charAt(6) == '2') && (arrnew.charAt(7) == '2') && (arrnew.charAt(0) == '2')) {

            if (chance4 == 0) {
                chance4++;
                return true;
            }
        }
        if ((arrnew.charAt(8) == '2') && (arrnew.charAt(9) == '2') && (arrnew.charAt(10) == '2')) {

            if (chance5 == 0) {
                chance5++;
                return true;
            }
        }
        if ((arrnew.charAt(10) == '2') && (arrnew.charAt(11) == '2') && (arrnew.charAt(12) == '2')) {

            if (chance6 == 0) {
                chance6++;
                return true;
            }
        }
        if ((arrnew.charAt(12) == '2') && (arrnew.charAt(13) == '2') && (arrnew.charAt(14) == '2')) {

            if (chance7 == 0) {
                chance7++;
                return true;
            }
        }
        if ((arrnew.charAt(14) == '1') && (arrnew.charAt(15) == '1') && (arrnew.charAt(8) == '1')) {

            if (chance8 == 0) {
                chance8++;
                return true;
            }
        }
        if ((arrnew.charAt(16) == '2') && (arrnew.charAt(17) == '2') && (arrnew.charAt(18) == '2')) {

            if (chance9 == 0) {
                chance9++;
                return true;
            }
        }
        if ((arrnew.charAt(18) == '2') && (arrnew.charAt(19) == '2') && (arrnew.charAt(20) == '2')) {

            if (chance10 == 0) {
                chance10++;
                return true;
            }
        }
        if ((arrnew.charAt(20) == '2') && (arrnew.charAt(21) == '2') && (arrnew.charAt(22) == '2')) {

            if (chance11 == 0) {
                chance11++;
                return true;
            }
        }
        if ((arrnew.charAt(22) == '2') && (arrnew.charAt(23) == '2') && (arrnew.charAt(16) == '2')) {

            if (chance12 == 0) {
                chance12++;
                return true;
            }
        }
        if ((arrnew.charAt(0) == '2') && (arrnew.charAt(8) == '2') && (arrnew.charAt(16) == '2')) {

            if (chance13 == 0) {
                chance13++;
                return true;
            }
        }
        if ((arrnew.charAt(1) == '2') && (arrnew.charAt(9) == '2') && (arrnew.charAt(17) == '2')) {

            if (chance14 == 0) {
                chance14++;
                return true;
            }
        }
        if ((arrnew.charAt(2) == '2') && (arrnew.charAt(10) == '2') && (arrnew.charAt(18) == '2')) {

            if (chance15 == 0) {
                chance15++;
                return true;
            }
        }
        if ((arrnew.charAt(3) == '2') && (arrnew.charAt(11) == '2') && (arrnew.charAt(19) == '2')) {

            if (chance16 == 0) {
                chance16++;
                return true;
            }
        }
        if ((arrnew.charAt(4) == '2') && (arrnew.charAt(12) == '2') && (arrnew.charAt(20) == '2')) {

            if (chance17 == 0) {
                chance17++;
                return true;
            }
        }
        if ((arrnew.charAt(5) == '2') && (arrnew.charAt(13) == '2') && (arrnew.charAt(21) == '2')) {

            if (chance18 == 0) {
                chance18++;
                return true;
            }
        }
        if ((arrnew.charAt(6) == '2') && (arrnew.charAt(14) == '2') && (arrnew.charAt(22) == '2')) {

            if (chance19 == 0) {
                chance19++;
                return true;
            }
        }
        if ((arrnew.charAt(7) == '2') && (arrnew.charAt(15) == '2') && (arrnew.charAt(23) == '2')) {

            if (chance20 == 0) {
                chance20++;
                return true;
            }
        }

        return false;
    }

    //detect machine get a nerenchi point
    public boolean getNerenchiMachine() {

        if ((arrnew.charAt(0) == '1') && (arrnew.charAt(1) == '1') && (arrnew.charAt(2) == '1')) {

            if (chance1 == 0) {
                chance1++;
                return true;
            }
        }
        if ((arrnew.charAt(2) == '1') && (arrnew.charAt(3) == '1') && (arrnew.charAt(4) == '1')) {

            if (chance2 == 0) {
                chance2++;
                return true;
            }
        }
        if ((arrnew.charAt(4) == '1') && (arrnew.charAt(5) == '1') && (arrnew.charAt(6) == '1')) {

            if (chance3 == 0) {
                chance3++;
                return true;
            }
        }
        if ((arrnew.charAt(6) == '1') && (arrnew.charAt(7) == '1') && (arrnew.charAt(0) == '1')) {

            if (chance4 == 0) {
                chance4++;
                return true;
            }
        }
        if ((arrnew.charAt(8) == '1') && (arrnew.charAt(9) == '1') && (arrnew.charAt(10) == '1')) {

            if (chance5 == 0) {
                chance5++;
                return true;
            }
        }
        if ((arrnew.charAt(10) == '1') && (arrnew.charAt(11) == '1') && (arrnew.charAt(12) == '1')) {

            if (chance6 == 0) {
                chance6++;
                return true;
            }
        }
        if ((arrnew.charAt(12) == '1') && (arrnew.charAt(13) == '1') && (arrnew.charAt(14) == '1')) {

            if (chance7 == 0) {
                chance7++;
                return true;
            }
        }
        if ((arrnew.charAt(14) == '1') && (arrnew.charAt(15) == '1') && (arrnew.charAt(8) == '1')) {

            if (chance8 == 0) {
                chance8++;
                return true;
            }
        }
        if ((arrnew.charAt(16) == '1') && (arrnew.charAt(17) == '1') && (arrnew.charAt(18) == '1')) {

            if (chance9 == 0) {
                chance9++;
                return true;
            }
        }
        if ((arrnew.charAt(18) == '1') && (arrnew.charAt(19) == '1') && (arrnew.charAt(20) == '1')) {

            if (chance10 == 0) {
                chance10++;
                return true;
            }
        }
        if ((arrnew.charAt(20) == '1') && (arrnew.charAt(21) == '1') && (arrnew.charAt(22) == '1')) {

            if (chance11 == 0) {
                chance11++;
                return true;
            }
        }
        if ((arrnew.charAt(22) == '1') && (arrnew.charAt(23) == '1') && (arrnew.charAt(16) == '1')) {

            if (chance12 == 0) {
                chance12++;
                return true;
            }
        }
        if ((arrnew.charAt(0) == '1') && (arrnew.charAt(8) == '1') && (arrnew.charAt(16) == '1')) {

            if (chance13 == 0) {
                chance13++;
                return true;
            }
        }
        if ((arrnew.charAt(1) == '1') && (arrnew.charAt(9) == '1') && (arrnew.charAt(17) == '1')) {

            if (chance14 == 0) {
                chance14++;
                return true;
            }
        }
        if ((arrnew.charAt(2) == '1') && (arrnew.charAt(10) == '1') && (arrnew.charAt(18) == '1')) {

            if (chance15 == 0) {
                chance15++;
                return true;
            }
        }
        if ((arrnew.charAt(3) == '1') && (arrnew.charAt(11) == '1') && (arrnew.charAt(19) == '1')) {

            if (chance16 == 0) {
                chance16++;
                return true;
            }
        }
        if ((arrnew.charAt(4) == '1') && (arrnew.charAt(12) == '1') && (arrnew.charAt(20) == '1')) {

            if (chance17 == 0) {
                chance17++;
                return true;
            }
        }
        if ((arrnew.charAt(5) == '1') && (arrnew.charAt(13) == '1') && (arrnew.charAt(21) == '1')) {

            if (chance18 == 0) {
                chance18++;
                return true;
            }
        }
        if ((arrnew.charAt(6) == '1') && (arrnew.charAt(14) == '1') && (arrnew.charAt(22) == '1')) {

            if (chance19 == 0) {
                chance19++;
                return true;
            }
        }
        if ((arrnew.charAt(7) == '1') && (arrnew.charAt(15) == '1') && (arrnew.charAt(23) == '1')) {

            if (chance20 == 0) {
                chance20++;
                return true;
            }
        }

        return false;
    }

//    public void responseTwo(String position) {
//        selectPosition(position);
//        increaceMachineCount();
////        t4.start();
////        Thread t4 = Thread.currentThread();
////        t4.setName("Thread4");
//        blackTrue();
//        determineWhoseTurn();
//        System.out.println("RESPONSEONE------------------->" + position);
//        //System.out.println(position);
//        System.out.println("");
//
//         printString(Integer.parseInt(position));
//
//    }
//
//    public void responseThree(String position) {
//
//        selectPosition(position);
//        increaceMachineCount();
////        t5.start();
////        Thread t5 = Thread.currentThread();
////        t5.setName("Thread5");
//        blackTrue();
//        determineWhoseTurn();
//        System.out.println("RESPONSEONE------------------->" + position);
//        //System.out.println(ans);
//        System.out.println("");
//
//         printString(Integer.parseInt(position));
//    }
//
//    public void responseFour(String position) {
//
//        selectPosition(position);
//        increaceMachineCount();
////        t2.start();
////        Thread t2 = Thread.currentThread();
////        t2.setName("Thread2");
//        blackTrue();
//        determineWhoseTurn();
//        System.out.println("RESPONSEONE------------------->" + position);
//        // System.out.println(ans);
//        System.out.println("");
//         printString(Integer.parseInt(position));
//
//    }
//
//    public void responseFive(String position) {
//
//        selectPosition(position);
//        increaceMachineCount();
////        t6.start();
////        Thread t6 = Thread.currentThread();
////        t6.setName("Thread6");
//        blackTrue();
//        determineWhoseTurn();
//        System.out.println("RESPONSEONE------------------->" + position);
//        //System.out.println(ans);
//        System.out.println("");
//         printString(Integer.parseInt(position));
//
//    }
    public void selectPosition(String position) {
        if (position.equals("0")) {
            btn1.setBackground(Color.BLACK);
        } else if (position.equals("1")) {
            btn2.setBackground(Color.BLACK);
        } else if (position.equals("2")) {
            btn3.setBackground(Color.BLACK);
        } else if (position.equals("3")) {
            btn4.setBackground(Color.BLACK);
        } else if (position.equals("4")) {
            btn5.setBackground(Color.BLACK);
        } else if (position.equals("5")) {
            btn6.setBackground(Color.BLACK);
        } else if (position.equals("6")) {
            btn7.setBackground(Color.BLACK);
        } else if (position.equals("7")) {
            btn8.setBackground(Color.BLACK);
        } else if (position.equals("8")) {
            btn9.setBackground(Color.BLACK);
        } else if (position.equals("9")) {
            btn10.setBackground(Color.BLACK);
        } else if (position.equals("10")) {
            btn11.setBackground(Color.BLACK);
        } else if (position.equals("11")) {
            btn12.setBackground(Color.BLACK);
        } else if (position.equals("12")) {
            btn13.setBackground(Color.BLACK);
        } else if (position.equals("13")) {
            btn14.setBackground(Color.BLACK);
        } else if (position.equals("14")) {
            btn15.setBackground(Color.BLACK);
        } else if (position.equals("15")) {
            btn16.setBackground(Color.BLACK);
        } else if (position.equals("16")) {
            btn17.setBackground(Color.BLACK);
        } else if (position.equals("17")) {
            btn18.setBackground(Color.BLACK);
        } else if (position.equals("18")) {
            btn19.setBackground(Color.BLACK);
        } else if (position.equals("19")) {
            btn20.setBackground(Color.BLACK);
        } else if (position.equals("20")) {
            btn21.setBackground(Color.BLACK);
        } else if (position.equals("21")) {
            btn22.setBackground(Color.BLACK);
        } else if (position.equals("22")) {
            btn23.setBackground(Color.BLACK);
        } else if (position.equals("23")) {
            btn24.setBackground(Color.BLACK);
        }
    }


    private void btn_btn_clearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_btn_clearAllActionPerformed

        btn1.setBackground(Color.WHITE);
        btn2.setBackground(Color.WHITE);
        btn3.setBackground(Color.WHITE);
        btn4.setBackground(Color.WHITE);
        btn5.setBackground(Color.WHITE);
        btn6.setBackground(Color.WHITE);
        btn7.setBackground(Color.WHITE);
        btn8.setBackground(Color.WHITE);
        btn9.setBackground(Color.WHITE);
        btn10.setBackground(Color.WHITE);
        btn11.setBackground(Color.WHITE);
        btn12.setBackground(Color.WHITE);
        btn13.setBackground(Color.WHITE);
        btn14.setBackground(Color.WHITE);
        btn15.setBackground(Color.WHITE);
        btn16.setBackground(Color.WHITE);
        btn17.setBackground(Color.WHITE);
        btn18.setBackground(Color.WHITE);
        btn19.setBackground(Color.WHITE);
        btn20.setBackground(Color.WHITE);
        btn21.setBackground(Color.WHITE);
        btn22.setBackground(Color.WHITE);
        btn23.setBackground(Color.WHITE);
        btn24.setBackground(Color.WHITE);

        System.out.println("END and RESET VALUES");
        System.out.println(" ");

        for (int i = 0; i < arrnew.length(); i++) {
            sb = new StringBuilder(arrnew);
            sb.setCharAt(i, '0');
        }

        arrnew = sb.toString();
        JOptionPane.showMessageDialog(this, "Game End - Play Again!");
        dispose();

    }//GEN-LAST:event_btn_btn_clearAllActionPerformed

    private void btn_helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_helpActionPerformed
        jDialog1.setVisible(true);
        jDialog1.setSize(350, 600);
        jDialog1.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_helpActionPerformed

    private void btn_dialog_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dialog_cancelActionPerformed
        jDialog1.dispose();
    }//GEN-LAST:event_btn_dialog_cancelActionPerformed

    private void btn_profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_profileActionPerformed
        String name = playerOne;
        int playermark = humanmovescount;
        int machinemark = machinemovescount;
        ManageProfileDao manageProfileDao = new ManageProfileDao();

        boolean isAdded = manageProfileDao.add(playermark, machinemark, name);

        if (isAdded) {
            JOptionPane.showMessageDialog(this, "Markes Added Successfully!");
            JOptionPane.showConfirmDialog(this, "Quit the Game?", "Quit", JOptionPane.YES_NO_OPTION);
        }

        dispose();
    }//GEN-LAST:event_btn_profileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            jDialog2.setVisible(true);
            jDialog2.setSize(550, 400);
            jDialog2.setLocationRelativeTo(null);

            ManageProfileDao manageProfileDao = new ManageProfileDao();
            ResultSet rsl = manageProfileDao.getAllDetails();
            DefaultTableModel dtm = (DefaultTableModel) DetailTable.getModel();
            dtm.setRowCount(0);

            while (rsl.next()) {
                Object[] rowdata = {rsl.getString("playername"), rsl.getInt("playermarks"), rsl.getInt("machinemarks")};
                dtm.addRow(rowdata);

            }
        } catch (Exception ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jDialog2.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game(1).setVisible(true);
            }
        });

        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICENAME_kevin);
        voice.allocate();
        try {
            voice.speak(texts);
        } catch (Exception e) {
            System.out.println("exception occur:" + e);
        }

    }

    //Time allocation to each rounds
    class Watch extends Thread {

        int ms = 999, s = 30;

        public void run() {
            for (;;) {
                try {
                    sleep(1);
                    ms--;
                    if (ms <= 0) {
                        s--;
                        ms = 999;
                    }
                    if (s < 0) {

                        s = 30;
                        ms = 999;
                    }
                    if (s == 0) {

                        JOptionPane.showConfirmDialog(null, "Time Out...Quit the Game?", "Time Out!", JOptionPane.YES_NO_OPTION);
                        dispose();
                        break;
                    }
                    lbl_miliseconds.setText(Integer.toString(ms));
                    lblseconds.setText(Integer.toString(s));

                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DetailTable;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn13;
    private javax.swing.JButton btn14;
    private javax.swing.JButton btn15;
    private javax.swing.JButton btn16;
    private javax.swing.JButton btn17;
    private javax.swing.JButton btn18;
    private javax.swing.JButton btn19;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JButton btn23;
    private javax.swing.JButton btn24;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btn_clearAll;
    private javax.swing.JButton btn_dialog_cancel;
    private javax.swing.JButton btn_help;
    private javax.swing.JButton btn_profile;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_playerone;
    private javax.swing.JLabel jLabel_playertwo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_humancount;
    private javax.swing.JLabel lbl_machinecount;
    private javax.swing.JLabel lbl_miliseconds;
    private javax.swing.JLabel lblseconds;
    private javax.swing.JLabel whoseTurn;
    private javax.swing.JLabel winhumannerenchi;
    private javax.swing.JLabel winmachinenerenchi;
    // End of variables declaration//GEN-END:variables

}
