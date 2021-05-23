package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class GameFrame extends JFrame{ 

    public GameFrame() {
        Image icon = new ImageIcon("src\\view\\pictures\\Icon.gif").getImage();
        setTitle("扫雷游戏");
        setIconImage(icon);
        
        setSize(1000, 815);
        
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        StartComponent start = new StartComponent();
        TransComponent trans = new TransComponent();
        StoryComponent story = new StoryComponent();
        HelpComponent help = new HelpComponent();
        StransComponent strans = new StransComponent();
        DtransComponent dtrans = new DtransComponent();
        MtransComponent mtrans = new MtransComponent();
        DItransComponent dItransComponent = new DItransComponent();
        final BoardComponent[] boardcom = new BoardComponent[40];
        Number n=new Number();


        for(int i=0;i<40;i++){
            boardcom[i]=new BoardComponent();
            boardcom[i].rets.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setContentPane(start);
                }
            });
        }

        start.start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(trans);
            }
        });
        start.contin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser("out\\.");
                chooser.showOpenDialog(start);
                File file = chooser.getSelectedFile();
                if (file == null) {
                    JOptionPane.showMessageDialog(start, "未得到存档文件", "提示", JOptionPane.WARNING_MESSAGE, null);
                }else{
                    FileReader reader = null;
                    try {
                        reader = new FileReader(file);
                        BufferedReader br = new BufferedReader(reader);
                        
                        String nextline;
                        try {
                            nextline = br.readLine();
                            int[] a = new int[40];
                            String[] b = new String[40];
                            b = nextline.split(" ");
                            for(int i=0;i<b.length;i++){
                                a[i] = Integer.parseInt(b[i]);
                            }
                                
                            int playerNum = a[0];
                            int aiNum = a[1];
                            int moveNum = a[2];
                            boardcom[n.i].setSuMembers(playerNum, aiNum, moveNum);
                                    
                                
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            nextline = br.readLine();
                            int[] a = new int[40];
                            String[] b = new String[40];
                            b = nextline.split(" ");
                            for(int i=0;i<b.length;i++){
                                a[i] = Integer.parseInt(b[i]);
                            }
                                
                            int row = a[0];
                            int col = a[1];
                            int mineNum = a[2];
                            boardcom[n.i].setBoard(row , col, mineNum);
                                    
                                
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            nextline = br.readLine();
                            int[] a = new int[40];
                            String[] b = new String[40];
                            b = nextline.split(" ");
                            for(int i=0;i<b.length;i++){
                                a[i] = Integer.parseInt(b[i]);
                            }
                                
                            int playerNow = a[0];
                            int move = a[1];
                            int remain = a[2];
                            boardcom[n.i].board.setMove(move);
                            boardcom[n.i].board.setPlayerNow(playerNow);
                            boardcom[n.i].board.setRemain(remain);
                                    
                                
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            nextline = br.readLine();
                            int[] a = new int[40];
                            String[] b = new String[40];
                            b = nextline.split(" ");
                            for(int i=0;i<b.length;i++){
                                a[i] = Integer.parseInt(b[i]);
                            }
                            int score = a[0];
                            int miss = a[1];   
                            for(int i=1;i<=boardcom[n.i].board.getPlayerNum()+boardcom[n.i].board.getAiNum();i++){
                                boardcom[n.i].board.getPlayers()[i].setScore(score);
                                boardcom[n.i].board.getPlayers()[i].setMiss(2);
                            }
                                    
                                
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }

                        int tmp = 1;
                       /* try {
                            while(br.readLine()!=null){
                                nextline = br.readLine();
                                int[] a = new int[40];
                                String[] b = new String[40];
                                b = nextline.split(" ");
                                for(int i=0;i<b.length;i++){
                                    a[i] = Integer.parseInt(b[i]);
                                }
                                for(int y=1;y<=boardcom[n.i].board.row;y++){
                                    
                                        boardcom[n.i].board.gridInfo[tmp][y]=a[y];
                                    
                                }
                                tmp++;
                                if(tmp>boardcom[n.i].board.row)break;
                            }
                            
                            
                        } catch (NumberFormatException e1) {
                            e1.printStackTrace();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }*/
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }finally{
                        try {
                            reader.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    setContentPane(boardcom[n.i]);
                    n.i++;
                } 
            }
        });
        start.story.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(story);
            }
        });
        start.help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(help);
            }
        });        
        trans.rets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(start);
            }
        });

        trans.one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(strans);
            }
        });

        trans.two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(dtrans);
            }
        });

        trans.many.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(mtrans);
            }
        });

        trans.diy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(dItransComponent);
            }
        });
        help.rets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(start);
            }
        });

        story.rets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(start);
            }
        });

        strans.rets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(trans);
            }
        });

        strans.primary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardcom[n.i].setSuMembers(1, 0, 5);
                boardcom[n.i].setBoard(9 , 9, 10);
                setContentPane(boardcom[n.i]);     
                n.i++;
            }
        });
        strans.middle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardcom[n.i].setSuMembers(1, 0, 5);
                boardcom[n.i].setBoard(16 , 16, 40);
                setContentPane(boardcom[n.i]);
                n.i++;
            }
        });
        strans.advance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardcom[n.i].setSuMembers(1, 0, 5);
                boardcom[n.i].setBoard(16 , 30, 99);
                setContentPane(boardcom[n.i]);
                n.i++;
            }
        });
        dtrans.rets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(trans);
            }
        });
        dtrans.primary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardcom[n.i].setSuMembers(2, 0, 5);
                boardcom[n.i].setBoard(9 , 9, 10);
                setContentPane(boardcom[n.i]);     
                n.i++;
            }
        });
        dtrans.middle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardcom[n.i].setSuMembers(2, 0, 5);
                boardcom[n.i].setBoard(16 , 16, 40);
                setContentPane(boardcom[n.i]);
                n.i++;
            }
        });
        dtrans.advance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardcom[n.i].setSuMembers(2, 0, 5);
                boardcom[n.i].setBoard(16 , 30, 99);
                setContentPane(boardcom[n.i]);
                n.i++;
            }
        });
        
        mtrans.rets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(trans);
            }
        });

        mtrans.primary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardcom[n.i].setSuMembers(4, 0, 5);
                boardcom[n.i].setBoard(9 , 9, 10);
                setContentPane(boardcom[n.i]);     
                n.i++;
            }
        });
        mtrans.middle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardcom[n.i].setSuMembers(4, 0, 5);
                boardcom[n.i].setBoard(16 , 16, 40);
                setContentPane(boardcom[n.i]);
                n.i++;
            }
        });
        mtrans.advance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardcom[n.i].setSuMembers(4, 0, 5);
                boardcom[n.i].setBoard(16 , 30, 99);
                setContentPane(boardcom[n.i]);
                n.i++;
            }
        });

        


        

        setContentPane(start);
        

    }
}
