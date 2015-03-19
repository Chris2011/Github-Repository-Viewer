package org.chrisle.netbeans.modules.gitrepoviewer.service;

import org.openide.awt.ActionID;
import javax.swing.Action;
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
public class GitRepoNode extends AbstractNode {
    public GitRepoNode(Children children) {
        super(Children.create(new GitRepoChildFactory(), true), Lookups.singleton(children));
        setDisplayName("test");
    }

    public GitRepoNode() {
        super(Children.create(new GitRepoChildFactory(), true));
//        setDisplayName(Bundle.LBL_AllPropsNode());
//        setShortDescription(Bundle.HINT_AllPropsNode());
        setDisplayName("Git Repository");
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