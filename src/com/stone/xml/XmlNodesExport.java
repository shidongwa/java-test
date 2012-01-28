package com.stone.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlNodesExport {

	private List<String>	result;  //store the result leaf node list which value is not null

	private Queue<MyNode> queue;  //temporary queue for storing non-leaf node
	/**
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		InputStream input = ParseTest.class.getClassLoader().getResourceAsStream("com/stone/xml/books.xml");
		XmlNodesExport export = new XmlNodesExport();
        export.init(input);
		
		export.traverse();
		
		Iterator<String> it = export.getResult().iterator();
		while(it.hasNext()){
			String nodeName = it.next();
			System.out.println(nodeName);
		}
	}
	
	public  void init(InputStream input) throws ParserConfigurationException, SAXException, IOException{
		result = new LinkedList<String>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(input);
		Element element = document.getDocumentElement();
		
		queue = new LinkedList();		
		if(element != null){
//			queue.add(element.getNodeName());	
			queue.add(new MyNode(element.getNodeName(), element));
		}


	}

	public void traverse(){
		
		while(!queue.isEmpty()){
			MyNode myNode = queue.poll();
			String nodeName = myNode.getNodeFullName();
			
			Element el = myNode.getElement();
			NodeList childNodes = el.getChildNodes();
			for(int j=0;j<childNodes.getLength();j++){
				
				if(childNodes.item(j).getNodeType()==Node.ELEMENT_NODE){
					queue.add(new MyNode(nodeName + "." + childNodes.item(j).getNodeName(), (Element)childNodes.item(j)));
				}else if(childNodes.item(j).getNodeType()==Node.TEXT_NODE ){
					if(childNodes.getLength() == 1)  // eliminate non-leaf element 
						result.add(nodeName);                    
				}
			}
		}
	}
	
	class MyNode{
		private String nodeFullName;
		private Element element;
		public String getNodeFullName() {
			return nodeFullName;
		}
		public void setNodeFullName(String nodeFullName) {
			this.nodeFullName = nodeFullName;
		}
		public Element getElement() {
			return element;
		}
		public void setElement(Element element) {
			this.element = element;
		}

		MyNode(String nodeFullName, Element element){
			this.nodeFullName = nodeFullName;
			this.element = element;
		}
	}

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}


}
