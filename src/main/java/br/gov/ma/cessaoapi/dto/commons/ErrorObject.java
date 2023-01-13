package br.gov.ma.cessaoapi.dto.commons;

public class ErrorObject extends ModelObject {

	private String id;
	private String errorCode;
	private String description;
	
	public ErrorObject() {}

	public ErrorObject(String id, String errorCode, String description) {
		super();
		this.id = id;
		this.errorCode = errorCode;
		this.description = description;
	}

	public ErrorObject(String errorCode, String description) {
		super();
		this.errorCode = errorCode;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
