package org.eop.jmx.dynamic.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public interface IDocument extends IXNode {

	Declaration getDeclaration();
	
	void setDeclaration(Declaration declaration);
	
	DocType getDocType();
	
	void setDocType(DocType docType);
	
	IElement getRoot();
	
	void setRoot(IElement root);
}
