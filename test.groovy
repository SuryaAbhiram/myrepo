pipeline {
    agent any
    withCredentials([usernamePassword(credentialsId: 'RDS_DEPLOY', passwordVariable: 'pass', usernameVariable: 'dns')]){
        stages {
             stage('Deploy1'){
                 steps{
                       sh '''#!/bin/bash
                       cd data
                       mysql -h ${dns} -P 3306 -u suryadb22-p${pass} -D test < create.sql 
                      '''
                      }
                    }
                 stage('Deploy2'){
                    steps{
                        sh '''#!/bin/bash
                        cd data
                        mysql -h ${dns} -P 3306 -u suryadb22-p${pass} -D test < insert.sql
                      '''
                      }
                      
                    } 
            }
        }
    }
