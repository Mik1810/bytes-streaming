import java.io.*;

public class BytesToFileConverter {

    public byte[] streamToBytes(String fileName) {

        InputStream inputStream = null;
        
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] buffer = new byte[8192];
        int bytesRead;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = output.toByteArray();
        return bytes;
    }

   
    public File bytesToFile(byte[] bytes) {

        File tempFile = null;
        File directory = new File("C:\\Users\\micha\\OneDrive\\Desktop\\prova");

        try {

            tempFile = File.createTempFile("tempFile", ".mp3", directory);
            
            //Comment out the following line if you want to see the temporary file in the folder you specified
            //tempFile.deleteOnExit();

            FileOutputStream fos = new FileOutputStream(tempFile);
            fos.write(bytes);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempFile;
    }
    
    public static void main(String[] args) throws IOException {

        BytesToFileConverter converter = new BytesToFileConverter();

        //Insert the name of the file here
        File file = converter.bytesToFile(converter.streamToBytes(args[0]));

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
    }
}
