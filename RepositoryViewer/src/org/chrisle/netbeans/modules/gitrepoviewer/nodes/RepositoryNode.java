package org.chrisle.netbeans.modules.gitrepoviewer.nodes;

import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

/**
 *
 * @author chrl
 */
public class RepositoryNode extends AbstractNode{
    public RepositoryNode(IRepository repoChildNode) {
        super(Children.LEAF);
        super.setName(repoChildNode.getName());
        super.setIconBaseWithExtension(repoChildNode.getIcon());

        setShortDescription("All Repos");
    }

    public RepositoryNode() {
        super(Children.create(new RepositoryNodeChildFactory(new Repository()), true));
    }
}