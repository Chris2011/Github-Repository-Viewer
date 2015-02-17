package org.chrisle.githubrepoviewer.classes;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author chrl
 */
public class GithubRepo {

    private final DefaultMutableTreeNode _treeNode;
    
    public GithubRepo(DefaultMutableTreeNode treeNode) {
        _treeNode = treeNode;
    }

    public void fillTreeNodeModel() {
        
    }

    public DefaultTreeModel getRepositories() {
        return new DefaultTreeModel(_treeNode);
    }
}