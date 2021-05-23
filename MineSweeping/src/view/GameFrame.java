package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        final BoardComponent[] priboardcom = new BoardComponent[10];
        final BoardComponent[] midboardcom = new BoardComponent[10];
        final BoardComponent[] advboardcom = new BoardComponent[10];
        final BoardComponent[] diyboardcom = new BoardComponent[10];
        BoardComponent boardcom = new BoardComponent(10,10,1,0,9,5);

     /*   for(int i=0;i<=9;i++){
            priboardcom[i] = new BoardComponent(10, 10, 10 , 5);
            midboardcom[i] = new BoardComponent(16, 16, 40 , 5);
            advboardcom[i] = new BoardComponent(24, 30, 99 , 5);
            diyboardcom[i] = new BoardComponent(1);
            
        }
        */

        start.start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(trans);
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
                setContentPane(boardcom);
            }
        });
        strans.middle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(boardcom);
            }
        });
        strans.advance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(boardcom);
            }
        });



        dtrans.rets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(trans);
            }
        });
        
        mtrans.rets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(trans);
            }
        });

        


        boardcom.rets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(start);
            }
        });

        setContentPane(start);
        

    }
}
