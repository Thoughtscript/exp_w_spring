# README

## Sequential

Non-Concurrent Request Testing:

> `1000` Requests

- [_blocking_client_non_reactive](./Sequential-Non-Reactive-RestTemplate-Postman.json)
- [_webflux_web_client](./Sequential-WebFlux-Postman.json)
- [_reactive_web_client_non_reactive](./Sequential-Reactive-Web-Client-Non-Reactive-App-Postman.json)

Interesting:

| Fully Reactive | Blocking Client Non Reactive | Reactive WebClient in Non Reactive |
| --- | --- | --- |
| 33127 | 33210 | 28097 |

Slightly counter-intuitive: The hybrid of the two outperformed the others in sequential Requests.

There's almost no difference between a fully Reactive and Non-Reactive ("blocking") app. That might be partly explained by the fact that Reactive apps benefit more from concurrent back-pressure.

## Concurrent

Concurrent Request Testing:

> `20 Virtual Users`, `5 Minutes`, `Fixed Ramp Up`

- [_blocking_client_non_reactive](./Concurrent-Non-Reactive-RestTemplate-Postman.pdf)
- [_webflux_web_client](./Concurrent-WebFlux-Postman.pdf)
- [_reactive_web_client_non_reactive](./Concurrent-Reactive-Web-Client-Non-Reactive-App-Postman.pdf)


| Combination | Throughput | Avg. Response Time |
| --- | --- | --- |
| Fully Reactive  | 17.73 | 31 |
| Blocking Client Non Reactive | 17.75 | 30 |
| Reactive WebClient in Non Reactive | 17.74 | 30 |

Almost the same. Curious. Possible explanations:

* Low concurrent user count (perhaps too low for more noticeable Reactive performance gains to kick in).
* Most performance gains here might be more beneficially gained in terms of tweaks to serialization and not in terms of swapping out the client that's used.