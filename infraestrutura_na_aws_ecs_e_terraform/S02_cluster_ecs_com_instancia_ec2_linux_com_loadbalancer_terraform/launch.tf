resource "aws_launch_configuration" "nginx-terraform" {
  name_prefix = "nginx-terraform-asg"
  image_id      = data.aws_ami.ecs_ami.id
  instance_type = "t2.micro"
  user_data = data.template_file.init.rendered
    iam_instance_profile = aws_iam_instance_profile.nginx-terraform.name
    security_groups = var.sg_id

  lifecycle {
    create_before_destroy = true
  }
}



#resource "aws_launch_configuration" "meu-launch-config" {
#  name_prefix = "meu-launch-config"
#  image_id = "id-da-ami"
#  instance_type = "t2.micro"
#  iam_instance_profile = "nome-da-iam"
#  security_groups = "id-do-sg"
#}