/*
 * @lc app=leetcode.cn id=1195 lang=java
 *
 * [1195] 交替打印字符串
 */

// @lc code=start
class FizzBuzz {
    private int curr = 1;

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (this.curr <= this.n) {
            synchronized(this) {
                if (this.curr % 3 == 0 && this.curr % 5 != 0) {
                    printFizz.run();
                    this.curr++;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (this.curr <= this.n) {
            synchronized(this) {
                if (this.curr % 3 != 0 && this.curr % 5 == 0) {
                    printBuzz.run();
                    this.curr++;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (this.curr <= this.n) {
            synchronized(this) {
                if (this.curr % 3 == 0 && this.curr % 5 == 0) {
                    printFizzBuzz.run();
                    this.curr++;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (this.curr <= this.n) {
            synchronized(this) {
                if (this.curr % 3 != 0 && this.curr % 5 != 0) {
                    printNumber.accept(this.curr);
                    this.curr++;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }
}
// @lc code=end

