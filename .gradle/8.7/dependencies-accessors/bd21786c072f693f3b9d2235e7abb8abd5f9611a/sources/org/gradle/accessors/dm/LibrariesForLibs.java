package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final JavaxLibraryAccessors laccForJavaxLibraryAccessors = new JavaxLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>com</b>
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Group of libraries at <b>javax</b>
     */
    public JavaxLibraryAccessors getJavax() {
        return laccForJavaxLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComOpencsvLibraryAccessors laccForComOpencsvLibraryAccessors = new ComOpencsvLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.opencsv</b>
         */
        public ComOpencsvLibraryAccessors getOpencsv() {
            return laccForComOpencsvLibraryAccessors;
        }

    }

    public static class ComOpencsvLibraryAccessors extends SubDependencyFactory {

        public ComOpencsvLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>opencsv</b> with <b>com.opencsv:opencsv</b> coordinates and
         * with version reference <b>com.opencsv.opencsv</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOpencsv() {
            return create("com.opencsv.opencsv");
        }

    }

    public static class JavaxLibraryAccessors extends SubDependencyFactory {
        private final JavaxInterceptorLibraryAccessors laccForJavaxInterceptorLibraryAccessors = new JavaxInterceptorLibraryAccessors(owner);

        public JavaxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>javax.interceptor</b>
         */
        public JavaxInterceptorLibraryAccessors getInterceptor() {
            return laccForJavaxInterceptorLibraryAccessors;
        }

    }

    public static class JavaxInterceptorLibraryAccessors extends SubDependencyFactory {
        private final JavaxInterceptorJavaxLibraryAccessors laccForJavaxInterceptorJavaxLibraryAccessors = new JavaxInterceptorJavaxLibraryAccessors(owner);

        public JavaxInterceptorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>javax.interceptor.javax</b>
         */
        public JavaxInterceptorJavaxLibraryAccessors getJavax() {
            return laccForJavaxInterceptorJavaxLibraryAccessors;
        }

    }

    public static class JavaxInterceptorJavaxLibraryAccessors extends SubDependencyFactory {
        private final JavaxInterceptorJavaxInterceptorLibraryAccessors laccForJavaxInterceptorJavaxInterceptorLibraryAccessors = new JavaxInterceptorJavaxInterceptorLibraryAccessors(owner);

        public JavaxInterceptorJavaxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>javax.interceptor.javax.interceptor</b>
         */
        public JavaxInterceptorJavaxInterceptorLibraryAccessors getInterceptor() {
            return laccForJavaxInterceptorJavaxInterceptorLibraryAccessors;
        }

    }

    public static class JavaxInterceptorJavaxInterceptorLibraryAccessors extends SubDependencyFactory {

        public JavaxInterceptorJavaxInterceptorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>javax.interceptor:javax.interceptor-api</b> coordinates and
         * with version reference <b>javax.interceptor.javax.interceptor.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("javax.interceptor.javax.interceptor.api");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgHibernateLibraryAccessors laccForOrgHibernateLibraryAccessors = new OrgHibernateLibraryAccessors(owner);
        private final OrgPostgresqlLibraryAccessors laccForOrgPostgresqlLibraryAccessors = new OrgPostgresqlLibraryAccessors(owner);
        private final OrgSpringframeworkLibraryAccessors laccForOrgSpringframeworkLibraryAccessors = new OrgSpringframeworkLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.hibernate</b>
         */
        public OrgHibernateLibraryAccessors getHibernate() {
            return laccForOrgHibernateLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.postgresql</b>
         */
        public OrgPostgresqlLibraryAccessors getPostgresql() {
            return laccForOrgPostgresqlLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework</b>
         */
        public OrgSpringframeworkLibraryAccessors getSpringframework() {
            return laccForOrgSpringframeworkLibraryAccessors;
        }

    }

    public static class OrgHibernateLibraryAccessors extends SubDependencyFactory {
        private final OrgHibernateHibernateLibraryAccessors laccForOrgHibernateHibernateLibraryAccessors = new OrgHibernateHibernateLibraryAccessors(owner);

        public OrgHibernateLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.hibernate.hibernate</b>
         */
        public OrgHibernateHibernateLibraryAccessors getHibernate() {
            return laccForOrgHibernateHibernateLibraryAccessors;
        }

    }

    public static class OrgHibernateHibernateLibraryAccessors extends SubDependencyFactory {

        public OrgHibernateHibernateLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jpamodelgen</b> with <b>org.hibernate:hibernate-jpamodelgen</b> coordinates and
         * with version reference <b>org.hibernate.hibernate.jpamodelgen</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJpamodelgen() {
            return create("org.hibernate.hibernate.jpamodelgen");
        }

    }

    public static class OrgPostgresqlLibraryAccessors extends SubDependencyFactory {

        public OrgPostgresqlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>postgresql</b> with <b>org.postgresql:postgresql</b> coordinates and
         * with version reference <b>org.postgresql.postgresql</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPostgresql() {
            return create("org.postgresql.postgresql");
        }

    }

    public static class OrgSpringframeworkLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootLibraryAccessors laccForOrgSpringframeworkBootLibraryAccessors = new OrgSpringframeworkBootLibraryAccessors(owner);
        private final OrgSpringframeworkDataLibraryAccessors laccForOrgSpringframeworkDataLibraryAccessors = new OrgSpringframeworkDataLibraryAccessors(owner);
        private final OrgSpringframeworkSpringLibraryAccessors laccForOrgSpringframeworkSpringLibraryAccessors = new OrgSpringframeworkSpringLibraryAccessors(owner);

        public OrgSpringframeworkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot</b>
         */
        public OrgSpringframeworkBootLibraryAccessors getBoot() {
            return laccForOrgSpringframeworkBootLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.data</b>
         */
        public OrgSpringframeworkDataLibraryAccessors getData() {
            return laccForOrgSpringframeworkDataLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.spring</b>
         */
        public OrgSpringframeworkSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringLibraryAccessors laccForOrgSpringframeworkBootSpringLibraryAccessors = new OrgSpringframeworkBootSpringLibraryAccessors(owner);

        public OrgSpringframeworkBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring</b>
         */
        public OrgSpringframeworkBootSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkBootSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootLibraryAccessors laccForOrgSpringframeworkBootSpringBootLibraryAccessors = new OrgSpringframeworkBootSpringBootLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot</b>
         */
        public OrgSpringframeworkBootSpringBootLibraryAccessors getBoot() {
            return laccForOrgSpringframeworkBootSpringBootLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter</b>
         */
        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors getStarter() {
            return laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>starter</b> with <b>org.springframework.boot:spring-boot-starter</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("org.springframework.boot.spring.boot.starter");
        }

        /**
         * Dependency provider for <b>test</b> with <b>org.springframework.boot:spring-boot-starter-test</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.test</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTest() {
            return create("org.springframework.boot.spring.boot.starter.test");
        }

        /**
         * Dependency provider for <b>thymeleaf</b> with <b>org.springframework.boot:spring-boot-starter-thymeleaf</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.thymeleaf</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getThymeleaf() {
            return create("org.springframework.boot.spring.boot.starter.thymeleaf");
        }

        /**
         * Dependency provider for <b>web</b> with <b>org.springframework.boot:spring-boot-starter-web</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.web</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWeb() {
            return create("org.springframework.boot.spring.boot.starter.web");
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter.data</b>
         */
        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors getData() {
            return laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jpa</b> with <b>org.springframework.boot:spring-boot-starter-data-jpa</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.data.jpa</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJpa() {
            return create("org.springframework.boot.spring.boot.starter.data.jpa");
        }

        /**
         * Dependency provider for <b>rest</b> with <b>org.springframework.boot:spring-boot-starter-data-rest</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.data.rest</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRest() {
            return create("org.springframework.boot.spring.boot.starter.data.rest");
        }

    }

    public static class OrgSpringframeworkDataLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkDataSpringLibraryAccessors laccForOrgSpringframeworkDataSpringLibraryAccessors = new OrgSpringframeworkDataSpringLibraryAccessors(owner);

        public OrgSpringframeworkDataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.data.spring</b>
         */
        public OrgSpringframeworkDataSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkDataSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkDataSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkDataSpringDataLibraryAccessors laccForOrgSpringframeworkDataSpringDataLibraryAccessors = new OrgSpringframeworkDataSpringDataLibraryAccessors(owner);

        public OrgSpringframeworkDataSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.data.spring.data</b>
         */
        public OrgSpringframeworkDataSpringDataLibraryAccessors getData() {
            return laccForOrgSpringframeworkDataSpringDataLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkDataSpringDataLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkDataSpringDataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jpa</b> with <b>org.springframework.data:spring-data-jpa</b> coordinates and
         * with version reference <b>org.springframework.data.spring.data.jpa</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJpa() {
            return create("org.springframework.data.spring.data.jpa");
        }

    }

    public static class OrgSpringframeworkSpringLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>orm</b> with <b>org.springframework:spring-orm</b> coordinates and
         * with version reference <b>org.springframework.spring.orm</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOrm() {
            return create("org.springframework.spring.orm");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final JavaxVersionAccessors vaccForJavaxVersionAccessors = new JavaxVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com</b>
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.javax</b>
         */
        public JavaxVersionAccessors getJavax() {
            return vaccForJavaxVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org</b>
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComOpencsvVersionAccessors vaccForComOpencsvVersionAccessors = new ComOpencsvVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.opencsv</b>
         */
        public ComOpencsvVersionAccessors getOpencsv() {
            return vaccForComOpencsvVersionAccessors;
        }

    }

    public static class ComOpencsvVersionAccessors extends VersionFactory  {

        public ComOpencsvVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.opencsv.opencsv</b> with value <b>5.7.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getOpencsv() { return getVersion("com.opencsv.opencsv"); }

    }

    public static class JavaxVersionAccessors extends VersionFactory  {

        private final JavaxInterceptorVersionAccessors vaccForJavaxInterceptorVersionAccessors = new JavaxInterceptorVersionAccessors(providers, config);
        public JavaxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.javax.interceptor</b>
         */
        public JavaxInterceptorVersionAccessors getInterceptor() {
            return vaccForJavaxInterceptorVersionAccessors;
        }

    }

    public static class JavaxInterceptorVersionAccessors extends VersionFactory  {

        private final JavaxInterceptorJavaxVersionAccessors vaccForJavaxInterceptorJavaxVersionAccessors = new JavaxInterceptorJavaxVersionAccessors(providers, config);
        public JavaxInterceptorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.javax.interceptor.javax</b>
         */
        public JavaxInterceptorJavaxVersionAccessors getJavax() {
            return vaccForJavaxInterceptorJavaxVersionAccessors;
        }

    }

    public static class JavaxInterceptorJavaxVersionAccessors extends VersionFactory  {

        private final JavaxInterceptorJavaxInterceptorVersionAccessors vaccForJavaxInterceptorJavaxInterceptorVersionAccessors = new JavaxInterceptorJavaxInterceptorVersionAccessors(providers, config);
        public JavaxInterceptorJavaxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.javax.interceptor.javax.interceptor</b>
         */
        public JavaxInterceptorJavaxInterceptorVersionAccessors getInterceptor() {
            return vaccForJavaxInterceptorJavaxInterceptorVersionAccessors;
        }

    }

    public static class JavaxInterceptorJavaxInterceptorVersionAccessors extends VersionFactory  {

        public JavaxInterceptorJavaxInterceptorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>javax.interceptor.javax.interceptor.api</b> with value <b>1.2.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("javax.interceptor.javax.interceptor.api"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgHibernateVersionAccessors vaccForOrgHibernateVersionAccessors = new OrgHibernateVersionAccessors(providers, config);
        private final OrgPostgresqlVersionAccessors vaccForOrgPostgresqlVersionAccessors = new OrgPostgresqlVersionAccessors(providers, config);
        private final OrgSpringframeworkVersionAccessors vaccForOrgSpringframeworkVersionAccessors = new OrgSpringframeworkVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.hibernate</b>
         */
        public OrgHibernateVersionAccessors getHibernate() {
            return vaccForOrgHibernateVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.postgresql</b>
         */
        public OrgPostgresqlVersionAccessors getPostgresql() {
            return vaccForOrgPostgresqlVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework</b>
         */
        public OrgSpringframeworkVersionAccessors getSpringframework() {
            return vaccForOrgSpringframeworkVersionAccessors;
        }

    }

    public static class OrgHibernateVersionAccessors extends VersionFactory  {

        private final OrgHibernateHibernateVersionAccessors vaccForOrgHibernateHibernateVersionAccessors = new OrgHibernateHibernateVersionAccessors(providers, config);
        public OrgHibernateVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.hibernate.hibernate</b>
         */
        public OrgHibernateHibernateVersionAccessors getHibernate() {
            return vaccForOrgHibernateHibernateVersionAccessors;
        }

    }

    public static class OrgHibernateHibernateVersionAccessors extends VersionFactory  {

        public OrgHibernateHibernateVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.hibernate.hibernate.jpamodelgen</b> with value <b>5.3.7.Final</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJpamodelgen() { return getVersion("org.hibernate.hibernate.jpamodelgen"); }

    }

    public static class OrgPostgresqlVersionAccessors extends VersionFactory  {

        public OrgPostgresqlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.postgresql.postgresql</b> with value <b>42.3.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPostgresql() { return getVersion("org.postgresql.postgresql"); }

    }

    public static class OrgSpringframeworkVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootVersionAccessors vaccForOrgSpringframeworkBootVersionAccessors = new OrgSpringframeworkBootVersionAccessors(providers, config);
        private final OrgSpringframeworkDataVersionAccessors vaccForOrgSpringframeworkDataVersionAccessors = new OrgSpringframeworkDataVersionAccessors(providers, config);
        private final OrgSpringframeworkSpringVersionAccessors vaccForOrgSpringframeworkSpringVersionAccessors = new OrgSpringframeworkSpringVersionAccessors(providers, config);
        public OrgSpringframeworkVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.boot</b>
         */
        public OrgSpringframeworkBootVersionAccessors getBoot() {
            return vaccForOrgSpringframeworkBootVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework.data</b>
         */
        public OrgSpringframeworkDataVersionAccessors getData() {
            return vaccForOrgSpringframeworkDataVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework.spring</b>
         */
        public OrgSpringframeworkSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringVersionAccessors vaccForOrgSpringframeworkBootSpringVersionAccessors = new OrgSpringframeworkBootSpringVersionAccessors(providers, config);
        public OrgSpringframeworkBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring</b>
         */
        public OrgSpringframeworkBootSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkBootSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootVersionAccessors vaccForOrgSpringframeworkBootSpringBootVersionAccessors = new OrgSpringframeworkBootSpringBootVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot</b>
         */
        public OrgSpringframeworkBootSpringBootVersionAccessors getBoot() {
            return vaccForOrgSpringframeworkBootSpringBootVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootStarterVersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterVersionAccessors = new OrgSpringframeworkBootSpringBootStarterVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot.starter</b>
         */
        public OrgSpringframeworkBootSpringBootStarterVersionAccessors getStarter() {
            return vaccForOrgSpringframeworkBootSpringBootStarterVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        private final OrgSpringframeworkBootSpringBootStarterDataVersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterDataVersionAccessors = new OrgSpringframeworkBootSpringBootStarterDataVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringBootStarterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter</b> with value <b>2.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("org.springframework.boot.spring.boot.starter"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.test</b> with value <b>2.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTest() { return getVersion("org.springframework.boot.spring.boot.starter.test"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.thymeleaf</b> with value <b>2.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getThymeleaf() { return getVersion("org.springframework.boot.spring.boot.starter.thymeleaf"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.web</b> with value <b>2.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getWeb() { return getVersion("org.springframework.boot.spring.boot.starter.web"); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot.starter.data</b>
         */
        public OrgSpringframeworkBootSpringBootStarterDataVersionAccessors getData() {
            return vaccForOrgSpringframeworkBootSpringBootStarterDataVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterDataVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkBootSpringBootStarterDataVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.data.jpa</b> with value <b>2.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJpa() { return getVersion("org.springframework.boot.spring.boot.starter.data.jpa"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.data.rest</b> with value <b>2.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRest() { return getVersion("org.springframework.boot.spring.boot.starter.data.rest"); }

    }

    public static class OrgSpringframeworkDataVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkDataSpringVersionAccessors vaccForOrgSpringframeworkDataSpringVersionAccessors = new OrgSpringframeworkDataSpringVersionAccessors(providers, config);
        public OrgSpringframeworkDataVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.data.spring</b>
         */
        public OrgSpringframeworkDataSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkDataSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkDataSpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkDataSpringDataVersionAccessors vaccForOrgSpringframeworkDataSpringDataVersionAccessors = new OrgSpringframeworkDataSpringDataVersionAccessors(providers, config);
        public OrgSpringframeworkDataSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.data.spring.data</b>
         */
        public OrgSpringframeworkDataSpringDataVersionAccessors getData() {
            return vaccForOrgSpringframeworkDataSpringDataVersionAccessors;
        }

    }

    public static class OrgSpringframeworkDataSpringDataVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkDataSpringDataVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.data.spring.data.jpa</b> with value <b>2.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJpa() { return getVersion("org.springframework.data.spring.data.jpa"); }

    }

    public static class OrgSpringframeworkSpringVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.spring.orm</b> with value <b>5.3.20</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getOrm() { return getVersion("org.springframework.spring.orm"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
