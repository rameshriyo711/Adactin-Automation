package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	/**
	 * @see maintains to generate json to jvm report
	 * @param jsonFile
	 */
	public static void generatejvmreport(String jsonFile) {

		File file = new File("C:\\Users\\Ramesh Riyo\\eclipse-workspace\\OmrBranchAutomation\\target");

		Configuration config = new Configuration(file, "Adactin automation");

		config.addClassifications("Browser", "chrome");

		List<String> li = new ArrayList<String>();

		li.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(li, config);

		builder.generateReports();

	}
}
