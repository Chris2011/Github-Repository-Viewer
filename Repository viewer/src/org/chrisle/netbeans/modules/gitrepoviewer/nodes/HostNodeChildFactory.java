package org.chrisle.netbeans.modules.gitrepoviewer.nodes;

/**
 *
 * @author Chris
 */
import java.util.Arrays;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.Host;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.IHost;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;

public class HostNodeChildFactory extends ChildFactory<IHost> {
    private ChangeListener _listener;
    private final IHost _host;

    public HostNodeChildFactory(IHost host) {
        this._host = host;
    }

    protected void addNotify() {
        HostNotifier.addChangeListener(this._listener = (ChangeEvent e) -> {
            refresh(true);
        });
    }

    protected void removeNotify() {
        if (_listener != null) {
            HostNotifier.removeChangeListener(_listener);
            _listener = null;
        }
    }

    @Override
    protected boolean createKeys(List<IHost> hosts) {
        // TODO: Length of saved hosts.
        IHost[] objs = new Host[5];
        for (int i = 0; i < objs.length; i++) {
            // TODO: Saved hosts.
            IHost host = new Host();

            host.setHostName("Bitbucket");
            host.setIcon("org/chrisle/netbeans/modules/gitrepoviewer/resources/bitbucket.png");
            objs[i] = host;
        }

        hosts.addAll(Arrays.asList(objs));

        return true;
    }

    @Override
    protected Node createNodeForKey(IHost key) {
        return new HostNode(key);

//        Node result = new AbstractNode(Children.create(new HostNodeChildFactory(_host), true), Lookups.singleton(key));
//        result.setDisplayName(key.getHostName());
//
//        return result;
    }
}