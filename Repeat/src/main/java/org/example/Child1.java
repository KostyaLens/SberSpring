package org.example;

import lombok.NonNull;

class Child1 extends ParentClass {
    @CustomRepeatable(hour = 12, description = "child1", priority = 1)
    public void method(@NonNull DataContainer dataContainer) {
        dataContainer.setYear(32);
        System.out.println(dataContainer.getYear());
    }

    @CustomRepeatable(hour = 21, description = "child1", priority = 1)
    public void method1(@NonNull DataContainer dataContainer) {
        dataContainer.setName("Слава");
        System.out.println(dataContainer.getName());
    }

}
