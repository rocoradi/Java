/**
 * @author Coradi
 *
 * 11 de jan de 2018
 */
package com.schoolofnet.Dialect;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

public class FormDialect extends AbstractDialect{

	public FormDialect() {
		super();
	}
	
	@Override
	public String getPrefix() {
		return "form";
	}
	
	@Override
	public Set<IProcessor> getProcessors(){
		Set<IProcessor> processors = new HashSet<IProcessor>();
		
		processors.add(new Form());
		return processors;
	}

}
