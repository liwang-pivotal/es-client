package io.spring.esdemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.floragunn.searchguard.ssl.SearchGuardSSLPlugin;
import com.floragunn.searchguard.ssl.util.SSLConfigConstants;

@Configuration
public class EsDemoConfig {
	
	@Bean
	public TransportClient getESTemplate() throws UnknownHostException {
		Settings settings = Settings.builder()
				.put("cluster.name", "myesdb")
				.put("searchguard.ssl.transport.enabled", true)
                .put(SSLConfigConstants.SEARCHGUARD_SSL_HTTP_ENABLE_OPENSSL_IF_AVAILABLE, true)
                .put(SSLConfigConstants.SEARCHGUARD_SSL_TRANSPORT_ENABLE_OPENSSL_IF_AVAILABLE, true)
                .put("searchguard.ssl.transport.keystore_filepath", "/Users/lwang/Desktop/node-keystore.jks")
                .put("searchguard.ssl.transport.keystore_password", "changeit")
                .put("searchguard.ssl.transport.truststore_filepath", "/Users/lwang/Desktop/truststore.jks")
                .put("searchguard.ssl.transport.truststore_password", "changeit")
                .put("searchguard.ssl.transport.enforce_hostname_verification", false)
                .put("searchguard.ssl.transport.resolve_hostname", false)
                .build();

		TransportClient client = new PreBuiltTransportClient(settings, SearchGuardSSLPlugin.class);

		client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		
		return client;
	}

}
