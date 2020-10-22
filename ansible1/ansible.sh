#!/bin/bash
scp -r Install.sh qa@${ip}:

scp -r ~/Documents/docker.sh qa@${ip}:

ansible-playbook -i inventory.cfg playbook.yaml

scp -r ~/.jenkins jenkins@${ip}:

ssh qa@${ip}

EOF
