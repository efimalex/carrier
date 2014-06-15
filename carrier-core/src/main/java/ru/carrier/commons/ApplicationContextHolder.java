package ru.carrier.commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Collection;
import java.util.Map;

/**
 * Implementation of a Spring interface that is configured in Spring's applicationContext.xml or some
 * other Spring type of way. This class and the spring bean needed to wire it could be used as an
 * alternative to getting the ApplicationContext from the ServletContext.
 */
public class ApplicationContextHolder implements ApplicationContextAware {

	private static final Log LOG = LogFactory.getLog(ApplicationContextHolder.class);

	private static ApplicationContext applicationContext;
	
	/**
	 * Sets application context.
	 * 
	 * @param applicationContextP application context.
	 */
	public void setApplicationContext(final ApplicationContext applicationContextP) {
		applicationContext = applicationContextP;
	}

	/** 
	 * Access to spring wired beans.
	 * 
	 * @param beanName bean to get from spring context.
	 * @param <T> bean type.
	 * @return bean managed by spring. 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(final String beanName) {
		return (T) applicationContext.getBean(beanName);
	}

	/** 
	 * Access to spring wired beans.
	 * <p>
	 * <b>IMPORTANT:</b> Returns <tt>null</tt> if one or more than one instance can be identified by class. 
	 * </p>
	 * 
	 * @param clazz class to get instance of.
	 * @param <T> bean type.
	 * @return bean managed by spring. 
	 */
	@SuppressWarnings("unchecked")
	public static  <T> T getBean(final Class clazz) {
		Map beansOfType = applicationContext.getBeansOfType(clazz);
		if (beansOfType.size() != 1) {
			LOG.error("Spring configuration problem: more than one or no instances define for the " + clazz + ". Try to get bean by name instead.");
			return null;
		}
		return (T) beansOfType.values().iterator().next();
	}


    /**
	 * Access to spring wired beans.
	 * <p>
	 * <b>IMPORTANT:</b> Returns <tt>null</tt> if instances can be identified by class.
	 * </p>
	 *
	 * @param clazz class to get instances of.
	 * @return beans collection managed by spring.
	 */
	@SuppressWarnings("unchecked")
	public static  <T> Collection<T> getBeans(final Class clazz) {
		Map beansOfType = applicationContext.getBeansOfType(clazz);
        if (beansOfType.size() <= 0) {
			LOG.error("Spring configuration problem:  no instances define for the " + clazz);
			return null;
		}
		return (Collection<T>) beansOfType.values();
	}
}
