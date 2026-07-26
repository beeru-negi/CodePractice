# System Design Mock Interview Q&A

## Advanced Solution Architect Practice

Use this file to practice spoken answers. Read the question, pause, answer aloud, then compare with the sample. The goal is to build structure, tradeoff thinking, and confidence under interview pressure.

---

## 1. How do you start a system design interview answer?

### Sample answer

I start by clarifying functional and non-functional requirements. Then I estimate scale, define the high-level architecture, and only after that drill into storage, caching, APIs, and failure handling. This helps me avoid solving the wrong problem or overengineering too early.

## 2. How do you design for uncertain growth?

### Sample answer

I choose a design that is simple today but preserves scaling options for later. That usually means stateless compute, externalized state, clean interfaces, strong observability, and avoiding tight coupling that would make future scaling difficult.

## 3. How do you choose between a monolith and microservices?

### Sample answer

I do not choose microservices by default. I look for clear needs such as independent scaling, team ownership boundaries, deployment independence, or technology differences. If those drivers are weak, a modular monolith is usually operationally simpler and safer.

## 4. What are the most common scaling bottlenecks?

### Sample answer

The most common bottlenecks are usually database pressure, chatty APIs, missing caches, blocking work on the request path, and poor observability that hides the true cause. I try to identify whether the problem is CPU, memory, IO, network, or coordination related before proposing a fix.

## 5. How do you make APIs more efficient?

### Sample answer

I reduce payload size, minimize round trips, paginate large results, cache read-heavy responses, and avoid pushing expensive aggregation work to the client. For writes, I care about idempotency, validation, and asynchronous handling of non-critical work.

## 6. How do you decide whether to use caching?

### Sample answer

I cache when read volume is high, latency matters, and the data changes less frequently than it is read. I always explain invalidation strategy, TTL, and fallback behavior, because caching without correctness discipline often creates subtle production bugs.

## 7. How do you handle cache invalidation?

### Sample answer

I pick the invalidation strategy based on the data freshness requirement. Some systems work well with simple TTLs. Others need event-driven invalidation or write-through updates. I also think about hot keys, stampede prevention, and how the system behaves during cache misses.

## 8. How do you scale a read-heavy system?

### Sample answer

I optimize the read path first with CDN caching, distributed caches, read replicas, precomputed views, and query optimization. I also check whether the API is returning more data than clients actually need.

## 9. How do you scale a write-heavy system?

### Sample answer

For write-heavy systems, I focus on efficient write paths, batching where appropriate, asynchronous downstream processing, and partitioning data by a stable key. I also try to minimize distributed coordination on the hot write path.

## 10. How do you separate critical and non-critical work?

### Sample answer

I identify what must succeed before the user can move on, such as order creation or payment authorization, and keep that on the synchronous path. Things like email, analytics, recommendation updates, or search indexing usually move to asynchronous consumers so failures there do not block the core action.

## 11. How do you design for failure?

### Sample answer

I assume dependencies will fail and design for isolation, timeouts, retries with backoff, circuit breakers, and graceful degradation. The goal is not to eliminate failure. The goal is to prevent localized failure from becoming a system-wide incident.

## 12. What is graceful degradation?

### Sample answer

Graceful degradation means the system continues delivering core functionality even if optional or non-critical parts fail. For example, checkout should continue even if recommendations or notification services are temporarily unavailable.

## 13. How do you handle retries safely?

### Sample answer

Retries should be bounded and should use exponential backoff with jitter. The underlying operation should be idempotent where possible, otherwise retries can cause duplicate side effects or retry storms that make outages worse.

## 14. How do you protect a system from overload?

### Sample answer

I use rate limiting, admission control, bounded queues, backpressure, circuit breakers, and request prioritization where needed. I want the system to fail in a controlled way instead of slowing down until everything collapses.

## 15. When do you shard a database?

### Sample answer

I shard when a single node can no longer handle the throughput, storage size, or contention, and when I have a stable partition key such as user ID or tenant ID. Sharding is powerful, but it adds complexity around routing, rebalancing, and cross-shard queries.

## 16. How do you choose SQL vs NoSQL?

### Sample answer

I base the choice on access patterns, consistency requirements, and data relationships. SQL fits relational, transactional systems well. NoSQL fits flexible schema and high-scale access patterns where denormalization is acceptable.

## 17. How do you design an efficient dashboard API?

### Sample answer

I avoid making the client call many small services and assemble data itself. Instead, I use an aggregated endpoint or backend-for-frontend pattern, shaped for the UI, and I precompute or cache expensive summary data where possible.

## 18. How do you reason about eventual consistency?

### Sample answer

I use eventual consistency where temporary lag is acceptable, such as feeds, search indexing, and analytics. I avoid it for financial correctness, inventory reservation, or operations where stale data creates real business risk.

## 19. How do you design observability into a system?

### Sample answer

I include structured logs, metrics for service health and saturation, distributed tracing, dashboards, and alerts from the beginning. I want enough telemetry to detect failure early and localize the bottleneck quickly.

## 20. How do you design for multi-region?

### Sample answer

I start by asking whether global low latency or region-level disaster recovery is actually required. Then I use RTO, RPO, user distribution, and consistency needs to decide between regional failover, warm standby, or active-active patterns.

## 21. How do you design a payment system?

### Sample answer

I focus first on correctness, idempotency, transaction durability, reconciliation, and provider failure handling. Only after that do I scale the system operationally. Payment systems are more about not charging twice and maintaining an audit trail than about raw traffic scale.

## 22. How do you design a social feed?

### Sample answer

I clarify whether the feed is chronological or ranked, then decide between fan-out on write, fan-out on read, or a hybrid model. Read performance is critical, so caching and precomputed feed entries often matter, but celebrity accounts can make pure fan-out on write expensive.

## 23. How do you design a search system?

### Sample answer

I separate the write path from the search path. Source data is written to the primary store, then indexed asynchronously into a search engine optimized for retrieval and ranking. I also discuss query latency, filter design, pagination, and eventual consistency.

## 24. How do you design a file upload service?

### Sample answer

I usually use signed upload URLs so large files go directly to object storage instead of through the main application servers. Then I trigger asynchronous scanning, transformation, and metadata updates through events or queues.

## 25. How do you deploy safely at scale?

### Sample answer

I use canary or blue-green deployment, feature flags, health-based rollback, and strong observability. The goal is to reduce exposure first, detect issues quickly, and reverse safely if the new version degrades the system.

## 26. What are signs a design is overengineered?

### Sample answer

If the solution introduces multiple distributed systems without a real scaling or reliability need, or if the team cannot reasonably operate the platform, it is probably overengineered. Good architecture should solve the problem at the right complexity level.

## 27. How do you talk about tradeoffs in an interview?

### Sample answer

I compare options across correctness, latency, scale, resilience, cost, and operational complexity. I explain why I chose one option and what cost or limitation I accepted in return. That is usually more valuable than pretending there is one perfect design.

## 28. How do you improve a slow API without changing the whole architecture?

### Sample answer

I first trace the latency source. Then I look at query optimization, indexing, payload reduction, request aggregation, caching, and moving non-critical work off the request path. I try low-complexity improvements before redesigning the system.

## 29. How do you explain blast radius reduction?

### Sample answer

I reduce blast radius by isolating dependencies, failure domains, worker pools, queues, data stores, and access boundaries. The goal is that one failing component or noisy workload cannot consume all shared resources and take down the entire platform.

## 30. What makes a system production-ready?

### Sample answer

Production readiness means more than functional correctness. The system needs observability, overload protection, deployment safety, rollback, security controls, recovery strategy, and operational simplicity. If a system works only when everything is healthy, it is not production-ready.

---

## Speaking Advice

- start with requirements before technology
- show how you think about tradeoffs
- separate critical path from optional work
- mention observability and rollout safety naturally
- keep the answer simple first, then deepen where asked