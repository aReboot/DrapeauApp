package com.example.aller.drapeauapp.modele;

/**
 * Created by Adrien on 21/09/2017.
 */

public class Country {

	private String name;
	private String code;
	private String flagURL;
	private String flagPath;

	public String getFlagPath() {
		return flagPath;
	}

	public void setFlagPath(String flagPath) {
		this.flagPath = flagPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFlagURL() {
		return flagURL;
	}

	public void setFlagURL(String flagURL) {
		this.flagURL = flagURL;
	}
}
