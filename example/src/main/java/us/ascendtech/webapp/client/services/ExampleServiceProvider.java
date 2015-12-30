package us.ascendtech.webapp.client.services;

import com.google.gwt.core.shared.GWT;

/**
 * Created by pmeyer on 5/13/15.
 */
public class ExampleServiceProvider {

	private static ExampleServiceProvider serviceProvider = new ExampleServiceProvider();

	public static ExampleServiceProvider get() {
		return serviceProvider;
	}

	private ExampleServiceAsync exampleService;

	private ExampleServiceProvider() {
		exampleService = GWT.create(ExampleService.class);
	}

	public ExampleServiceAsync getExampleService() {
		return exampleService;
	}

}
