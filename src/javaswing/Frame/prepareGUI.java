/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing.Frame;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author dongvu
 */
public class prepareGUI extends JFrame {

    private JPanel panelContent;
    private JMenuBar menubar;
    private JMenu menu;
    private JMenuItem add;
    private JMenuItem edit;
    private JMenuItem delete;
    private JMenuItem getList;
    private CardLayout cardLayout;
    private JPanel landing;

    public prepareGUI() {
        this.setSize(950, 660);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.cardLayout = new CardLayout();
        this.menubar = new JMenuBar();
        this.menu = new JMenu("Menu");
        this.add = new JMenuItem("Add Student");
        this.add.setActionCommand("add");
        this.add.addActionListener(new actionHandle());

        this.edit = new JMenuItem("Edit Student");
        this.edit.setActionCommand("edit");
        this.edit.addActionListener(new actionHandle());

        this.delete = new JMenuItem("Delete Student");
        this.delete.setActionCommand("delete");
        this.delete.addActionListener(new actionHandle());

        this.getList = new JMenuItem("Get List Student");
        this.getList.setActionCommand("getList");
        this.getList.addActionListener(new actionHandle());

        this.panelContent = new JPanel();
        this.panelContent.setLayout(cardLayout);

        try {
            landing = new JPanel();
            JLabel background = new JLabel(new ImageIcon(ImageIO.read(new File("/Users/dongvu/NetBeansProjects/javaconsole/src/javaconsole/frame/background.png"))));
            landing.add(background);
        } catch (IOException ex) {
            System.out.println("Set background Failed " + ex.getMessage());
        }

        this.panelContent.add(landing, "1");

        this.panelContent.add(new AddStudent(), "2");

        panelContent.add(new GetListStudent(), "3");

        this.cardLayout.show(panelContent, "1");

        this.add(panelContent);

        this.menu.add(add);

        this.menu.add(edit);

        this.menu.add(delete);

        this.menu.add(getList);

        this.menubar.add(menu);

        this.setJMenuBar(menubar);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(
                true);

    }

    private class actionHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ("add".equals(e.getActionCommand())) {
                cardLayout.show(panelContent, "2");
            }
            if ("getList".equals(e.getActionCommand())) {
                cardLayout.show(panelContent, "3");
            }

        }
    }

}
