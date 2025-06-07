def call(String status) {
    if (status == 'SUCCESS') {
        emailext (
            subject: "Build Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
            body: """Hello Team,

Build succeeded for job ${env.JOB_NAME} #${env.BUILD_NUMBER}.

Build details: ${env.BUILD_URL}

Regards,
Jenkins""",
            to: 'anantlaghane@gmail.com'
        )
    } else if (status == 'FAILURE') {
        emailext (
            subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
            body: """Hello Team,

Build failed for job ${env.JOB_NAME} #${env.BUILD_NUMBER}.

Please check logs at: ${env.BUILD_URL}

Regards,
Jenkins""",
            to: 'anantlaghane@gmail.com'
        )
    }
}
