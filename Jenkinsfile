node {
    def server = Artifactory.server "artifactory"
    def rtMaven = Artifactory.newMavenBuild()
    def buildInfo
    try {
        notifySlack()
        stage ('Checkout') {
            checkout scm
        }
    
        stage ('Artifactory configuration') {
            rtMaven.tool = "maven" // Tool name from Jenkins configuration
            rtMaven.deployer releaseRepo: 'libs-release-local', snapshotRepo: 'libs-snapshot-local', server: server
            rtMaven.resolver releaseRepo: 'libs-release', snapshotRepo: 'libs-snapshot', server: server
            rtMaven.deployer.deployArtifacts = false // Disable artifacts deployment during Maven run

            buildInfo = Artifactory.newBuildInfo()
        }
    
        stage ('Test') {
            rtMaven.run pom: 'pom.xml', goals: 'clean test'
        }
            
        stage ('Install') {
            rtMaven.run pom: 'pom.xml', goals: 'install', buildInfo: buildInfo
            fingerprint 'target/*.jar'
        }
    
        stage ('Deploy') {
            rtMaven.deployer.deployArtifacts buildInfo
        }
            
        stage ('Publish build info') {
            server.publishBuildInfo buildInfo
        }
    } catch (e) {
        currentBuild.result = 'FAILURE'
        throw e
    } finally {
        notifySlack(currentBuild.result)
    }
}

def notifySlack(String buildStatus = 'STARTED') {
    // Build status of null means success.
    buildStatus = buildStatus ?: 'SUCCESS'

    def color

    if (buildStatus == 'STARTED') {
        color = '#D4DADF'
    } else if (buildStatus == 'SUCCESS') {
        color = '#BDFFC3'
    } else if (buildStatus == 'UNSTABLE') {
        color = '#FFFE89'
    } else {
        color = '#FF9FA1'
    }

    def msg = "${buildStatus}: `${env.JOB_NAME}` #${env.BUILD_NUMBER}:\n${env.BUILD_URL}"

    slackSend(color: color, message: msg)
}