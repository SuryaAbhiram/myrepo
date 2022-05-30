pipeline {
    agent any
    withCredentials([file(credentialsId: 'RDS_creds', variable: 'rds_creds')]) {
        dns="${rds_creds.DNS}"
        user="${rds_creds.USER}"
        pass="${rds_creds.PASSWORD}"
     }
        stages {
             stage('Deploy1'){
                 steps{
                       sh '''#!/bin/bash
                       cd data
                       mysql -h ${dns} -P 3306 -u ${user} -p${pass} -D test < create.sql 
                      '''
                      }
                    }
                 stage('Deploy2'){
                    steps{
                        sh '''#!/bin/bash
                        cd data
                        mysql -h ${dns} -P 3306 -u ${user} -p${pass} -D test -D test < insert.sql 
                      '''
                      }
                      
                    } 
            }    
    }
