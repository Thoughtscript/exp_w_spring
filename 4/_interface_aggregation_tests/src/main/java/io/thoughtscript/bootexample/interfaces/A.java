package io.thoughtscript.bootexample.interfaces;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public interface A {

    void voidMethod();

    @Slf4j
    class D implements A {
        String x;

        public D (String x) {
            this.x = x;
        }

        @Override
        public void voidMethod() {
            log.info(this.x);
        }
    }

    @Slf4j
    @Component
    class G extends B.E {
        public void test() {
            super.voidMethod();
        }
    }

    interface B extends A {

        @Slf4j
        @NoArgsConstructor
        class C implements B {

            private static String name;

            private static final String staticName = "staticName";

            private final D d = new D("y");

            public void setName(String name) {
                this.name = name;
            }

            public String getName() {
                return this.name;
            }

            public static void getStaticName() {
                log.info(staticName);
            }

            @Override
            public void voidMethod() {
                this.d.voidMethod();
                setName(this.d.x);
                log.info(getName());
            }
        }

        @Slf4j
        @Component
        @Primary
        class E implements B {
            @Override
            public void voidMethod() {
                log.info("e");
            }
        }

        @Slf4j
        class F extends C {

            public F () {
                super.setName("f");
            }

            public void test() {
                super.voidMethod();
            }
        }
    }
}
