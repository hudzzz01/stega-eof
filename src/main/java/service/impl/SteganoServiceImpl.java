package service.impl;



import com.kentung.exception.InvalidReadImageException;
import service.SteganoService;
import utils.IOFile;

import java.io.File;
import java.nio.file.Path;

public class SteganoServiceImpl implements SteganoService {
    IOFile IOFile = new IOFile();
    String outputPath = "OutputFile";
    String outputMessage = "OutputMessage";

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public String getOutputMessage() {
        return outputMessage;
    }

    public void setOutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public Integer[] insertAsecretFileToReceptacleFile(File inputFileReceptacle, File inputSecretFile){
        String output = outputPath +"/" + inputFileReceptacle.getName();
        Path outputPath = Path.of(output);
        File outputFile = outputPath.toFile();
        byte [] fileReceptacleByte = null;
        try {
            fileReceptacleByte = getImageByte(inputFileReceptacle);
        } catch (InvalidReadImageException e) {
            System.out.println(e.getMessage());
            return new Integer[]{0,0};
        }
        
        //message section
        byte [] fileSecretByte = null;
        try {
            fileSecretByte = getImageByte(inputSecretFile);
        } catch (InvalidReadImageException e) {
            System.out.println(e.getMessage());
            return new Integer[]{0,0};
        }


        byte [] newData = combineByte(fileReceptacleByte, fileSecretByte);
        if(writeByteToFile(newData, outputFile)) return new Integer[]{1, fileSecretByte.length};
        return new Integer[]{0,0};
    }

    public Integer[] extractSecretFileFromReceptacleFile(File fileForExtractMessage, int messageLength, String extension){
        byte [] fileData = null;
        try {
            fileData =  getImageByte(fileForExtractMessage);
        } catch (InvalidReadImageException e) {
            System.out.println(e.getMessage());
            return new Integer[]{0,0};
        }

        int startIndex = fileData.length - messageLength;

        byte[] messageDataByte = extractMessageData(startIndex, messageLength, fileData);

        //message section
        String output = outputMessage + "/" + "secretMessage." + extension;
        Path outputPath = Path.of(output);
        File outputFile = outputPath.toFile();
        if(writeByteToFile(messageDataByte, outputFile)) return new Integer[]{1, fileData.length};


        return new Integer[]{0, 0};
    }

    byte[] extractMessageData(int starIndex, int messageLength, byte[] imageData){
        byte [] messageData = new byte[messageLength];
        for (int i = 0; i < messageLength; i++) {
            messageData[i] = imageData[starIndex + i];
        }
        return messageData;

    }

    String toStringFromByte(byte[] data){
        return new String(data);
    }

    byte [] getImageByte(File file) throws InvalidReadImageException {
        byte [] data = IOFile.readImage(file);
        if(data == null || data.length == 0){
            throw new InvalidReadImageException();
        }
        return IOFile.readImage(file);
    }

    byte [] getMessageByte(String message){
        return message.getBytes();

    }

    byte [] combineByte(byte [] imageByte, byte [] messageByte){
        byte [] newData = new byte[imageByte.length + messageByte.length];
        System.arraycopy(imageByte, 0, newData, 0, imageByte.length);
        System.arraycopy(messageByte, 0, newData, imageByte.length, messageByte.length);
        return newData;
    }

    Boolean writeByteToFile(byte [] data, File file){
        IOFile.writeImage(data,file);
        return file.exists();
    }

}
