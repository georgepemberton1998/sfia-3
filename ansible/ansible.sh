#!/bin/bash
scp -r Install.sh ubuntu@${ip}:

ansible-playbook -i inventory.cfg playbook.yaml

scp -r ~/.jenkins jenkins@${ip}:

echo "echo 'jenkins ALL=(ALL:ALL) NOPASSWD: ALL' | sudo EDITOR='tee -a' visudo"

ssh ubuntu@${ip}

EOF
