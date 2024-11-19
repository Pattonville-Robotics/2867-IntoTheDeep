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
        DcMotor mMotor = hardwareMap.dcMotor.get("somethingBetter"); // port 0 on expansion hub
        Servo mServo = hardwareMap.servo.get("badThing"); // port 0

        waitForStart();
        while (opModeIsActive()){
            mMotor.setPower(0.4);
            double position = 0;

            if(gamepad1.left_bumper){
                position = -.1;
            }
            if(gamepad1.right_bumper){
                position = .1;
            }
            mServo.setPosition(position);

        }
    }
}