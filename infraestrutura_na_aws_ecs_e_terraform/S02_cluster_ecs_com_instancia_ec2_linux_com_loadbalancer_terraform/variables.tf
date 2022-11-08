variable "aws_region" {
  type    = string
  default = "us-east-1"
}

variable "subnet_id" {
  type    = string
  default = "subnet-0be9a7341271a6fbb"
}

variable "keyname" {
  type    = string
  default = "zup-edu-dev"
}

variable "sg_id" {
  type    = list(any)
  default = ["sg-091fd188de899e9170"]
}

variable "vpc_id" {
  type    = string
  default = "vpc-04874f33510788c8d"
}

variable "subnets_ids" {
  type    = list(string)
  default = ["subnetid1", "subnetid2", "subnetid3"]
}