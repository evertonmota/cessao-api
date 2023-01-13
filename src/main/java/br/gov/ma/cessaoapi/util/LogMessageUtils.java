package br.gov.ma.cessaoapi.util;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LogMessageUtils {
	
	public static String formatServiceLog(final String message, final String serviceName, final String endpoint) {
		return new StringBuilder().append(message).append(" [").append(serviceName).append("] endpoint: [")
				.append(endpoint).append("]").toString();
	}

	public static String formatServiceErrorLog(final String message, final String errorMessage,
			final String serviceName, final String endpoint) {
		return new StringBuilder().append(message).append(" error message: [").append(errorMessage).append("] in ")
				.append(" [").append(serviceName).append("] endpoint: [").append(endpoint).append("]").toString();
	}

	public static String formatServiceErrorLog(final String message, final int errorCode, final String errorMessage,
			final String serviceName, final String endpoint) {
		return LogMessageUtils.formatServiceErrorLog(message, String.valueOf(errorCode), errorMessage, serviceName,
				endpoint);
	}

	public static String formatServiceErrorLog(final String message, final String errorCode, final String errorMessage,
			final String serviceName, final String endpoint) {
		return new StringBuilder().append(message).append(" error message: [").append(errorCode).append("-")
				.append(errorMessage).append("] in ").append(" [").append(serviceName).append("] endpoint: [")
				.append(endpoint).append("]").toString();
	}

	public static String formatParameters(final String parameterName, final Object parameterValue) {
		return new StringBuilder().append(parameterName).append("= [").append(parameterValue).append("]").toString();
	}

	public static String formatParameters(final String message, final String methodName, final String parameterName,
			final Object parameterValue) {
		return new StringBuilder().append(message).append(" [").append(methodName).append("]: <")
				.append(LogMessageUtils.formatParameters(parameterName, parameterValue)).append(">").toString();
	}

	public static String formatParameters(final String message, final String methodName, final String[] parameterNames,
			final Object... parameterValues) {
		return new StringBuilder().append(message).append(" [").append(methodName).append("]: <")
				.append(LogMessageUtils.formatParameters(parameterNames, parameterValues)).append(">").toString();
	}

	public static String formatParameters(final String[] parameterNames, final Object... parameterValues) {
		String parameters = null;
		String parameterValue;

		if (parameterNames != null && parameterNames.length > 0) {
			for (int i = 0; i < parameterNames.length; i++) {
				parameterValue = "<not found>";
				parameters = parameters != null ? parameters + ", " : "";
				if (parameterValues != null && parameterValues.length > i) {
					parameterValue = "[" + parameterValues[i] + "]";
				}
				parameters += parameterNames[i] + "=" + parameterValue;
			}
		}

		return parameters;
	}

	public static String formatParameterArrayMap(Map<String, String[]> parameters) {
		String parametersStr = null;
		String parameterStr = null;

		if (parameters == null || parameters.isEmpty()) {
			parametersStr = " [no parameters]";
		} else {
			for (Entry<String, String[]> e : parameters.entrySet()) {
				parametersStr = parametersStr != null ? parametersStr + ", " : "";

				String paramValue = e.getValue() == null ? "null"
						: (e.getValue().length == 0 ? "empty"
								: e.getValue().length == 1 ? e.getValue()[0] : Arrays.toString(e.getValue()));
				parameterStr = String.format("[%s]=[%s]", e.getKey(), paramValue);
				parametersStr += parameterStr;
			}
		}

		return parametersStr;
	}

	public static String formatParameterMap(Map<String, String> parameters) {
		String parametersStr = null;
		String parameterStr = null;

		if (parameters == null || parameters.isEmpty()) {
			parametersStr = " [no parameters]";
		} else {
			for (Entry<String, String> e : parameters.entrySet()) {
				parametersStr = parametersStr != null ? parametersStr + ", " : "";

				String paramValue = e.getValue() == null ? "null" : e.getValue();
				parameterStr = String.format("[%s]=[%s]", e.getKey(), paramValue);
				parametersStr += parameterStr;
			}
		}

		return parametersStr;
	}

	public static String formatMap(Map<String, String[]> map) {

		String mapStr = "";

		Set<String> keys = map.keySet();
		for (String key : keys) {
			mapStr += key + "--->" + Arrays.toString(map.get(key)) + ";";
		}

		return mapStr;
	}

	public static String formatServiceErrorLog(final String message, final int errorCode, final String errorMessage,
			final String endpoint) {
		return new StringBuilder().append(message).append(" error message: [").append(errorMessage)
				.append("] in endpoint: [").append(endpoint).append("]").append(" with errorCode: [").append(errorCode)
				.append("]").toString();
	}

	public static String formatServiceErrorLog(final String message, final String errorMessage,
			final String serviceName) {
		return new StringBuilder().append(message).append(" error message: [").append(errorMessage).append("] in ")
				.append(" [").append(serviceName).toString();
	}

}
