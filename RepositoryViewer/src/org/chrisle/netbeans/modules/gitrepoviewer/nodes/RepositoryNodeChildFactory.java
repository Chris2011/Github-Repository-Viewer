package org.chrisle.netbeans.modules.gitrepoviewer.nodes;

import java.util.Arrays;
import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;

/**
 *
 * @author chrl
 */
public class RepositoryNodeChildFactory extends ChildFactory<IRepository> {
    private final IRepository _repo;

    public RepositoryNodeChildFactory(IRepository repo) {
        this._repo = repo;
    }

    @Override
    protected boolean createKeys(List<IRepository> repos) {
        // TODO: Length of saved repositories.
        IRepository[] objs = new Repository[5];

        for (int i = 0; i < objs.length; i++) {
            // TODO: Saved repositoryList.
            IRepository repo = new Repository();

            repo.setName("TestRepo");
//            repo.setIcon("org/chrisle/netbeans/modules/gitrepoviewer/resources/repo.png");

            objs[i] = repo;
        }

        repos.addAll(Arrays.asList(objs));

        return true;
    }

    @Override
    protected Node createNodeForKey(IRepository key) {
        return new RepositoryNode(key);
    }
}
