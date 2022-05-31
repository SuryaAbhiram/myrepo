pipeline {
    agent {label 'linux'}
    environment{
        rdscreds = credentials('RDS_DEPLOY')
        } 
        stages {
             stage('Deploy1'){
                 steps{
                       sh '''#!/bin/bash
                       cd data
                       mysql -h suryadb22.cvirjo0fysae.us-east-1.rds.amazonaws.com -P 3306 -u $rdscreds_USR -p$rdscreds_PSW -D test < create.sql
                      '''
                      }
                    }
                 stage('Deploy2'){
                    steps{
                        sh '''#!/bin/bash
                        cd data
                        mysql -h suryadb22.cvirjo0fysae.us-east-1.rds.amazonaws.com -P 3306 -u $rdscreds_USR -p$rdscreds_PSW -D test < insert.sql 
                      '''
                      }
                      
                    } 
            }
        
    }
