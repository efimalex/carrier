package ru.carrier.web.init.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by efim on 09.07.14.
 */
@WebFilter(value = "/*",
        initParams = {@WebInitParam(name = "encoding", value = "UTF-8"),
                @WebInitParam(name = "ignore", value = "true")})
public class CharacterEncodingFilter implements Filter {

    /**
     * Class logger
     */
    protected Logger logger = Logger.getLogger(CharacterEncodingFilter.class.getName());

    /**
     * The default character encoding to set for requests that pass through this filter.
     */
    protected String encoding = null;

    /**
     * The filter configuration object we are associated with. If this value is null, this filter instance is not currently configured.
     */
    protected FilterConfig filterConfig = null;

    /**
     * Should a character encoding specified by the client be ignored?
     */
    protected boolean ignore = true;

    // ----------------------------------------------------- Public Methods

    /**
     * Take this filter out of service.
     */
    public void destroy() {
        this.encoding = null;
        this.filterConfig = null;
    }

    /**
     * Select and set (if specified) the character encoding to be used to interpret request parameters for this request.
     *
     * @param request The servlet request we are processing
     * @param result  The servlet response we are creating
     * @param chain   The filter chain we are processing
     * @throws IOException      if an input/output error occurs
     * @throws ServletException if a servlet error occurs
     */
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {

        // Conditionally select and set the character encoding to be used
        if (ignore || (request.getCharacterEncoding() == null)) {
            String encoding = selectEncoding(request);
            if (encoding != null)
                request.setCharacterEncoding(encoding);
        }

        // Pass control on to the next filter
        chain.doFilter(request, response);
    }

    /**
     * Place this filter into service.
     *
     * @param filterConfig The filter configuration object
     */
    public void init(final FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.encoding = filterConfig.getInitParameter("encoding");
        String value = filterConfig.getInitParameter("ignore");
        if (value == null)
            this.ignore = true;
        else if (value.equalsIgnoreCase("true"))
            this.ignore = true;
        else if (value.equalsIgnoreCase("yes"))
            this.ignore = true;
        else
            this.ignore = false;
        logger.info("Charset filter initialized encoding [" + this.encoding + "]; ignoring client encoding [" + this.ignore + ":980214]");
    }

    /**
     * Select an appropriate character encoding to be used, based on the characteristics of the current request and/or filter initialization
     * parameters. If no character encoding should be set, return null. The default implementation unconditionally returns the value configured by
     * the encoding initialization parameter for this filter.
     *
     * @param request The servlet request we are processing
     */
    protected String selectEncoding(final ServletRequest request) {
        return (this.encoding);
    }
}
