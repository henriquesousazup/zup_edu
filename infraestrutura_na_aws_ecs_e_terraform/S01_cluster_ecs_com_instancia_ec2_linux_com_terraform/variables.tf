variable "aws_region" {
  type = string
  default = "us-east-1"
}

variable "subnet_id" {
  type = string
  default = "subnet-0be9a7341271a6fbb"
}

variable "keyname" {
  type = string
  default = "zup-edu-dev"
}

variable "sg_id" {
  type = list(any)
  default = ["sg-091fd188d899e9170"]
}