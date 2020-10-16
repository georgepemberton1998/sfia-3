#! /bin/bash

cd ~/sfia-3/ansible

ansible-playbook -i {inv 1} {playbook1}
ansible-playbook -i {inv 2} {playbook2}
ansible-playbook -i {inv 3} {playbook3}

echo "Successfully completed Ansible playbooks"
