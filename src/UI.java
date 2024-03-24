import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread;

public class UI extends JFrame implements ActionListener {

    private int Coin = 0;

    Thread coinThread = null;

    private int totalUpgrades1 = 0;
    private int totalUpgrades2 = 0;
    private int totalUpgrades3 = 0;


    private int totalCoins = 100;

    private int MineCost = 100;
    private int MineCost1 = 400;
    private int MineCost2 = 1000;

    ImageIcon icon = new ImageIcon("C:\\Users\\Андрей\\Pictures\\Mine.jpg");

    private JLabel text = new JLabel("0");
    private JLabel coins = new JLabel("Total Coins : " + totalCoins);
    private JLabel Mine1 = new JLabel(icon);
    private JLabel priceMine = new JLabel("Price : " + MineCost + " Coins");
    private JLabel Mine2 = new JLabel(icon);
    private JLabel priceMine1 = new JLabel("Price : " + MineCost1 + " Coins");
    private JLabel Mine3 = new JLabel(icon);
    private JLabel priceMine2 = new JLabel("Price : " + MineCost2 + " Coins");

    JButton start = new JButton("Start");
    JButton buyMine = new JButton("Buy First Mine");
    JButton buyMine1 = new JButton("Buy Second Mine");
    JButton buyMine2 = new JButton("Buy Third Mine");




    UI() {

        Font font1 = new Font("Arial", Font.PLAIN, 24);
        Font font2 = new Font("Arial", Font.PLAIN, 20);

        setSize(750, 750);
        setLayout(null);
        start.setBounds(225, 225, 200, 200);
        start.setBackground(Color.lightGray);
        start.setForeground(Color.BLUE);
        coins.setBounds(250, 10, 1000, 50);
        //first mine
        buyMine.setBounds(15, 585, 200, 50);
        Mine1.setBounds(15, 375, 200, 200);
        priceMine.setBounds(15, 625, 200, 50);
        //second mine
        buyMine1.setBounds(235, 585, 200, 50);
        Mine2.setBounds(235, 375, 200, 200);
        priceMine1.setBounds(235, 625, 200, 50);
        //Third mine
        buyMine2.setBounds(455, 585, 200, 50);
        Mine3.setBounds(455, 375, 200, 200);
        priceMine2.setBounds(455, 625, 200, 50);


        coins.setFont(font1);
        start.setFont(font1);
        priceMine.setFont(font2);
        priceMine1.setFont(font2);
        priceMine2.setFont(font2);

        add(start);
        add(coins);
        add(Mine1);
        add(buyMine);
        add(priceMine);
        add(Mine2);
        add(buyMine1);
        add(priceMine1);
        add(Mine3);
        add(buyMine2);
        add(priceMine2);


        start.addActionListener(this);
        buyMine.addActionListener(this);
        buyMine1.addActionListener(this);
        buyMine2.addActionListener(this);




        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.white);
        Mine1.setVisible(false);
        buyMine.setVisible(false);
        priceMine.setVisible(false);
        Mine2.setVisible(false);
        buyMine1.setVisible(false);
        priceMine1.setVisible(false);
        Mine3.setVisible(false);
        buyMine2.setVisible(false);
        priceMine2.setVisible(false);
        coins.setVisible(false);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (text.getText().equals("0"))
            text.setText("");

        switch (b.getText()) {
            case "Start":
                start.setVisible(false);
                coins.setVisible(true);
                Mine1.setVisible(true);
                priceMine.setVisible(true);
                buyMine.setVisible(true);
                Mine2.setVisible(true);
                priceMine1.setVisible(true);
                buyMine1.setVisible(true);
                Mine3.setVisible(true);
                priceMine2.setVisible(true);
                buyMine2.setVisible(true);
                break;
            case "Buy First Mine":
                if (totalCoins >= MineCost) {
                    Coin += 3;
                    totalCoins -= MineCost;
                    totalUpgrades1++;
                    if (totalUpgrades1 == 10) {
                        buyMine.setText("Maximum Upgrades");
                        buyMine.setForeground(Color.RED);
                        buyMine.removeActionListener(this);
                        priceMine.setVisible(false);
                    }
                    coins.setText("Total Coins : " + totalCoins);
                    MineCost += 200;
                    priceMine.setText("Price : " + MineCost + " Coins");
                    Thread firstMineThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                while (true) {
                                    Thread.sleep(1000);
                                    totalCoins += Coin;
                                    coins.setText("Total Coins : " + totalCoins);
                                }
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    });
                    firstMineThread.start();
                } else {
                    buyMine.setText("You don't have enough coins");
                    Timer timer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            buyMine.setText("Buy First Mine");
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
                break;

            case "Buy Second Mine":
                if (totalCoins >= MineCost1) {
                    Coin += 10;
                    totalUpgrades2++;
                    if (totalUpgrades2 == 10) {
                        buyMine1.setText("Maximum Upgrades");
                        buyMine1.setForeground(Color.RED);
                        buyMine1.removeActionListener(this);
                        priceMine1.setVisible(false);
                    }
                    totalCoins -= MineCost1;
                    coins.setText("Total Coins : " + totalCoins);
                    MineCost1 += 350;
                    priceMine1.setText("Price : " + MineCost1 + " Coins");
                    Thread secondMineThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                while (true) {
                                    Thread.sleep(1000);
                                    totalCoins += Coin;
                                    coins.setText("Total Coins : " + totalCoins);
                                }
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    });
                    secondMineThread.start();
                } else {
                    buyMine1.setText("You don't have enough coins");
                    Timer timer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            buyMine1.setText("Buy Second Mine");
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
                break;

            case "Buy Third Mine":
                if (totalCoins >= MineCost2) {
                    Coin += 50;
                    totalUpgrades3++;
                    if (totalUpgrades3 == 10) {
                        buyMine2.setText("Maximum Upgrades");
                        buyMine2.setForeground(Color.RED);
                        buyMine2.removeActionListener(this);
                        priceMine2.setVisible(false);
                    }
                    totalCoins -= MineCost2;
                    coins.setText("Total Coins : " + totalCoins);
                    MineCost2 += 1000;
                    priceMine2.setText("Price : " + MineCost2 + " Coins");
                    Thread thirdMineThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                while (true) {
                                    Thread.sleep(1000);
                                    totalCoins += Coin;
                                    coins.setText("Total Coins : " + totalCoins);
                                }
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    });
                    thirdMineThread.start();
                } else {
                    buyMine2.setText("You don't have enough coins");
                    Timer timer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            buyMine2.setText("Buy Third Mine");
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
                break;

        }
    }
}