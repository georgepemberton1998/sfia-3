variable "ami" {
  description = "Ubuntu image"
  default     = "ami-09a1e275e350acf38"
}

variable "instance_type" {
  description = "Type of instance to be started up"
  default     = "t2.micro"
}

variable "key_name" {
  description = "AWS key pair name"
  default     = "MyKeyPair"
}

variable "subnet_id" {
  description = "Required default value, will be added in the primary main.tf"
  default     = "Null"
}

variable "vpc_sg_ids" {
  description = "IDs of the security groups that this instance will belong to."
  default     = "Pull from main.tf"
}

variable "associate_public_ip_address" {
  description = "Should this EC2 instance have a public ip addresss"
  default     = true
}

variable "tags" {
  description = "Tags to be applied to the EC2 Instances"
  default = {
    Name        = "Default"
    Description = "Default Desc"
  }
}