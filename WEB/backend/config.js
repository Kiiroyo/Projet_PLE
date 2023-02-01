const hbase = require('hbase')
const krb5 = require('krb5')
client = hbase({
    host: 'lsd-prod-namenode-0.lsd.novalocal',
    protocol: 'https',
    port: 8080,
    krb5: {
        service_principal: 'HTTP/lsd-prod-namenode-0.lsd.novalocal',//il faut preciser le service principal,il n'est pas bien construit dans le code du package hbase si on ne le donne pas
        principal: "ahabachi@LSD.NOVALOCAL"//,
    }
})