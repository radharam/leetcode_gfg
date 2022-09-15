class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private boolean printf = true;
    public void foo(Runnable printFoo) throws InterruptedException {
        
       
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            
        for(int i = 0; i < n; i++) {
            synchronized(this) {
                if(!printf) {
                    this.wait();
                }

                printFoo.run();
                printf = false;
                this.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized(this) {
                
                if(printf) {
                    this.wait();
                }
                
                printBar.run();
                printf = true;
                this.notifyAll();
            }
        	
        }
    }
}