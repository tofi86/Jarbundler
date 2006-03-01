Mac OS X Jar Bundler Ant Task
-----------------------------
Will Gilbert <gilbert@informagen.com>
Version 1.5
February 2006

See <http://informagen.com/jarbundler/> for more information.

=========================================================================================
Based on the previous work of:
Seth Morabito <sethm@loomcom.com>
Version 1.4
November 13, 2004

See <http://www.loomcom.com/jarbundler/index.html> for more information.
=========================================================================================


Summary
-------
This is an ant task which will generate a Mac OS X Application Bundle if
provided a set of jars and a main class to launch.


Installation
------------
Put the file "jarbundler-1.5.jar" from the "bin" directory into 
the "/Developer/Java/Ant/lib" directory.  Authenticating as necessary.

Windows and UNIX installations add the your ANT lib directory.


Usage
-----

In your ANT build.xml file, add a task definition like this:

  <taskdef name="jarbundler" 
           classname="com.informagen.ant.tasks.jarbundler.JarBundler" />


Now, from any target you can call the "jarbundler" task.

  <jarbundler dir="release"
              name="MyApp 1.0"
              mainclass="org.foo.myapp.Main" 
              jars="${bin}/myapp.jar ${lib}/foo.jar ${lib}/bar.jar" />

This will create a Mac OS X application bundle called "MyApp 1.0.app" in
the directory "release".

If you prefer, you can use nested FileSets or FileLists in place of the
"jars" and "execs" attributes.  For example,

  <jarbundler dir="release" name="MyApp 1.0" mainclass="org.foo.myapp.Main">
  
    <jarfileset dir="${bin}>
      <include name="**/*.jar" />
      <exclude name="Test.jar" />
    <jarfileset>
    
    <jarfileset dir="${lib}>
      <include name="foo.jar" />
      <include name="bar.jar" />
    <jarfileset>
    
    <execfilelist dir="${extra}" files="FooExec, bar.sh"/>
    
  </jarbundler>


A longer example with all the optional goodies might look like this:

      <jarbundler dir="release"
                  name="Sequence Analysis"
                  mainclass="com.informagen.sa.SequenceAnalysis"
                  icon="${MacResources}/SA.icns"
                  version="${version}"
                  infostring="${version}, Informagen, Inc."
                  bundleid="com.informagen.SA"
                  signature="_SA_"
                  jvmversion="1.4+"
                  vmoptions="-Xms512m -Xmx1024m">
                  
          <!-- Native Environment Integration -->
          <javaproperty name="apple.laf.useScreenMenuBar"         value="true"/>
          <javaproperty name="apple.awt.brushMetalLook"           value="false"/>
          <javaproperty name="apple.awt.brushMetalRounded"        value="false"/>
          <javaproperty name="apple.awt.fileDialogForDirectories" value="false"/>
          <javaproperty name="apple.awt.antialiasing"             value="false"/>
          <javaproperty name="apple.awt.showGrowBox"              value="true"/>

          <!-- Rendering Hints -->
          <javaproperty name="apple.awt.textantialiasing"         value="false"/>
          
           <!-- Specify the SAX parser -->
          <javaproperty name="org.xml.sax.driver" value="org.apache.xerces.parsers.SAXParser"/>

       
          <jarfileset file="${SA.jar}"/>
          <jarfileset file="${SA-rsrc.jar}"/>
          
          <jarfileset dir="${lib}">
            <include name="**/*.jar" />
          </jarfileset>
          
          
        </jarbundler>

Changes
-------

February 2006 (version 1.5)

  Changed the package from 'com.loomcom.ant.tasks.jarbundler' to
  'com.informagen.ant.tasks.jarbundler' so that version 1.4 can remain installed

  Added a nested DataType called "javaproperty" so that new properties can be added
  by end users and deprecated properties can be removed.  Former jarbundler
  tag atributes are still available but have been deprecated in favor of their
  'javaproperty' equivalents.
  
  Currently, a jarbundler tag attribute overrides a javaproperty tag.  This was
  done to maintain backward compatibility with version 1.4


13 November 2004 (version 1.4):

   Fixed a bug that was causing application arguments not to be set.

23 October 2004 (version 1.3):

   Added "extraclasspath" attribute, and "extraclasspathfileset" and
   "extraclasspathfilelist" nested elements, allowing users to
   optionally add external resources to the runtime classpath which will
   not be copied into the application bundle at build time.  Removed
   some Java 1.4 requirements to allow building the sources under Java
   1.3. Clarified the documentation.

27 July 2004 (version 1.2):

   Added ANT property setters for "bundleid" and "developmentregion".
   Bundleid has no default, and is optional.  Developmentregion defaults
   to "English", and is also optional.  Fixed documentation on the
   website.

26 July 2004 (version 1.1):

   Fixed several minor bugs, and improved BuildException messages.
   jarfilesets and execfilesets now preserve directory structure when
   copying.  Thanks to Trevor Harmon <trevor 'at' vocaro 'dot' com> for
   pointing out bugs and enhancements.

25 July 2004 (version 1.0):

   "execs" and "jars" can now be set using embedded filesets or
   filelists.  Added a "verbose" flag, which currently sees limited use.
   Added "chmod" attribute, which can be used to point to a non-standard
   'chmod' command (not normally needed!)  Increased error checking.
   Hopefully, the code is now robust enough for widespread production
   use!

28 Dec 2003 (version 0.5):

   Added setter for "execs" attribute.  Added setter for "workingdir"
   attribute.  Fixed missing setter for "arguments" attribute.  Added
   alternate Java runtime parameter names for Mac OS X Java VM version
   1.4.1.  Included change submitted by Pierre-Luc Paour
   <pierre-luc 'at' paour 'dot' com>.  Thanks also to Dante Briones
   <dante 'at' electronicingenuity 'dot' com> and Graham Perks
   <grahamperks 'at' mac 'dot' com> for pointing out bugs and enhancements.

12 Oct 2003 (version 0.2):

   Added setter for "vmoptions" attribute.  Change submitted by Alok
   Saldanha <oakie137 'at' yahoo 'dot' com>

License
-------
Potions Copyright (c) 2006, William Gilbert <gilbert@informagen.com> All rights reserved.

Copyright (c) 2003, Seth J. Morabito <sethm@loomcom.com> All rights reserved.

This program is free software; you can redistribute it and/or modify it
under the terms of the GNU General Public License as published by the Free
Software Foundation; either version 2 of the License, or (at your option)
any later version.

This program is distributed in the hope that it will be useful, but WITHOUT
ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
FITNESS FOR A PARTICULAR PURPOSE.  See  the GNU General Public License for
more details.

You should have received a copy of the GNU General Public License along with
this program; if not, write to the Free Software Foundation, Inc., 59 Temple
Place - Suite 330, Boston, MA  02111-1307, USA.
