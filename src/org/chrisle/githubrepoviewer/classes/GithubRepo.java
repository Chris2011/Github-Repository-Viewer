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
        _treeNode.add(new DefaultMutableTreeNode("Repo1"));
        _treeNode.add(new DefaultMutableTreeNode("Repo2"));
        _treeNode.add(new DefaultMutableTreeNode("Repo3"));
        _treeNode.add(new DefaultMutableTreeNode("Repo4"));
    }

    public DefaultTreeModel getRepositories() {
        return new DefaultTreeModel(_treeNode);
    }
}