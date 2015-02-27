package org.chrisle.gitrepoviewer.hosts;

import java.util.List;
import org.eclipse.egit.github.core.Repository;

/**
 *
 * @author chrl
 */
public interface IHost {
    public List<Repository> getRepositories();
    public List<String> getBranches();
    public List<String> getTags();
    public Boolean isPrivate();
    public String getHostName();
    public String getHostIcon();
}