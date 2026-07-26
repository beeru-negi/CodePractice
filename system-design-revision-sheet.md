# System Design Revision Sheet

## Quick Interview Flow

1. clarify requirements
2. estimate scale
3. define high-level architecture
4. identify bottlenecks
5. explain scaling strategy
6. explain resilience strategy
7. cover observability, security, and rollout
8. summarize tradeoffs

## Core Principles

- keep compute stateless where possible
- isolate critical and non-critical paths
- scale horizontally before adding unnecessary complexity
- cache only with a clear invalidation strategy
- treat overload and failure as normal design conditions
- choose consistency level based on business need
- keep production telemetry built in from day one

## Diagrams To Remember

### Stateless Scaling

```mermaid
flowchart LR
    User[User] --> LB[Load Balancer]
    LB --> API1[API 1]
    LB --> API2[API 2]
    LB --> API3[API 3]
    API1 --> Cache[Cache]
    API2 --> Cache
    API3 --> Cache
    Cache --> DB[(Database)]
```

Memory point:

Scale the stateless tier horizontally and protect the database with caching.

### Cache-Aside

```mermaid
flowchart TD
    Client[Client] --> API[API]
    API --> Cache{Hit?}
    Cache -->|Yes| Response[Fast Response]
    Cache -->|No| DB[(Database)]
    DB --> API
    API --> Cache
```

Memory point:

Good for read-heavy systems. Always discuss TTL and invalidation.

### Async Processing

```mermaid
flowchart LR
    Client[Client] --> API[API]
    API --> Queue[Queue]
    API --> Ack[Fast Ack]
    Queue --> Worker1[Worker 1]
    Queue --> Worker2[Worker 2]
    Worker1 --> Store[(Storage)]
    Worker2 --> Store
```

Memory point:

Keep the request path small. Move heavy work to workers.

### Event-Driven Flow

```mermaid
flowchart LR
    OrderAPI[Order API] --> OrderDB[(Order DB)]
    OrderAPI --> Bus[Event Bus]
    Bus --> Email[Email Consumer]
    Bus --> Analytics[Analytics Consumer]
    Bus --> Shipping[Shipping Consumer]
```

Memory point:

Critical write first. Non-critical downstream actions should be decoupled.

### Rate Limiting

```mermaid
flowchart LR
    Client[Client] --> Gateway[Gateway]
    Gateway --> Limit{Allowed?}
    Limit -->|Yes| Service[Service]
    Limit -->|No| Reject[429]
```

Memory point:

Protect expensive services before overload reaches them.

### Circuit Breaker

```mermaid
flowchart LR
    API[API] --> CB{Circuit Breaker}
    CB -->|Closed| Downstream[Downstream]
    CB -->|Open| Fallback[Fallback]
```

Memory point:

Stop repeated failing calls from cascading across the system.

### Sharding

```mermaid
flowchart LR
    App[App] --> Router[Shard Router]
    Router --> S1[(Shard 1)]
    Router --> S2[(Shard 2)]
    Router --> S3[(Shard 3)]
```

Memory point:

Shard only when a single node is no longer enough. Be ready to discuss hot shards and cross-shard queries.

## Fast Tradeoff Table

- SQL: strong consistency, joins, transactions
- NoSQL: flexible schema, high scale, simpler access patterns
- Sync: immediate result, simpler user flow, higher latency pressure
- Async: better decoupling and resilience, more eventual consistency
- Cache: lower latency, less DB load, harder invalidation
- Sharding: more scale, more operational complexity
- Microservices: team and scaling flexibility, more coordination cost
- Monolith: simpler operations, weaker independent scaling at large size

## High-Value Phrases

- I want to clarify the read-write ratio before choosing a data strategy.
- I would keep the critical path small and move optional work asynchronously.
- I would design for graceful degradation instead of assuming every dependency stays healthy.
- I would validate scaling decisions with bottleneck analysis and telemetry.
- I would choose the simplest design that safely meets the reliability target.

## Bottlenecks Checklist

- CPU-bound?
- memory-bound?
- network-bound?
- IO-bound?
- database-bound?
- coordination-bound?

## Final Pre-Interview Checklist

- vertical vs horizontal scaling
- cache-aside vs write-through
- read replicas vs sharding
- sync vs async workflows
- idempotency and retries
- rate limiting and overload protection
- circuit breaker and graceful degradation
- metrics, logs, traces
- canary vs blue-green deployment
- RTO and RPO