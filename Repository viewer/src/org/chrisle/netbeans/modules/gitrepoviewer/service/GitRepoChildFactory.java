package org.chrisle.netbeans.modules.gitrepoviewer.service;

/**
 *
 * @author chrl
 */
import java.awt.Event;
import org.chrisle.netbeans.modules.gitrepoviewer.hosts.HostBase;
import java.util.Arrays;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.chrisle.netbeans.modules.gitrepoviewer.hosts.Github;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.lookup.Lookups;

public class GitRepoChildFactory extends ChildFactory<HostBase> {

    private ChangeListener listener;

    protected void addNotify() {
        HostNotifier.addChangeListener(listener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ev) {
                refresh(true);
            }
        });
    }

    protected void removeNotify() {
        if (listener != null) {
            HostNotifier.removeChangeListener(listener);
            listener = null;
        }
    }

    @Override
    protected boolean createKeys(List<HostBase> hosts) {
        HostBase[] objs = new HostBase[5];
        for (int i = 0; i < objs.length; i++) {
            objs[i] = new Github("Github");
        }

        hosts.addAll(Arrays.asList(objs));

        return true;
    }

    protected Node createNodeForKey(Event key) {
        Node result = new AbstractNode(
        Children.create(new GitRepoChildFactory(), true), 
        Lookups.singleton(key));
        result.setDisplayName(key.toString());

        return result;
    }
}