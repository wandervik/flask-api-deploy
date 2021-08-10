pipeline {

    agent any
    stages {
        stage("checkout") {
            steps {
                git branch: 'main', url: 'https://github.com/wandervik/flask_api-deploy'

            }

        }

        stage("execute ansible playbook") {
            steps {
                ansiblePlaybook credentialsId: 'private-key', disableHostKeyChecking: true, installation: 'ansible_env', inventory: 'ansible/inventory', playbook: 'ansible/ansible_environment.yml'
            
            # new pipeline
            # ansiblePlaybook become: true, becomeUser: 'admin_fa', credentialsId: 'admin_fa', inventory: 'ansible/inventory', playbook: 'ansible/ansible_environment.yml'


            }

        }

    }
}