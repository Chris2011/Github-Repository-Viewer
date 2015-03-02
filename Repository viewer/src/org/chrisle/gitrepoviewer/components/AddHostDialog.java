/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chrisle.gitrepoviewer.components;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.tree.DefaultMutableTreeNode;
import org.chrisle.gitrepoviewer.hosts.Bitbucket;
import org.chrisle.gitrepoviewer.hosts.Github;
import org.chrisle.gitrepoviewer.hosts.IHost;
import org.openide.util.ImageUtilities;

/**
 *
 * @author chrl
 */
public class AddHostDialog extends javax.swing.JDialog {
    private final Map<String, IHost> hosts;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        addHostBtn = new javax.swing.JButton();
        _hint = new javax.swing.JLabel();
        _hostSelectBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        _authToken = new javax.swing.JTextField();
        _username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        _password = new javax.swing.JPasswordField();
        _oAuthTokenBlock = new javax.swing.JRadioButton();
        _userCredentialsBlock = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog.title")); // NOI18N
        setAlwaysOnTop(true);
        setFocusTraversalPolicyProvider(true);
        setModal(true);
        setName("hostDialog"); // NOI18N
        setResizable(false);

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog.jPanel1.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog.jLabel5.text")); // NOI18N

        jTextField2.setText(org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog.jTextField2.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(28, 28, 28)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog.jPanel2.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog.jLabel4.text")); // NOI18N

        jLabel1.setDisplayedMnemonic('u');
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog.jLabel1.text")); // NOI18N

        _authToken.setText(org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog._authToken.text")); // NOI18N

        _username.setText(org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog._username.text")); // NOI18N

        jLabel2.setDisplayedMnemonic('p');
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog.jLabel2.text")); // NOI18N

        _password.setText(org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog._password.text")); // NOI18N

        buttonGroup1.add(_oAuthTokenBlock);
        org.openide.awt.Mnemonics.setLocalizedText(_oAuthTokenBlock, org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog._oAuthTokenBlock.text")); // NOI18N

        buttonGroup1.add(_userCredentialsBlock);
        org.openide.awt.Mnemonics.setLocalizedText(_userCredentialsBlock, org.openide.util.NbBundle.getMessage(AddHostDialog.class, "AddHostDialog._userCredentialsBlock.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_userCredentialsBlock)
                    .addComponent(_oAuthTokenBlock)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(_username, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(_password, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(39, 39, 39)
                                .addComponent(_authToken, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_userCredentialsBlock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_username, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_password, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_oAuthTokenBlock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(_authToken, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(70, 70, 70)
                        .addComponent(_hostSelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(_hint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addHostBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(_hostSelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addHostBtn)
                    .addComponent(_hint))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addHostBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHostBtnActionPerformed
        if (!_username.getText().isEmpty() && _password.getPassword().length > 0) {
            Object selectedHost = _hostSelectBox.getSelectedItem();
            _selectedHost = hosts.get(selectedHost);
            
            _selectedHost.setUserCredentials(_username.getText(), Arrays.toString(_password.getPassword()));

            IconData hostIcon = new IconData(ImageUtilities.image2Icon(ImageUtilities.loadImage(_selectedHost.getHostIcon())), String.format("%s (%s)", _selectedHost.getHostName(), _username.getText()));
            DefaultMutableTreeNode hostTreeNode = new DefaultMutableTreeNode(hostIcon);

            if (_selectedHost.getRepositories() != null) {
                _selectedHost.getRepositories().stream().forEach((repo) -> {
                    String privateIcon = "org/chrisle/gitrepoviewer/resources/private.png";

                    if (!repo.isPrivate()) {
                        privateIcon = "org/chrisle/gitrepoviewer/resources/world.png";
                    }
                    
                    IconData privateRepoIcon = new IconData(ImageUtilities.image2Icon(ImageUtilities.loadImage(privateIcon)), repo.getName());
                    final DefaultMutableTreeNode repoTreeNode = new DefaultMutableTreeNode(privateRepoIcon);
                    hostTreeNode.add(repoTreeNode);
                    
                    if (_selectedHost.getBranches(repo) != null) {
                        _selectedHost.getBranches(repo).stream().forEach((branch) -> {
                            DefaultMutableTreeNode branchTreeNode = new DefaultMutableTreeNode(branch.getName());

                            repoTreeNode.add(branchTreeNode);
                        });
                    }
                });
            }

            GitRepoViewerTopComponent.addTreeNode(hostTreeNode);
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
    private javax.swing.JTextField _authToken;
    private javax.swing.JLabel _hint;
    private javax.swing.JComboBox _hostSelectBox;
    private javax.swing.JRadioButton _oAuthTokenBlock;
    private javax.swing.JPasswordField _password;
    private javax.swing.JRadioButton _userCredentialsBlock;
    private javax.swing.JTextField _username;
    private javax.swing.JButton addHostBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
