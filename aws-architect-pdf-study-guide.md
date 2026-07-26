# AWS Architect Interview Study Guide

## Infrastructure, Security, Containers, Terraform, and CI/CD

This version is formatted to export cleanly to PDF. It uses shorter sections, consistent headings, and compact paragraphs so it is easier to print or share.

---

## 1. What Interviewers Usually Test

For an AWS architect role that covers infrastructure, application delivery, and CI/CD, interviewers usually assess whether you can design production systems, justify AWS service selection, secure workloads properly, automate infrastructure, and explain tradeoffs clearly.

Strong candidates do not just list AWS services. They explain why they chose a service, how they secure it, how it scales, how it fails, how it is observed, and how it is deployed safely.

---

## 2. Recommended Answer Structure

Use this sequence in most technical answers:

1. clarify the workload and constraints
2. choose the service or architecture pattern
3. justify the choice
4. describe security controls
5. describe HA and scaling
6. describe CI/CD and rollback
7. mention cost and tradeoffs

This pattern keeps answers structured and makes you sound like a practitioner rather than someone reciting definitions.

---

## 3. ECS vs EKS

ECS is usually the better choice when the team wants containers with lower operational overhead. It integrates naturally with IAM, ALB, CloudWatch, ECR, and Auto Scaling. Fargate also removes the need to manage hosts.

EKS is appropriate when Kubernetes itself is a real platform requirement. That typically means the team needs Helm, operators, CRDs, GitOps controllers, service mesh patterns, or Kubernetes standardization across teams.

In interviews, a strong answer is: choose ECS by default when simplicity is enough; choose EKS when Kubernetes capabilities are required and the team can support the added complexity.

---

## 4. ALB, Route 53, and Traffic Design

ALB is the common Layer 7 entry point for containerized applications. It handles HTTP and HTTPS, TLS termination, health checks, and host-based or path-based routing. It is commonly used with ECS services and EKS ingress.

Route 53 should be described as both a DNS service and a traffic management layer. It supports weighted routing, latency-based routing, failover routing, and health checks. This makes it useful in canary rollout, blue-green traffic shifting, and disaster recovery.

If asked about ALB vs NLB, keep it simple: ALB is for application-layer web traffic; NLB is for network-layer TCP or UDP traffic and use cases needing static IP or very high-throughput network handling.

---

## 5. IAM, KMS, and Secrets

IAM should appear naturally in almost every architecture answer. Strong answers use roles instead of long-lived access keys. The trust policy defines who can assume a role. The permission policy defines what the role can do. For workloads, ECS task roles and EKS IRSA are preferred patterns.

KMS should be discussed not just as encryption, but as governance and access control. It is used to protect S3, EBS, RDS, and Secrets Manager data. A common interview depth question is the difference between a key policy and an IAM policy. The key point is that KMS authorization depends heavily on the key policy, so IAM permission alone may not be enough.

Secrets should be stored in Secrets Manager or Parameter Store, encrypted with KMS, and accessed only through workload roles. Never describe secrets in code, container images, or plaintext configuration committed to source control as acceptable practice.

---

## 6. Security Groups and Network Layout

Security groups are stateful firewalls around AWS resources. A standard three-tier pattern is simple and effective: expose only the load balancer publicly, allow the application tier to accept traffic only from the load balancer security group, and allow the database tier to accept traffic only from the application security group.

A strong VPC answer includes Multi-AZ design, public subnets for internet-facing load balancers, private subnets for applications and databases, and clear control of east-west and north-south traffic.

---

## 7. Terraform Expectations

Terraform is often where interviewers distinguish between operational familiarity and platform discipline. Strong answers mention reusable modules, isolated environments, remote state, drift management, and plan review before apply.

Good practice is to store state remotely in private encrypted S3 with versioning and restricted IAM access. Avoid one giant state file for everything. Keep environments or stacks separated to reduce blast radius.

If asked about drift, explain that manual changes outside Terraform create mismatch between declared and actual infrastructure, and that drift is detected with `terraform plan` and controlled through disciplined change management.

---

## 8. CI/CD Expectations

A good pipeline answer includes source control review, automated validation, artifact creation, security scanning, controlled deployment, and rollback. A strong pattern is to build an immutable image once, tag it with a commit SHA, push it to ECR, validate infrastructure changes through Terraform plan, deploy first to a lower environment, run smoke tests, and promote with approvals where needed.

The most important interview point here is deployment safety. If you discuss deployment without health checks, observability, and rollback, the answer will feel incomplete.

---

## 9. Architecture Pattern You Should Be Ready To Describe

A common answer is a secure AWS container platform: Route 53 for DNS, ALB in public subnets, ECS tasks or EKS workloads in private subnets across multiple AZs, IAM roles for workload access, secrets in Secrets Manager, KMS-backed encryption, CloudWatch for observability, and Terraform for repeatable provisioning.

If asked why this is a strong design, explain that it separates public and private concerns, uses managed services where practical, limits credential exposure, supports scaling and failover, and remains fully automatable.

---

## 10. High-Value Questions To Practice

Be ready to answer these clearly and quickly:

- When would you choose ECS over EKS?
- What is IRSA?
- What is the difference between task role and execution role?
- What is the difference between ALB and NLB?
- How do you secure an S3 bucket?
- How do you handle secrets securely?
- How do you manage Terraform state?
- What is Terraform drift?
- How do you do blue-green deployment?
- How do you investigate failed ALB health checks?

---

## 11. Points To Remember

- Choose the simplest architecture that satisfies the requirement.
- Keep workloads private and expose only the load balancer.
- Prefer IAM roles over static credentials.
- Use KMS for encryption governance, not just box-checking.
- Keep secrets in managed secret stores.
- Use Terraform modules with isolated remote state.
- Build once and promote the same artifact.
- Include rollback in any deployment discussion.
- Multi-AZ is the default answer for production availability.
- Security, observability, and operations are part of architecture.

---

## 12. Short Introduction Template

I work on AWS architecture with a focus on secure infrastructure, container platforms, and delivery automation. I have experience building workloads on ECS and EKS, exposing them through ALB and Route 53, securing them with IAM, KMS, and security groups, and provisioning infrastructure through Terraform. I usually focus on repeatability, security, operational simplicity, and safe deployment through CI/CD.

---

## 13. Final Review Checklist

Before the interview, make sure you can explain:

- ECS vs EKS with tradeoffs
- ALB vs NLB clearly
- task role vs execution role
- IRSA in one clean sentence
- key policy vs IAM policy in KMS
- private vs public subnet placement
- Terraform state and drift
- blue-green vs canary
- how to secure secrets and S3
- how to build a safe CI/CD pipeline