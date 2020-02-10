package com.profectus.fishshop.interpreter;

public abstract class SymbolExpression implements Expression {

    protected Expression left = null;
    protected Expression right = null;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

}
