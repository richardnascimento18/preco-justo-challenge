package br.com.preco.justo.infrastructure.ports.in.web.dto.response;

import java.time.Instant;
import java.util.Map;

public class ApiResponseDto<T> {

    private final int status;
    private final String version;
    private final Instant timestamp;
    private final T data;
    private final Map<String, Link> _links;

    public ApiResponseDto(int status, String version, T data, Map<String, Link> links) {
        this.status = status;
        this.version = version;
        this.timestamp = Instant.now();
        this.data = data;
        this._links = links;
    }

    public int getStatus() { return status; }
    public String getVersion() { return version; }
    public Instant getTimestamp() { return timestamp; }
    public T getData() { return data; }
    public Map<String, Link> get_links() { return _links; }

    public static class Link {
        private final String method;
        private final String href;
        private final String rel;

        public Link(String method, String href, String rel) {
            this.method = method;
            this.href = href;
            this.rel = rel;
        }

        public String getMethod() { return method; }
        public String getHref() { return href; }
        public String getRel() { return rel; }
    }
}
