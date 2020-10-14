output "VM0_publicIP" {
  value = aws_instance.VM[0].public_ip

}
output "VM1_publicIP" {
  value = aws_instance.VM[1].public_ip

}