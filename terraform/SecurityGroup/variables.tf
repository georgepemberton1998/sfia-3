variable "ingress_ports" {
  type        = list(number)
  description = "Ingress ports"
  default     = [22, 80, 8080, 8081, 3306]
}

variable "egress_ports" {
  type        = list(number)
  description = "Egress ports."
  default     = [0]
}

variable "ingress_ports1" {
  type        = list(number)
  description = "Ingress ports"
  default     = [3306]
}

variable "egress_ports1" {
  type        = list(number)
  description = "Egress ports."
  default     = [0]
}

variable "vpc_id" {
  description = "VPC ID"
  default     = "override"
}

variable "name" {
  description = "Name of Security Group"
  default     = "project-sg"
}