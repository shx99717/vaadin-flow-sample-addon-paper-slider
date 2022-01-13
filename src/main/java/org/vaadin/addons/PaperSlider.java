package org.vaadin.addons;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.PropertyDescriptor;
import com.vaadin.flow.component.PropertyDescriptors;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

//This defines the name of the HTML element to be presented on the page
//This must be matched with the predefined name from the web-component
@Tag("paper-slider")
//Annotation for defining a NPM package dependency on a Component class which includes one or more JS modules. The JS Modules can be defined using JsModule annotation on the same Component. For adding multiple NPM packages files for a single component, you can use this annotation multiple times. 
//Declared NPM packages will be bundled by flow-maven-plugin in a package.json file, making sure that only one dependency is created.
@NpmPackage(value = "@polymer/paper-slider", version = "3.0.1")
//Annotation for defining JavaScript Module dependencies on a Component class. For adding multiple JavaScript Module files for a single component,you can use this annotation multiple times. 
//The JavaScript module files should be located: 
//• inside frontend directory in your root project folder in case of WAR project 
//• inside META-INF/resources/frontend directory (inside a project resources folder) in case of JAR project (if you are using Maven this is src/main/resources/META-INF/resources/frontend directory). 
//It is guaranteed that dependencies will be loaded only once. The files loaded will be in the same order as the annotations were on the class. However,loading order is only guaranteed on a class level; Annotations from different classes may appear in different order, grouped by the annotated class. Also,files identified by @JsModule will be loaded before com.vaadin.flow.component.dependency.JavaScript and com.vaadin.flow.component.dependency.CssImport. 
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
 * @CssImport(value = "./cool-paper-slider.css", themeFor = "paper-slider") The
 *                  CssImport here does not work for paper-slider, because the
 *                  paper-slider is not written in a way support Vaadin Flow's
 *                  proprietary solution ThemableMixin.
 */
@CssImport("./my-module.css")
public class PaperSlider extends Component {

	// The old-fashion way
	// private static final String PROPERTY_PIN = "pin"; // boolean
	// The new fashion way
	private static final PropertyDescriptor<Boolean, Boolean> pinProperty = PropertyDescriptors
			.propertyWithDefault("pin", false);

//	private static final String PROPERTY_VALUE = "value"; // int
	private static final PropertyDescriptor<Integer, Integer> valueProperty = PropertyDescriptors
			.propertyWithDefault("value", 0);

//	private static final String PROPERTY_MAX = "max"; // int
	private static final PropertyDescriptor<String, String> maxAttribute = PropertyDescriptors
			.attributeWithDefault("max", "100");

//	private static final String PROPERTY_EDITABLE = "editable"; // boolean
	private static final PropertyDescriptor<Boolean, Boolean> editableProperty = PropertyDescriptors
			.propertyWithDefault("editable", false);

//	private static final String PROPERTY_MAX_MARKERS = "max-markers"; // int
	private static final PropertyDescriptor<Integer, Integer> maxMarkersProperty = PropertyDescriptors
			.propertyWithDefault("max-markers", 0);

//	private static final String PROPERTY_STEP = "step"; // int
	private static final PropertyDescriptor<Integer, Integer> stepProperty = PropertyDescriptors
			.propertyWithDefault("step", 0);

//	private static final String PROPERTY_SNAPS = "snaps"; // boolean
	private static final PropertyDescriptor<Boolean, Boolean> snapsProperty = PropertyDescriptors
			.propertyWithDefault("snaps", false);

//	private static final String PROPERTY_SECONDARY_PROGRESS = "secondary-progress"; // int
	private static final PropertyDescriptor<String, String> secondaryProgressAttribute = PropertyDescriptors
			.attributeWithDefault("secondary-progress", "0");

//	private static final String PROPERTY_DISABLED = "disabled"; // boolean
	private static final PropertyDescriptor<Boolean, Boolean> disabledProperty = PropertyDescriptors
			.propertyWithDefault("disabled", false);

	// check https://www.webcomponents.org/element/@polymer/paper-slider
	// the demo there introduces properties/attributes of the paper-slider element
	public PaperSlider() {

	}

	public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
		return addListener(ClickEvent.class, listener);
	}

	/**
	 * Calling Element Functions In addition to properties and events, many elements
	 * offer methods that can be invoked for different reasons. To call a function
	 * on an element, you can use the callJsFunction method in Element as a way of
	 * providing an API.
	 */
	public void increment() {
		getElement().callJsFunction("increment");
	}

	public void setPin(boolean pin) {
		// The old-fashion way
		// getElement().setProperty(PROPERTY_PIN, pin);

		// The new fashion way
		set(pinProperty, pin);
	}

	public boolean isPin() {
		// The old-fashion way
		// return getElement().getProperty(PROPERTY_PIN, false);

		// The new fashion way
		return get(pinProperty);
	}

	public void setValue(int value) {
//		getElement().setAttribute(PROPERTY_VALUE, Integer.toString(value));
		set(valueProperty, value);
	}

	public int getValue() {
//		return Integer.parseInt(getElement().getProperty(PROPERTY_VALUE));
		return get(valueProperty);
	}

	public void setMax(int max) {
//		getElement().setAttribute(PROPERTY_MAX, Integer.toString(max));
		set(maxAttribute, Integer.toString(max));
	}

	public int getMax() {
//		return Integer.parseInt(getElement().getProperty(PROPERTY_MAX));
		return Integer.parseInt(get(maxAttribute));
	}

	public void setEditable(boolean editable) {
//	    getElement().setAttribute(PROPERTY_EDITABLE, editable);
		set(editableProperty, editable);
	}

	public boolean isEditable() {
//	    return getElement().getProperty(PROPERTY_EDITABLE, false);
		return get(editableProperty);
	}

	public void setMaxMarkers(int maxMarkers) {
//		getElement().setAttribute(PROPERTY_MAX_MARKERS, Integer.toString(maxMarkers));
		set(maxMarkersProperty, maxMarkers);
	}

	public int getMaxMarkers() {
//		return Integer.parseInt(getElement().getProperty(PROPERTY_MAX_MARKERS));
		return get(maxMarkersProperty);
	}

	public void setStep(int step) {
//		getElement().setAttribute(PROPERTY_STEP, Integer.toString(step));
		set(stepProperty, step);
	}

	public int getStep() {
//		return Integer.parseInt(getElement().getProperty(PROPERTY_STEP));
		return get(stepProperty);
	}

	public void setSnaps(boolean snaps) {
//	    getElement().setAttribute(PROPERTY_SNAPS, snaps);
		set(snapsProperty, snaps);
	}

	public boolean isSnaps() {
//	    return getElement().getProperty(PROPERTY_SNAPS, false);
		return get(snapsProperty);
	}

	public void setSecondaryProgress(int secondaryProgress) {
//		getElement().setAttribute(PROPERTY_SECONDARY_PROGRESS, Integer.toString(secondaryProgress));
		set(secondaryProgressAttribute, Integer.toString(secondaryProgress));
	}

	public int getSecondaryProgress() {
//		return Integer.parseInt(getElement().getProperty(PROPERTY_SECONDARY_PROGRESS));
		return Integer.parseInt(get(secondaryProgressAttribute));
	}

	public void setDisabled(boolean disabled) {
//	    getElement().setAttribute(PROPERTY_DISABLED, disabled);
		set(disabledProperty, disabled);
	}

	public boolean isDisabled() {
//	    return getElement().getProperty(PROPERTY_DISABLED, false);
		return get(disabledProperty);
	}
	
	
	/**
	 * Maps a DOM event to a ComponentEvent. Marking a ComponentEvent class
	 * with @DomEvent will cause the ComponentEvent to be fired whenever the DOM
	 * event occurs.
	 * 
	 * ClickEvent uses the @DomEvent annotation to define the name of the DOM event
	 * to listen for (click in this case).
	 */
	@DomEvent("click")
	public static class ClickEvent extends ComponentEvent<PaperSlider> {

		// click coordinates from the browser.
		private int x, y;

		// The expression inside each @EventData annotation is evaluated when the event
		// is handled in the browser: It accesses DOM event properties using the event.
		// prefix (for example event.offsetX) and element properties using the element.
		// prefix.
		public ClickEvent(PaperSlider source, boolean fromClient, @EventData("event.offsetX") int x,
				@EventData("event.offsetY") int y) {
			super(source, fromClient);
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

	}
}
