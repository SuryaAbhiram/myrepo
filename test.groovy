pipeline {
    agent any

    stages {
        stage('DDL') {
            steps {
                sh(script:"""
				mysql -h suryadb22.cvirjo0fysae.us-east-1.rds.amazonaws.com -P 3306 -u suryadb22 -psuryadb22 -D test < create.sql 
                """)
            }
        }stage('DML'){
            steps{
                sh(script:"""
                mysql -h suryadb22.cvirjo0fysae.us-east-1.rds.amazonaws.com -P 3306 -u suryadb22 -psuryadb22 -D test < insert.sql
                """)
            }
        }
    }
}