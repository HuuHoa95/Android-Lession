// IDocument
package com.example.lession1;

// Declare any non-default types here with import statements

/** Example service interface */
interface IDocument {
    /** Request the process ID of this service, to do evil things with it. */
    int getPid();

    /** Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int Int, long aLong, boolean aBoolean);
}