package org.chrisle.netbeans.modules.gitrepoviewer.nodes;

import javax.swing.AbstractAction;
import org.chrisle.netbeans.modules.gitrepoviewer.service.actions.AddHostAction;
import org.openide.awt.ActionID;
import javax.swing.Action;
import javax.swing.event.ChangeListener;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.Host;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.IHost;
import org.chrisle.netbeans.modules.gitrepoviewer.service.actions.RemoveHostAction;
import org.netbeans.api.core.ide.ServicesTabNodeRegistration;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.NbBundle;
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
public class HostNode extends AbstractNode {
    ChangeListener _listener;
    HostNodeChildFactory _gitRepoChildFactory;
    AbstractAction hostAction;

    @NbBundle.Messages("HINT_HostNode=Represents a git repository.")
    public HostNode(IHost hostChildNode) {
        super(Children.create(new RepositoryNodeChildFactory(new Repository("")), true), Lookups.singleton(hostChildNode));
        super.setName(hostChildNode.getHostName());
        super.setShortDescription(Bundle.HINT_HostNode());
        super.setIconBaseWithExtension(hostChildNode.getIcon());

        hostAction = new RemoveHostAction();
    }

    public HostNode() {
        super(Children.create(new HostNodeChildFactory(new Host()), true));
        super.setName("Git Repositories");
        super.setShortDescription("See all repositories of a host account (Github, BitBucket)");
        super.setIconBaseWithExtension("org/chrisle/netbeans/modules/gitrepoviewer/resources/world.png");

        hostAction = new AddHostAction();
    }

    @Override
    public Action[] getActions(boolean context) {
        Action[] result = new Action[] {
            hostAction
        };
        return result;
    }
}