resource "aws_db_instance" "db" {
  allocated_storage      = var.storage
  storage_type           = var.storage_type
  engine                 = var.db_engine
  engine_version         = var.engine_version
  instance_class         = var.instance_class
  name                   = var.name
  username               = var.username
  password               = var.password
  parameter_group_name   = var.parameter_group_name
  vpc_security_group_ids = [var.vpc_security_group_ids]
  publicly_accessible    = true
  skip_final_snapshot    = true
  count                  = 2

}