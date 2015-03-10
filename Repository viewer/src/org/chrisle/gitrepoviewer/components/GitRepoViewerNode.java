package org.chrisle.gitrepoviewer.components;

import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import java.io.IOException;
import javax.swing.Action;
import org.netbeans.api.core.ide.ServicesTabNodeRegistration;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.actions.NewAction;
import org.openide.actions.OpenLocalExplorerAction;
import org.openide.actions.PropertiesAction;
import org.openide.actions.ToolsAction;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.SystemAction;
import org.openide.util.datatransfer.NewType;

@ActionID(
        category = "Team",
        id = "org.chrisle.gitrepoviewer.components.GitRepoViewerNode"
)
//@ActionRegistration(
//        displayName = "#CTL_GitRepoViewerNode"
//)
@ActionReference(path = "Menu/Tools", position = 805)
@Messages({
    "CTL_GitRepoViewerServiceNode=Git Repositories",
    "HINT_GitRepoViewerServiceNode=See all repositories of a host account (Github, BitBucket)"
})

@ServicesTabNodeRegistration(
        name = "GitRepoViewerNode",
        displayName = "Git Repositories",
        shortDescription = "See all repositories of a host account (Github, BitBucket)",
        iconResource = "org/chrisle/gitrepoviewer/resources/world.png",
        position = 2021)
public class GitRepoViewerNode extends AbstractNode {
    public GitRepoViewerNode() {
        super(Children.create(new GitRepoViewerChildFactory(), false));
//        setDisplayName(Bundle.LBL_AllPropsNode());
//        setShortDescription(Bundle.HINT_AllPropsNode());
        setDisplayName("Git Repository Viewer");
        setShortDescription("See all repositories of a host account (Github, BitBucket)");
        setIconBaseWithExtension("org/chrisle/gitrepoviewer/resources/world.png");
    }

    @Override
    public Action[] getActions(boolean context) {
        Action[] result = new Action[] {
            new RefreshPropsAction(),
            null,
            SystemAction.get(OpenLocalExplorerAction.class),
            null,
            SystemAction.get(NewAction.class),
            null,
            SystemAction.get(ToolsAction.class),
            SystemAction.get(PropertiesAction.class),};
        return result;
    }

    @Override
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    public Node cloneNode() {
        return new GitRepoViewerNode();
    }

    @Messages({
        "LBL_NewProp=System Property",
        "LBL_NewProp_dialog=Create New Property",
        "MSG_NewProp_dialog_key=New property name:",
        "MSG_NewProp_dialog_value=New property value:"})
    @Override
    public NewType[] getNewTypes() {
        return new NewType[]{
            new NewType() {
                @Override
                public String getName() {
                    return Bundle.LBL_NewProp();
                }

                @Override
                public void create() throws IOException {
                    NotifyDescriptor.InputLine msg = new NotifyDescriptor.InputLine(Bundle.LBL_NewProp_dialog(), Bundle.MSG_NewProp_dialog_key());
                    DialogDisplayer.getDefault().notify(msg);
                    String key = msg.getInputText();
                    if ("".equals(key)) {
                        return;
                    }
                    msg = new NotifyDescriptor.InputLine(Bundle.MSG_NewProp_dialog_value(), Bundle.MSG_NewProp_dialog_key());
                    DialogDisplayer.getDefault().notify(msg);
                    String value = msg.getInputText();
                    System.setProperty(key, value);
                    PropertiesNotifier.changed();
                }
            }
        };
    }
}