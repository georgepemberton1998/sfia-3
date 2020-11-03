#!/bin/bash
scp -r Install.sh ubuntu@${ip}:

ansible-playbook -i inventory.cfg playbook.yaml

scp -r ~/.jenkins jenkins@${ip}:

ssh ubuntu@${ip}

EOF
