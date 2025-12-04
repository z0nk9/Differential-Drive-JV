package org.sciborgs1155.robot.Drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj2.command.Command;


public class Drive {
    private DifferentialDrivetrainSim sim = new DifferentialDrivetrainSim(DCMotor.getNEO(2), 1/2, 1, 1, 1, 1, null);
    public Command drive(DoubleSupplier left, DoubleSupplier right) {
        return run(() -> sim.setInputs(left.getAsDouble(), right.getAsDouble()));
    }
}