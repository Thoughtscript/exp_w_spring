# Findings

`700` consecutive requests from Postman using [YourKit](https://www.yourkit.com/) Profiler and logging.

Static helpers appear to be a better choice in the following specific circumstances:
 
* Preference for memory optimization.
* Latency optimization.
* Less variance between Highest and Lowest Response Times.

Looks like `Components` win (but well-within the acceptable deviation/variability rates):

* With a slight gain in CPU performance.
* Better overall Response Times.

Common sense suggests one should use `Beans` sparingly. If one is not using a `Component`-Heavy Design Pattern necessitated by say `@Repository` `Classes` (e.g. - when working with persistent data that must be mapped via an Object-Relational Mapping Framework), one should probably prefer simply `Static Helpers` in the light of the above (barring certain specific considerations).

## Components

Using `@Component` based helpers only: 

`2023-10-07T21:08:33.944-05:00  INFO 21712 --- [nio-8080-exec-5] i.t.s.helpers.ExampleComponentHelper     : heapSize: 75497472 heapMaxSize: 8573157376 heapFreeSize: 46056608`

| Avg. CPU Time | Committed Memory | Used Memory | Heap Free (Logging) | Total Time (700 Request) | Avg. JSP Call Duration | Threads | 
| --- | --- | --- | --- | --- | --- | --- |
| 3.83%   |   72  | 27.78 | 46056608 | 1656 | 3 | 22 | 

## Static Helpers

Using `Static` helpers only: 

`2023-10-07T21:19:30.316-05:00  INFO 11816 --- [nio-8080-exec-5] i.t.s.helpers.ExampleStaticHelper        : heapSize: 79691776 heapMaxSize: 8573157376 heapFreeSize: 55739696`

| Avg. CPU Time | Committed Memory | Used Memory | Heap Free (Logging) | Total Time (700 Request) | Avg. JSP Call Duration | Threads | 
| --- | --- | --- | --- | --- | --- | --- |
| 4.97%   |   76  | 19.81 | 55739696 | 1783 | 2 | 22 | 

## Combined

Curious about the influence of GC - some possible advantages due to how `Bean`'s are loaded.

```
2023-10-07T20:54:11.711-05:00  INFO 17800 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 0 ms
2023-10-07T20:54:11.726-05:00  INFO 17800 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : heapSize: 75497472 heapMaxSize: 8573157376 heapFreeSize: 58207856
2023-10-07T20:54:11.727-05:00  INFO 17800 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Garbage collecting...
2023-10-07T20:54:11.756-05:00  INFO 17800 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Sleeping for 5s...
2023-10-07T20:54:16.761-05:00  INFO 17800 --- [nio-8080-exec-1] i.t.s.helpers.ExampleStaticHelper        : testStaticHelper
2023-10-07T20:54:16.762-05:00  INFO 17800 --- [nio-8080-exec-1] i.t.s.helpers.ExampleStaticHelper        : Time taken 1
2023-10-07T20:54:16.762-05:00  INFO 17800 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : heapSize: 58720256 heapMaxSize: 8573157376 heapFreeSize: 45785128
2023-10-07T20:54:16.762-05:00  INFO 17800 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Garbage collecting...
2023-10-07T20:54:16.789-05:00  INFO 17800 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Sleeping for 5s...
2023-10-07T20:54:21.802-05:00  INFO 17800 --- [nio-8080-exec-1] i.t.s.helpers.ExampleComponentHelper     : testComponentHelper
2023-10-07T20:54:21.802-05:00  INFO 17800 --- [nio-8080-exec-1] i.t.s.helpers.ExampleComponentHelper     : Time taken 0
2023-10-07T20:54:21.802-05:00  INFO 17800 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : heapSize: 41943040 heapMaxSize: 8573157376 heapFreeSize: 30602968
2023-10-07T20:54:21.802-05:00  INFO 17800 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Garbage collecting...
2023-10-07T20:54:21.822-05:00  INFO 17800 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Sleeping for 5s...
2023-10-07T20:54:33.599-05:00  INFO 17800 --- [nio-8080-exec-4] i.t.springexps.helpers.JvmHeapHelper     : heapSize: 41943040 heapMaxSize: 8573157376 heapFreeSize: 26816176
2023-10-07T20:54:33.600-05:00  INFO 17800 --- [nio-8080-exec-4] i.t.springexps.helpers.JvmHeapHelper     : Garbage collecting...
2023-10-07T20:54:33.621-05:00  INFO 17800 --- [nio-8080-exec-4] i.t.springexps.helpers.JvmHeapHelper     : Sleeping for 5s...
2023-10-07T20:54:38.627-05:00  INFO 17800 --- [nio-8080-exec-4] i.t.s.helpers.ExampleStaticHelper        : testStaticHelper
2023-10-07T20:54:38.627-05:00  INFO 17800 --- [nio-8080-exec-4] i.t.s.helpers.ExampleStaticHelper        : Time taken 0
2023-10-07T20:54:38.627-05:00  INFO 17800 --- [nio-8080-exec-4] i.t.springexps.helpers.JvmHeapHelper     : heapSize: 41943040 heapMaxSize: 8573157376 heapFreeSize: 30240928
2023-10-07T20:54:38.627-05:00  INFO 17800 --- [nio-8080-exec-4] i.t.springexps.helpers.JvmHeapHelper     : Garbage collecting...
2023-10-07T20:54:38.648-05:00  INFO 17800 --- [nio-8080-exec-4] i.t.springexps.helpers.JvmHeapHelper     : Sleeping for 5s...
2023-10-07T20:54:43.651-05:00  INFO 17800 --- [nio-8080-exec-4] i.t.s.helpers.ExampleComponentHelper     : testComponentHelper
2023-10-07T20:54:43.651-05:00  INFO 17800 --- [nio-8080-exec-4] i.t.s.helpers.ExampleComponentHelper     : Time taken 0
2023-10-07T20:54:43.651-05:00  INFO 17800 --- [nio-8080-exec-4] i.t.springexps.helpers.JvmHeapHelper     : heapSize: 41943040 heapMaxSize: 8573157376 heapFreeSize: 30242296
2023-10-07T20:54:43.651-05:00  INFO 17800 --- [nio-8080-exec-4] i.t.springexps.helpers.JvmHeapHelper     : Garbage collecting...
2023-10-07T20:54:43.673-05:00  INFO 17800 --- [nio-8080-exec-4] i.t.springexps.helpers.JvmHeapHelper     : Sleeping for 5s...

```