# Paper Slider

Vaadin 14 Java integration of @polymer/paper-slider

## How to quickly start development of a Vaadin Flow Add-On
While you can start from scratch and do it all manually, the easiest way is to use the [Vaadin Add-on Starter](https://vaadin.com/start/lts/component). This gives you:
- A project with all the necessary dependencies.
- An npm import for the selected component.
- A stub component Java class for your Web Component integration.
- A Maven profile that handles everything necessary to deploy the component to Vaadin Directory.



## Development instructions

JavaScript modules can either be published as an NPM package or be kept as local 
files in your project. The local JavaScript modules should be put in 
`src/main/resources/META-INF/frontend` so that they are automatically found and 
used in the using application.

If the modules are published then the package should be noted in the component 
using the `@NpmPackage` annotation in addition to using `@JsModule` annotation.


Starting the test/demo server:
1. Run `mvn jetty:run`.
2. Open http://localhost:8080 in the browser.  

(Run the demo in production mode `mvn jetty:run -Pproduction`)

## Publishing to Vaadin Directory

You can create the zip package needed for [Vaadin Directory](https://vaadin.com/directory/) using

```
mvn versions:set -DnewVersion=1.0.0 # You cannot publish snapshot versions 
mvn install -Pdirectory
```

The package is created as `target/paper-slider-1.0.0.zip`  
Upload the resulting zip from target folder to Vaadin Directory from the website [Vaadin Directory](https://vaadin.com/directory)

For more information or to upload the package, visit https://vaadin.com/directory/my-components?uploadNewComponent



## Run Integration Test
```
mvn verify -Pit
```

The goal `verify` will both execute `unit-test`(by surefire plugin) and `integration-test`(by failsafe plugin)
The goal `test` will only execute `unit-test`(by surefire plugin)

The order of basic phases is:
- Validate
- Compile
- Test
- Package
- Verify
- Install
- Deploy


