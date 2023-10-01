package io.thoughtscript.springexps.services;

import io.thoughtscript.springexps.dtos.Example;
import io.thoughtscript.springexps.dtos.ExampleListItem;
import io.thoughtscript.springexps.helpers.ExampleComponentHelper;
import io.thoughtscript.springexps.helpers.ExampleStaticHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        System.gc();
        ExampleStaticHelper.testStaticHelper();
        exampleComponentHelper.testComponentHelper();
    }

}
