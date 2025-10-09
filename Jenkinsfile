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
        sh 'mvn -B -Dmaven.test.failure.ignore=false test package'
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
  }

  post {
    always {
      archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      junit '**/target/surefire-reports/*.xml'
    }
  }
}


