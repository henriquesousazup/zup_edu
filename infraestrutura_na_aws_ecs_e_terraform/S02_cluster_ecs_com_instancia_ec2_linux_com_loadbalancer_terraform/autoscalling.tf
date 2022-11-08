resource "aws_autoscaling_group" "nginx-terraform" {
  name = "nginx-terraform-asg"
  wait_for_capacity_timeout = 0
  max_size = 3
  min_size = 3
  desired_capacity = 3
  launch_configuration = aws_launch_configuration.nginx-terraform.name
  vpc_zone_identifier = var.subnets_ids

  lifecycle {
    create_before_destroy = true
    ignore_changes = [load_balancers, target_group_arns]
  }
}


#resource "aws_autoscaling_group" "meu-auto-scalling" {
#  name = "meu-auto-scalling"
#  wait_for_capacity_timeout = 0
#  min_size = 3
#  max_size = 3
#  desired_capacity = 3
#  launch_configuration = "nome-do-launch-configuration"
#  vpc_zone_identifier = "ids-das-subnets"
#}