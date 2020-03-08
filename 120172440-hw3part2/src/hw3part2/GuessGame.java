/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3part2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author مركز هوم تكـ
 */
public class GuessGame extends JFrame {

    int num = (int) ((Math.random() * ((1000 - 1) + 1)) + 1);

    public GuessGame() {
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout(0, 100, 10));
        JLabel label1 = new JLabel("I have a number between 1 to 1000.");
        add(label1, BorderLayout.NORTH);

        JLabel label2 = new JLabel("Can you guess my number?");
        add(label2);
        JPanel jpanel = new JPanel();
        JLabel label3 = new JLabel("normal");
        jpanel.add(label3);

        JLabel label4 = new JLabel(" .Try lower number");
        jpanel.add(label4);
        JTextField text = new JTextField();

        text.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    int x = Integer.parseInt(text.getText());
                    if (x > 1000) {
                        text.setText("1000");
                    }
                } catch (Exception ev) {

                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    int x = Integer.parseInt(text.getText());
                    if (x > 1000) {
                        text.setText("1000");
                    }
                } catch (Exception ev) {

                }
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    int x = Integer.parseInt(text.getText());
                    if (x > 1000) {
                        text.setText("1000");
                    } else {
                        if (num > x) {
                            getContentPane().setBackground(Color.BLUE);
                            label3.setText("To low");
                        } else if (num == Integer.parseInt(text.getText())) {
                            JOptionPane.showMessageDialog(null, "Correct", null, JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            getContentPane().setBackground(Color.RED);
                            label3.setText("To High");
                        }
                    }

                } catch (Exception ev) {

                }

                //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        text.setPreferredSize(new Dimension(50, 20));
        jpanel.add(text);
        add(jpanel);

        JButton btn = new JButton("New Game");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = (int) ((Math.random() * ((1000 - 1) + 1)) + 1);
                System.out.println(num);
            }
        });
        System.out.println(num);
        add(btn);
        setVisible(true);
    }

    public static void main(String[] args) {
        GuessGame m = new GuessGame();
    }
}
