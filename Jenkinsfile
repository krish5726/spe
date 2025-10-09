pipeline {
  agent any

  environment {
    // DockerHub credentials configured in Jenkins (username/password or token)
    DOCKERHUB_CRED = credentials('dockerhub-creds-id')
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/krish5726/spe.git'
      }
    }

    stage('Build & Test') {
      steps {
        sh 'mvn clean install'
      }
    }

    stage('Build Docker Image') {
      steps {
        sh "docker build -t krish5726/spe:latest ."
      }
    }

    stage('Push to Docker Hub') {
      steps {
        script {
          sh "echo ${DOCKERHUB_CRED_PSW} | docker login -u ${DOCKERHUB_CRED_USR} --password-stdin"
          sh "docker push krish5726/spe:latest"
        }
      }
    }

    stage("Deploy via ansible") {
            steps {
                ansiblePlaybook(
                    installation: 'Ansible',
                    inventory: 'ansible/hosts.ini',
                    playbook: 'ansible/playbook-deploy.yml',
                )
            }
        }
  }

  post {
    success{
      mail to: "krishspatel@gmail.com",
        subject: "Jenkins Job Status",
        body: "Build Succcess ${env.BUILD_NUMBER}"
    }

    failure{
      mail to: "krishspatel@gmail.com",
        subject: "Jenkins Job status",
        body: "Build Failed ${env.BUILD_NUMBER}"
    }
  }
}






