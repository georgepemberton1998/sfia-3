output "VM0_publicIP" {
  value = module.aws_EC2_instances.VM0_publicIP

}
output "VM1_publicIP" {
  value = module.aws_EC2_instances.VM1_publicIP
}

output "db0_endpoint" {
  value = module.aws_rds.db0_endpoint

}
output "db1_endpoint" {
  value = module.aws_rds.db1_endpoint

}