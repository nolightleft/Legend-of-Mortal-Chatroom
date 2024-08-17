package com.nolightleft.chatroom;

import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 * Title: {@link ApplicationConfiguration}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry pRegistry) {
		exposeDirectory("cache", pRegistry);
	}
	
	/**
	 * Add a resource handler for a folder with same name
	 * 
	 * @param relativePath
	 * @param registry
	 */
	private void exposeDirectory(String relativePath, ResourceHandlerRegistry registry) {
		String filePath = Paths.get(relativePath).toFile().getAbsolutePath();

		if (relativePath.startsWith("../")) {
			relativePath = relativePath.replace("../", "");
		}

		registry.addResourceHandler("/" + relativePath + "/**").addResourceLocations("file:/" + filePath + "/");
	}
}
