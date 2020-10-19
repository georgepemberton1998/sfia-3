pipeline{
    agent any
    environment {
        app_version = 'v1'
        rollback = 'false'
    }
    stages {
        stage('Test') {
            steps {
                load "/home/jenkins/.envvars/env-vars.groovy"
                sh '''
                ssh ubuntu@xx.xxx.x.xxx << EOF
                rm -rf sfia-3
                git clone https://github.com/georgepemberton1998/sfia-3.git
                cd sfia-3
                export SECRET_KEY="$SECRET_KEY"
                export DB_PASSWORD="$DB_PASSWORD"
                export DATABASE_URI="$DATABASE_URI"
                export TEST_DATABASE_URI="$TEST_DATABASE_URI"
                >> EOF
                '''
            }
        }
        stage('Build Frontend Image') {
            steps{
                script {
                    if (env.rollback == 'false') {
                        image = docker.build("maccpr7/frontend") && docker.build("maccpr7/backend-java")
                    }
                }
            }
        }
        stage('Build Backend Image') {
            steps{
                script {
                    if (env.rollback == 'false') {
                        image = docker.build("maccpr7/backend-java")
                    }
                }
            }
        }
        stage ('Pull Image') {
            steps{
                script {
                    if (env.rollback == 'false'){
                        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials'){ //need to set up a dockerhub credentials on jenkins
                            image.push("${env.app_version}")
                        }
                    }
                }
            }
        }
        Stage('Build App') {
            steps { 
                sh '''
                docker-compose pull && docker-compose up -d
                docker-compose ps
                //testing would go here but haven't covered that yet
                exit
                >> EOF
                '''
            }
        }
        stage('Production') {
            steps {
              //  load "/home/jenkins/.envvars/env-vars-prod.groovy"
                sh '''
                ssh ubuntu@xx.xxx.xxx.xx << EOF
               
                >> EOF
                '''
            }

        }
    }
}
