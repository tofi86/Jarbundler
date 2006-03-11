package net.sourceforge.jarbundler;

import java.lang.String;
import java.io.File;


  public class DocumentType {
    public String name;
    public String[] extensions;
    public String[] osTypes;
    public File iconFile;
    public String role;

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

  }
