import javax.swing.*;
import java.io.*;
import java.lang.reflect.Method;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.util.jar.JarOutputStream;
import java.util.jar.Pack200;
import java.util.zip.GZIPInputStream;

/**
 * This class checks for an updated main jar and, if found, downloads it.
 * After update check, forwards on to main jar main method.
 */
public class AppLoader {

    // The App directory
    static final String AppDirName = "appLoader";

    // The main application jar name
    static final String JarName = "tft-overlay-core.jar";

    // The path to the update jar at website
    static final String JarURL = "https://raw.githubusercontent.com/kotololeuw/tft-overlay-app/master/bin/tft-overlay-core.jar";

    // The name of jar that holds this class
    static final String LoaderJarName = "AppLoader.jar";

    // The main class of the main application
    static final String MainClass = "Application";

    // Version local
    static final String versionLocalPath = "version.txt";

    // Version online
    static final String versionOnlineUrl = "https://raw.githubusercontent.com/kotololeuw/tft-overlay-app/master/bin/version.txt";

    /**
     * Main method - reinvokes main1() on Swing thread in exception handler.
     */
    public static void main(final String args[]) {
        // Invoke real main with exception handler
        try {
            main1(args);
        } catch (Throwable e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    /**
     * Main method: - Gets main Jar file from default, if missing - Updates main
     * Jar file from local update file, if previously loaded - Load main Jar
     * into URLClassLoader, load main class and invoke main method - Check for
     * update from remove site in background
     */
    public static void main1(final String args[]) throws Exception {
        try {
            copyDefaultMainJar();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        // Launch JAR
        String rutaJarMainApp = getAppDataDirLocal((AppDirName + "\\" + JarName));
        Runtime.getRuntime().exec("java -jar " + rutaJarMainApp);
    }

    /**
     * Copies the default main jar into place for initial run.
     */
    private static void copyDefaultMainJar() throws IOException {
        // Get main jar from local
        File jarLocal = getAppFile(JarName);

        // Online version
        URL onlineVersionUrl = new URL(versionOnlineUrl);
        HttpURLConnection onlineVersionHttp = (HttpURLConnection) onlineVersionUrl.openConnection();
        InputStream onlineVersionStream = onlineVersionHttp.getInputStream();
        String versionOnline = getStringFromStream(onlineVersionStream);

        File versionLocalFile = new File(getAppDataDirLocal(AppDirName + "\\" + versionLocalPath));

        if(!versionLocalFile.exists()) {
            // Get online version if not exist
            downloadFileToLocal(versionOnlineUrl, versionLocalPath);
        }

        // Local version
        String pathEx = getAppDataDirLocal(AppDirName + "\\" + versionLocalPath);
        String versionLocal = readFile(pathEx);


        // We copy online file to local if it doesnt exist or it's an old version
        if (!jarLocal.exists()) {
            downloadFileToLocal(JarURL, JarName);
        } else if(!versionLocal.equals(versionOnline)) {
            // Delete local jar
            jarLocal.delete();
            // Download online jar
            downloadFileToLocal(JarURL, JarName);
            // Delete local version
            versionLocalFile.delete();
            // Download local version
            downloadFileToLocal(versionOnlineUrl, versionLocalPath);
        }
    }


    /**
     * download an online file to local
     */
    private static void downloadFileToLocal(String url, String file) {
        try {
            URL onlineFileUrl = new URL(url);
            HttpURLConnection onlineFileHttp = (HttpURLConnection) onlineFileUrl.openConnection();
            InputStream onlineFileStream = onlineFileHttp.getInputStream();
            String path = getAppDataDirLocal(AppDirName) + "\\" + file;
            Files.copy(onlineFileStream, Paths.get(path));
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
            return writer.toString();
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