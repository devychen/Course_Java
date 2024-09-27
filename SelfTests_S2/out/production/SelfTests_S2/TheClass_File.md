# Java.io.File Class

[Reference](https://www.geeksforgeeks.org/file-class-in-java/)  

## Key Points
1. It's Java's representation of a **file or directory pathname**.
 - and it's an abstract representation.
 - Why needed? File and dir names have different formats, a simple string is not adequate to name them.
2. Has methods for working with the pathname, deleting/renaming files, creating new directories, listing the contents of a directory, and determining several common attributes of files and directories;
3. Always start with creating the File class object by passing the filename or directory name to it:
```java
// to create a File object
File a = new File("/usr/local/bin/geeks");
/* this defines an abstract filename for the {geeks} file in the directory {/usr/local/bin/}
 this is the absolute abstract filename;
 */
```
4. Some methods
- `exist()`, boolean. Tests whether the file or directory denoted by this abstract pathname exists. 
- `isDirectory()`, boolean. Tests whether the file denoted by this pathname is a directory
- `isFile()`
- `equals()`, boolean. Tests this abstract pathname for equality with the given object.
- `getName()`, String. Returns the name of the file or directory denoted by this abstract pathname.
- `listFiles()`, File(). Returns an array of abstract pathnames denoting the files in the directory.