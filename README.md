Jarbundler
==========

Inofficial git port of the Sourceforge Ant-Jarbundler Task.

JarBundler is a feature-rich Apache ANT task that can create Mac OS X Application Bundles from a list of JAR files and a main class name. It also provides fine-grained control over the Mac OS X Application Bundle options and application behavior.


Modifications
-----

* **version 2.2.2** (2014-04-01)
 * Issue a warning when using deprecated 'aboutmenuname' attribute

* **version 2.2.1** (2014-01-25)
 * Added optional `allowMixedLocalizations` attribute to ant task. If `true`, the bundle supports the retrieval of localized strings from frameworks. This should be set to true if your app supports different languages. Default: `false`


Official Documentation
-----

See official website http://informagen.com/JarBundler/index.html


Official Sources
-----

See official Sourceforge project site: http://sourceforge.net/projects/jarbundler/


License
-----

Licensed under `Apache License v2.0`
