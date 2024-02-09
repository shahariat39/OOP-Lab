
public class Main {
    public static void main(String[] args) {
        class Philosopher extends Thread {
            private final int philosopherNumber;
            private final Object leftFork;
            private final Object rightFork;

            public Philosopher(int philosopherNumber, Object leftFork, Object rightFork) {
                this.philosopherNumber = philosopherNumber;
                this.leftFork = leftFork;
                this.rightFork = rightFork;
            }

            @Override
            public void run() {
                try {
                    while (true) {
                        // Thinking
                        System.out.println("Philosopher " + philosopherNumber + " is thinking.");

                        synchronized (leftFork) {
                            System.out.println("Philosopher " + philosopherNumber + " picked up left fork " + philosopherNumber);
                            synchronized (rightFork) {
                                // Eating
                                System.out.println("Philosopher " + philosopherNumber + " is eating spaghetti.");

                                // Simulating eating time
                                Thread.sleep(1000);
                            }
                            System.out.println("Philosopher " + philosopherNumber + " put down right fork " + ((philosopherNumber + 1) % 3));
                        }
                        System.out.println("Philosopher " + philosopherNumber + " put down left fork " + philosopherNumber);

                        // Simulating thinking time
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public class Main {
            public static void main(String[] args) {
                // Create forks
                Object[] forks = new Object[3];
                for (int i = 0; i < 3; i++) {
                    forks[i] = new Object();
                }

                // Create philosophers
                Philosopher[] philosophers = new Philosopher[3];
                for (int i = 0; i < 3; i++) {
                    philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % 3]);
                    philosophers[i].start();
                }
            }
        }
    }
}