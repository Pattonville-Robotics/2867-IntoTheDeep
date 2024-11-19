/*
package org.firstinspires.ftc.teamcode;
//this stuff, the packages and imports, don't worry about, it's just how we get robotics specific
// methods and variables such as motors
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//based stolen code is based and demure and postmodern
@TeleOp
public class JMecanum extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        // Declare our motors
        // Make sure your ID's match your configuration, the strings are important
        // The strings need to match on the driver station in order for it to line up correctly
        // TODO: change hardware IDs to match variable names
        // TODO: fix drift by tweaking some values

        DcMotor motorFrontRight = hardwareMap.dcMotor.get("Front Right"); //
        DcMotor motorBackRight = hardwareMap.dcMotor.get("Back Right");   //
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("Front Left"); //
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("Back Left");   //


        motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
        motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();
        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;
            //we can fix controls eventually

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            // This is the math to get your rotating and driving and etc
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (Math.pow((y + x + rx), 3) * 0.8) / denominator;
            double backLeftPower = (Math.pow((y - x + rx), 3) * 0.8) / denominator;
            double frontRightPower = (Math.pow((y - x - rx), 3) * 0.8) / denominator;
            double backRightPower = (Math.pow((y + x - rx), 3) * 0.8) / denominator;

            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower);

        }

        DcMotor mMotor = hardwareMap.dcMotor.get("somethingBetter"); // port 0 on expansion hub
        Servo mServo = hardwareMap.servo.get("badThing"); // port 0

        waitForStart();
        while (opModeIsActive()) {

            double position = 0;

            if (gamepad1.left_bumper) {
                position = -.1;
            }
            if (gamepad1.right_bumper) {
                position = .1;
            }
            mServo.setPosition(position);

        }
    }
}
*/
