package ch.ice.main;

import java.io.IOException;

import ch.ice.file.ExcelParser;

public class Main {

	public static void main(String[] args) throws IOException {
			ExcelParser.readRegisterFile();
			ExcelParser.readPOSFile();
	}
}
