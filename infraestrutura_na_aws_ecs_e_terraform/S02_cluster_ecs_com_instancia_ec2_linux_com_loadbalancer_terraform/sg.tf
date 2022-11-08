#Security Group
resource "aws_security_group" "nginx-terraform_instance" {
  name = "nginx-terraform_instance"

  ingress {
    from_port       = 80
    to_port         = 80
    protocol        = "tcp"
    security_groups = [aws_security_group.nginx-terraform_lb.id]
  }

  ingress {
    from_port       = 22
    to_port         = 22
    protocol        = "tcp"
    security_groups = [aws_security_group.nginx-terraform_lb.id]
  }

  egress {
    from_port = 0
    to_port   = 0
    protocol  = "-1"
    security_groups = [aws_security_group.nginx-terraform_lb.id]
  }

  vpc_id = var.vpc_id
}

resource "aws_security_group" "nginx-terraform_lb" {
  name = "nginx-terraform_lb"

  ingress {
    from_port = 80
    to_port   = 80
    protocol  = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port = 0
    to_port   = 0
    protocol  = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  vpc_id = var.vpc_id
}