/**
 * QuickNumberDetailsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI.types;

public class QuickNumberDetailsType  implements java.io.Serializable {
    private java.lang.String destinationNumber;

    private long cost;

    private long offset;

    private long length;

    private long rate;

    private java.lang.String swDomainId;

    private java.lang.String fileName;

    public QuickNumberDetailsType() {
    }

    public QuickNumberDetailsType(
           java.lang.String destinationNumber,
           long cost,
           long offset,
           long length,
           long rate,
           java.lang.String swDomainId,
           java.lang.String fileName) {
           this.destinationNumber = destinationNumber;
           this.cost = cost;
           this.offset = offset;
           this.length = length;
           this.rate = rate;
           this.swDomainId = swDomainId;
           this.fileName = fileName;
    }


    /**
     * Gets the destinationNumber value for this QuickNumberDetailsType.
     * 
     * @return destinationNumber
     */
    public java.lang.String getDestinationNumber() {
        return destinationNumber;
    }


    /**
     * Sets the destinationNumber value for this QuickNumberDetailsType.
     * 
     * @param destinationNumber
     */
    public void setDestinationNumber(java.lang.String destinationNumber) {
        this.destinationNumber = destinationNumber;
    }


    /**
     * Gets the cost value for this QuickNumberDetailsType.
     * 
     * @return cost
     */
    public long getCost() {
        return cost;
    }


    /**
     * Sets the cost value for this QuickNumberDetailsType.
     * 
     * @param cost
     */
    public void setCost(long cost) {
        this.cost = cost;
    }


    /**
     * Gets the offset value for this QuickNumberDetailsType.
     * 
     * @return offset
     */
    public long getOffset() {
        return offset;
    }


    /**
     * Sets the offset value for this QuickNumberDetailsType.
     * 
     * @param offset
     */
    public void setOffset(long offset) {
        this.offset = offset;
    }


    /**
     * Gets the length value for this QuickNumberDetailsType.
     * 
     * @return length
     */
    public long getLength() {
        return length;
    }


    /**
     * Sets the length value for this QuickNumberDetailsType.
     * 
     * @param length
     */
    public void setLength(long length) {
        this.length = length;
    }


    /**
     * Gets the rate value for this QuickNumberDetailsType.
     * 
     * @return rate
     */
    public long getRate() {
        return rate;
    }


    /**
     * Sets the rate value for this QuickNumberDetailsType.
     * 
     * @param rate
     */
    public void setRate(long rate) {
        this.rate = rate;
    }


    /**
     * Gets the swDomainId value for this QuickNumberDetailsType.
     * 
     * @return swDomainId
     */
    public java.lang.String getSwDomainId() {
        return swDomainId;
    }


    /**
     * Sets the swDomainId value for this QuickNumberDetailsType.
     * 
     * @param swDomainId
     */
    public void setSwDomainId(java.lang.String swDomainId) {
        this.swDomainId = swDomainId;
    }


    /**
     * Gets the fileName value for this QuickNumberDetailsType.
     * 
     * @return fileName
     */
    public java.lang.String getFileName() {
        return fileName;
    }


    /**
     * Sets the fileName value for this QuickNumberDetailsType.
     * 
     * @param fileName
     */
    public void setFileName(java.lang.String fileName) {
        this.fileName = fileName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QuickNumberDetailsType)) return false;
        QuickNumberDetailsType other = (QuickNumberDetailsType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.destinationNumber==null && other.getDestinationNumber()==null) || 
             (this.destinationNumber!=null &&
              this.destinationNumber.equals(other.getDestinationNumber()))) &&
            this.cost == other.getCost() &&
            this.offset == other.getOffset() &&
            this.length == other.getLength() &&
            this.rate == other.getRate() &&
            ((this.swDomainId==null && other.getSwDomainId()==null) || 
             (this.swDomainId!=null &&
              this.swDomainId.equals(other.getSwDomainId()))) &&
            ((this.fileName==null && other.getFileName()==null) || 
             (this.fileName!=null &&
              this.fileName.equals(other.getFileName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDestinationNumber() != null) {
            _hashCode += getDestinationNumber().hashCode();
        }
        _hashCode += new Long(getCost()).hashCode();
        _hashCode += new Long(getOffset()).hashCode();
        _hashCode += new Long(getLength()).hashCode();
        _hashCode += new Long(getRate()).hashCode();
        if (getSwDomainId() != null) {
            _hashCode += getSwDomainId().hashCode();
        }
        if (getFileName() != null) {
            _hashCode += getFileName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QuickNumberDetailsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "quickNumberDetailsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "destinationNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "offset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("length");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "length"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "rate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("swDomainId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "swDomainId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "fileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
