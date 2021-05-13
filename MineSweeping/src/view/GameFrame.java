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
    public void setContentPane(DItransComponent ditrans) {
        getRootPane().setContentPane(ditrans);
    }

    public GameFrame() {
        Image icon = new ImageIcon("src\\view\\pictures\\Icon.gif").getImage();
        setTitle("扫雷游戏");
        setIconImage(icon);
        
        setSize(818, 815);
        
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
        DItransComponent ditrans = new DItransComponent();

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

        
        trans.ret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(start);
            }
        });
        trans.rets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(start);
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

        

        setContentPane(start);
        

    }
}
