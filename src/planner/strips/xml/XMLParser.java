package planner.strips.xml;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {
	private String name;
	private String content;
	private Map<String, String> nameAttributes = new HashMap<String, String>();
	private Map<String, List<XMLParser>> nameChildren = new HashMap<String, List<XMLParser>>();

	private static Element rootElement(String filename, String rootName) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filename);
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.parse(fileInputStream);
			Element rootElement = document.getDocumentElement();
			if (!rootElement.getNodeName().equals(rootName))
				throw new RuntimeException("Could not find root node: " + rootName);
			return rootElement;
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (Exception exception) {
					throw new RuntimeException(exception);
				}
			}
		}
	}

	public XMLParser(String filename, String rootName) {
		this(rootElement(filename, rootName));
	}

	private XMLParser(Element element) {
		this.name = element.getNodeName();
		this.content = element.getTextContent();
		NamedNodeMap namedNodeMap = element.getAttributes();
		int n = namedNodeMap.getLength();
		for (int i = 0; i < n; i++) {
			Node node = namedNodeMap.item(i);
			String name = node.getNodeName();
			addAttribute(name, node.getNodeValue());
		}
		NodeList nodes = element.getChildNodes();
		n = nodes.getLength();
		for (int i = 0; i < n; i++) {
			Node node = nodes.item(i);
			int type = node.getNodeType();
			if (type == Node.ELEMENT_NODE)
				addChild(node.getNodeName(), new XMLParser((Element) node));
		}
	}

	private void addAttribute(String name, String value) {
		nameAttributes.put(name, value);
	}

	private void addChild(String name, XMLParser child) {
		List<XMLParser> children = nameChildren.get(name);
		if (children == null) {
			children = new ArrayList<XMLParser>();
			nameChildren.put(name, children);
		}
		children.add(child);
	}

	public String name() {
		return name;
	}

	public String content() {
		return content;
	}

	public XMLParser child(String name) {
		List<XMLParser> children = children(name);
		if (children.size() != 1)
			throw new RuntimeException("Could not find individual child node: " + name);
		return children.get(0);
	}

	public List<XMLParser> children(String name) {
		List<XMLParser> children = nameChildren.get(name);
		return children == null ? new ArrayList<XMLParser>() : children;
	}

	public String string(String name) {
		String value = nameAttributes.get(name);
		if (value == null)
			throw new RuntimeException("Could not find attribute: " + name + ", in node: " + this.name);
		return value;
	}

	public int integer(String name) {
		return Integer.parseInt(string(name));
	}

}