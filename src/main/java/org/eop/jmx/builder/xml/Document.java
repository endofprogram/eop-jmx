package org.eop.jmx.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class Document extends XNode implements IDocument {

	private Declaration declaration;
	private DocType docType;
	private IElement root;
	
	public Document(IXNode parent, String name) {
		super(parent, name);
	}
	
	@Override
	public Declaration getDeclaration() {
		return declaration;
	}
	
	@Override
	public void setDeclaration(Declaration declaration) {
		this.declaration = declaration;
	}
	
	@Override
	public DocType getDocType() {
		return docType;
	}
	
	@Override
	public void setDocType(DocType docType) {
		this.docType = docType;
	}
	
	@Override
	public IElement getRoot() {
		return root;
	}
	
	@Override
	public void setRoot(IElement root) {
		this.root = root;
	}

	@Override
	public void toXml(StringBuilder sb) {
		if (declaration != null) {
			declaration.toXml(sb);
		}
		
		if (docType != null) {
			docType.toXml(sb);
		}
		
		root.toXml(sb);
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		if (declaration != null) {
			declaration.toXml(sb, indent);
		}
		
		if (docType != null) {
			docType.toXml(sb, indent);
		}
		
		root.toXml(sb, indent);
	}

	@Override
	public IXNode deepClone(IXNode parent) {
		Document document = new Document(parent, getName());
		document.setDeclaration(declaration.deepClone(document));
		document.setDocType(docType.deepClone(document));
		document.setRoot((IElement)root.deepClone(document));
		return document;
	}
}
