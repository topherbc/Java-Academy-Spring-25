package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {
    private int employeeId;
    private String name, department;
    private double payRate, hoursWorked, startTime;
    private LocalDateTime timeStampPunchIn;

    public Employee(int employeeId, String name, String department, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0;
        this.startTime = -1;
    }

    public double getTotalPay() {
        return ((getRegularHours() * this.payRate) + (getOvertimeHours() * (this.payRate * 1.5)));
    }

    public double getPayRate() {
        return payRate;
    }

    public double getRegularHours() {
//        return Math.min(this.hoursWorked, 40);
        if (this.hoursWorked > 40) {
            return 40;
        } else {
            return this.hoursWorked;
        }
    }

    public double getOvertimeHours() {
//                return Math.max(this.hoursWorked-40, 0);
        if (this.hoursWorked > 40) {
            return this.hoursWorked-40;
        } else {
            return 0;
        }
    }

    public void punchIn(double time) {
        this.startTime = time;
    }

    public void punchOut(double time) {
        this.hoursWorked += time - this.startTime;
        this.startTime = -1;
    }

    public void punchIn() {
        LocalDateTime punchIn = LocalDateTime.now();
        this.startTime = (punchIn.getHour()) + (punchIn.getMinute() / 60);
    }

    public void punchOut() {
        LocalDateTime punchOut = LocalDateTime.now();
        double punchOutTime = (punchOut.getHour()) + (punchOut.getMinute() / 60);

        this.hoursWorked += punchOutTime - this.startTime;
        this.startTime = -1;
    }

    public void punchTimeCard(double time) {
        //exclamation point
        if (this.startTime == -1) {
            this.startTime = time;
        } else {
            this.hoursWorked += time - this.startTime;
            this.startTime = -1;
        }
    }
}
