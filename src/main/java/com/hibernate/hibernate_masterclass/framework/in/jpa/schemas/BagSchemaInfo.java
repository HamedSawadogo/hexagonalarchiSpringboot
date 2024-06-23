package com.hibernate.hibernate_masterclass.framework.in.jpa.schemas;

/**
 * Projection for {@link BagSchema}
 */
public interface BagSchemaInfo {
    Long getId();

    String getBrand();

    String getColor();

    String getType();

    String getMaterial();

    Integer getCompartments();

    String getDimensions();

    Double getWeight();
}