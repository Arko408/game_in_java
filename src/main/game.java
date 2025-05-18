package main;

import javax.swing.*;

public class game
{
    public static void main(String[] args)
    {
        JFrame window=new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("MY_GAME");
        game_panel gamepanel= new game_panel();
        window.add(gamepanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
