package com.github.andrejpetras.insights.zeebe;

import io.quarkiverse.zeebe.JobWorker;
import io.quarkiverse.zeebe.Variable;
import io.quarkiverse.zeebe.VariablesAsType;
import io.quarkus.logging.Log;

public class ParameterJobWorker {

    @JobWorker(type = "create-parameter")
    public Parameter createParameter(@Variable("inputName") String name, @Variable String inputValue) {
        Parameter parameter = new Parameter();
        parameter.name = name;
        parameter.value = inputValue;
        return parameter;
    }

    @JobWorker(type = "update-description")
    public Parameter createParameter(@VariablesAsType Parameter parameter) {
        parameter.description = parameter.name + "/" + parameter.value;
        return parameter;
    }

    @JobWorker(type = "println-parameter")
    public void printlnParameter(@VariablesAsType Parameter parameter) {
        Log.infof("%s", parameter);
    }
}
