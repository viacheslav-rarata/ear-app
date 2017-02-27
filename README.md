# ear-app

To REDEPLOY only one .war file included in .ear:
- doc: http://sqltech.cl/doc/oas11gR1/web.1111/e13702/redeploy.htm#i1025500
- example: java -cp /home/bmath/weblogic/wlserver/server/lib/weblogic.jar weblogic.Deployer -username root -password Tf9Hdc4Sd -redeploy -name ear_ear_exploded -targets app1-1.0.0.war@AdminServer
