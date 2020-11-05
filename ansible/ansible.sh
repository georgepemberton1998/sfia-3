#!/bin/bash
scp -r Install.sh qa@${ip}:

ansible-playbook -i inventory.cfg playbook.yaml

scp -r ~/.jenkins jenkins@${ip}:

echo "echo 'jenkins ALL=(ALL:ALL) NOPASSWD: ALL' | sudo EDITOR='tee -a' visudo"

ssh qa@${ip}

EOF
