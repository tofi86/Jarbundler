/*
    JNI hook for involking "NSApplication showHelp:"
*/ 

#import <JavaVM/jni.h>
#import <Cocoa/Cocoa.h>

JNIEXPORT void JNICALL Java_net_sourceforge_jarbundler_example_HelpBook_launchHelpViewer (JNIEnv *env, jclass clazz) {
	[[NSApplication sharedApplication] performSelectorOnMainThread:@selector(showHelp:) withObject:NULL waitUntilDone:NO];
}
