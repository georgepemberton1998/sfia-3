pipeline{
    agent any
    environment {
        app_version = 'v1'
        rollback = 'false'
    }
    stages {
        stage('Set up') {
            steps {
                //this may not be required, depends if we need a test vm
                load "/home/jenkins/.envvars/env-vars.groovy"
                sh '''
                ssh $USER@$VM << EOF
                if [ -d "sfia-3" ]
                then
                rm -r sfia-3 --force
                git clone https://github.com/georgepemberton1998/sfia-3.git
                else
                git clone https://github.com/georgepemberton1998/sfia-3.git
                fi
                >> EOF
                '''
            }
        }
        stage('Build images') {
            steps{
                script {
                    if (env.rollback == 'false') {
                        image = docker.build("maccpr7/frontend-react", "./frontend")
                        image1 = docker.build("maccpr7/backend-java", "./backend")
                    }
                }
            }
        }
        stage ('Push images') {
            steps{
                script {
                    if (env.rollback == 'false'){
                        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials'){ //need to set up a dockerhub credentials on jenkins
                            image.push("${env.app_version}")
                            image1.push("${env.app_version}")
                        }
                    }                 
                }
            }
        }
        stage('Deploy app') {
            steps { 
                sh '''
                ssh $USER@$VM << EOF
                cd sfia-3
                export app_version = $app_version
                docker-compose up -d --build 
                >> EOF
                '''
            }
        }
/*        stage('Production deploy') {
            steps {
              //  load "/home/jenkins/.envvars/env-vars-prod.groovy"
                sh '''
                kubectl apply -f /kubernetes
                '''
            }

        }*/
    }
}
