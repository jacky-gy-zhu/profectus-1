package com.profectus.fishshop.interpreter;

public class OrExpression extends SymbolExpression {

    public OrExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public boolean interpret(String context) {
        return left.interpret(context) || right.interpret(context);
    }

}
