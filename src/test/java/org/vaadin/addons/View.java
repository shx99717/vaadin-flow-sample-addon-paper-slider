package org.vaadin.addons;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

/**
 * This view is in the src/test/java, but when running 'mvn jetty:run', we can still view it.
 * This is because the jetty-maven-plugin definition <useTestScope>true</useTestScope>
 */
@Route("")
public class View extends Div {

    public View() {
        PaperSlider paperSlider = new PaperSlider();
        add(paperSlider);
    }
}
