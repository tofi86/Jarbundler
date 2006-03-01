Mac OS X Jar Bundler Ant Task
-----------------------------
Seth Morabito <sethm@loomcom.com>
Version 1.4
November 13, 2004

See <http://www.loomcom.com/jarbundler/index.html> for more information.

This is an ant task which will generate a Mac OS X Application Bundle if
provided a set of jars and a main class to launch.

Although it should still be considered beta quality software, and has
not received as much testing as I would like, as of the 1.0 release the
jarbundler task is probably ready for more widespread use, and is
extremely flexible and functional.  As always, if you find any bugs or
make any enhancements please let me know so that I can add your work to
the next release.

Use
---

In your ant build.xml file, add a task definition like this:

  <taskdef name="jarbundler" 
           classpath="${lib}/jarbundler-0.2.jar"
           classname="com.loomcom.ant.tasks.jarbundler.JarBundler" />

(where ${lib} is wherever you've put the jarbundler-0.2 jar file)

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
              verbose="true"
              name="MyApp 1.0"
              mainclass="org.foo.myapp.Main" 
              icon="${resources}/myapp.icns"
              version="1.0"
              infostring="MyApp 1.0, (c) 2003"
              aboutmenuname="MyApp"
              jvmversion="1.3+"
	      bundleid="org.foo.myapp.MyAppBundle"
	      developmentregion="French"
	      signature="MYAP"
	      type="TEST"
              vmoptions="-Xmx500m"
	      chmod="/usr/local/bin/chmod"
              smalltabs="true"
              antialiasedgraphics="true"
              antialiasedtext="true"
              liveresize="true"
              growboxintrudes="false"
              stubfile="/Alternate/Path/To/JavaStubFile"
              screenmenu="true">
    <jarfileset dir="${lib}">
      <exclude name="**/CVS" />
      <include name="**/*.jar" />
    </jarfileset>
    <execfileset dir="${exec}">
      <exclude name="**/CVS" />
      <include name="**/*.sh" />
    </execfileset>
    <!-- these files will NOT be copied into the bundle. -->
    <extraclasspathfileset dir="/System/Library/Frameworks/JavaFoundation.framework/Resources/Java">
      <include name="*.jar" />
    </extraclasspathfileset>
  </jarbundler>

This will set the various Mac OS X native look-and-feel bells and whistles,
copy in the appropriate Icon resource, and specify that the application
requires JVM version 1.3 or higher.

To Do
-----

- A number of Java runtime system properties are deprecated or changed
  under Mac OS X Java 1.4.1.  Although some of these were updated with
  version 0.5, not all were.  More will need to be done to handle this
  more cleanly.  This is scheduled for a future version.

Changes
-------

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
