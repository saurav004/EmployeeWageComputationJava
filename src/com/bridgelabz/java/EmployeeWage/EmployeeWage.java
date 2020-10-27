package com.bridgelabz.java.EmployeeWage;

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class EmployeeWage {
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;
	private final String company;
	private final int RATE_PER_HOUR;
	private final int workingDays;
	private final int maxHours;
	private int totalEmpWages; 
	
	public EmployeeWage(String company,int RATE_PER_HOUR,int workingDays,int maxHours) {
		this.company=company;
		this.RATE_PER_HOUR=RATE_PER_HOUR;
		this.workingDays=workingDays;
		this.maxHours=maxHours;
		}
	public void Calculation() {
		int empHours=0,totalEmpHours=0,totalWorkingDays=0;
		
		while(totalEmpHours<=maxHours && totalWorkingDays<workingDays) {
			totalWorkingDays++;
			int check=(int) (Math.floor(Math.random()*10)%3);
			switch(check) {
			 case IS_FULL_TIME : empHours=8;
			 					 break;
			 case IS_PART_TIME : empHours=4;
			 					 break;
			 default : empHours=0;
			}
			totalEmpHours+=empHours;
			//System.out.println("Day :"+totalWorkingDays+"Emp Hours :"+empHours);
			
		}
		//System.out.println("Total Employee work Hours :"+totalEmpHours);
		totalEmpWages=totalEmpHours*RATE_PER_HOUR;
	}
	
	@Override
	public String toString() {
		return "Total Emp Wage for Company :"+company+"is:"+totalEmpWages;
	}
	public static void main(String[] args) {
		System.out.println("========Welcome to Employee Wage Computation========");
		EmployeeWage fab=new EmployeeWage("Facebook",20,200,100);
		EmployeeWage app=new EmployeeWage("Apple",35,100,100);
		fab.Calculation();
		System.out.println(fab);
		app.Calculation();
		System.out.println(app);
	 }
}
class CompanyEmpWage {
	public final String company;
	public final int empRateperHour;
	public final int workingDays;
	public final int maxHours;
	public int totalEmpWage;
	
	public CompanyEmpWage(String company,int empRatePerHour,int workingDays,int maxHours) {
		this.company=company;
		this.empRateperHour=empRatePerHour;
		this.workingDays=workingDays;
		this.maxHours=maxHours;
	}
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage=totalEmpWage;
	}
	@Override
	public String toString() {
		return "Total Emp Wage for Company "+company+" is :"+totalEmpWage;
	}

}
interface IComputeEmpWage {
	public void addCompanyEmpWage(String company,int empRateperHour,int workingDays,int maxHours);
	public void computeEmpWage();
	}