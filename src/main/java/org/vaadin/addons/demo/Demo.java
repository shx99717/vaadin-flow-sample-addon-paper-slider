package org.vaadin.addons.demo;

import org.vaadin.addons.PaperSlider;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

/**
 * Visit at http://localhost:8080/demo
 */
@Route("demo")
public class Demo extends Div {

    public Demo() {
        PaperSlider paperSlider = new PaperSlider();
        add(paperSlider);
    }
}
