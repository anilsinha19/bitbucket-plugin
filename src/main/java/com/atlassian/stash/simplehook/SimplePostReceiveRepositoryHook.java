package com.atlassian.stash.simplehook;

import com.atlassian.stash.hook.repository.AsyncPostReceiveRepositoryHook;
import com.atlassian.stash.hook.repository.RepositoryHookContext;
import com.atlassian.stash.repository.RefChange;

import java.util.Collection;

/**
 *
 */
public class SimplePostReceiveRepositoryHook implements AsyncPostReceiveRepositoryHook
{
    private final SimpleService simpleService;

    public SimplePostReceiveRepositoryHook(SimpleService simpleService)
    {
        this.simpleService = simpleService;
    }

    @Override
    public void postReceive(RepositoryHookContext context, Collection<RefChange> refChanges)
    {
        for (RefChange refChange : refChanges)
        {
            System.out.println(String.format("%s %s -> %s",
                    refChange.getRefId(),
                    refChange.getFromHash().substring(0, 7),
                    refChange.getToHash().substring(0, 7)));
        }

        simpleService.doStuff();
    }
}
