resource "aws_ecs_cluster" "ecs_cluster" {
  name = var.cluster_name
}

resource "aws_ecs_task_definition" "ecs_task" {
  family                = var.ecs_task_name
  container_definitions = <<DEFINITION [
    {
      "name" : "${var.ecs_task_name}",
      "image" : "${var.image_name}: ${var.image_tag}"
      "essential" : true,
      "portMappings" : [
        {
          "containerPort" : "${var.container_port}",
          "hasPort" : "${var.host_port}"
        }
      ],
      "memory" : 256,
      "cpu" : 128
    }
  ]
DEFINITION
  requires_compatibilities = ["FARGATE"]
  network_mode             = "awsvpc"
  memory                   = 512
  cpu                      = 256
  execution_role_arn       = aws_iam_role.ecsTaskExecutionRole.arn
}

## ecs task definition
#resource "aws_ecs_task_definition" "ecs_task" {
#  family                   = "minha-task"
#  container_definitions    = <<DEFINITION
#[
#{
#"name": "minha-task",
#"image": "minha-imagem-de-container",
#"essential": true,
#"portMappings": [
#{
#"containerPort": "porta-do-container",
#"hostPort": "porta-do-host"
#}
#],
#"memory": 256,
#"cpu": 128
#}
#]
#DEFINITION
#  requires_compatibilities = ["FARGATE"]
#  network_mode             = "awsvpc"
#  memory                   = 512
#  cpu                      = 256
#  execution_role_arn       = aws_iam_role.ecsTaskExecutionRole.arn
#}

resource "aws_ecs_service" "ecs_service" {
  name            = var.service_name
  cluster         = aws_ecs_cluster.ecs_cluster.id
  task_definition = aws_ecs_task_definition.ecs_task.arn
  launch_type     = "FARGATE"
  desired_count   = var.service_container_count

  health_check_grace_period_seconds = 147

  load_balancer {
    target_group_arn = aws_lb_target_group.target_group.arn
    container_name   = aws_ecs_task_definition.ecs_task.family
    container_port   = var.container_port
  }

  network_configuration {
    subnets          = var.subnets_id
    assign_public_ip = false
    security_groups  = ["${aws_security_group.service_security_group.id}"]
  }

  depends_on = [
    aws_alb.application_load_balancer
  ]

  lifecycle {
    ignore_changes = [desired_count]
  }
}

## ecs service
#resource "aws_ecs_service" "ecs_service" {
#  name            = "nome-do-service"
#  cluster         = "id-do-cluster"
#  task_definition = "arn-da-task"
#  launch_type     = "FARGATE"
#  desired_count   = "quantidade de tasks"
#
#  health_check_grace_period_seconds = 147
#
#  network_configuration {
#    subnets          = "ids-das-subnets"
#    assign_public_ip = false
#    security_groups  = "ids-dos-security-groups"
#  }
#}