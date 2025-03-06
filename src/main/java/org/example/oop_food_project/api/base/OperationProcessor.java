package org.example.oop_food_project.api.base;

public interface OperationProcessor<Input, Output> {

    Output process(Input input);
}
