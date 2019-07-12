package org.onetwo.boot.core;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.ResourcePropertySource;

// CompositePropertySource 
public class IncludablePropertySourceFactory extends DefaultPropertySourceFactory {
	
	@Override
	public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
		PropertySource<?> source = (name != null ? new ResourcePropertySource(name, resource) : new ResourcePropertySource(resource));
		String fileName = resource.getResource().getFilename();
		CompositePropertySource composite = new CompositePropertySource(fileName);
		composite.addPropertySource(source);
		
		String include = (String)source.getProperty("profiles.include");
		if (StringUtils.isNotBlank(include)) {
			ClassPathResource includeRes = new ClassPathResource(include);
			ResourcePropertySource includeProperty = new ResourcePropertySource(includeRes);
			composite.addFirstPropertySource(includeProperty);
		}
		return composite;
	}
}
