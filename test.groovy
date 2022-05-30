pipeline {
    agent any
        stages {
            dir("data") {
                sh "pwd"
                }
             stage('Deploy1'){
                 steps{
                       sh '''#!/bin/bash
                       mysql -h suryadb22.cvirjo0fysae.us-east-1.rds.amazonaws.com -P 3306 -u suryadb22 -psuryadb22 -D test < create.sql 
                      '''
                      }
                    }
                 stage('Deploy2'){
                    steps{
                        sh '''#!/bin/bash
                        mysql -h suryadb22.cvirjo0fysae.us-east-1.rds.amazonaws.com -P 3306 -u suryadb22 -psuryadb22 -D test < insert.sql 
                      '''
                      }
                      
                    } 
            }    
    }
