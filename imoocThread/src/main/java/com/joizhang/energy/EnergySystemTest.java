package com.joizhang.energy;

/**
 * 争用条件
 * 当多个线程同时共享访问同一数据（内存区域）时，每个线程都
 * 尝试操作该数据，从而导致数据被破坏（corrupted）,这种现
 * 象被称为争用条件
 */
public class EnergySystemTest {

    //将要构建的能量世界中能量盒子数
    private static final int BOX_AMOUNT = 100;
    //每个盒子初始能量
    private static final double INITIAL_ENERGY = 1000;

    public static void main(String[] args) {
        EnergySystem energySystem = new EnergySystem(BOX_AMOUNT, INITIAL_ENERGY);
        for (int i = 0; i < BOX_AMOUNT; i++) {
            EnergyTransferTask energyTransferTask = new EnergyTransferTask(energySystem, i, INITIAL_ENERGY);
            Thread thread = new Thread(energyTransferTask, "TransferThread_" + i);
            thread.start();
        }
    }
}
