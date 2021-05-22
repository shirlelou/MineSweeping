package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame{

    
    public void setContentPane(StartComponent start) {
        getRootPane().setContentPane(start);
    }
    public void setContentPane(TransComponent trans) {
        getRootPane().setContentPane(trans);
    }
    public void setContentPane(HelpComponent help) {
        getRootPane().setContentPane(help);
    }
    public void setContentPane(StransComponent strans) {
        getRootPane().setContentPane(strans);
    }
    public void setContentPane(DtransComponent dtrans) {
        getRootPane().setContentPane(dtrans);
    }
    public void setContentPane(MtransComponent mtrans) {
        getRootPane().setContentPane(mtrans);
    }
    

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
        BoardComponent boardcom = new BoardComponent(24,30,1,0,99,5);;
        

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

        


        

        setContentPane(start);
        

    }
}
