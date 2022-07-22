package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports.html"}
        ,features = "classpath:feature/test"
        ,glue= {"steps", "hook", "mapper"}
        ,tags = "@End2End"
        ,snippets = CucumberOptions.SnippetType.CAMELCASE
        ,monochrome = true
)
public class RunnerTest { }