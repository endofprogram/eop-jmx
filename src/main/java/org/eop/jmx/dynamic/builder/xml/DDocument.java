package org.eop.jmx.dynamic.builder.xml;

import org.eop.claw.Claw;
/**
 * lixinjie 2016-12-26
 */
public class DDocument extends DCNode implements IDDocument {

	private Document document;
	
	public DDocument(Claw claw) {
		super(null, null, null);
		this.document = new Document();
		this.claw = claw;
	}
	
	Document getDocument() {
		return document;
	}
	
	void setDocument(Document document) {
		this.document = document;
	}
	
	@Override
	public Declaration getDeclaration() {
		return document.getDeclaration();
	}

	@Override
	public void setDeclaration(Declaration declaration) {
		document.setDeclaration(declaration);
	}
	
	@Override
	public DocType getDocType() {
		return document.getDocType();
	}

	@Override
	public void setDocType(DocType docType) {
		document.setDocType(docType);
	}
	
	@Override
	public IElement getRoot() {
		return document.getRoot();
	}

	@Override
	public void setRoot(IElement root) {
		document.setRoot(root);
	}

	@Override
	ICNode getSelf() {
		return null;
	}

	@Override
	void prepare() {
		
	}

	@Override
	public void toXml(StringBuilder sb) {
		document.toXml(sb);
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		document.toXml(sb, indent);
	}

	@Override
	public DDocument deepClone(IXNode parent) {
		DDocument ddocument = new DDocument(claw);
		ddocument.setDocument((Document)document.deepClone(ddocument));
		return ddocument;
	}

	@Override
	IDCNode cloneDSelf(IXNode parent) {
		return null;
	}

}
