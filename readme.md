# stega-eof 🔖
### @kentung 🚩
### hudzaifahzzzzzz@gmail.com
#### +62895-3669-75992 

Its library steganografy with EOF algoritm. 🚀

The `stega-eof` interface provides methods for inserting and extracting secret files within receptacle files, along with customizable output directories for generated files.

## Maven Dependency 
```
  <dependencies>
        <dependency>
            <groupId>com.kentung</groupId>
            <artifactId>stega-eof</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>

```


## Methods

### 1. `insertAsecretFileToReceptacleFile`
```java
public Integer[] insertAsecretFileToReceptacleFile(File inputFileReceptacle, File inputSecretFile);
```
#### Description:
- Embeds a secret file into a receptacle file.
- Returns an array with the following structure:
    - `status`: `1` indicates success, any other value indicates failure.
    - `length`: The length of the key or the secret message.

#### Parameters:
- `File inputFileReceptacle`: The file that will act as the receptacle.
- `File inputSecretFile`: The secret file to be embedded.

---

### 2. `extractSecretFileFromReceptacleFile`
```java
public Integer[] extractSecretFileFromReceptacleFile(File fileForExtractMessage, int messageLength, String extension);
```
#### Description:
- Extracts a secret file from a given receptacle file.
- Returns an array with the following structure:
    - `status`: `1` indicates success, any other value indicates failure.
    - `length`: The length of the receptacle file including the secret message.

#### Parameters:
- `File fileForExtractMessage`: The file from which the secret message will be extracted.
- `int messageLength`: The length of the secret message.
- `String extension`: The extension of the secret file to be extracted.

---

## Output Directory
By default, the output directories are:
- **For inserted files**: `OutputFile`
- **For extracted messages**: `OutputMessage`

### Important:
- These directories must be created manually before using the service.
- Alternatively, you can customize the directories using the methods below.

---

## Custom Directory Methods

### 1. `getOutputPath`
```java
public String getOutputPath();
```
- Retrieves the current directory path for inserted files.

### 2. `setOutputPath`
```java
public void setOutputPath(String outputPath);
```
- Sets a custom directory path for inserted files.

### 3. `getOutputMessage`
```java
public String getOutputMessage();
```
- Retrieves the current directory path for extracted messages.

### 4. `setOutputMessage`
```java
public void setOutputMessage(String outputMessage);
```
- Sets a custom directory path for extracted messages.

---

## Notes:
- Ensure that the directories specified in `outputPath` and `outputMessage` exist before running the service to avoid errors.
- Customize the output paths as needed to suit your application requirements.
