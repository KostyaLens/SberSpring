package org.example;

import lombok.NonNull;

@CustomInherited(daysWeek = 5)
class Child2 extends ParentClass {
    @CustomRepeatable(hour = 11, description = "child2", priority = 4)
    public void method(@NonNull DataContainer dataContainer) {
        dataContainer.setAct(false);
        System.out.println(dataContainer.isAct());
    }

    @Override
    void method1(@NonNull DataContainer dataContainer) {
    }
}