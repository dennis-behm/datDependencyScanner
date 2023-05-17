package com.dat.custom.dbb.scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import com.ibm.dbb.dependency.AbstractDependencyScanner;
import com.ibm.dbb.dependency.LogicalDependency;
import com.ibm.dbb.dependency.LogicalFile;

public class DATDependencyScanner extends AbstractDependencyScanner {

	@Override
	protected LogicalFile createLogicalFile(String file, Object scanMetadata) {
		return (LogicalFile) scanMetadata;
	}

	@Override
	protected Object runScan(String file, InputStream inputStream, String encoding) {

		LogicalFile lfile = new LogicalFile(createLogicalName(file), file, "MYCOBOL", false, false, false, false);

		// make sure we use the right encoding
		Reader reader;
		try {
			reader = new InputStreamReader(inputStream, encoding);
			
	        BufferedReader br = new BufferedReader(reader);
	        
	        String line;
	        while ((line = br.readLine()) != null) {
	            
	        	System.out.println("[DAT Dependency Scanner] reading : " + line);
	        	
	        	if (line.contains("COPYRIGHT")) {
	        		LogicalDependency logicalDependency = new LogicalDependency("COPYRIGHT", "SYSLIB", "COPY");
	        		lfile.addLogicalDependency(logicalDependency);
	        	}
	        	
	        }			
			
		} catch (UnsupportedEncodingException e) {
			// logging=
			return lfile;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return lfile;
	}

}
