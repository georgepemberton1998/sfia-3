#! /bin/bash

cd ~/sfia-3/ansible

ansible-playbook -i inventory1.ini user1.yaml
ansible-playbook -i inventory2.ini install2.yaml
ansible-playbook -i inventory3.ini install3.yaml

echo "Successfully completed Ansible playbooks"
