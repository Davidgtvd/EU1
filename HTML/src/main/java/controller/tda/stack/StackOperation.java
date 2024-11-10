package controller.tda.stack;

import controller.tda.list.ListEmptyException;
import controller.exception.OverFlowException;
import controller.tda.list.LinkedList;

public class StackOperation<E> extends LinkedList<E> {

    private Integer top;

    public StackOperation(Integer top) {
        this.top = top;
    }

    public StackOperation() {

    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    @Override
    public boolean isEmpty() {
        return getSize().equals(0);
    }

    public void push(E data) throws OverFlowException, IndexOutOfBoundsException, ListEmptyException {
        add(data, 0);

    }

    public E peek() {
        return this.getHead().getData();
    }

    public E pop() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Pila vacia");
        } else {
            return deleteHeader();
        }
    }
}

