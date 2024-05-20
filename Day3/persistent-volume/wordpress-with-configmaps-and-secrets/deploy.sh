echo "\nDeploying mariadb sever ..."
oc apply -f mariadb-cm.yml
oc apply -f mariadb-secrets.yml
oc apply -f mariadb-pv.yml
oc apply -f mariadb-pvc.yml
oc apply -f mariadb-deploy.yml
oc apply -f mariadb-svc.yml


echo "\nDeploying wordpress server ..."
oc apply -f wordpress-pv.yml
oc apply -f wordpress-pvc.yml
oc apply -f wordpress-deploy.yml
oc apply -f wordpress-svc.yml
oc apply -f wordpress-route.yml

oc get all
