pipeline {

    agent any
    stages {
        stage("shh connection") {
            steps {
                sh 'ssh admin_fa@192.168.56.103'
            }

        }

    stage ('Pulling repository') {
            steps {
                sh 'git clone https://github.com/ei-roslyakov/flask-api.git /home/admin_fa/app'
            }
        }

    }
}