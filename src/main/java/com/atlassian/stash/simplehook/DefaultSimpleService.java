package com.atlassian.stash.simplehook;

import com.atlassian.stash.scm.git.GitScm;

public class DefaultSimpleService implements SimpleService
{
    private final GitScm gitScm;

    public DefaultSimpleService(GitScm gitScm) {
        this.gitScm = gitScm;
    }

    @Override
    public void doStuff() {
        System.out.println(String.format("The minimum git version is %s", gitScm.getMinimumVersion()));
    }
}
