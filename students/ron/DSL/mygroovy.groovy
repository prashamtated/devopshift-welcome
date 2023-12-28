job('Ron NodeJS example') { // Job NAME
    scm { // Configure Source control management 
        git('https://github.com/yanivomc/devopshift-welcome.git', '*/elbit/jenkinsdec26') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User - ronhu')
            node / gitConfigEmail('jenkins-dsl@domain.com')
        }
    }
    triggers { // Configure when to check for changes 
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('NodeJS') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps { // what steps to take 
        shell("npm install")
    }
}