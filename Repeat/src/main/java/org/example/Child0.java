package org.example;

import lombok.NonNull;

class Child0 extends ParentClass {
    @CustomRepeatable(hour = 21, description = "child0", priority = 2)
    public void method(@NonNull DataContainer dataContainer) {
        dataContainer.setName("Арнольд");
        System.out.println(dataContainer.getName());

    }

    @CustomRepeatable(hour = 21, description = "child0", priority = 1)
    public void method1(@NonNull DataContainer dataContainer) {
        dataContainer.setName("Игорь");
        System.out.println(dataContainer.getName());
    }
}