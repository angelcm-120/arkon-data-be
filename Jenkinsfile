pipeline {
    environment {
        scannerHome=tool 'SonarQube'

    }
    agent any
    stages {
        stage('clean workspace'){
            steps {
                sh '''
                    ls
                    echo $directorio
                    java -version
                    rm -r -f /p/a/t/h Checkmarx
                    rm -rf /p/a/t/h build
                '''
            }
        }
        stage('ambiente') {
            steps {
               contentReplace(
                   configs: [
                       fileContentReplaceConfig(
                           configs: [
                               fileContentReplaceItemConfig(
                                   search: 'devlocal',
                                   replace: '${ambiente}',
                                   matchCount: 1)
                           ],
                           fileEncoding: 'UTF-8',
                           filePath: 'src/main/resources/application.properties')
               ])
            }
        }
        stage('gradle tasks') {
            steps {
                script {
                    if(offline == 'no') {
                        sh "${tool 'Gradle7.0'}/bin/gradle tasks"
                    }
                    else{
                        sh "${tool 'Gradle7.0'}/bin/gradle --offline tasks"
                    }
                }
            }
        }
        stage('gradle build') {
            steps {
                script {
                    if(offline == 'no') {
                        sh "${tool 'Gradle7.0'}/bin/gradle build -x test"
                    }
                    else{
                        sh "${tool 'Gradle7.0'}/bin/gradle --offline build -x test"
                    }
                }
            }
        }
        stage('gradle test') {
            steps {
                script {
                    if(ambiente == 'devlocal') {
                        if(offline == 'no') {
                            sh "${tool 'Gradle7.0'}/bin/gradle test"
                            sh '''
                                mkdir -p coverage
                                cp ./build/reports/jacoco/test/jacocoTestReport.xml ./coverage/jacoco.xml
                            '''
                        }
                        else{
                            sh "${tool 'Gradle7.0'}/bin/gradle --offline test"
                            sh '''
                                mkdir -p coverage
                                cp ./build/reports/jacoco/test/jacocoTestReport.xml ./coverage/jacoco.xml
                            '''
                        }

                    }else{
                        echo 'test solo se corren en devlocal'
                    }
                }
            }
        }
        stage('SonarQube Analysis Dev') {
            steps{
                withSonarQubeEnv('SonarQubeDev') {
                    sh "${scannerHome}/bin/sonar-scanner -D'sonar.login=$sonarpoclogin2' -D'sonar.host.url=http://devops:9004'"
                }
            }
        }
      stage('SonarQube Analysis') {
            steps{
                withSonarQubeEnv('SonarQube') {
                    sh "${scannerHome}/bin/sonar-scanner -D'sonar.login=$sonarpoclogin'"
                }
            }
        }
        stage('Checkmarx') {
            steps {
                script {
                    if(Checkmarx == 'si') {
                        step([$class: 'CxScanBuilder',
                        addGlobalCommenToBuildCommet: true,
                        comment: '',
                        configAsCode: true,
                        credentialsId: 'checkmarxcloud',
                        excludeFolders: '',
                        exclusionsSetting: 'global',
                        failBuildOnNewResults: false,
                        failBuildOnNewSeverity: 'HIGH',
                        filterPattern: '''!**/_cvs/**/*, !**/.svn/**/*, !**/.hg/**/*, !**/.git/**/*, !**/.bzr/**/*,
                            !**/.gitgnore/**/*, !**/.gradle/**/*, !**/.checkstyle/**/*, !**/.classpath/**/*, !**/bin/**/*,
                            !**/obj/**/*, !**/backup/**/*, !**/.idea/**/*, !**/*.DS_Store, !**/*.ipr, !**/*.iws,
                            !**/*.bak, !**/*.tmp, !**/*.aac, !**/*.aif, !**/*.iff, !**/*.m3u, !**/*.mid, !**/*.mp3,
                            !**/*.mpa, !**/*.ra, !**/*.wav, !**/*.wma, !**/*.3g2, !**/*.3gp, !**/*.asf, !**/*.asx,
                            !**/*.avi, !**/*.flv, !**/*.mov, !**/*.mp4, !**/*.mpg, !**/*.rm, !**/*.swf, !**/*.vob,
                            !**/*.wmv, !**/*.bmp, !**/*.gif, !**/*.jpg, !**/*.png, !**/*.psd, !**/*.tif, !**/*.swf,
                            !**/*.jar, !**/*.zip, !**/*.rar, !**/*.exe, !**/*.dll, !**/*.pdb, !**/*.7z, !**/*.gz,
                            !**/*.tar.gz, !**/*.tar, !**/*.gz, !**/*.ahtm, !**/*.ahtml, !**/*.fhtml, !**/*.hdm,
                            !**/*.hdml, !**/*.hsql, !**/*.ht, !**/*.hta, !**/*.htc, !**/*.htd, !**/*.war, !**/*.ear,
                            !**/*.htmls, !**/*.ihtml, !**/*.mht, !**/*.mhtm, !**/*.mhtml, !**/*.ssi, !**/*.stm,
                            !**/*.bin,!**/*.lock,!**/*.svg,!**/*.obj,
                            !**/*.stml, !**/*.ttml, !**/*.txn, !**/*.xhtm, !**/*.xhtml, !**/*.class, !**/*.iml, !Checkmarx/Reports/*.*,
                            !OSADependencies.json, !**/node_modules/**/*, !**/build/**, !**/gradle/**, !**/.gradle/**, !**/.idea/**''',
                        fullScanCycle: 10,
                        fullScansScheduled: true,
                        generatePdfReport: true,
                        groupId: '123',
                        incremental: true,
                        password: '{AQAAABAAAAAQmytvsivAP0KIfpxWFw7UNbjbR/QWPtDY0U+TdmDrurs=}',
                        preset: '36',
                        projectName: 'mso_template',
                        sastEnabled: true,
                        serverUrl: 'https://10.64.248.39/',
                        sourceEncoding: '1',
                        useOwnServerCredentials: true,
                        username: '',
                        vulnerabilityThresholdEnabled: true,
                        vulnerabilityThresholdResult: 'UNSTABLE',
                        waitForResultsEnabled: true])
                    }
                    else{
                        echo 'El pipeline no solicitó revisión con checkmarx'
                        sh 'sleep 120'
                    }
                }
            }
        }
        stage("SonarQube QualityGate") {
            steps {
                timeout(time: 60, unit: 'SECONDS') {
                    waitForQualityGate (abortPipeline: true)
                }
            }
        }
        stage('artifactory jar') {
            steps {
                    sh "${tool 'Gradle7.0'}/bin/gradle publishAllPublicationsToDevopsRepository"
            }
        }
        stage('gradle bootjar') {
            steps {
                sh "${tool 'Gradle7.0'}/bin/gradle bootJar"
            }
        }
        stage('artifactory docker') {
            steps {
                script {
                    if(deploy == 'sí') {
                        sh '''
                            $dockerlogin
                            export imagen=$(cat image.txt)
                            docker build -t $repositoryArtifactory/$imagen .
                            docker push $repositoryArtifactory/$imagen
                        '''
                    }else{
                        echo 'El pipeline no solicitó despliegue en el repositoryArtifactory'
                    }
                }
            }
        }
        stage('harbor') {
            steps {
                script {
                    if(deploy == 'sí') {
                        sh '''
                            export imagen=$(cat image.txt)
                            docker build -t $repositoryharbor/$imagen .
                            docker push $repositoryharbor/$imagen
                        '''
                    }else{
                        echo 'El pipeline no solicitó despliegue en el repositoryharbor'
                    }
                }
            }
        }
        stage('archivos'){
            steps {
                step([$class: 'ArtifactArchiver', artifacts: '**/build/libs/*.jar', fingerprint: true])
            }
        }
    }
}
