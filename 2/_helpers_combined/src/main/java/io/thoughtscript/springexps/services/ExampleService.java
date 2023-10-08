package io.thoughtscript.springexps.services;

import io.thoughtscript.springexps.dtos.Example;
import io.thoughtscript.springexps.dtos.ExampleListItem;
import io.thoughtscript.springexps.helpers.ExampleComponentHelper;
import io.thoughtscript.springexps.helpers.ExampleStaticHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static io.thoughtscript.springexps.helpers.JvmHeapHelper.printHeap;

@Slf4j
@Service
public class ExampleService {

    @Autowired
    ExampleComponentHelper exampleComponentHelper;

    public Example getAllExamples() {
        List<ExampleListItem> exampleList = new ArrayList<>();
        ExampleListItem exampleListItemA = new ExampleListItem("exampleListItemA");
        ExampleListItem exampleListItemB = new ExampleListItem("exampleListItemB");
        ExampleListItem exampleListItemC = new ExampleListItem("exampleListItemC");
        exampleList.add(exampleListItemA);
        exampleList.add(exampleListItemB);
        exampleList.add(exampleListItemC);
        Example example = new Example("example", exampleList);
        return example;
    }

    public void TestHelpers() throws InterruptedException {
        printHeap();
        ExampleStaticHelper.testStaticHelper();
        exampleComponentHelper.testComponentHelper();
    }

}
