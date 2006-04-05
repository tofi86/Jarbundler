package net.sourceforge.jarbundler;

import java.lang.String;
import java.io.File;

/**
 * Represents an Info.plist DocumentType used for associating a file with the 
 *   application bundle
 * 
 * The Document Types allows you to specify which documents your finished
 * product can handle. You should list the application's primary
 * document type first because the document controller uses that type by default
 * when the user requests a new document. Here is whats in the Document Types
 * table:
 * 
 *    Name - The name of the document type.
 * 
 *    Extensions -  A list of the filename extensions for this document type. Don't
 *       include the period in the extension.
 *
 * 
 *    OS Types - A list of four-letter codes for the document. These codes are
 *       stored in the document's resources or information property list files.
 * 
 *    Icon File - The name of the file that contains the document type's icon.
 * 
 *    Role - A description of how the application uses the documents of this type.
 *       You can choose from four values:
 * 
 * 		    Editor - The application can display, edit, and save documents of this type.
 * 
 * 	        Viewer - The application can display, but not edit, documents of this type.
 * 
 * 	        Shell - The application provides runtime services for other processes
 *                  for example, a Java applet viewer.
 * 
 * 	        None - The application can neither display nor edit documents of this 
 *                 type but instead uses them in some other way. For example, 
 *                 Sketch uses this role to declare types it can export but not read.
 * 
 * 
 *   Bundle -  Specifies whether the document is a single file or a file bundle,
 *        that is, a directory that is treated as a single document by certain applications,
 *        such as the Finder.
 * 
 * 
 * <pre>
 *  &lt;documenttype 	
 *      name=&quot;Scan Project&quot;
 *      extensions=&quot;scansort scanproj&quot;
 *      ostypes=&quot;fold disk fdrp&quot;
 *      iconfile=&quot;document.icns&quot;
 *      role=&quot;editor&quot;
 *      bundle=&quot;true&quot; /&gt;
 * </pre>
 */

  public class DocumentType {


    /** Name. The name of the document type. */
    public String name = null;


    /**
	 * Extensions. A list of the filename extensions for this document type.
	 * Don't include the period in the extension.
	 */


    public String[] extensions = null;
    /**
	 * OS Types. A list of four-letter codes for the document. These codes are
	 * stored in the document's resources or information property list files.
	 */


    public String[] osTypes = null;
    /**
	 * MIME Types. A list of the Multipurpose Internet Mail Extensions (MIME)
	 * types for the document. MIME types identify content types for Internet
	 * applications.
	 */


    public String[] mimeTypes = null;
    
    /**
	 * Icon File. The name of the file that contains the document types icon.
	 */


    public File iconFile = null;
    /**
	 * Role. A description of how the application uses the documents of this
	 * type. You can choose from four values:
	 * <p>
	 * Editor. The application can display, edit, and save documents of this
	 * type.
	 * <p>
	 * Viewer. The application can display, but not edit, documents of this
	 * type.
	 * <p>
	 * Shell. The application provides runtime services for other processesfor
	 * example, a Java applet viewer.
	 * <p>
	 * None. The application can neither display nor edit documents of this type
	 * but instead uses them in some other way. For example, Sketch uses this
	 * role to declare types it can export but not read.
	 */


    public String role = null;


    /**
	 * Bundle. Specifies whether the document is a single file document or a document
	 * bundle, that is, a directory that is treated as a single document by certain
	 * applications, such as the Finder.
	 */


    public boolean isBundle = false; 



    public void setName(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }


    public void setExtensions(String extensions) {
      this.extensions = extensions.split("[\\s,]");
    }
    
    public String[] getExtensions() {
      return extensions;
    }


    public void setOSTypes(String osTypes) {
      this.osTypes = osTypes.split("[\\s,]");
    }
    
    public String[] getOSTypes() {
      return osTypes;
    }


    public void setIconFile(File iconFile) {
      this.iconFile = iconFile;
    }
    
    public File getIconFile() {
      return iconFile;
    }


    public void setRole(String role) {
      this.role = role;
    }

    public String getRole() {
      return role;
    }


    
	public boolean isBundle() {
	  return isBundle ;
	}

	public void setBundle(boolean isBundle) {
	   this.isBundle = isBundle;
	}

  	
}
