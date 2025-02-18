package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp
public class Mclaw extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException{
        // Declare our motors
        // Make sure your ID's match your configuration
        // TODO: change hardware IDs to match variable names
        // TODO: fix drift by tweaking some values
        DcMotor mMotor = hardwareMap.dcMotor.get("somethingBetter"); // arm
        Servo mServo = hardwareMap.servo.get("badThing"); //claw

        DcMotor motorFrontRight = hardwareMap.dcMotor.get("Front Right"); //
        DcMotor motorBackRight = hardwareMap.dcMotor.get("Back Right");   //
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("Front Left"); //
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("Back Left");   //


        motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
        motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();
        while (opModeIsActive()){

            double position = 0;
            double armPower = 0;

            if(gamepad1.left_bumper){
                position = 0;
                mServo.setPosition(position);
            }
            if(gamepad1.right_bumper){
                position = 0.6;
                mServo.setPosition(position);
            }

            if(gamepad1.left_trigger != 0) {
                armPower = -0.25;
            } else if(gamepad1.right_trigger != 0){
                armPower = 0.6;
            } else {
                armPower = 0;
            }
            mMotor.setPower(armPower); //hi

            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;
            //we can fix controls eventually

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            // This is the math to get your rotating and driving and etc
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (Math.pow((y + x + rx),3) * 1.0) / denominator;
            double backLeftPower = (Math.pow((y - x + rx),3) * 1.0) / denominator;
            double frontRightPower = (Math.pow((y - x - rx),3) * 1.0) / denominator;
            double backRightPower = (Math.pow((y + x - rx),3) * 1.0) / denominator;

            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower);

        }
    }
}