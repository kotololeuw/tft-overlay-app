import javax.swing.*;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * This class checks for an updated main jar and, if found, downloads it.
 * After update check, forwards on to main jar main method.
 */
public class AppLoader {

    // The App directory
    static final String AppDirName = "tft-overlay-app";

    // The main application zip name
    static final String zipName = "tft-overlay-app.zip";

    // The main application zip folder
    static final String zipNameFolder = "tft-overlay-app";

    // First folder in the zip to extract
    static final String firstFolderInZipToExtract = "tft-overlay-app";

    // The path to the update zip at website
    static final String zipUrl = "https://raw.githubusercontent.com/kotololeuw/tft-overlay-app/master/tft-overlay-core/release/tft-overlay-app.zip";

    // Version local
    static final String versionLocalPath = "version.txt";

    // Version online
    static final String versionOnlineUrl = "https://raw.githubusercontent.com/kotololeuw/tft-overlay-app/master/tft-overlay-core/release/version.txt";

    // Folder core local
    static final String folderCoreLocalName = "tft-overlay-app\\launch.bat";

    /**
     * Main method - reinvokes main1() on Swing thread in exception handler.
     */
    public static void main(final String args[]) {
        // Invoke real main with exception handler
        try {
            init(args);
        } catch (Throwable e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
            System.exit(0);
        }
    }

    /**
     * Init
     * @param args args
     * @throws Exception Exception
     */
    public static void init(final String args[]) throws Exception {
        System.out.println("### BEGIN init ###");
        new Thread("initThread"){
            public void run(){
               JOptionPane.showOptionDialog(null, "Launching Application...","   tft-overlay-app made by Kotolol", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
            }
        }.start();
        try {
            copyFilesToLocal();
        } catch (Throwable e) {
           System.out.println("there was en error launching application:");
           System.out.println(e);
           System.out.println("trying to launch in offline mode if file already exist");
            // Launch EXE if exist
            String rutaApp = getAppDataDirLocal((AppDirName + "\\" + folderCoreLocalName));
            File executeApp = new File(rutaApp);
            if(executeApp.exists()) {
                System.out.println(rutaApp + " file has been found, executing...");
                Runtime.getRuntime().exec(rutaApp);
                System.exit(0);
            } else {
                System.out.println(executeApp.getPath() + " file not found");
                throw new Exception("error copying files to local");
            }
        }

        // Launch EXE
        String rutaApp = getAppDataDirLocal((AppDirName + "\\" + folderCoreLocalName));
        File executeApp = new File(rutaApp);
        if(executeApp.exists()) {
            // launching rutaApp= C:\Users\Usuario\AppData\Local\appLoader\tft-overlay-core\tft-overlay-core.exe
            System.out.println("launching rutaApp= " + rutaApp);
            Runtime.getRuntime().exec(rutaApp);
        } else {
            System.out.println("Application does not exist");
            throw new Exception("Application does not exist");
        }
        System.out.println("### END init ###");
        System.exit(0);
    }

    private static void extractZip() {
        System.out.println("### BEGIN extractZip ###");
        try {
            File zipLocal = getAppFile(zipName);
            String zipPath = zipLocal.getPath();
            String rutaDestino = getAppDataDirLocal(AppDirName);
            File folderDestino = new File(rutaDestino);
            // Create first extracted folder inside zip (if it doesnt exist, it will fail)
            String firstFolderInZip = rutaDestino + "\\" + firstFolderInZipToExtract;
            File firstFolder = new File(firstFolderInZip);
            if(!firstFolder.exists()) {
                System.out.println("created folder " + firstFolder.getPath());
                firstFolder.mkdirs();
            }

            byte[] buffer = new byte[1024];
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipPath));
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File newFile = newFile(folderDestino, zipEntry);
                boolean isDirectory;
                try {
                    isDirectory = zipEntry.isDirectory();
                } catch (Throwable e) {
                    System.out.println("Error checking if entry is directory");
                    throw new Exception ("Error checking if entry is directory");
                }
                if(!isDirectory) {
                    // Es un archivo ya que acaba por .xxx
                    FileOutputStream fos = new FileOutputStream(newFile);
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                    System.out.println("extracted file " + zipEntry.getName());
                } else {
                   // Es una carpeta
                    String folder = newFile.getPath();
                    try {
                        File folderZip = new File(folder);
                        if (!folderZip.exists()) {
                            System.out.println("folder created " + folderZip.getPath());
                            folderZip.mkdirs();
                        }
                    } catch (Throwable e) {
                        System.out.println("Error creating folder " + folder + ". " + e);
                        throw new Exception("Error creating folder " + folder);
                    }
                }
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
            System.out.println("### END extractZip ###");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for unziping with java
     * @param destinationDir destino
     * @param zipEntry zip
     * @return File
     * @throws IOException Excepcion
     */
    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }

    /**
     * Copies the default main jar into place for initial run.
     */
    private static void copyFilesToLocal() throws IOException {
        System.out.println("### BEGIN copyFilesToLocal ###");
        // Check main zip app
        File zipLocal = getAppFile(zipName);

        // Folder zip
        File folderZipLocal = getAppFile(zipNameFolder);

        // Online version || Note: It takes about 5-10 min to refresh the version when you upload a new version.txt
        URL onlineVersionUrl = new URL(versionOnlineUrl);
        HttpURLConnection onlineVersionHttp = (HttpURLConnection) onlineVersionUrl.openConnection();
        InputStream onlineVersionStream = onlineVersionHttp.getInputStream();
        System.out.println("inputStream from " + onlineVersionUrl + " downloaded");
        String versionOnline = getStringFromStream(onlineVersionStream);

        File versionLocalFile = new File(getAppDataDirLocal(AppDirName + "\\" + versionLocalPath));
        if(!versionLocalFile.exists()) {
            // Get online version if not exist
            System.out.println("local file not exist -> " +  getAppDataDirLocal(AppDirName + "\\" + versionLocalPath + ", download it"));
            downloadFileToLocal(versionOnlineUrl, versionLocalPath);
        } else {
            System.out.println("local file exist -> " +  getAppDataDirLocal(AppDirName + "\\" + versionLocalPath));
        }

        // Local version
        String pathEx = getAppDataDirLocal(AppDirName + "\\" + versionLocalPath);
        String versionLocal = readFile(pathEx);

        // We copy online file to local if it doesnt exist or it's an old version
        if (!zipLocal.exists()) {
            System.out.println("!zipLocal.exists()");
            // Delete folderZip local
            if(folderZipLocal.exists()) {
                deleteDirectory(folderZipLocal);
            }
            // Download online zip
            downloadFileToLocal(zipUrl, zipName);
            // Unzip online zip
            extractZip();
        } else if(!versionLocal.equals(versionOnline)) {
            System.out.println("!versionLocal.equals(versionOnline)");
            // Delete folderZip local
            deleteDirectory(folderZipLocal);
            // Delete local zip
            zipLocal.delete();
            // Delete local version
            versionLocalFile.delete();
            // Download online zip
            downloadFileToLocal(zipUrl, zipName);
            // Unzip online zip
            extractZip();
            // Download local version
            downloadFileToLocal(versionOnlineUrl, versionLocalPath);
        } else if(zipLocal.exists() && !folderZipLocal.exists()) {
            System.out.println("(zipLocal.exists() && !folderZipLocal.exists()");
            extractZip();
        } else {
            System.out.println("app up to date, no actions required");
        }
        System.out.println("### END copyFilesToLocal ###");
    }

    /*
     * Right way to delete a non empty directory in Java
     */
    public static boolean deleteDirectory(File dir) {
        System.out.println("### BEGIN deleteDirectory dir= " + dir + " ###");
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDirectory(children[i]);
                if (!success) {
                    return false;
                }
            }
        }
        // either file or an empty directory
        System.out.println("removing file or directory : " + dir.getName());
        System.out.println("### END deleteDirectory dir= " + dir + " ###");
        return dir.delete();
    }

    /**
     * download an online file to local
     */
    private static void downloadFileToLocal(String url, String file) {
        System.out.println("### BEGIN downloadFileToLocal url= " + url + ", file= " + file + " ###");
        try {
            URL onlineFileUrl = new URL(url);
            HttpURLConnection onlineFileHttp = (HttpURLConnection) onlineFileUrl.openConnection();
            InputStream onlineFileStream = onlineFileHttp.getInputStream();
            String path = getAppDataDirLocal(AppDirName) + "\\" + file;
            Files.copy(onlineFileStream, Paths.get(path));
            System.out.println("### END downloadFileToLocal ###");
        } catch (Throwable e ) {
            e.printStackTrace();
        }

    }

    /**
     * Method for getting the string content from a stream
     * @param inputStream inputstream
     * @return String
     */
    private static String getStringFromStream(InputStream inputStream) {
        System.out.println("### BEGIN getStringFromStream ###");
        if (inputStream != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[2048];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                int counter;
                while ((counter = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, counter);
                }
            } catch(Throwable e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch(Throwable e) {
                    e.printStackTrace();
                }
            }
            String result = writer.toString();
            System.out.println("result= " + result);
            System.out.println("### END getStringFromStream ###");
            return result;
        } else {
            return "No Contents";
        }
    }


    /**
     * Reading file method
     * @param path path
     * @return String file content
     */
    private static String readFile(String path) {
        System.out.println("### BEGIN readFile path= " + path + " ###");
        // The name of the file to open.
        String fileName = path;
        String result = "";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            File file = new File(path);
            InputStream in = new FileInputStream(file);
            Reader reader = new InputStreamReader(in);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(reader);

            while ((line = bufferedReader.readLine()) != null) {
                result = result + line;
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
        System.out.println("result= " + result);
        System.out.println("### END readFile ###");
        return result;
    }

    /**
     * Returns the Main jar file.
     */
    private static File getAppFile(String aName) {
        return new File(getAppDir(), aName);
    }

    /**
     * Returns the Main jar file.
     */
    private static File getAppDir() {
        return getAppDataDir(AppDirName, true);
    }

    /**
     * Returns the AppData or Application Support directory file.
     */
    public static File getAppDataDir(String aName, boolean doCreate) {
        String dir = getAppDataDirLocal(aName);
        // Create file, actual directory (if requested) and return
        File dfile = new File(dir);
        if (doCreate && aName != null) {
            dfile.mkdirs();
        }
        return dfile;
    }

    /**
     * Method for getting Appdata
     * @param aName String
     * @return String
     */
    public static String getAppDataDirLocal(String aName) {
        // Get user home + AppDataDir (platform specific) + name (if provided)
        String dir = System.getProperty("user.home");
        if (isWindows) {
            dir += File.separator + "AppData" + File.separator + "Local";
        } else if (isMac) {
            dir += File.separator + "Library" + File.separator
                    + "Application Support";
        }
        if (aName != null)
            dir += File.separator + aName;
        return dir;
    }

    // Whether Windows/Mac
    static boolean isWindows = (System.getProperty("os.name")
            .indexOf("Windows") >= 0);
    static boolean isMac = (System.getProperty("os.name").indexOf("Mac OS X") >= 0);

}
