package org.FluffyTerror.Cucumber.TestRunner;


import org.FluffyTerror.Cucumber.Hooks.Hooks;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ConfigurationParameters;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.*;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameters({
        @ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@UI"),
        @ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/Features"),
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.FluffyTerror.Cucumber.Steps, org.FluffyTerror.Cucumber.Hooks"),
        @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm,pretty"),
})

//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/resources/Features",
//        glue = {"org.FluffyTerror.Cucumber.Steps, org.FluffyTerror.Cucumber.Hooks"},
//        tags = "@UI",
//        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm,pretty"}
//)

public class TestRunner {
    public static void tearDownAll() {
        Hooks.tearDownDriver();
    }

}
