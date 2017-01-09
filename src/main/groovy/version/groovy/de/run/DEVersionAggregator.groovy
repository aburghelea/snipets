package version.groovy.de.run

import groovy.json.JsonBuilder
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

import static Method.GET
import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.ContentType.TEXT
import static version.groovy.de.run.Constants.*

/**
 * @author <a href="mailto:alexandru.burghelea@adswizz.com">Alexandru BURGHELEA</a>
 * @since 26/11/15
 */


class DEVersionAggregator {
    public static void main(String[] args) {
        print new JsonBuilder(clientsPerVersionMap()).toPrettyString();
    }

    static clientsPerVersionMap() {
        def clientsPerVersionMap = [:]
        HTTP_BUILDER.request(CLIENTS_CONFIGURATION_URL, GET, JSON) {
            response.success = { ignored, clients ->
                clients.findAll {
                    it.active
                }.collect({
                    try {
                    [(CLIENT): it.name] << HTTP_BUILDER.request("$URL_PREFIX${it.name}$URL_SUFFIX", GET, TEXT) {
                        response.success = {
                            ignore, statusReader ->
                                statusReader.readLines().grep({ line -> line.contains GIT_COMMIT }).collectEntries({ line ->
                                    def tokens = line.split SEPARATOR
                                    [(tokens[0].contains(ABBREV) ? SHA : TAG): tokens[1]]
                                })
                        }
                    }} catch (Exception e) {
                        [(CLIENT):name] << ["Connection" : "refused"];
                    }
                })
            }
        }.each {
            if (!clientsPerVersionMap.containsKey(it.tag)) {
                clientsPerVersionMap[(it.tag)] = [];
            }
            clientsPerVersionMap[(it.tag)] << it.client
        }
        clientsPerVersionMap
    }
}

interface Constants {
    static final CLIENTS_CONFIGURATION_URL = 'http://configuration-api.adserver.adswizz.com:8080/clients'
    static final URL_PREFIX = 'http://'
    static final URL_SUFFIX = '.adswizz.com/getStatus'
    static final GIT_COMMIT = "git.commit"
    static final String ABBREV = 'abbrev'
    static final String SHA = 'sha'
    static final String TAG = 'tag'
    static final String CLIENT = 'client'
    static final HTTP_BUILDER = new HTTPBuilder();
    static final SEPARATOR = ' = ';
}