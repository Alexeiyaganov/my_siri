class Thread1 extends Thread
{
    @Override
    public void run()
    {
        System.out.print("Loading:");
        for (int i = 0; i < 1000; i++) {
            while(!Thread.currentThread().isInterrupted()){
                try{
                    sleep(500);
                    System.out.print("-");
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt(); // propagate interrupt
                }
            }
        }
    }
}
