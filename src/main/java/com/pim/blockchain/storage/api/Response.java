package com.pim.blockchain.storage.api;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
	
	private T data;
	
	private List<String> erros;

	public T getData() {
		return data;
	}

	public Response<T> setData(T data) {
		this.data = data;
		return this;
	}

	public List<String> getErros() {
		if( this.erros == null )
			this.erros = new ArrayList<String>();
		
		return erros;
	}

	public Response<T> setErros(List<String> erros) {
		this.erros = erros;
		return this;
	}
}
