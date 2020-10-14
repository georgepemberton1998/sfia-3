resource "aws_security_group" "project-sg" {
  name        = "project-sg"
  description = "Allow SSH"
  vpc_id      = var.vpc_id
  dynamic "ingress" {
    iterator = port
    for_each = var.ingress_ports
    content {
      from_port   = port.value
      to_port     = port.value
      protocol    = "tcp"
      cidr_blocks = ["0.0.0.0/0"]
    }
  }
  dynamic "egress" {
    iterator = port
    for_each = var.egress_ports
    content {
      protocol    = "-1"
      from_port   = port.value
      to_port     = port.value
      cidr_blocks = ["0.0.0.0/0"]
    }
  }
}

resource "aws_security_group" "rds-sg" {
  name        = "rds-sg"
  description = "Allow SSH"
  dynamic "ingress" {
    iterator = port
    for_each = var.ingress_ports1
    content {
      from_port   = port.value
      to_port     = port.value
      protocol    = "tcp"
      cidr_blocks = ["0.0.0.0/0"]
    }
  }
  dynamic "egress" {
    iterator = port
    for_each = var.egress_ports1
    content {
      protocol    = "-1"
      from_port   = port.value
      to_port     = port.value
      cidr_blocks = ["0.0.0.0/0"]
    }
  }
}
