package org.chrisle.netbeans.modules.gitrepoviewer.nodes;

import org.chrisle.netbeans.modules.gitrepoviewer.service.actions.AddHostAction;
import org.openide.awt.ActionID;
import javax.swing.Action;
import javax.swing.event.ChangeListener;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.Host;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.IHost;
import org.netbeans.api.core.ide.ServicesTabNodeRegistration;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.lookup.Lookups;

@ActionID(
    category = "Team",
    id = "org.chrisle.gitrepoviewer.service.GitRepoNode"
)
//@ActionRegistration(
//        displayName = "#CTL_GitRepoNode"
//)
//@ActionReference(path = "Menu/Tools", position = 805)
//@Messages({
//    "CTL_GitRepoViewerServiceNode=Git Repositories",
//    "HINT_GitRepoViewerServiceNode=See all repositories of a host account (Github, BitBucket)"
//})

@ServicesTabNodeRegistration(
        name = "GitRepoNode",
        displayName = "Git Repositories",
        shortDescription = "See all git repositories of a host account (Github, BitBucket)",
        iconResource = "org/chrisle/netbeans/modules/gitrepoviewer/resources/world.png",
        position = 2021)
public class GitHostNode extends AbstractNode {
    ChangeListener _listener;
    GitHostChildFactory _gitRepoChildFactory;

//    public GitHostNode(IHost childNode) {
//        super(Children.create(new GitHostChildFactory(new Host()), true), Lookups.singleton(childNode));
//
//        setDisplayName("test");
//    }

    public GitHostNode() {
        super(Children.create(new GitHostChildFactory(new Host()), true));

//        setDisplayName(Bundle.LBL_AllPropsNode());
//        setShortDescription(Bundle.HINT_AllPropsNode());
        setDisplayName("Git Repositories");
        setShortDescription("See all repositories of a host account (Github, BitBucket)");
        setIconBaseWithExtension("org/chrisle/netbeans/modules/gitrepoviewer/resources/world.png");
    }

    @Override
    public Action[] getActions(boolean context) {
        Action[] result = new Action[] {
            new AddHostAction()
        };
        return result;
    }
}