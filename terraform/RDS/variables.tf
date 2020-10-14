variable "storage" {
  default = "20"
}

variable "storage_type" {
  default = "gp2"
}

variable "db_engine" {
  default = "mysql"
}

variable "engine_version" {
  default = "5.7"
}

variable "instance_class" {
  default = "db.t2.micro"
}

variable "name" {
  default = "db"
}

variable "username" {
  description = "username to be passed as environment variable"

}

variable "password" {
  description = "password to be passed as environment variable"

}

variable "parameter_group_name" {
  default = "default.mysql5.7"
}

variable "vpc_security_group_ids" {
  default = "override"
}
