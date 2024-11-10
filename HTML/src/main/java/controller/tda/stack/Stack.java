package controller.tda.stack;


public class Stack<E> {

    private StackOperation<E> stackOperation;

    public Stack(Integer cant) {
        stackOperation = new StackOperation<>(cant);
    }

    public Stack() {
        stackOperation = new StackOperation<>();
    }

    public void push(E data) throws Exception {
        stackOperation.push(data);
    }

    public Integer getSize() {
        return stackOperation.getSize();
    }

    public void clear() {
        this.stackOperation.reset();
    }

    public Integer getTop() {
        return this.stackOperation.getTop();
    }

    public E peek() {
        return this.stackOperation.peek();
    }

    public E pop() throws Exception {
        return stackOperation.pop();
    }

    public boolean isEmpty() {
        return stackOperation.isEmpty();
    }

    public void print() {
        System.out.println("PILA");
        System.out.println(stackOperation.toString());
        System.out.println("********");
    }

    @Override
    public String toString() {
        return stackOperation.toString();
    }

    public StackOperation<E> getStackOperation() {
        return stackOperation;
    }

    public void setStackOperation(StackOperation<E> stackOperation) {
        this.stackOperation = stackOperation;
    }
}
