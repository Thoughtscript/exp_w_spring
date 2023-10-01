package io.thoughtscript.springexps.helpers;

import io.thoughtscript.springexps.dtos.Example;
import io.thoughtscript.springexps.dtos.ExampleListItem;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static io.thoughtscript.springexps.helpers.JvmHeapHelper.printHeap;

@Slf4j
public class ExampleStaticHelper {

    public static Example testStaticHelper() throws InterruptedException {

        log.info("testStaticHelper");
        Date begin = new Date();

        // Create in memory within the static method.
        List<ExampleListItem> exampleList = new ArrayList<>();
        ExampleListItem exampleListItemA = new ExampleListItem("exampleListItemA");
        ExampleListItem exampleListItemB = new ExampleListItem("exampleListItemB");
        ExampleListItem exampleListItemC = new ExampleListItem("exampleListItemC");
        exampleList.add(exampleListItemA);
        exampleList.add(exampleListItemB);
        exampleList.add(exampleListItemC);
        Example example = new Example("example", exampleList);

        Date end = new Date();
        log.info("Time taken {}", end.getTime() - begin.getTime());
        printHeap();

        return example;
    }
}
