package org.chrisle.githubrepoviewer.classes;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;

/**
 *
 * @author chrl
 */
public class GithubRepo {

    private final MutableTreeNode _treeNode;
    
    public GithubRepo(MutableTreeNode treeNode) {
        _treeNode = treeNode;
    }

    public void fillTreeNodeModel() {
        
    }

    public DefaultTreeModel getRepositories() {
        return new DefaultTreeModel(_treeNode);
    }

    public void addTreeNode(MutableTreeNode host) {
    }
}