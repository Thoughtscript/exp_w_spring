package io.thoughtscript.bootexample.services;

import io.thoughtscript.bootexample.interfaces.A;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExampleService {

    @Autowired
    A.B.E e;

    @Autowired
    A.G g;

    private final A.D d = new A.D("d");

    public String example() {
        log.info("======== Non-Static Tests ========");
        A.B.C c = new A.B.C();
        c.voidMethod();
        A.B.F f = new A.B.F();
        f.test();

        log.info("======== Field Injection Tests ========");
        d.voidMethod();

        log.info("======== Bean Injection Tests ========");
        e.voidMethod();
        g.test();

        log.info("======== Static Tests ========");
        A.B.C.getStaticName();

        return "done";
    }
}
