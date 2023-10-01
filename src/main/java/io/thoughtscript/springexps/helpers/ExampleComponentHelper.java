package io.thoughtscript.springexps.helpers;

import io.thoughtscript.springexps.dtos.Example;
import io.thoughtscript.springexps.dtos.ExampleListItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static io.thoughtscript.springexps.helpers.JvmHeapHelper.printHeap;

@Slf4j
@Component
public class ExampleComponentHelper {

    public Example testComponentHelper() throws InterruptedException {

        log.info("testComponentHelper");

        // Create in memory within the Component method.
        List<ExampleListItem> exampleList = new ArrayList<>();
        ExampleListItem exampleListItemA = new ExampleListItem("exampleListItemA");
        ExampleListItem exampleListItemB = new ExampleListItem("exampleListItemB");
        ExampleListItem exampleListItemC = new ExampleListItem("exampleListItemC");
        exampleList.add(exampleListItemA);
        exampleList.add(exampleListItemB);
        exampleList.add(exampleListItemC);
        Example example = new Example("example", exampleList);
        printHeap();

        return example;
    }
}
