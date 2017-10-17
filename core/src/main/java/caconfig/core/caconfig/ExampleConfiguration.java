package caconfig.core.caconfig;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;

@Configuration(label="Example Configuration", description="Dummy Configuration class to show how Context-Aware Configuration works in AEM")
public @interface ExampleConfiguration {

    @Property(label="Custom value", description="Some custom value for a resource that is fetched by Context-Aware Configuration")
    String customValue() default "Global value";
}