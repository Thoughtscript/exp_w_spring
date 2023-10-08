package io.thoughtscript.springexps.helpers;

import io.thoughtscript.springexps.dtos.Example;
import io.thoughtscript.springexps.dtos.ExampleListItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class ExampleComponentHelper {

    public Example testComponentHelper() {

        log.info("testComponentHelper");
        Date begin = new Date();

        // Create in memory within the Component method.
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

        long heapSize = Runtime.getRuntime().totalMemory();
        long heapMaxSize = Runtime.getRuntime().maxMemory();
        long heapFreeSize = Runtime.getRuntime().freeMemory();

        log.info("heapSize: {} heapMaxSize: {} heapFreeSize: {}", heapSize, heapMaxSize, heapFreeSize);

        return example;
    }
}
