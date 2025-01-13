package service;

import java.io.File;

public interface SteganoService {


    public Integer[] insertAsecretFileToReceptacleFile(File inputFileReceptacle, File inputSecretFile);
    //return [status, length of key or length of secret message]
    //if the status is 1 means success
    //else failed


    public Integer[] extractSecretFileFromReceptacleFile(File fileForExtractMessage, int messageLength, String extension);
    //return [status, length of file receptacle including secret message]
    //if the status is 1 means success
    //else failed


    // By Default Output Directory the directory is
    //    public String outputPath = "OutputFile";  //INSERT
    //    public String outputMessage = "OutputMessage"; //EXCRACT MESSAGE

    // !!! SO you MUST create the directory before using the service. Or change the directory Or you will get error

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++ OPTIONAL CHANGING CUSTOM DIRECTORY ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String getOutputPath();
    public void setOutputPath(String outputPath); //INSERT
    public String getOutputMessage();
    public void setOutputMessage(String outputMessage); //EXTRACT

}
