//package com.br.artistas.spotify.services.request;
//
//import org.apache.commons.lang3.builder.ToStringBuilder;
//
//import java.util.List;
//
//import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;
//
//public class RouteRequest {
//
//    private List<String> routes;
//    private String origin;
//    private String destiny;
//
//    public List<String> getRoutes() {
//        return routes;
//    }
//
//    public void setRoutes(List<String> routes) {
//        this.routes = routes;
//    }
//
//    public String getOrigin() {
//        return origin;
//    }
//
//    public void setOrigin(String origin) {
//        this.origin = origin;
//    }
//
//    public String getDestiny() {
//        return destiny;
//    }
//
//    public void setDestiny(String destiny) {
//        this.destiny = destiny;
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this, JSON_STYLE)
//                .append("routes", routes)
//                .append("origin", origin)
//                .append("destiny", destiny)
//                .build();
//    }
//}
