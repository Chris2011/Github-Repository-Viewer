package org.chrisle.githubrepoviewer.hosts;

import java.util.List;

/**
 *
 * @author chrl
 */
public interface IHost {
    public List<String> getRepositories();
    public List<String> getBranches();
    public List<String> getTags();
    public Boolean isPrivate();
    public String getHostName();
    public String getHostIcon();
}