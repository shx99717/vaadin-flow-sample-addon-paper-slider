package org.vaadin.addons.demo;

import org.vaadin.addons.PaperSlider2;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * Visit at http://localhost:8080/demo2
 */
@Route("demo2")
public class Demo2 extends VerticalLayout {

	public Demo2() {
		PaperSlider2 paperSlider = new PaperSlider2();
		paperSlider.setPin(true);
		paperSlider.addValueChangeListener(e -> {
			String message = "The value is now " + e.getValue();
			if (e.isFromClient()) {
				message += " (set by the user)";
			}
			Notification.show(message, 3000, Position.MIDDLE);
		});
		add(paperSlider);

		Button incrementButton = new Button("Increment using setValue", e -> {
			paperSlider.setValue(paperSlider.getValue() + 5);
		});
		add(incrementButton);
	}
}
