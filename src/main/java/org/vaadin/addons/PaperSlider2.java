package org.vaadin.addons;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.PropertyDescriptor;
import com.vaadin.flow.component.PropertyDescriptors;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

/**
 * The paper-slider component allows the user to input a single value. To make
 * it work automatically as a field, this kind of component should implement the
 * HasValue interface.
 * 
 * We need the value to be synchronized automatically from the client to the
 * server when the user changes it, as well as from the server to the client
 * when it is updated programmatically. In addition, a value-change event should
 * be fired on the server whenever the value changes.
 * 
 * In the common use case in which the getValue() method is based on a
 * single-element property, the AbstractSinglePropertyField base class takes
 * care of everything related to the value.
 */
@Tag("paper-slider")
@JsModule("@polymer/paper-slider/paper-slider.js")
@NpmPackage(value = "@polymer/paper-slider", version = "3.0.1")
public class PaperSlider2 extends AbstractSinglePropertyField<PaperSlider2, Integer> {
	private static final PropertyDescriptor<Boolean, Boolean> pinProperty = PropertyDescriptors
			.propertyWithDefault("pin", false);

	public PaperSlider2() {
		// The constructor parameters define the name of the element property that
		// contains the value ("value"), the default value to use if the property isn’t
		// set (0), and whether setValue(null) should be allowed or throw an exception
		// (false means that null is not allowed).
		super("value", 0, false);
	}

	public void setPin(boolean pin) {
		set(pinProperty, pin);
	}

	public boolean isPin() {
		return get(pinProperty);
	}
}
