def remote = [:]
remote.name = 'clean'
remote.host = '192.168.56.104'
remote.user = 'admin_fa'
remote.password = 'admin'
remote.allowAnyHosts = true

node {
        // stage ('Pulling repository') {

        //         sshCommand remote: remote, command: 'git clone https://github.com/ei-roslyakov/flask-api.git /home/admin_fa/app'
            
        // }


        stage ('Starting app') {

               sshCommand remote: remote, command: 'cd /home/admin_fa/app/api; python3 -m app.app &' 
           
        }
        

        stage ('Init data') {
            
                sshCommand remote: remote, command: 'curl -X POST http://localhost:5000/api/v1/init_data'
            
        }
}