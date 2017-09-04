package com.joizhang.energy;

/**
 * 宇宙的能量系统
 * 遵循能量守恒定律
 * 能量不会凭空创生或小时，只会从一处转移到另一处
 */
public class EnergySystem {

    //能量盒子，能量储存的地方
    private final double[] energyBoxes;
    //锁
    private final Object lockObj = new Object();

    /**
     *
     * @param n 能量盒子的数量
     * @param initialEnergy 每个盒子初始含有的能量值
     */
    public EnergySystem(int n, double initialEnergy) {
        energyBoxes = new double[n];
        for (int i = 0; i < energyBoxes.length; i++) {
            energyBoxes[i] = initialEnergy;
        }
    }

    /**
     * 能量转移，从一个盒子到另一个盒子
     * 
     * @param from 能量源
     * @param to 能量终点
     * @param amount 能量值
     */
    public void transfer(int from, int to, double amount) {
        synchronized (lockObj) {
            /*if (energyBoxes[from] < amount) return;*/

            //while循环，保证条件不满足时任务会被条件阻挡，而不是继续竞争cpu资源
            //Wait set
            while (energyBoxes[from] < amount) {
                try {
                    lockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName());
            energyBoxes[from] -= amount;
            System.out.printf("从%d转移%10.2f单位能量到%d", from, amount, to);
            energyBoxes[to] += amount;
            System.out.printf(" 能量总和：%10.2f%n", getTotalEnergies());

            //唤醒所有在lockObj对象上等待的线程
            lockObj.notifyAll();
        }
    }

    /**
     * 获得能量总和
     * @return
     */
    private double getTotalEnergies() {
        double sum = 0;
        for (double amount : energyBoxes) {
            sum +=amount;
        }
        return sum;
    }

    public int getBoxAmount() {
        return energyBoxes.length;
    }
}
