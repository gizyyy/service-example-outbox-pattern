# service-example-outbox-pattern
An alternative outbox pattern implementation

Project uses @TransactionalEventlistener and AggregateRoot support of Spring in order to implement an outbox pattern around DDD approach.

@TransactionalEventListener has different phases. This project subjects a use case that I faced in real life project.

Scenario:

1) Service supposed to listen an event from outside world.
2) Supposed to make some projection or calculations around it and create it's own aggregate and persist.
3) This aggregate is a domain object which is inside of this service's bounded context responsibilty.
4) Service is supposed to inform outside world about the aggregate which is persisted. ( via transactionaleventlistener BEFORE_COMMIT)
5) After emission of this event, service is supposed to execute a logic and can do another job(if its a db persist again, should be considered to use transactional around), this is being tracked by AFTER_COMPLATION block.

With this way, db change and emission of Event Carried State Transfer is bounded to each other and if one fails, the other one will not work too.

AFTER_COMPLETATION block will work when those two successfully works. Undepended from their transaction boundries.
