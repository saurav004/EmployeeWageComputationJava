package com.bridgelabz.java.EmployeeWage;

import java.util.Scanner;

public class EmployeeWage {

	public static void main(String[] args) {
		System.out.println(
				"-------------------------Welcome to Employee Wage Computation Problem-------------------------");
		Scanner sc = new Scanner(System.in);
		String companyName = null;

		int exit = 0;
		while (exit == 0) {
			System.out.println("Enter your choice");
			System.out.println("1.\t EXIT\t 2.\t calculate Employee Wage");
			int choice1 = sc.nextInt();
			if (choice1 == 1) {
				exit = 1;
			} else {
				System.out.println("Enter company name");
				companyName = sc.next();
				System.out.println("Enter Working days in a month");
				int workingDaysInMonth = sc.nextInt();
				System.out.println("Enter Working hours in a month");
				int workingHoursinMonth = sc.nextInt();
				System.out.println("Enter emp wage per hour");
				int empWagePerHour = sc.nextInt();
				empWageForMonth(companyName, workingDaysInMonth, workingHoursinMonth, empWagePerHour);
			}
		}
		sc.close();
	}

	public static void empWageForMonth(String CompanyName, int workingDaysInMonth, int workingHoursinMonth,
			int empWagePerHour) {
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
		System.out.println("Total Employee Hours: " + totalHrs + " total Employee days " + totalEmpDays);
		System.out.println();
		System.out.println("company name\t" + CompanyName);
		System.out.println();
		System.out.println("Employee's salary for the month is " + totalMonthlyWage);
		System.out.println();
	}
}
