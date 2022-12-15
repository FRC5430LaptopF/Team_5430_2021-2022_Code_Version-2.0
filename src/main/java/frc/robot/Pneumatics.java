
package frc.robot;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class Pneumatics implements Runnable{
  //originally 2,5 | 3,4
    //After Module Type, the first port is seen by the code as kForwards and the second port is seen as kBackwards.
    DoubleSolenoid solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2,4); //bottpm solenoid
    DoubleSolenoid solenoidB = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3, 5); //top solenoid
    Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    //Below code checks whether the compressor is enabled, the presure switch's value, and the current of the Compressor.
  boolean enabled = compressor.enabled();
  boolean pressureSwitch = compressor.getPressureSwitchValue();
  double current = compressor.getCurrent();
  
    static boolean loop = true;

  public void run() {
   // ((Object) compressor).clearAllPCMStickyFaults();
    solenoid.set(Value.kForward);
    solenoidB.set(Value.kReverse); // << Jio edit, Also sets solenoid channel to kForward
    while (loop) {
      if (Robot.joystickButton(2)) {
        while (Robot.joystickButton(2)) {
        }
        solenoid.toggle(); // Swaps active solenoid channel.
        solenoidB.toggle(); // << Jio edit, Also swaps solenoid channel of second Solenoid

      }
      
      // Below code checks whether the compressor is enabled, the presure switch's
      // value, and the current of the Compressor.
      enabled = compressor.enabled();
      pressureSwitch = compressor.getPressureSwitchValue();
      current = compressor.getCurrent();

    }
  }

  public static void stopper() {
    loop = false;
    }
}