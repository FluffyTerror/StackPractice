pipeline {
    agent any

    tools {
        maven 'maven-loader' // Убедись, что такое имя указано в Jenkins
        jdk 'jdk-21'         // Или твоя версия JDK, как настроено в Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/FluffyTerror/StackPractice.git', branch: 'master' // Или другая ветка
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            echo 'Тесты упали!'
        }
    }
}