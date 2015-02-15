package org.chrisle.githubrepoviewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Team",
        id = "org.chrisle.githubrepoviewer.GithubRepoViewer"
)
@ActionReferences({
    @ActionReference(path = "Shortcuts", name = "DO-G DO-R")
})
@Messages("CTL_GithubRepoViewer=Github Repository Viewer")
public final class GithubRepoViewer implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
