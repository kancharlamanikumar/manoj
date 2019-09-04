def ciBuildTrigger = "job_dsl"
def githubUrl = "https://github.com/kancharlamanikumar/manoj/"
def repositoryUrl = "https://github.com/kancharlamanikumar/manoj.git"
def branchName = "*/master"

freeStyleJob(ciBuildTrigger) {
    logRotator {
        numToKeep(3)
        artifactNumToKeep(1)
        }
    properties{
        githubProjectUrl(githubUrl)
        }
   jdk('linux-jdk-1.8.0_20')
   label 'node name'
   scm{
      git{
         
        remote {
          name ('origin')
          url(repositoryUrl)
          
        }
        }
        }
   mavenInstallation("Maven-citools-3.3.9")
   goals('clean install --debug checkstyle:checkstyle pmd:pmd spotbugs:spotbugs')
     publishers {
        archiveArtifacts('artifacts')
        }
        }
