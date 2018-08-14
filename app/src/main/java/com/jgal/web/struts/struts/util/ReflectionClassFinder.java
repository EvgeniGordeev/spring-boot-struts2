package com.jgal.web.struts.struts.util;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.finder.ClassFinder;
import com.opensymphony.xwork2.util.finder.ClassLoaderInterface;
import com.opensymphony.xwork2.util.finder.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.springframework.lang.Nullable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ReflectionClassFinder.
 *
 * @author evgeni.gordeev
 * @version 1.0.0
 * @since 8/9/18
 */
public class ReflectionClassFinder implements ClassFinder {

    private String[] packages;

    public ReflectionClassFinder(String... packages) {
        this.packages = packages;
    }

    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotation) {
        throw new NotImplementedException();
    }

    @Override
    public List<String> getClassesNotLoaded() {
        throw new NotImplementedException();
    }

    @Override
    public List<Package> findAnnotatedPackages(Class<? extends Annotation> annotation) {
        return null;
    }

    @Override
    public List<Class> findAnnotatedClasses(Class<? extends Annotation> annotation) {
        throw new NotImplementedException();
    }

    @Override
    public List<Method> findAnnotatedMethods(Class<? extends Annotation> annotation) {
        throw new NotImplementedException();
    }

    @Override
    public List<Constructor> findAnnotatedConstructors(Class<? extends Annotation> annotation) {
        throw new NotImplementedException();
    }

    @Override
    public List<Field> findAnnotatedFields(Class<? extends Annotation> annotation) {
        throw new NotImplementedException();
    }

    @Override
    public List<Class> findClassesInPackage(String packageName, boolean recursive) {
        throw new NotImplementedException();
    }

    /**
     * Find action classes implementing {@link Action} and ignoring {@link org.apache.struts2.convention.PackageBasedActionConfigBuilder#getActionClassTest()}
     * since our rule is more restrictive.
     *
     * @param test ignored
     * @return struts actions classes
     */
    @Override
    public List<Class> findClasses(@Nullable Test<ClassInfo> test) {
        Reflections reflections = new Reflections(
            new ConfigurationBuilder()
                .forPackages(packages)
                .filterInputsBy(new FilterBuilder().includePackage(packages).excludePackage(ActionSupport.class))
                .setScanners(new SubTypesScanner()/*.filterResultsBy(filter)*/));
        // replacing with stream api
        // filterResultsBy is non-intuitive, see https://github.com/ronmamo/reflections/issues/26
        return reflections
            .getSubTypesOf(Action.class)
            .stream()
            .filter(clazz -> !clazz.equals(ActionSupport.class))
            .collect(Collectors.toList());
    }

    @Override
    public List<Class> findClasses() {
        throw new NotImplementedException();
    }

    @Override
    public ClassLoaderInterface getClassLoaderInterface() {
        throw new NotImplementedException();
    }
}
