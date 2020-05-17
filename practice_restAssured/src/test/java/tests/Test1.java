package tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Test1 {
	public static String GenerateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

	public static void main(String arg[]) throws IOException {
		String s=GenerateStringFromResource("D:/Testfile.txt");
		System.out.println(s);
	}

}
