# AWS Architect Interview Preparation Guide

## Scope

This guide is designed for interviews that expect hands-on AWS architecture depth across:

- infrastructure design
- container platforms using ECS and EKS
- CI/CD and deployment pipelines
- IAM, KMS, S3, Route 53, security groups, and network security
- Terraform-based infrastructure as code
- production operations, rollback, and observability

Use this in two passes:

1. Read the detailed sections to build strong concepts and answer structure.
2. Revisit the revision sections before the interview for fast recall.

---

## How To Answer Like An Architect

In this type of interview, the interviewer is rarely satisfied by a definition of a service. They want to know whether you can make design decisions and justify them.

Use this response pattern in most answers:

1. Clarify the workload and constraints.
2. Choose the service or pattern.
3. Explain why it fits.
4. Cover security.
5. Cover scaling and high availability.
6. Cover deployment and rollback.
7. Mention tradeoffs and cost.

### Example answer structure

If I need containerized microservices with low operational overhead, I would prefer ECS on Fargate. If the platform requires Kubernetes-native capabilities such as operators, Helm, custom resources, or GitOps tooling, I would consider EKS. In both cases, I would keep workloads in private subnets, expose them through ALB, use Route 53 for DNS, use IAM roles and KMS-backed encryption for security, and provision the full stack through Terraform.

---

## Core AWS Topics You Must Know Well

## ECS

Amazon ECS is AWS-native container orchestration. It is usually the simpler choice when a team wants to run containers without Kubernetes control-plane and cluster-management overhead.

In interview language, ECS is often the answer when the business wants containers but does not want the platform team to spend time managing Kubernetes internals. It is especially strong for API services, background workers, scheduled tasks, and internal business applications that need reliability and security more than Kubernetes flexibility.

### Key concepts

- Cluster: logical grouping of compute
- Task Definition: blueprint for containers, CPU, memory, ports, logging, and secrets
- Task: a running instance of a task definition
- Service: keeps the desired number of tasks running
- Fargate: serverless compute for containers
- ECS on EC2: ECS using EC2 instances you manage

### When to choose ECS

Choose ECS when:

- the team wants low operational overhead
- the workload is a standard web or API service
- tight AWS integration matters more than Kubernetes portability
- the team does not need custom Kubernetes controllers or ecosystem features

### Why interviewers ask about ECS

This question tests whether you understand that architecture is about choosing the right level of complexity. A weak candidate says ECS is simpler. A stronger candidate explains why that simplicity matters: fewer moving parts, easier operations, faster onboarding, and tighter integration with AWS-native identity, logging, and load balancing.

### Practical example

Suppose a company has five microservices, each packaged as a Docker container, and the team wants HTTPS routing, autoscaling, secret injection, and fast deployment without running Kubernetes. A good design would be:

- ALB for public HTTPS traffic
- ECS services on Fargate in private subnets
- images stored in ECR
- secrets stored in Secrets Manager
- task roles for S3 or DynamoDB access
- CloudWatch for logs and metrics

This is a strong ECS use case because the requirements are production-grade, but not Kubernetes-specific.

### Strong interview answer

I prefer ECS when the goal is reliable, secure container hosting with minimal operational burden. ECS integrates well with ALB, IAM roles, CloudWatch, ECR, and Auto Scaling, and Fargate removes server management completely.

### What to remember

- ECS is often the right default for AWS-first teams
- ECS task role and execution role are different and interviewers ask this often
- ALB commonly fronts ECS services
- ECS is simpler than EKS operationally

## EKS

Amazon EKS is a managed Kubernetes control plane. It is useful when Kubernetes is a real platform requirement, not just a trend-driven choice.

EKS is valuable when the company needs Kubernetes as a platform, not just containers as a runtime. That usually means multiple teams, standardized deployment tooling, operators, admission controllers, service mesh, advanced ingress patterns, or GitOps workflows.

### When to choose EKS

Choose EKS when:

- the organization standardizes on Kubernetes
- teams need Helm, operators, CRDs, or service mesh capabilities
- advanced scheduling or cluster-level platform engineering is required
- portability or Kubernetes alignment matters

### Operational reality

EKS manages the control plane, but you still handle:

- node groups or Fargate profiles
- ingress
- add-ons
- observability
- cluster upgrades
- RBAC and workload identity

This is an important interview point because many candidates say EKS is managed and stop there. A stronger answer makes it clear that AWS manages the control plane, but the team still owns cluster operations, governance, cost efficiency, add-on lifecycle, and workload security.

### Practical example

Suppose an enterprise already runs Kubernetes in multiple places and wants one standard way to deploy applications using Helm charts, GitOps, and shared platform controls. In that case, EKS makes sense because the platform benefits from Kubernetes consistency. The tradeoff is that the team now has to handle cluster upgrades, policy management, controller lifecycle, and more operational complexity than ECS.

### Strong interview answer

I choose EKS when Kubernetes-native capabilities are needed and the team is ready for the extra complexity. If the problem can be solved with ECS more simply, I would avoid introducing EKS unnecessarily.

### What to remember

- EKS is more flexible but more operationally complex
- use IRSA for pod-level AWS access
- ALB ingress is a common north-south traffic pattern
- mention RBAC and cluster governance when discussing security

## ALB

Application Load Balancer is a Layer 7 load balancer designed for HTTP and HTTPS workloads.

ALB matters in interviews because it often becomes the main traffic entry point in modern AWS application design. It is not just a load balancer. It is also part of the routing, deployment safety, and observability story.

### Key capabilities

- host-based routing
- path-based routing
- TLS termination
- health checks
- redirects and listener rules
- WebSocket support

### Strong interview answer

I use ALB when I need HTTP or HTTPS traffic management, intelligent routing, TLS termination, and health-based request distribution. It is a natural fit in front of ECS services and EKS ingress.

### Practical example

Imagine one domain serving multiple applications:

- `api.company.com` goes to the backend API
- `app.company.com` goes to the web frontend
- `/admin` routes to an internal admin service

ALB can handle that routing with listener rules and target groups. During deployment, ALB health checks also determine whether new tasks or pods should receive traffic.

### ALB vs NLB

ALB:

- Layer 7
- HTTP and HTTPS
- host and path routing
- web application traffic

NLB:

- Layer 4
- TCP and UDP
- static IP support
- very high-throughput, low-latency traffic handling

## Route 53

Route 53 is AWS DNS and traffic management service.

Many candidates describe Route 53 only as DNS. In interviews, it is better to describe it as DNS plus traffic control. That framing shows you understand how it fits into availability, failover, and deployment strategies.

### Main features

- public and private hosted zones
- alias records
- weighted routing
- failover routing
- latency-based routing
- health checks

### Strong interview answer

I use Route 53 not only for DNS resolution, but also for traffic strategies such as weighted rollout, health-based failover, and internal service naming through private hosted zones.

### Practical example

Suppose you are releasing a new version of an application in a second environment. You can create weighted records and send 10 percent of users to the new environment while 90 percent continue to use the stable one. If metrics stay healthy, you can gradually increase the percentage. That is a clean interview example because it connects Route 53 to controlled rollout rather than basic name resolution.

### What to remember

- weighted routing is useful for canary or blue-green traffic shifting
- failover routing supports disaster recovery patterns
- alias records are commonly used with ALB and CloudFront

## KMS

AWS KMS manages encryption keys and provides governance around data protection.

KMS is one of the services that often separates surface-level AWS knowledge from real production depth. Encryption alone is easy to say. The stronger discussion is about who controls keys, who can decrypt, where audit trails exist, and how encryption ties into compliance and least privilege.

### Where KMS is used

- S3
- EBS
- RDS
- Secrets Manager
- Parameter Store
- application-level encryption patterns

### Strong interview answer

KMS matters not just for encryption at rest, but for governance, access control, auditability, and separation of duties. In enterprise environments, customer-managed keys are often preferred when tighter policy control is needed.

### Key interview point

Key policy and IAM policy are both involved in KMS authorization. An IAM policy alone may not be enough if the key policy does not allow the access model.

### Practical example

Assume an ECS application reads documents from an S3 bucket encrypted with a customer-managed KMS key. The architecture is not complete if you only allow `s3:GetObject`. The task role must also be allowed to use the KMS key for decryption, and the key policy must support that access model. This is the kind of detail interviewers often use to distinguish practical AWS experience from theory.

### What to remember

- KMS is a governance service as much as an encryption service
- key policy knowledge is a high-value differentiator in interviews
- restrict `kms:Decrypt` carefully

## IAM Roles

IAM roles provide temporary credentials and should be the default method for workload access to AWS services.

In architecture interviews, IAM is not just an identity topic. It is central to workload security, CI/CD safety, and separation of duties between teams, services, and environments.

### Important ideas

- role: an assumable identity
- permission policy: what the role can do
- trust policy: who can assume the role

### Strong interview answer

I avoid long-lived access keys in workloads. I use IAM roles for ECS tasks, EC2 instances, Lambda functions, CI/CD systems, and IRSA in EKS so that access is short-lived, auditable, and easier to govern.

### Practical example

If a reporting service running on ECS needs to read files from S3 and publish messages to SQS, the right answer is not to store an access key in environment variables. The right answer is to attach a task role with only `s3:GetObject` on the specific bucket path and `sqs:SendMessage` on the specific queue. That shows least privilege and good architectural judgment.

### What to remember

- never embed credentials in code or images
- separate human access from workload access
- least privilege is a core design rule

## Security Groups

Security groups are stateful firewalls attached to AWS resources.

Security groups are simple on the surface, but they reveal whether a candidate can reason about traffic flow. Strong answers are explicit about who can talk to what, over which ports, and why.

### Good design example

- ALB security group allows inbound 443 from the internet
- App security group allows inbound only from the ALB security group
- DB security group allows inbound only from the App security group

### Strong interview answer

I prefer explicit traffic design. Internet traffic should stop at the ALB, the application tier should accept traffic only from the ALB security group, and the database tier should accept traffic only from the application tier.

### Practical example

For a three-tier application:

- ALB security group allows inbound 443 from `0.0.0.0/0`
- application security group allows inbound 8080 only from the ALB security group
- database security group allows inbound 3306 only from the application security group

That answer is better than saying open the required ports, because it demonstrates controlled trust boundaries.

### What to remember

- security groups are stateful
- prefer security-group references over open CIDR rules where possible
- private compute and database tiers are standard practice

## S3

S3 is object storage used for artifacts, logs, backups, static assets, and Terraform state.

S3 appears in many interview scenarios because it sits in the middle of delivery, storage, backup, and security patterns. A strong answer should mention both access control and lifecycle management.

### Strong interview answer

For important S3 buckets, I enable Block Public Access, encryption, versioning, and least-privilege bucket policies. If content needs to be distributed publicly, I usually prefer CloudFront in front of S3 rather than exposing the bucket directly.

### Practical example

For a Terraform state bucket, I would keep the bucket private, enable versioning to recover from accidental state overwrite, enforce encryption, and restrict access to the pipeline role and a small admin group. For a public frontend asset bucket, I would usually place CloudFront in front and keep direct S3 access limited.

### What to remember

- S3 is often used for Terraform state and CI/CD artifacts
- encryption and versioning are common baseline controls
- use lifecycle policies where appropriate

---

## Terraform For AWS Architecture

Terraform is an Infrastructure as Code tool that allows infrastructure to be repeatable, version-controlled, reviewable, and automated.

Interviewers often use Terraform questions to check whether you can operate safely at scale. They want to hear not just that you can write resources, but that you understand state, environment separation, review discipline, and drift control.

### What interviewers want to hear

- modular design
- environment isolation
- remote state
- drift management
- `plan` before `apply`
- pipeline-based execution
- restricted access to production infrastructure changes

### Practical Terraform structure

Use reusable modules for:

- VPC and networking
- ECS or EKS
- ALB and target groups
- IAM roles and policies
- S3 and KMS

Then keep separate root configurations or stacks for:

- dev
- test
- prod

This structure matters because it balances reuse with isolation. Reusable modules reduce duplication, while separate environments reduce blast radius and make approvals more manageable.

### State management

Good practice includes:

- remote state in private S3
- encryption enabled
- versioning enabled
- tightly restricted IAM access
- separate state per environment or stack

### Strong interview answer

I structure Terraform so that shared patterns live in modules, while environments have isolated state and controlled deployment through CI/CD. I treat state as sensitive data and avoid relying on local state files as the system of record.

### Practical example

Imagine a company has one shared VPC module, one ECS service module, and one ALB module. The dev environment can use smaller instance sizes or fewer tasks, while production uses higher capacity and stricter access controls. The modules stay the same, but the root configuration and variables differ by environment. That is the kind of clean structure interviewers like to hear.

### Common mistakes to mention

- one shared state for everything
- hardcoded secrets
- uncontrolled console changes causing drift
- lack of plan review before apply
- overly generic modules that become hard to operate

---

## CI/CD For Infrastructure And Applications

A strong answer here should connect source control, validation, artifact handling, deployment safety, and rollback.

This topic is important because many AWS architect roles now expect ownership across both platform and release process. A good answer should show that you understand build safety, release control, environment promotion, and recovery from failed changes.

### Example pipeline flow

1. Developer creates a pull request.
2. CI runs linting, tests, dependency checks, and security scanning.
3. Docker image is built once and tagged with commit SHA.
4. Image is scanned and pushed to ECR.
5. Terraform validate and plan run for infrastructure changes.
6. Deployment goes to a non-production environment.
7. Smoke and integration tests run.
8. Production deployment happens through approval and controlled rollout.
9. Health checks determine whether rollout continues or rollback triggers.

### Strong interview answer

I prefer immutable artifacts and promotion of the same image across environments. For infrastructure, I require reviewed Terraform plans before apply. For application deployment, I rely on health checks, controlled rollout, and clear rollback paths rather than assuming deployments will always succeed.

### Practical example

For example, a pull request can trigger unit tests, linting, dependency scanning, Docker build, and image scanning. The image is tagged with the Git commit SHA and pushed to ECR. Terraform changes generate a reviewed plan. Deployment first targets a test environment, then after validation it moves to production with health checks through ALB and automatic rollback if targets fail.

### What to remember

- build once, promote same artifact
- do not skip rollback strategy
- secure the pipeline itself with least-privilege roles

---

## Architecture Patterns You Should Be Ready To Explain

## Pattern 1: Secure ECS Application On AWS

Typical design:

- Route 53 for DNS
- ALB in public subnets
- ECS services in private subnets
- images stored in ECR
- secrets in Secrets Manager or Parameter Store
- IAM task roles for service access
- KMS for encryption
- CloudWatch for logs and metrics
- Multi-AZ deployment
- Auto Scaling based on usage or traffic
- Terraform for provisioning

### Model answer

I would place the ALB in public subnets and the ECS tasks in private subnets across multiple AZs. Route 53 would map the domain to the ALB, ACM would provide TLS certificates, IAM task roles would control AWS access, and secrets would be stored in Secrets Manager encrypted with KMS. Observability would go to CloudWatch, and the full stack would be provisioned through Terraform with CI/CD-based deployment.

### Why this pattern is strong

This pattern is strong because it keeps the attack surface small, uses managed services where possible, supports autoscaling and Multi-AZ resilience, and avoids static credentials. It is also straightforward to explain in interviews because each service has a clear responsibility.

### Example scenario

Suppose you need to host an internal order-processing API used by a web frontend and a mobile app. ECS on Fargate is a good choice if the services are standard HTTP applications and the team wants to move quickly without managing Kubernetes. The API can scale based on CPU or request count, and secrets such as database credentials can be pulled securely at runtime.

## Pattern 2: EKS Platform With ALB Ingress

Typical design:

- EKS cluster across multiple AZs
- managed node groups or Fargate profiles
- ALB ingress through AWS Load Balancer Controller
- Route 53 for DNS
- ACM for certificates
- IRSA for workload IAM
- namespaces and RBAC for segmentation
- observability through CloudWatch or platform tooling
- Terraform for cluster and supporting services

### Model answer

I would choose EKS when Kubernetes is an actual platform requirement. I would expose HTTP services through ALB ingress, use IRSA for workload permissions, keep environment or team boundaries clean with namespaces and RBAC, and automate infrastructure and cluster dependencies with Terraform.

### Why this pattern is strong

This pattern makes sense when multiple teams need a shared application platform with Kubernetes-native deployment tools. It allows standardized ingress, workload identity, namespace isolation, and platform-level policy controls.

### Example scenario

Suppose a platform team supports many application teams that already package workloads as Helm charts and want GitOps deployment through a controller such as Argo CD. EKS becomes easier to justify because the value comes from shared Kubernetes workflows, not just from running containers.

## Pattern 3: Secure Multi-Environment Platform

Typical design:

- separate dev, test, and prod environments
- preferably separate AWS accounts for stronger isolation
- separate Terraform state per environment
- separate IAM roles and access boundaries
- CI/CD gates controlling each stage
- standardized reusable modules

### Model answer

For a secure multi-environment platform, I would isolate environments strongly, ideally at the AWS account boundary for production separation. I would keep Terraform state separate, restrict pipeline roles by environment, and ensure each deployment path is reviewable and auditable.

### Why this pattern is strong

This pattern reduces blast radius. A mistake in development should not affect production, and a developer who can deploy to non-production should not automatically have production-level access.

### Example scenario

For example, dev and test may live in one lower-risk account with smaller capacity, while production lives in a separate account with tighter IAM boundaries, stronger approval controls, and stricter monitoring. The deployment process can still be standardized, but the access model remains safer.

---

## Security Depth That Interviewers Value

You should be comfortable speaking across four security layers.

## Identity

- IAM roles instead of access keys
- least privilege
- trust boundaries
- separation of human and workload access

## Network

- public vs private subnet design
- security groups
- restricted east-west traffic
- WAF for public applications when appropriate

## Data

- encryption at rest
- encryption in transit
- KMS-backed secrets and storage encryption
- controlled access to decryption rights

## Operations

- CloudTrail for audit
- logging and alerting
- image scanning and patch hygiene
- controlled deployments and approval gates

### Strong interview line

I think about security in layers: identity, network, data, and operations. That prevents security from being treated as a single checkbox and helps surface weak points early in the design.

---

## 20 High-Probability Interview Questions With Strong Sample Answers

## 1. When would you choose ECS over EKS?

I would choose ECS when the team wants lower operational overhead and the workload does not need Kubernetes-native features. ECS is well integrated with AWS services and is often the simpler choice for standard microservices.

## 2. When would you choose EKS over ECS?

I would choose EKS when the platform genuinely requires Kubernetes ecosystem features such as Helm, operators, CRDs, or advanced cluster-level tooling, and when the team is prepared to manage the extra complexity.

## 3. What is the difference between ECS task role and execution role?

The execution role is used by ECS to pull images and write logs during startup and runtime support. The task role is assumed by the running application container to call AWS services.

## 4. What is IRSA and why is it important?

IRSA allows Kubernetes service accounts to assume IAM roles. It is important because it gives pod-level AWS permissions and avoids broad node-level access.

## 5. How do you secure an S3 bucket?

I enable Block Public Access, use encryption, restrict access through IAM and bucket policy, and enable versioning for important buckets. If the content needs public delivery, I prefer CloudFront over direct exposure.

## 6. How do you secure secrets for workloads?

I use Secrets Manager or Parameter Store, encrypt with KMS, and give access only through workload IAM roles such as ECS task roles or IRSA roles.

## 7. What is the difference between ALB and NLB?

ALB operates at Layer 7 and is built for HTTP and HTTPS with routing logic. NLB operates at Layer 4 and is used for TCP, UDP, static IP needs, or very high-performance network traffic.

## 8. How do you design a production VPC?

I use multiple AZs, public subnets for ALB, private subnets for workloads and databases, explicit security group controls, and restricted outbound access based on actual need.

## 9. How do you manage Terraform state?

I store it remotely in a private encrypted S3 bucket with versioning and restricted IAM access, and I isolate state by environment or stack.

## 10. What is Terraform drift?

Drift is when infrastructure differs from the code because of manual or out-of-band changes. I detect it through `terraform plan` and reduce it by enforcing changes through code review and pipelines.

## 11. How would you build CI/CD for container workloads?

I would run tests and scans in CI, build once, push to ECR, deploy to lower environments first, and promote through controlled rollout with health checks and rollback support.

## 12. How do you do blue-green deployment?

I keep old and new versions separately, route traffic to the new version only after health checks pass, and retain fast rollback to the stable version if metrics degrade.

## 13. How do you do canary deployment?

I shift a small percentage of traffic first, observe errors and latency, and increase traffic only if the new version behaves correctly.

## 14. What is the role of Route 53 in rollout and resilience?

Route 53 supports weighted routing for controlled rollout and health-check-driven failover for resilience and disaster recovery patterns.

## 15. How do you investigate failed ALB health checks?

I check target health, the health-check path and code expectations, application logs, port mappings, startup time, security group rules, and whether the new version changed behavior or configuration.

## 16. How do you design for high availability?

I spread workloads across multiple AZs, avoid single points of failure, use health checks and load balancing, and ensure deployment and failover paths are tested.

## 17. How do you reduce blast radius in AWS?

I isolate environments, use least-privilege IAM, keep network boundaries tight, separate Terraform state, and keep access and encryption scopes narrow.

## 18. What are common Terraform mistakes?

Common mistakes include shared state for everything, hardcoded secrets, lack of environment isolation, weak review discipline, and allowing manual console drift.

## 19. How do you optimize cost in container platforms?

I right-size CPU and memory, reduce idle environments, tune logging retention, use Spot capacity where safe, and avoid unnecessary always-on infrastructure.

## 20. How would you migrate a monolith to containers?

I would first understand dependencies and deployment behavior, then containerize and stabilize the existing app, externalize secrets and configuration, introduce CI/CD, and only then consider service decomposition if it provides clear value.

---

## Points To Remember Before The Interview

## Service comparisons

- ECS vs EKS
- ALB vs NLB
- task role vs execution role
- IAM role vs policy
- key policy vs IAM policy
- blue-green vs canary
- public subnet vs private subnet

## Topics that should appear naturally in answers

- IAM roles
- KMS
- ALB
- Route 53
- security groups
- private workloads
- Terraform
- CI/CD
- rollback
- observability

## Strong phrases to use

- I would choose the simplest platform that satisfies the requirement.
- I would keep the workload private and expose only the load balancer.
- I would secure access through IAM roles rather than static credentials.
- I would automate provisioning through Terraform and deployment through CI/CD.
- I would include health checks, observability, and rollback from the beginning.

---

## Rapid Revision Sheet

## One-line definitions

- ECS: AWS-native container orchestration with lower operational overhead
- EKS: managed Kubernetes on AWS
- ALB: Layer 7 load balancer for HTTP and HTTPS traffic
- Route 53: DNS and traffic management service
- KMS: key management and encryption governance service
- IAM role: temporary assumable identity
- Security group: stateful firewall around AWS resources
- S3: object storage for artifacts, data, logs, and state
- Terraform: Infrastructure as Code for repeatable provisioning
- IRSA: pod-level IAM access model for EKS

## Final checklist

Before the interview, make sure you can explain clearly:

- when ECS is better than EKS
- when EKS is justified despite complexity
- how ALB integrates with ECS and EKS
- how Route 53 supports routing and failover
- how KMS works with IAM and key policy
- how to secure S3 and secrets
- how Terraform state is handled
- how CI/CD supports safe release and rollback
- how to design private, Multi-AZ application platforms

---

## Short Self-Introduction Template

I work on AWS architecture with a focus on secure infrastructure, container platforms, and delivery automation. I have experience building and securing workloads on ECS and EKS, exposing applications through ALB and Route 53, using IAM, KMS, and security groups for security, and provisioning infrastructure through Terraform. My focus is usually on repeatability, security, operational simplicity, and safe deployment through CI/CD.