


def remote = [:]
remote.name = 'clean'
remote.host = '192.168.56.104'
remote.user = 'admin_fa'
remote.password = 'admin'
remote.allowAnyHosts = true

node {
    stage ('echo test') {
        sh 'echo "test test"'
    }

    stage ('check connection') {
        sshCommand remote: remote, command: 'touch success.txt'
        sshCommand remote: remote, command: 'ls'
    }


}


//  stage ('check connection') {
//       steps {
//           sh 'touch success.txt'
//           sh 'ls'
//       }
//   }