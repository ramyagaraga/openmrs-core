pipeline {
    agent { label 'node1'}
    stages {
        stage('vcs') {
            steps {
                git url: 'https://github.com/ramyagaraga/openmrs-core.git',
                    branch: 'declarative'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}