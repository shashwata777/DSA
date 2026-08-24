public class queuebyarray {

    int[] arr;
    int front;
    int rear;
    int size;

    queuebyarray(int size) {
        arr = new int[size];
        front = 0;
        rear = -1;
        this.size = size;
    }

    void enqueue(int value) {
        if (rear == size - 1) {
            System.out.println("Queue is full");
            return;
        }

        rear++;
        arr[rear] = value;
    }

    int dequeue() {
        if (front > rear) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = arr[front];
        front++;
        return value;
    }

    void display() {
        if (front > rear) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        queuebyarray q = new queuebyarray(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.display();

        System.out.println("Removed: " + q.dequeue());

        q.display();

        q.enqueue(50);

        q.display();
    }
}