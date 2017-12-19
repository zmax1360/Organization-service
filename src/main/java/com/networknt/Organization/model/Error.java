
package com.networknt.Organization.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {

	private String message;

	private long time;

	private String error;

	private String exception;

	private String path;

	private Integer code;

	public Error(String message, long l, String error, String exception, String path, Integer code) {
		super();
		this.message = message;
		this.time = l;
		this.error = error;
		this.exception = exception;
		this.path = path;
		this.code = code;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("code")
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@JsonProperty("time")
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	@JsonProperty("error")
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@JsonProperty("exception")
	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	@JsonProperty("path")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Error Error = (Error) o;

		return Objects.equals(message, Error.message) &&

				Objects.equals(code, Error.code);
	}

	@Override
	public int hashCode() {

		return Objects.hash(message, code, time, path, error, exception);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Error {\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    time: ").append(toIndentedString(time)).append("\n");
		sb.append("    error: ").append(toIndentedString(error)).append("\n");
		sb.append("    exception: ").append(toIndentedString(exception)).append("\n");
		sb.append("    path: ").append(toIndentedString(path)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
