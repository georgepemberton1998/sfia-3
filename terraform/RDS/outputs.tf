output "db0_endpoint" {
  value = aws_db_instance.db[0].endpoint

}
output "db1_endpoint" {
  value = aws_db_instance.db[1].endpoint

}