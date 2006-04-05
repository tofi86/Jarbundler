package net.sourceforge.jarbundler.example;

public class HelpBook {
	static {
		System.loadLibrary("HelpBookJNI");
	}

	public static native void launchHelpViewer();
}
