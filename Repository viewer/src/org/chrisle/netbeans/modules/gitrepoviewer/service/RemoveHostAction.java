package org.chrisle.netbeans.modules.gitrepoviewer.service;

/**
 *
 * @author chrl
 */
import org.openide.util.NbBundle.Messages;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.chrisle.netbeans.modules.gitrepoviewer.components.RemoveHostDialog;

public class RemoveHostAction extends AbstractAction {
    RemoveHostDialog _removeHostDialog;

    @Messages("LBL_RemoveHost=Remove Host")
    public RemoveHostAction() {
        super(Bundle.LBL_RemoveHost());

        _removeHostDialog = new RemoveHostDialog(null, true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        _removeHostDialog.setVisible(true);
    }
}