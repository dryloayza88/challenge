#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage ('Checkout & Clone repository') {
            steps {
                checkout scm
            }
        }
        stage ('Build Artifact') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage ('Test Artifact') {
            steps {
                sh 'mvn test'
            }
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage ('Build docker image') {
            steps {
                sh 'docker build -t dryloayza/intercorp-challenge:${BUILD_NUMBER} .'
            }
        }
        stage ('Push docker image') {
            steps {
                withDockerRegistry(credentialsId: 'dockerhub', url: 'https://index.docker.io/v1/') {
                    sh 'docker push dryloayza/intercorp-challenge:${BUILD_NUMBER}'
                }
            }
        }
        stage('Docker deploy'){
            steps {
                sh 'docker run -itd --name=intercorp-challenge-${BUILD_NUMBER} -p 8181:8181 dryloayza/intercorp-challenge:${BUILD_NUMBER}'
            }
        }
        stage('Curl spring boot app'){
            steps {
                sh 'sleep 25'
                sh 'curl -vv 172.17.0.3:8181'
                sh 'curl -L 172.17.0.3:8181'
            }
        }
    }
}