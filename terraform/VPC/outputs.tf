output "vpc_id" {
  value = aws_vpc.project-vpc.id
}

output "public_subnetA_id" {
  value = aws_subnet.publicA.id
}

output "public_subnetB_id" {
  value = aws_subnet.publicB.id
}