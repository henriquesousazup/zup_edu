# Cluster
resource "aws_ecs_cluster" "nginx-terraform" {
  name = "nginx-terraform"
}

#resource "aws_ecs_cluster" "meu-cluster" {
#  name = "meu-cluster"
#}

resource "aws_ecs_task_definition" "nginx-terraform" {
  family                = "nginx-terraform"
  container_definitions = jsonencode([
    {
      name        = "nginx"
      image       = "rmnobarra/nginx:blue"
      cpu         = 10
      memory      = 128
      essential   = true
      portMapping = [
        {
          containerPort = 80
          hostPort      = 80
        }
      ]
    }
  ])

  # É necessário que o Load Balancer esteja up primeiro para não quebrar a task definition
  depends_on = [
    aws_lb_target_group.nginx-terraform
  ]
}

#resource "aws_ecs_task_definition" "meu-cluster" {
#  family = "meu-cluster"
#  container_definitions = jsonencode([
#    {
#      name = "nginx"
#      image = "rmnobarra/nginx:blue"
#      cpu = 10
#      memory = 128
#      essential = true
#      portMappings = [
#        {
#          containerPort = 80
#          hostPort = 80
#        }
#      ]
#    }
#  ])
#}


resource "aws_ecs_service" "nginx-terraform" {
  name            = "nginx-terraform"
  cluster         = aws_ecs_cluster.nginx-terraform.id
  task_definition = aws_ecs_task_definition.nginx-terraform.arn

  ordered_placement_strategy {
    type  = "binpack"
    field = "cpu"
  }
}

#resource "aws_ecs_service" "meu-cluster" {
#  name = "meu-cluster"
#  cluster = aws_ecs_cluster.meu-cluster.id
#  task_definition = aws_ecs_task_definition.meu-cluster.arn
#  desired_count = 1
#
#  ordered_placement_strategy {
#    type = "binpack"
#    field = "cpu"
#  }
#}
