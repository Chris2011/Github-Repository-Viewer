package org.chrisle.netbeans.modules.gitrepoviewer.nodes;

import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

/**
 *
 * @author chrl
 */
public class RepositoryNode extends AbstractNode{
    public RepositoryNode(IRepository childNode) {
        super(Children.LEAF);
        super.setName(childNode.getRepositoryName());

        setShortDescription("All Repos");
    }

    public RepositoryNode() {
        super(Children.create(new RepositoryNodeChildFactory(new Repository()), true));
    }
}