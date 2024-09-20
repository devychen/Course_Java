package lab11;

/**
 * @author: mkz
 *
 * Task: A programme to generate Exceptions for us,
 *      all we need is class name + default msg.
 *
 */


import java.io.*;     // BufferedReader, FileReader, IOException, etc

public class ExceptionGenerator {

    public static void main(String[] args) {
        // 1. Check for the correct number of command line arguments
        if (args.length != 1) {
            System.out.println("Usage: java ExceptionGenerator <input-file>");
            return;
        }

        // WHY: `args`指的是命令行参数。
        //  当你从命令行运行Java程序时，你可以在命令后面输入一些参数，这些参数会被传递给程序中的`main`方法。
        //  `args`是一个字符串数组，包含了这些命令行参数。
        //  `args[0]`是你在命令行中提供的第一个参数，它可以是文件名、路径、或者任何你需要传递给程序的字符串。

        // 2. Open the input file with filename given in args[0]
        String fileName = args[0];

        // 3. For every line in the input file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                // 3.1. Read a line
                String line;

                // 3.2. Create name of the new exception class
                while ((line = br.readLine()) != null){
                    String exceptionName;
                    String exceptionMessage;
                    String outputFileName;
                    if (!line.contains("Exception")) {
                        // 3.2. Create name of the new exception class
                        exceptionName = line.replaceAll("\\s", "") + "Exception";
                        exceptionMessage = line + "\\s" + "Exception";
                    } else {
                        exceptionName = line.replaceAll("\\s", "");
                        exceptionMessage = line;
                    }

                    // 3.3. Create name of the output file
                    outputFileName = exceptionName + ".java";

                    // 3.4. Create output file for the Java code
                    try(PrintWriter writer = new PrintWriter(outputFileName)){
                        // 3.5. Write code to the output file
                        writer.println("public class " + exceptionName + " extends Exception {");
                        writer.println("    public " + exceptionName + "() {");
                        writer.println("        super(\"" + exceptionMessage + "\");");
                        writer.println("    }");
                        writer.println("}");

                        // 3.6. Close the output file
                        writer.close();
                        System.out.println("Exception generated: " + outputFileName);

                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                        System.exit(0);
                    }
                }

                // close the input file
                br.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
