package com.jgal.web.struts.struts.util;

import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.util.finder.ClassFinder;
import com.opensymphony.xwork2.util.finder.ClassFinderFactory;
import com.opensymphony.xwork2.util.finder.ClassLoaderInterface;
import com.opensymphony.xwork2.util.finder.Test;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.ConventionConstants;

import java.net.URL;
import java.util.Collection;
import java.util.Set;

/**
 * ReflectionClassFinderFactory.
 *
 * @author evgeni.gordeev
 * @version 8.0
 * @since 8/9/18
 */
public class ReflectionClassFinderFactory implements ClassFinderFactory {

    private String[] actionPackages;

    @Override
    public ClassFinder buildClassFinder(ClassLoaderInterface classLoaderInterface, Collection<URL> urls, boolean extractBaseInterfaces, Set<String> protocols, Test<String> classNameFilter) {
        return new ReflectionClassFinder(actionPackages);
    }

    /**
     * @param actionPackages (Optional) An optional list of action packages that this should create
     *                       configuration for.
     */
    @Inject(value = ConventionConstants.CONVENTION_ACTION_PACKAGES, required = false)
    public void setActionPackages(String actionPackages) {
        if (StringUtils.isNotBlank(actionPackages)) {
            this.actionPackages = actionPackages.split("\\s*[,]\\s*");
        } else {
            throw new IllegalArgumentException("struts.convention.action.packages is required");
        }
    }
}
