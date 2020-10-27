package com.bridgelabz.java.EmployeeWage;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeWage {

	String CompanyName;
	int empWagePerHour;
	int workingDaysInMonth;
	int workingHoursinMonth;
	int totalMonthlyWage;

	public EmployeeWage(String CompanyName, int empWagePerHour, int workingHoursinMonth, int workingDaysInMonth) {
		this.CompanyName = CompanyName;
		this.empWagePerHour = empWagePerHour;
		this.workingDaysInMonth = workingDaysInMonth;
		this.workingHoursinMonth = workingHoursinMonth;
		this.totalMonthlyWage = empWageForMonth(this.CompanyName, this.empWagePerHour, this.workingHoursinMonth,
				this.workingDaysInMonth);

	}

	public static void main(String[] args) {
		System.out.println(
				"-------------------------Welcome to Employee Wage Computation Problem-------------------------");
		Scanner sc = new Scanner(System.in);
		String companyName = null;
		ArrayList<Object> saveCompanyWiseWage = new ArrayList<Object>();
		int numOfObjects = 0;
		System.out.println("Enter how many objects you want to add");
		numOfObjects = sc.nextInt();
		for (int i = 0; i < numOfObjects; i++) {
			System.out.println("Enter company name");
			companyName = sc.next();
			System.out.println("Enter Working days in a month");
			int workingDaysInMonth = sc.nextInt();
			System.out.println("Enter Working hours in a month");
			int workingHoursinMonth = sc.nextInt();
			System.out.println("Enter emp wage per hour");
			int empWagePerHour = sc.nextInt();
			EmployeeWage emp = new EmployeeWage(companyName, empWagePerHour, workingHoursinMonth, workingDaysInMonth);
			saveCompanyWiseWage.add(emp);
		}
		for (Object emp : saveCompanyWiseWage) {
			System.out.println(emp);
		}
		sc.close();
	}

	public String toString() {
		return "employee Wage for the CompanyName:\t" + CompanyName + "\tis\t" + totalMonthlyWage;

	}

	public static int empWageForMonth(String CompanyName, int empWagePerHour, int workingHoursinMonth,
			int workingDaysInMonth) {
		int end = 0;
		int empHrs = 0;
		int empDailyWage = 0;
		int totalEmpDays = 0;
		int totalHrs = 0;
		int totalMonthlyWage = 0;
		while (end >= 0) {
			++totalEmpDays;
			int attendance = (int) (Math.floor(Math.random() * 10) % 3);
			System.out.println("\n" + attendance);
			switch (attendance) {
			case 0:
				empHrs = 0;
				System.out.println("Employee is absent");
				System.out.println();
				break;
			case 1:
				System.out.println("Employee is present");
				System.out.println();
				empHrs = 8;
				break;
			case 2:
				System.out.println("Employee is present for Part time");
				System.out.println();
				empHrs = 4;
				break;
			}
			totalHrs += empHrs;
			empDailyWage = empWagePerHour * empHrs;
			System.out.println("\nEmployee's salary for the day is " + empDailyWage);
			totalMonthlyWage += empDailyWage;
			if (totalEmpDays == workingDaysInMonth || totalHrs == workingHoursinMonth) {
				break;
			}
		}
		return totalMonthlyWage;
	}
}
