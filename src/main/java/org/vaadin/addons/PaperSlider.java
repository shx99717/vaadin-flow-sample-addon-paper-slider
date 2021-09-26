package org.vaadin.addons;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

//This defines the name of the HTML element to be presented on the page
@Tag("paper-slider")

//Annotation for defining JavaScript Module dependencies on a Componentclass. For adding multiple JavaScript Module files for a single component,you can use this annotation multiple times. 
//The JavaScript module files should be located: 
//• inside frontend directory in your root project folder in case ofWAR project 
//• inside META-INF/resources/frontend directory (inside a projectresources folder) in case of JAR project (if you are using Maven this is src/main/resources/META-INF/resources/frontend directory). 
//It is guaranteed that dependencies will be loaded only once. The files loadedwill be in the same order as the annotations were on the class. However,loading order is only guaranteed on a class level; Annotations from differentclasses may appear in different order, grouped by the annotated class. Also,files identified by @JsModule will be loaded before com.vaadin.flow.component.dependency.JavaScript and com.vaadin.flow.component.dependency.CssImport. 
@JsModule("@polymer/paper-slider/paper-slider.js")
// This is the extra js file being added
// this js file will be finally included in an all-in-one bundle.js/main.js after webpack, therefore even the referencing
// component in this case the PaperSlider has not been initialized on the page, this javascript will
// still be triggered, in this sense, this is global included
// If you wish to include your own JS modules in the add-on jar, add the module
// files to './src/main/resources/META-INF/resources/frontend' and insert an
// annotation @JsModule("./my-module.js") here. 
@JsModule("./my-module.js")
/**
 * @CssImport(value = "./cool-paper-slider.css", themeFor = "paper-slider")
 * The CssImport here does not work for paper-slider, because the paper-slider is not written
 * in a way support Vaadin Flow's proprietary solution ThemableMixin.
*/
//Annotation for defining an NPM package dependency on a Componentclass which includes one or more JS modules. The JS Modules can be definedusing JsModule annotation on the same Component. For addingmultiple NPM packages files for a single component, you can use thisannotation multiple times. 
//Declared NPM packages will be bundled by flow-maven-plugin in a package.jsonfile, making sure that only one dependency is created.
@NpmPackage(value = "@polymer/paper-slider", version = "3.0.1")
public class PaperSlider extends Component {

	public PaperSlider() {
	}

}
