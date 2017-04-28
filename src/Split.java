import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class Split {

    @Option(name = "-o", metaVar = "EncodingI", required = false, usage = "Input file encoding")
    private String outputFile;

    @Option(name = "-d", metaVar = "EncodingI", required = false, usage = "Input file encoding")
    private static Boolean changeName;

    @Option(name = "-l", metaVar = "EncodingI", required = false, usage = "Input file encoding")
    private Integer fileSizeString;

    @Option(name = "-c", metaVar = "EncodingI", required = false, usage = "Input file encoding")
    private Integer fileSizeSymbol;

    @Option(name = "-n", metaVar = "EncodingI", required = false, usage = "Input file encoding")
    private Integer fileQuantity;

    @Argument(required = true, metaVar = "OutputName", index = 0, usage = "Output file name")
    private String inputFile;


    public static void main(String[] args) {

        new Split().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar recoder.jar -ie EncodingI -oe EncodingO InputName OutputName");
            parser.printUsage(System.err);
            return;
        }
        if ((fileSizeString == null && fileSizeSymbol == null && fileQuantity == null)) System.out.println("Error");
        else if ((fileSizeString != null) && ((fileSizeSymbol != null) || (fileQuantity != null)))
            System.out.println("Error");
        else if ((fileSizeSymbol != null) && ((fileSizeString != null) || (fileQuantity != null)))
            System.out.println("Error");
        else if ((fileQuantity != null) && ((fileSizeSymbol != null) || (fileSizeString != null)))
            System.out.println("Error");
        if (outputFile == null) outputFile = "x";
        if (outputFile == "-") outputFile = inputFile;
        if (changeName == null) changeName = false;
        if (fileSizeString != null) AddHelperKt.fileSizeString(inputFile, outputFile, fileSizeString);
        if (fileSizeSymbol != null) AddHelperKt.fileSizeSymbol(inputFile, outputFile, fileSizeSymbol);
        if (fileQuantity != null) AddHelperKt.fileQuantity(inputFile, outputFile, fileQuantity);

    }

    /*private void processingFlags(String[] args) {
        /flag "-o"
        if (inputFile == null) inputFile = "x";
        if (inputFile == "-") inputFile = inputFile;

        /flag "-d"
        boolean nameFiles;
        if (changeName == null) nameFiles = false;
        else nameFiles = true;

        /flag "-l"
        if (fileSizeString == null) fileSizeString = 100;
    }*/

    public static Boolean getChangeName() {
        return changeName;
    }

}
