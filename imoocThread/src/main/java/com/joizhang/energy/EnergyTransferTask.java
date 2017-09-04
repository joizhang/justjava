package com.joizhang.energy;

/**
 * Created by joizhang on 16-10-3.
 */
public class EnergyTransferTask implements Runnable {

    //共享的世界能量
    private EnergySystem energySystem;
    //能量转移源
    private int fromBox;
    //单次能量转移最大值
    private double maxAmount;
    //最大休眠时间（毫秒）
    private final int DELAY = 10;

    public EnergyTransferTask(EnergySystem energySystem, int fromBox, double maxAmount) {
        this.energySystem = energySystem;
        this.fromBox = fromBox;
        this.maxAmount = maxAmount;
    }

    public void run() {
        try {
            while (true) {
                int toBox = (int) (energySystem.getBoxAmount() * Math.random());
                double amount = maxAmount * Math.random();
                energySystem.transfer(fromBox, toBox, amount);

                Thread.sleep((long) (DELAY * Math.random()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
