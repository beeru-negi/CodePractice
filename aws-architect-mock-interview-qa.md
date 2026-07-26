# AWS Architect Mock Interview Q&A

## How To Use This File

Read one question at a time, answer aloud in your own words, then compare your answer with the sample. The goal is structured speaking, not memorization.

---

## 1. Tell me about your AWS architecture experience.

### Sample answer

I work on AWS architecture with a focus on secure infrastructure, containerized applications, and delivery automation. My experience includes building workloads on ECS and EKS, exposing applications through ALB and Route 53, securing them through IAM, KMS, and security groups, and provisioning infrastructure through Terraform. I usually focus on repeatability, security, safe deployment, and operational simplicity.

## 2. When would you choose ECS over EKS?

### Sample answer

I would choose ECS when I need container orchestration with lower operational overhead. It is a strong fit for AWS-centric teams that do not need Kubernetes-specific capabilities. If the workload can be handled well with ECS, I prefer not to introduce EKS complexity without a clear need.

## 3. When would you choose EKS over ECS?

### Sample answer

I would choose EKS when the organization needs Kubernetes-native tooling such as Helm, operators, CRDs, GitOps workflows, or cluster-wide platform patterns. EKS provides flexibility and ecosystem support, but the team must be ready for the operational burden.

## 4. How would you design a production-grade container platform on AWS?

### Sample answer

I would start with a Multi-AZ VPC. Public subnets would host the ALB, while ECS tasks or EKS nodes would run in private subnets. Route 53 would manage DNS, ACM would provide TLS, IAM roles would control AWS access, and Secrets Manager with KMS would manage secrets. CloudWatch would be used for logging and metrics, and Terraform would provision the entire stack.

## 5. What is the difference between ECS task role and execution role?

### Sample answer

The execution role is used by ECS to pull images from ECR and ship logs to CloudWatch. The task role is assumed by the running application container so it can access AWS services such as S3 or Secrets Manager.

## 6. What is IRSA and why is it important?

### Sample answer

IRSA stands for IAM Roles for Service Accounts. It allows pods in EKS to assume specific IAM roles through Kubernetes service accounts. This is important because it avoids broad node-level permissions and supports least privilege.

## 7. How do you expose services in EKS?

### Sample answer

For web traffic, I would typically use the AWS Load Balancer Controller with Kubernetes Ingress resources to provision an ALB. Route 53 would map DNS, and ACM would provide the TLS certificate.

## 8. How do you secure an ECS application?

### Sample answer

I would keep the tasks in private subnets, expose them through an ALB, use task roles for AWS permissions, store secrets in Secrets Manager encrypted by KMS, and control traffic with security groups. I would also enable centralized logging and image scanning.

## 9. How do you secure an S3 bucket?

### Sample answer

I enable Block Public Access unless there is a specific public requirement, encrypt the bucket, enable versioning for critical data, and apply least-privilege bucket and IAM policies. If the data must be publicly distributed, I usually prefer CloudFront in front of S3.

## 10. What is the difference between ALB and NLB?

### Sample answer

ALB is a Layer 7 load balancer for HTTP and HTTPS with path-based and host-based routing. NLB is a Layer 4 load balancer for TCP and UDP and is better when static IP or low-level network performance is required.

## 11. What is the role of KMS in AWS architecture?

### Sample answer

KMS is used for encryption, but its architectural importance is governance, auditability, and access control. It is commonly used to protect data in S3, EBS, RDS, and Secrets Manager, and I pay close attention to key policies and decryption permissions.

## 12. What is the difference between KMS key policy and IAM policy?

### Sample answer

KMS authorization depends heavily on the key policy. IAM policies can grant permissions, but they are not sufficient unless the key policy allows that access model. Both have to be understood together.

## 13. How do you design a production VPC?

### Sample answer

I use multiple AZs, place internet-facing load balancers in public subnets, and place application workloads and databases in private subnets. I control east-west traffic with security groups and keep the design explicit and minimal.

## 14. How do you manage secrets for workloads?

### Sample answer

I use Secrets Manager or Parameter Store, encrypt secrets with KMS, and provide access using IAM roles such as ECS task roles or IRSA. I avoid storing secrets in code, images, or static configuration files checked into source control.

## 15. How do you manage Terraform across environments?

### Sample answer

I keep reusable modules for shared patterns and separate root configurations or stacks for dev, test, and prod. Each environment has isolated state and access control, which reduces blast radius and keeps promotion manageable.

## 16. How do you manage Terraform state securely?

### Sample answer

I store state in private encrypted S3 with versioning and restricted IAM access. Since state can contain sensitive information, I treat it as sensitive infrastructure data and isolate it by environment or stack.

## 17. What is Terraform drift and how do you handle it?

### Sample answer

Drift occurs when infrastructure is changed outside Terraform and no longer matches the code. I detect it through `terraform plan` and reduce it by routing all changes through code review and pipeline execution.

## 18. How would you design CI/CD for AWS applications and infrastructure?

### Sample answer

I would validate code changes through tests and scans, build container images once, push them to ECR, run Terraform validate and plan for infra changes, deploy to lower environments first, and promote through controlled rollout with health checks and rollback support.

## 19. How would you do blue-green deployment?

### Sample answer

I would run old and new versions separately, usually with separate target groups or equivalent routing layers, and shift traffic only after the new version passes health checks. Rollback should be immediate if errors rise.

## 20. How would you do canary deployment?

### Sample answer

I would shift a small percentage of traffic first, observe latency, errors, and business metrics, and then gradually increase traffic if the new version remains healthy.

## 21. What is the role of Route 53 in resilience?

### Sample answer

Route 53 can be used for weighted rollout, health-check-based failover, latency-based routing, and private DNS. It becomes part of resilience strategy, not just basic name resolution.

## 22. How do you investigate ALB health-check failures?

### Sample answer

I start by checking target group health details, then application logs, port mappings, startup time, security group rules, and whether the configured health-check path matches real application behavior.

## 23. How do you design for high availability?

### Sample answer

I distribute critical components across multiple AZs, avoid single points of failure, use load balancing and health checks, and make sure scaling and rollback behavior are tested rather than assumed.

## 24. How do you reduce blast radius in AWS?

### Sample answer

I isolate environments, preferably by AWS account, keep Terraform state separate, use least-privilege IAM, limit network reachability, and avoid overly broad KMS or workload permissions.

## 25. How do you optimize cost in container environments?

### Sample answer

I right-size CPU and memory, reduce idle environments, review logging retention, use Spot capacity where acceptable, and avoid always-on infrastructure that is not justified by demand.

## 26. How would you migrate a monolith to containers?

### Sample answer

I would first understand dependencies and runtime behavior, then containerize the existing application, externalize configuration and secrets, introduce CI/CD, and only split into services later if there is a clear operational or business benefit.

## 27. What are common mistakes teams make on AWS?

### Sample answer

Common mistakes include putting too much in public subnets, using static credentials, treating KMS and secrets as afterthoughts, using one Terraform state for everything, and deploying without tested rollback or observability.

## 28. How do you approach disaster recovery?

### Sample answer

I start with RTO and RPO. Based on those targets, I choose an appropriate recovery pattern such as backup and restore, pilot light, warm standby, or active-active, and I ensure infrastructure can be reproduced through Terraform.

## 29. How do you decide between managed and self-managed services?

### Sample answer

My default is to prefer managed services if they meet the technical and business requirements, because they reduce operational burden and usually improve reliability and security posture. I choose self-managed options only when there is a clear reason.

## 30. If you joined our team, what would you look at first?

### Sample answer

I would first understand the current architecture, deployment process, operational pain points, and security posture. Then I would look for opportunities to simplify where possible, improve access control and secrets handling, strengthen Terraform and CI/CD discipline, and improve observability.

---

## Final Speaking Tips

- Answer in structure, not in scattered points.
- Use tradeoffs naturally.
- Mention security in almost every design answer.
- Mention rollback whenever you discuss deployment.
- Avoid overcomplicating the architecture unless the requirement justifies it.