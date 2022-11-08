#Interface de rede
resource "aws_network_interface" "nginx-terraform" {
  subnet_id = var.subnet_id

  tags = {
    Name = "primary_network_interface"
  }
}

# Instancia
resource "aws_instance" "nginx-terraform" {
  ami = data.aws_ami.ecs_ami.id
  instance_type = "t3.micro"
  key_name = var.keyname
  user_data = data.template_file.init.rendered
  iam_instance_profile = aws_iam_instance_profile.nginx-terraform.name

  network_interface {
    network_interface_id = aws_network_interface.nginx-terraform.id
    device_index         = 0
  }

  tags ={
    Name = "nginx-terraform"
  }
}