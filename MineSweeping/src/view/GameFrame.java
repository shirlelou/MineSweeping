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
        Number mu = new Number();


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
                                boardcom[n.i].board.getPlayers()[i].setMiss(miss);
                            } 
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }

                        int tmp = 1;
                        try {
                            while(br.readLine()!=null){
                                nextline = br.readLine();
                                int[] a = new int[40];
                                String[] b = new String[40];
                                if(nextline != null){
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
                            } 
                            
                            
                        } catch (NumberFormatException e1) {
                            e1.printStackTrace();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        for (int x = 1; x <= boardcom[n.i].board.row; x++) {
                            for (int y = 1; y <= boardcom[n.i].board.row; y++) {
                                if (true) {
                                    if (boardcom[n.i].board.getOpenState(x, y) == 3&&boardcom[n.i].board.getMineState(x, y) == 9) {
                                        Image Mine = new ImageIcon("src\\view\\pictures\\mine.jpg").getImage()
                                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                        ImageIcon mine = new ImageIcon(Mine);
                                        boardcom[n.i].buttons[x][y].setIcon(mine);
                                        boardcom[n.i].buttons[x][y].setBorderPainted(false);
                                    } else if (boardcom[n.i].board.getOpenState(x, y) == 3&&boardcom[n.i].board.getMineState(x, y) == 0) {
                                        Image Open = new ImageIcon("src\\view\\pictures\\blankOpen.jpg")
                                                .getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                        ImageIcon open = new ImageIcon(Open);
                                        boardcom[n.i].buttons[x][y].setIcon(open);
                                        boardcom[n.i].buttons[x][y].setBorderPainted(false);
                                    } else if (boardcom[n.i].board.getOpenState(x, y) == 3&&boardcom[n.i].board.getMineState(x, y) == 1) {
                                        Image Open = new ImageIcon("src\\view\\pictures\\1.jpg").getImage()
                                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                        ImageIcon open = new ImageIcon(Open);
                                        boardcom[n.i].buttons[x][y].setIcon(open);
                                        boardcom[n.i].buttons[x][y].setBorderPainted(false);
                                    } else if (boardcom[n.i].board.getOpenState(x, y) == 3&&boardcom[n.i].board.getMineState(x, y) == 2) {
                                        Image Open = new ImageIcon("src\\view\\pictures\\2.jpg").getImage()
                                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                        ImageIcon open = new ImageIcon(Open);
                                        boardcom[n.i].buttons[x][y].setIcon(open);
                                        boardcom[n.i].buttons[x][y].setBorderPainted(false);
                                    } else if (boardcom[n.i].board.getOpenState(x, y) == 3&&boardcom[n.i].board.getMineState(x, y) == 3) {
                                        Image Open = new ImageIcon("src\\view\\pictures\\3.jpg").getImage()
                                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                        ImageIcon open = new ImageIcon(Open);
                                        boardcom[n.i].buttons[x][y].setIcon(open);
                                        boardcom[n.i].buttons[x][y].setBorderPainted(false);
                                    } else if (boardcom[n.i].board.getOpenState(x, y) == 3&&boardcom[n.i].board.getMineState(x, y) == 4) {
                                        Image Open = new ImageIcon("src\\view\\pictures\\4.jpg").getImage()
                                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                        ImageIcon open = new ImageIcon(Open);
                                        boardcom[n.i].buttons[x][y].setIcon(open);
                                        boardcom[n.i].buttons[x][y].setBorderPainted(false);
                                    } else if (boardcom[n.i].board.getOpenState(x, y) == 3&&boardcom[n.i].board.getMineState(x, y) == 5) {
                                        Image Open = new ImageIcon("src\\view\\pictures\\5.jpg").getImage()
                                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                        ImageIcon open = new ImageIcon(Open);
                                        boardcom[n.i].buttons[x][y].setIcon(open);
                                        boardcom[n.i].buttons[x][y].setBorderPainted(false);
                                    } else if (boardcom[n.i].board.getOpenState(x, y) == 3&&boardcom[n.i].board.getMineState(x, y) == 6) {
                                        Image Open = new ImageIcon("src\\view\\pictures\\6.jpg").getImage()
                                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                        ImageIcon open = new ImageIcon(Open);
                                        boardcom[n.i].buttons[x][y].setIcon(open);
                                        boardcom[n.i].buttons[x][y].setBorderPainted(false);
                                    } else if (boardcom[n.i].board.getOpenState(x, y) == 3&&boardcom[n.i].board.getMineState(x, y) == 7) {
                                        Image Open = new ImageIcon("src\\view\\pictures\\7.jpg").getImage()
                                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                        ImageIcon open = new ImageIcon(Open);
                                        boardcom[n.i].buttons[x][y].setIcon(open);
                                        boardcom[n.i].buttons[x][y].setBorderPainted(false);
                                    } else if (boardcom[n.i].board.getOpenState(x, y) == 3&&boardcom[n.i].board.getMineState(x, y) == 8) {
                                        Image Open = new ImageIcon("src\\view\\pictures\\8.jpg").getImage()
                                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                        ImageIcon open = new ImageIcon(Open);
                                        boardcom[n.i].buttons[x][y].setIcon(open);
                                        boardcom[n.i].buttons[x][y].setBorderPainted(false);
                                    } else if(boardcom[n.i].board.getOpenState(x, y) == 1){
                                        Image Blank = new ImageIcon("src\\view\\pictures\\blankClosed.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                        ImageIcon blank = new ImageIcon(Blank);
                                        boardcom[n.i].buttons[x][y].setIcon(blank);
                                        boardcom[n.i].buttons[x][y].setBorderPainted(false);
                                    }
                                    else if(boardcom[n.i].board.getOpenState(x, y) == 1&&boardcom[n.i].board.getMineState(x, y) == 9){
                                        Image Flag = new ImageIcon("src\\view\\pictures\\flag.jpg").getImage()
                                                        .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon flag = new ImageIcon(Flag);
                                        boardcom[n.i].buttons[x][y].setIcon(flag);
                                        boardcom[n.i].buttons[x][y].setBorderPainted(false);
                                    }
                                
                                }
                            }
                        }
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
        start.music.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    
                    if (mu.i%2==1){
                        Music.loop();
                    }else {
                        Music.stop();
                    }
                mu.i++;
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
                /*boardcom[n.i].setSuMembers(1, 0, 5);
                boardcom[n.i].setBoard(9 , 9, 10);
                setContentPane(boardcom[n.i]);     
                n.i++;*/
                setContentPane(new BoardComponent(10,10,2,0,10,5));
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
