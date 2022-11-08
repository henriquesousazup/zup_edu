#Load Balancer
resource "aws_lb" "nginx-terraform" {
  name = "nginx-terraform-lb"
  internal = true
  load_balancer_type = "application"
  security_groups = [aws_security_group.nginx-terraform_lb.id]
  subnets = var.subnets_ids
}

#resource "aws_lb" "meu-alb" {
#  name = "meu-alb"
#  internal = true
#  load_balancer_type = "application"
#  security_groups = "ids-dos-security-groups"
#  subnets = "ids-das-subnets"
#}

#Load Balancer Listener
resource "aws_lb_listener" "nginx-terraform" {
  load_balancer_arn = aws_lb.nginx-terraform.arn
  port = "80"
  protocol = "HTTP"

  default_action {
    type = "forward"
    target_group_arn = aws_lb_target_group.nginx-terraform.arn
  }
}

#resource "aws_lb_listener" "meu-alb-listener" {
#  load_balancer_arn = "arn-do-load-balancer"
#  port = "80"
#  protocol = "HTTP"
#
#  default_action {
#    type = "forward"
#    target_group_arn = "arn-do-target-group"
#  }
#}


#Load Balancer Target Group
resource "aws_lb_target_group" "nginx-terraform" {
  name = "nginx-terraform"
  port = 80
  protocol = "HTTP"
  vpc_id = var.vpc_id
}

#resource "aws_lb_target_group" "meu-alb-target-group" {
#  name = "meu-alb-target-group"
#  port = 80
#  protocol = "HTTP"
#  vpc_id = "id-da-vpc"
#}

resource "aws_autoscaling_attachment" "nginx-terraform" {
  autoscaling_group_name = aws_autoscaling_group.nginx-terraform.id
  lb_target_group_arn = aws_lb_target_group.nginx-terraform.arn
}
