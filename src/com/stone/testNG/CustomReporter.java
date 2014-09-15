package com.stone.testNG;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.TestResult;
import org.testng.xml.XmlSuite;

public class CustomReporter implements IReporter {
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		// Iterating over each suite included in the test
		for (ISuite suite : suites) {
			// Following code gets the suite name
			String suiteName = suite.getName();
			// Getting the results for the said suite
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();
				System.out.println("Passed tests for suite '" + suiteName + "' is:" + tc.getPassedTests().getAllResults().size());
				System.out.println("Failed tests for suite '" + suiteName + "' is:" + tc.getFailedTests().getAllResults().size());
				System.out.println("Skipped tests for suite '" + suiteName + "' is:" + tc.getSkippedTests().getAllResults().size());	
				
				Set<ITestResult> set = tc.getPassedTests().getAllResults();
				for(ITestResult r : set){
					System.out.println(r.getName());
					System.out.println(r.getTestName());
					System.out.println(r.getInstanceName());
					System.out.println(r.getMethod().getMethodName());
					System.out.println(r.getClass().getCanonicalName());
				}
				
//				ITestResult faked = new TestResult();

			}
			
			Set<String> keySet = suiteResults.keySet();
			for(String key : keySet){
				System.out.println("key=" + key);
				System.out.println("value=" + suiteResults.get(key));
			}
			//suite.getResults()
		}
	}
}
