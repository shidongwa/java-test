package com.stone.hotswap2;

public class MsgHandler implements Runnable {

    @Override
    public void run() {
        while (true){
            BaseManager baseManager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            baseManager.logic();
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
