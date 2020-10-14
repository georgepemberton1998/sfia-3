provider "aws" {
  region = "eu-west-2"
}

module "aws_security_group" {
  source = "./SecurityGroup"
  name   = "Project Security Group"
  vpc_id = module.aws_vpc.vpc_id
}

module "aws_vpc" {
  source = "./VPC"
}

module "aws_rds" {
  source                 = "./RDS"
  vpc_security_group_ids = module.aws_security_group.rds-security-group_id
  username               = var.dbUsername
  password               = var.dbPassword
}

module "aws_EC2_instances" {
  source     = "./EC2"
  subnet_id  = module.aws_vpc.public_subnetA_id
  vpc_sg_ids = module.aws_security_group.security-group_id
  tags = {
    Name = "project-vm"
  }
  associate_public_ip_address = true
}

module "aws_eks_cluster" {
  source            = "./EKS-Cluster"
  subnet_ids        = module.aws_vpc.public_subnetA_id
  subnet_ids_2      = module.aws_vpc.public_subnetB_id
  security_group_id = module.aws_security_group.security-group_id
}



