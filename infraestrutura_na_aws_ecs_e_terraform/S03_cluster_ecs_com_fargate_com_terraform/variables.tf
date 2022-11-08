variable "aws_region" {
  type    = string
  default = "us-east-1"
}

variable "cluster_name" {
  type    = string
  default = "ecs-nginx-cluster"
}

variable "ecs_task_name" {
  type    = string
  default = "ecs-nginx-task"
}

variable "image_name" {
  type    = string
  default = "rmnobarra/nginx"
}

variable "image_tag" {
  type    = string
  default = "green"
}

variable "container_port" {
  type    = number
  default = 80
}

variable "host_port" {
  type    = number
  default = 80
}

variable "service_name" {
  type    = string
  default = "ecs-nginx-svc"
}

variable "service_container_count" {
  type = number
  default = 3
  description = "Quantidade de containeres a serem deployados"
}

variable "subnets_id" {
  type = list(string)
  default = ["id1", "id2", "id3"]
}

variable "alb_name" {
  type = string
  default = "ecs-nginx-alb"
}

variable "alb_sg_name" {
  type = string
  default = "ecs-nginx-alb-sg"
}

variable "vpc_id" {
  type = string
  default = "vpc-04874f33510788c8d"
}

variable "target_group_name" {
  type = string
  default = "ecs-nginx-tg"
}
