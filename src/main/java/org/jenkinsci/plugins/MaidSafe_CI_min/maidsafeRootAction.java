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

    public String getDisplayName() {
        return null;
    }

    public String getUrlName() {
        return URL;
    }
}
