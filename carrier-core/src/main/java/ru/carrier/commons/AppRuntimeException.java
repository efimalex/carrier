package ru.carrier.commons;

import org.apache.commons.lang.ArrayUtils;

/**
 * Created by User on 19.03.14.
 */
public class AppRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String code;

    private Object[] params;

    private String resolvedMessage;

    public AppRuntimeException(final String string) {
        super(string);
    }

    public AppRuntimeException(final String string, final Exception e) {
        super(string, e);
    }

    public static AppRuntimeException codedException(final String code, final Object... params) {
        AppRuntimeException exception = new AppRuntimeException("Codable RuntimeException. Code: " + code + " params: "
                + ArrayUtils.toString(params));
        exception.code = code;
        exception.params = params;
        return exception;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the params
     */
    public Object[] getParams() {
        return params;
    }

    @Override
    public String getMessage() {
        if (resolvedMessage == null) {
            return super.getMessage();
        }
        return resolvedMessage;
    }

    public void setResolvedMessage(final String resolvedMessage) {
        this.resolvedMessage = resolvedMessage;
    }
}
