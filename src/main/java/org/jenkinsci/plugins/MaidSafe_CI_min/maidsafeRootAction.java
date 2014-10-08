package org.jenkinsci.plugins.MaidSafe_CI_min;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.UnprotectedRootAction;
import hudson.security.ACL;
import jenkins.model.Jenkins;
import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContextHolder;
import org.kohsuke.github.GHEventPayload;
import org.kohsuke.github.GHRepository;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Benjamin Bollen on 07/10/14.
 * Copyright by MaidSafe ltd
 */


@Extension
public class maidsafeRootAction implements UnprotectedRootAction {

    static final String URL = "maidsafehook"; // configure webhook for pull requests
    private static final Logger logger = Logger.getLogger(maidsafeRootAction.class.getName());
    private static maidsafeGitHub msgh;

    public String getIconFileName() {
        return null;
    }

    public String getDisplayName() {
        return null;
    }

    public String getUrlName() {
        return URL;
    }

    public void doIndex(StaplerRequest req, StaplerResponse resp) {
        String event = req.getHeader("X-GitHub-Event");
        String payload = req.getParameter("payload"); // setup GitHub webhook
        if (payload == null) {
            logger.log(Level.SEVERE, "Request does not contain a payload.");
            return;
        }

        if (msgh  == null) {
            msgh = new maidsafeGitHub();
        }

        logger.log(Level.INFO, "Received payload event: {0}", event);
        try {
            if ("pull_request".equals(event)) {
                GHEventPayload.PullRequest pr = msgh.get().parseEventPayLoad(new StringReader(payload), GHEventPayload.PullRequest.class);
                
            }
        }
    }



}
