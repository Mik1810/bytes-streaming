# bytes-streaming
A Java class that create a temporary file from a byte streaming of another file, thaht can be used together with the class Media and MediaPlayer to reproduce songs

Compile the file with:

     javac BytesToFileConverter.java

Use with this:

     java BytesToFileConverter + file-name 

Where file-name is the name of the file .mp3 (for example) that you want to copy in a temporary file (the .mp3 file must have to be in the same directory of this file).

Then you should see, if you comment the line specified in the file, the temporary file otherwise it is created and deleted.

Try:

    java BytesToFileConverter jojo.mp3
