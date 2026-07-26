# AWS Architect 1-Page Revision Sheet

## Core Decision Framework

In most architecture answers, cover these seven points:

1. requirement
2. service choice
3. security
4. scalability
5. high availability
6. observability and rollback
7. tradeoffs and cost

## Must-Know Service Choices

### ECS vs EKS

Choose ECS when:

- you want simpler operations
- the team is AWS-focused
- you do not need Kubernetes-native tooling
- speed and lower platform overhead matter

Choose EKS when:

- Kubernetes is a real platform requirement
- you need Helm, operators, CRDs, or GitOps tooling
- standardization on Kubernetes matters
- the team can handle higher operational complexity

### ALB vs NLB

ALB:

- Layer 7
- HTTP and HTTPS
- path-based and host-based routing
- common for ECS and EKS ingress

NLB:

- Layer 4
- TCP and UDP
- static IP support
- high-throughput, low-latency traffic

## Security Essentials

### IAM

- roles over static credentials
- least privilege
- trust policy defines who can assume the role
- permission policy defines what the role can do

### KMS

- used for encryption governance
- protects S3, EBS, RDS, Secrets Manager, and more
- key policy matters along with IAM policy
- restrict `kms:Decrypt` carefully

### Secrets

- use Secrets Manager or Parameter Store
- encrypt with KMS
- access through task role or IRSA
- never store secrets in code or images

### Security Groups

- stateful firewalls
- expose only ALB publicly
- app tier accepts traffic only from ALB SG
- DB tier accepts traffic only from app SG

## Network Design Basics

- ALB in public subnets
- ECS tasks or EKS nodes in private subnets
- databases in private subnets
- Multi-AZ is standard for production
- Route 53 for DNS and failover strategies

## ECS Facts To Remember

- task definition defines container settings
- service maintains desired count
- task role is for app AWS access
- execution role is for image pull and log shipping
- Fargate removes host management

## EKS Facts To Remember

- managed Kubernetes control plane
- still need to manage node groups, ingress, add-ons, and upgrades
- use IRSA for pod-level AWS permissions
- use ALB ingress for HTTP and HTTPS

## Terraform Facts To Remember

- use modules for reusable infrastructure
- keep separate state per environment
- store remote state in private encrypted S3
- review `terraform plan` before `apply`
- avoid manual console drift

## CI/CD Facts To Remember

- build once and promote the same artifact
- tag images with commit SHA
- scan dependencies and container images
- deploy to lower environment first
- keep rollback ready and tested

## 15 Very Common Interview Questions

1. When would you choose ECS over EKS?
2. What is IRSA?
3. What is the difference between task role and execution role?
4. How do you secure an S3 bucket?
5. What is the difference between ALB and NLB?
6. How do you manage Terraform state?
7. What is Terraform drift?
8. How do you secure secrets in AWS?
9. How do you design a production VPC?
10. How do you do blue-green deployment?
11. How do you do canary release?
12. What is the role of Route 53 in failover?
13. What is the difference between key policy and IAM policy in KMS?
14. How do you design for high availability?
15. How do you reduce blast radius in AWS?

## Strong Phrases To Use

- I would choose the simplest platform that satisfies the requirement.
- I would keep workloads private and expose only the load balancer.
- I would use IAM roles instead of static credentials.
- I would automate provisioning through Terraform and delivery through CI/CD.
- I would include observability and rollback from the beginning.

## Final 5-Minute Checklist

Before the interview, make sure you can clearly explain:

- ECS vs EKS
- ALB vs NLB
- task role vs execution role
- key policy vs IAM policy
- public subnet vs private subnet
- blue-green vs canary
- Route 53 weighted routing
- Terraform state and drift
- Secrets Manager plus KMS pattern
- Multi-AZ production design