package org.example;

import lombok.NonNull;

@CustomInherited(daysWeek = 6)
abstract class ParentClass {
    abstract void method(@NonNull DataContainer dataContainer);

    abstract void method1(@NonNull DataContainer dataContainer);
}
