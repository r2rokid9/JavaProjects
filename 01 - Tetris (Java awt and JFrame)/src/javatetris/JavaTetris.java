/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatetris;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Art
 */
public class JavaTetris extends JFrame {

    private JLabel statusbar;
    private JLabel nextbar;
    
    public JavaTetris() {

        initUI();
    }

    private void initUI() {

        nextbar = new JLabel("Next piece: ");
        add(nextbar, BorderLayout.NORTH);
        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        var board = new Board(this);
        add(board);
        board.start();

        setTitle("Tetris");
        setSize(200, 460);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    JLabel getStatusBar() {

        return statusbar;
    }

    JLabel getNextBar() {
        return nextbar;
    }
    
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var game = new JavaTetris();
            game.setVisible(true);
        });
    }
}
