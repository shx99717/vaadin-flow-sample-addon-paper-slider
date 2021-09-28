package org.vaadin.addons.demo;

import org.vaadin.addons.PaperSlider;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * Visit at http://localhost:8080/demo
 */
@Route("demo")
public class Demo extends VerticalLayout {

    public Demo() {
    	Label label1 = new Label("Plain with global scope css");
        PaperSlider paperSlider1 = new PaperSlider();
        paperSlider1.getElement().getClassList().add("special-border");
        add(label1, paperSlider1);
        
        Label label2 = new Label("with secondary progress");
        PaperSlider paperSlider2 = new PaperSlider();
        paperSlider2.setValue(30);
        paperSlider2.setSecondaryProgress(85);
        add(label2, paperSlider2); 
        
        
        Label label3 = new Label("disabled");
        PaperSlider paperSlider3 = new PaperSlider();
        paperSlider3.setValue(33);
        paperSlider3.setDisabled(true);
        add(label3, paperSlider3); 
        
        Label label4 = new Label("Red");
        PaperSlider paperSlider4 = new PaperSlider();
        paperSlider4.getElement().getClassList().add("red");
        paperSlider4.setValue(23);
        paperSlider4.setMax(255);
        paperSlider4.setEditable(true);
        add(label4, paperSlider4); 
        
        Label label5 = new Label("pin snaps max max-markers step");
        PaperSlider paperSlider5 = new PaperSlider();
        paperSlider5.getElement().getClassList().add("green");
        paperSlider5.setPin(true);
        paperSlider5.setSnaps(true);
        paperSlider5.setMax(10);
        paperSlider5.setMaxMarkers(10);
        paperSlider5.setStep(1);
        paperSlider5.setValue(3);
        paperSlider5.setEditable(true);
        add(label5, paperSlider5); 
        
        
        Label label6 = new Label("Map client side click event to serve side");
        PaperSlider paperSlider6 = new PaperSlider();
        paperSlider6.addClickListener(e -> {
        	Notification.show("Clicked at " + e.getX() + "," + e.getY(), 1000, Position.BOTTOM_START);
        });
        add(label6, paperSlider6);
        Button incrementJSButton = new Button("Increment using JS", e -> {
        	paperSlider6.increment();
        });
        add(incrementJSButton);
        
        
    }
}
