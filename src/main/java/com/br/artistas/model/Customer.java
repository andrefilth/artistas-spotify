//package com.br.artistas.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import java.time.ZonedDateTime;
//
//@Entity(name = "CUSTOMER")
//public class Customer {
//
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String document;
//
//    private ZonedDateTime createdAt;
//    private ZonedDateTime updatedAt;
//
//    public Customer() {
//    }
//
//    public Customer(Builder builder) {
//        this.id = builder.id;
//        this.name = builder.name;
//        this.document = builder.document;
//        this.createdAt = builder.createdAt;
//        this.updatedAt = builder.updatedAt;
//    }
//
//    public static Builder builder() {
//        return new Builder();
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDocument() {
//        return document;
//    }
//
//    public void setDocument(String document) {
//        this.document = document;
//    }
//
//    public ZonedDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(ZonedDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public ZonedDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(ZonedDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public static final class Builder {
//        private Long id;
//        private String name;
//        private String document;
//        private ZonedDateTime createdAt;
//        private ZonedDateTime updatedAt;
//
//        public Builder setId(Long id) {
//            this.id = id;
//            return this;
//        }
//
//        public Builder setName(String name){
//            this.name = name;
//            return this;
//        }
//
//        public Builder setDocument(String document){
//            this.document = document;
//            return this;
//        }
//
//        public Builder setCreatedAt(ZonedDateTime createdAt){
//            this.createdAt = createdAt;
//            return this;
//        }
//
//        public Builder setUpdateAt(ZonedDateTime updateAt){
//            this.updatedAt = updateAt;
//            return this;
//        }
//
//        public Customer build(){
//            return new Customer(this);
//        }
//
//    }
//}
