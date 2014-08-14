package ru.carrier.exception;

import org.apache.commons.lang.ArrayUtils;

/**
 * Created by User on 19.03.14.
 */
public class AppException extends Exception {
    private static final long serialVersionUID = 1L;

    private String code;

    private Object[] params;

    private String resolvedMessage;

    protected AppException(final String code, final Object... params) {
        super("Codable WMSException. Code: " + code + " params: " + ArrayUtils.toString(params));

        this.code = code;
        if (params.length > 0) {
            this.params = params;
        }
    }

    public static AppException fromRuntime(final AppException runtimeException) {
        return codedException(runtimeException.getCode(), runtimeException.getParams());
    }

    public static AppException codedException(final String code, final Object... params) {
        AppException exception = new AppException("Codable WMSException. Code: " + code + " params: " + ArrayUtils.toString(params));
        exception.code = code;
        exception.params = params;
        return exception;
    }

    public AppException(final String string) {
        super(string);
    }

    public AppException(final Exception e) {
        super(e);
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
