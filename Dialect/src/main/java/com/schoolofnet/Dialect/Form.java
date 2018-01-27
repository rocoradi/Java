/**
 * @author Coradi
 *
 * 11 de jan de 2018
 */
package com.schoolofnet.Dialect;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Node;
import org.thymeleaf.processor.AbstractProcessor;
import org.thymeleaf.processor.ElementNameProcessorMatcher;
import org.thymeleaf.processor.IProcessorMatcher;
import org.thymeleaf.processor.ProcessorMatchingContext;
import org.thymeleaf.processor.ProcessorResult;

public class Form extends AbstractProcessor{

	@Override
	public IProcessorMatcher<? extends Node> getMatcher() {
		return new ElementNameProcessorMatcher("form");
	}

	@Override
	public int getPrecedence() {
		return 0;
	}

	@Override
	protected ProcessorResult doProcess(Arguments arguments, ProcessorMatchingContext processorMatchingContext,
			Node node) {
		
		Element rootElement = new Element("form");
		Element input = new Element("input");
		rootElement.addChild(input);
		
		node.getParent().insertBefore(node, rootElement);
		return ProcessorResult.OK;
	}
	
	

}
