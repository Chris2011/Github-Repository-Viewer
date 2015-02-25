/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chrisle.gitrepoviewer.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.event.ListDataListener;
import javax.swing.tree.DefaultMutableTreeNode;
import org.chrisle.gitrepoviewer.hosts.Bitbucket;
import org.chrisle.gitrepoviewer.hosts.Github;
import org.chrisle.gitrepoviewer.hosts.IHost;

/**
 *
 * @author chrl
 */
public class AddHostDialog extends javax.swing.JDialog {
    private Map<String, IHost> hosts;
    private IHost _selectedHost;

    /**
     * Creates new form HostsDialog
     */
    public AddHostDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        hosts = new HashMap<String, IHost>() {{
            IHost github = new Github("Github");
            IHost bitbucket = new Bitbucket("Bitbucket");

            put(github.getHostName(), github);
            put(bitbucket.getHostName(), bitbucket);
        }};

        _hostSelectBox.removeAllItems();
        fillHostSelectBox();
    }

    private void fillHostSelectBox() {
        for (String host : hosts.keySet()) {
            _hostSelectBox.addItem(host);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        addHostBtn = new javax.swing.JButton();
        _hint = new javax.swing.JLabel();
        _hostSelectBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog.title")); // NOI18N
        setAlwaysOnTop(true);
        setFocusTraversalPolicyProvider(true);
        setModal(true);
        setName("hostDialog"); // NOI18N
        setResizable(false);

        jLabel1.setDisplayedMnemonic('u');
        jLabel1.setLabelFor(username);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog.jLabel1.text")); // NOI18N

        username.setText(org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog.username.text")); // NOI18N

        jLabel2.setDisplayedMnemonic('p');
        jLabel2.setLabelFor(password);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog.jLabel2.text")); // NOI18N

        password.setText(org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog.password.text")); // NOI18N

        addHostBtn.setMnemonic('a');
        org.openide.awt.Mnemonics.setLocalizedText(addHostBtn, org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog.addHostBtn.text")); // NOI18N
        addHostBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addHostBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHostBtnActionPerformed(evt);
            }
        });

        _hint.setFont(new java.awt.Font("Dialog", 2, 10)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(_hint, org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog._hint.text")); // NOI18N

        _hostSelectBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        _hostSelectBox.setMinimumSize(new java.awt.Dimension(56, 25));
        _hostSelectBox.setPreferredSize(new java.awt.Dimension(56, 25));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog.jLabel3.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addHostBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_hint)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(_hostSelectBox, 0, 109, Short.MAX_VALUE)
                                            .addComponent(password)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(_hostSelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addHostBtn)
                .addGap(55, 55, 55)
                .addComponent(_hint)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addHostBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHostBtnActionPerformed
        if (!username.getText().isEmpty() && password.getPassword().length > 0) {
            Object selectedHost = _hostSelectBox.getSelectedItem();
            _selectedHost = hosts.get(selectedHost);

            IconData hostIcon = new IconData(new ImageIcon("C:\\Projekte\\Netbeans Plugins\\Repository viewer\\src\\org\\chrisle\\gitrepoviewer\\" + _selectedHost.getHostIcon()), String.format("%s (%s)", _selectedHost.getHostName(), username.getText()));
            DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode(hostIcon);

            if (_selectedHost.getRepositories() != null) {
                for (String host: _selectedHost.getRepositories()) {
                    defaultMutableTreeNode.add(new DefaultMutableTreeNode(host));
                }
            }

            GitRepoViewerTopComponent.addTreeNode(defaultMutableTreeNode);
            this.setVisible(false);
        }
    }//GEN-LAST:event_addHostBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddHostDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddHostDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddHostDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddHostDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddHostDialog dialog = new AddHostDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _hint;
    private javax.swing.JComboBox _hostSelectBox;
    private javax.swing.JButton addHostBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
