/**
 * 
 */
package com.bjc.ekk.cleanup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ekk9418
 *
 */
public class WriteFile {
	private String path;
	private String XmlFile;
	private File xf;
	private FileOutputStream outx;
	private byte[] xdata;

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @param xmlFile the xmlFile to set
	 */
	public void setXmlFile(String xmlFile) {
		XmlFile = xmlFile;
	}

	/**
	 * @param xf the xf to set
	 */
	public void setXf(File xf) {
		this.xf = xf;
	}

	/**
	 * @param xdata the xdata to set
	 */
	public void setXdata(byte[] xdata) {
		this.xdata = xdata;
	}
	
	public WriteFile(String ccowTerms) {
		setXdata((ccowTerms += "</userList>").getBytes());//adds end of xml file to string
		
		setPath("c:\\Tools\\");
		setXmlFile("ccowTerms.xml");
		setXf(new File(path + XmlFile));
		
		xf.getParentFile().mkdirs();//create any necessary folders in the path
		
		try {
			outx = new FileOutputStream(path + XmlFile);
			xf.createNewFile();
			
			outx.write(xdata);
			
			outx.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}