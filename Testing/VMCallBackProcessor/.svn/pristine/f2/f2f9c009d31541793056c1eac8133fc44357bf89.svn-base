package net.one97.processor.utils;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.impl.io.DefaultHttpResponseParser;
import org.apache.http.impl.io.DefaultHttpResponseParserFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import net.one97.processor.PropertiesExtractor;

public class HttpClientUtil {
	private static final Logger log = Logger.getLogger(HttpClientUtil.class);

	private HttpClientUtil() {
	}

	private static CloseableHttpClient httpClient = null;
	private static RequestConfig requestConfig = null;

	public static synchronized CloseableHttpClient getHttpClientInstance() {
		if (httpClient == null) {
			httpClient = HttpClientUtil.getHttpClient();
			log.info(" HTTPClient Created");
		}
		return httpClient;
	}

	public static synchronized RequestConfig getRequestConfig() {
		if (requestConfig == null) {
			requestConfig = HttpClientUtil.createRequestConfig();
		}
		return requestConfig;
	}

	private static CloseableHttpClient getHttpClient() {
		log.info("Createing HTTPClient");
		// Use custom message parser / writer to customize the way HTTP
		// messages are parsed from and written out to the data stream.
		HttpMessageParserFactory<HttpResponse> responseParserFactory = new DefaultHttpResponseParserFactory() {

			@Override
			public HttpMessageParser<HttpResponse> create(SessionInputBuffer buffer, MessageConstraints constraints) {
				LineParser lineParser = new BasicLineParser() {

					@Override
					public Header parseHeader(final CharArrayBuffer buffer) {
						try {
							return super.parseHeader(buffer);
						} catch (ParseException ex) {
							return new BasicHeader(buffer.toString(), null);
						}
					}

				};
				return new DefaultHttpResponseParser(buffer, lineParser, DefaultHttpResponseFactory.INSTANCE,
						constraints) {

				};
			}

		};
		HttpMessageWriterFactory<HttpRequest> requestWriterFactory = new DefaultHttpRequestWriterFactory();

		// Use a custom connection factory to customize the process of
		// initialization of outgoing HTTP connections. Beside standard
		// connection
		// configuration parameters HTTP connection factory can define message
		// parser / writer routines to be employed by individual connections.
		HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory = new ManagedHttpClientConnectionFactory(
				requestWriterFactory, responseParserFactory);

		// Client HTTP connection objects when fully initialized can be bound to
		// an arbitrary network socket. The process of network socket
		// initialization,
		// its connection to a remote address and binding to a local one is
		// controlled
		// by a connection socket factory.

		// SSL context for secure connections can be created either based on
		// system or application specific properties.

		// Create a registry of custom connection socket factories for supported
		// protocol schemes.

		// Create a connection manager with custom configuration.
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(connFactory);

		// Configure the connection manager to use socket configuration either
		// by default or for a specific host.

		// Validate connections after 1 sec of inactivity
		connManager.setValidateAfterInactivity(1000);

		// Create message constraints
		MessageConstraints messageConstraints = MessageConstraints.DEFAULT;
		// Create connection configuration
		ConnectionConfig connectionConfig = ConnectionConfig.custom().setMalformedInputAction(CodingErrorAction.IGNORE)
				.setUnmappableInputAction(CodingErrorAction.IGNORE).setCharset(Consts.UTF_8)
				.setMessageConstraints(messageConstraints).build();
		// Configure the connection manager to use connection configuration
		// either
		// by default or for a specific host.
		connManager.setDefaultConnectionConfig(connectionConfig);
		// Configure total max or per route limits for persistent connections
		// that can be kept in the pool or leased by the connection manager.
		int maxConn = 100;
		try {
			maxConn = Integer.parseInt(PropertiesExtractor.getProperty("http.max.connection"));
		} catch (Exception exception) {
			log.error(" Exception Occured while setting maxConn " + exception.getMessage());
		}

		connManager.setMaxTotal(maxConn);
		connManager.setDefaultMaxPerRoute(10);
		// Create an HttpClient with the given custom dependencies and
		// configuration.
		return HttpClients.createMinimal(connManager);
	}

	private static RequestConfig createRequestConfig() {
		log.info("Creating RequestConfig");
		RequestConfig defaultRequestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT)
				.setExpectContinueEnabled(true)
				.setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
				.setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
		int timeOut = 60000;
		try {
			timeOut = Integer.parseInt(PropertiesExtractor.getProperty("http.timeout"));
		} catch (Exception exception) {
			log.error(" Exception Occured while setting timeOut " + exception.getMessage());
		}
		return RequestConfig.copy(defaultRequestConfig).setSocketTimeout(timeOut).setConnectTimeout(timeOut)
				.setConnectionRequestTimeout(timeOut).build();
	}

	public static String getResponseString(final String msisdn, final HttpResponse response) {
		try {
			return (response.getEntity() != null) ? EntityUtils.toString(response.getEntity()) : null;
		} catch (ParseException e) {
			log.error(msisdn + "ParseException/IOException ", e);
		}catch (Exception e) {
			log.error(msisdn + "Exception ", e);
		}
		return null;
	}

}
