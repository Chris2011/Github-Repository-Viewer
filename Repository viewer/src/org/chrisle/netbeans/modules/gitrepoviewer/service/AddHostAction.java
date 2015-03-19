package org.chrisle.netbeans.modules.gitrepoviewer.service;

/**
 *
 * @author Chris
 */
import org.openide.util.NbBundle.Messages;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.chrisle.netbeans.modules.gitrepoviewer.components.AddHostDialog;

public class AddHostAction extends AbstractAction {
    AddHostDialog _addHostDialog;

    @Messages("LBL_AddHost=Add Host")
    public AddHostAction() {
        super(Bundle.LBL_AddHost());

        _addHostDialog = new AddHostDialog(null, true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        _addHostDialog.setVisible(true);
    }
}