pipeline {

    agent any
    stages {
        stage("checkout") {
            steps {
                git 'https://github.com/wandervik/flask_api-deploy'

            }

        }

        stage("execute ansible playbook") {
            steps {
                ansiblePlaybook credentialsId: 'private-key', disableHostKeyChecking: true, installation: 'ansible_env', inventory: 'ansible/inventory', playbook: '/ansible/old_playbooks/test_connection.yml'
            }

        }

    }
}