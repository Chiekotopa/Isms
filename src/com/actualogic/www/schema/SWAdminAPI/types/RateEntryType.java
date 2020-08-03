/**
 * RateEntryType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI.types;

public class RateEntryType  implements java.io.Serializable {
    private java.lang.String agentId;

    private java.lang.String rateId;

    private java.lang.String destNumber;

    private java.lang.String destNumberDesc;

    private long rate;

    private long setupCost;

    private long freeTime;

    public RateEntryType() {
    }

    public RateEntryType(
           java.lang.String agentId,
           java.lang.String rateId,
           java.lang.String destNumber,
           java.lang.String destNumberDesc,
           long rate,
           long setupCost,
           long freeTime) {
           this.agentId = agentId;
           this.rateId = rateId;
           this.destNumber = destNumber;
           this.destNumberDesc = destNumberDesc;
           this.rate = rate;
           this.setupCost = setupCost;
           this.freeTime = freeTime;
    }


    /**
     * Gets the agentId value for this RateEntryType.
     * 
     * @return agentId
     */
    public java.lang.String getAgentId() {
        return agentId;
    }


    /**
     * Sets the agentId value for this RateEntryType.
     * 
     * @param agentId
     */
    public void setAgentId(java.lang.String agentId) {
        this.agentId = agentId;
    }


    /**
     * Gets the rateId value for this RateEntryType.
     * 
     * @return rateId
     */
    public java.lang.String getRateId() {
        return rateId;
    }


    /**
     * Sets the rateId value for this RateEntryType.
     * 
     * @param rateId
     */
    public void setRateId(java.lang.String rateId) {
        this.rateId = rateId;
    }


    /**
     * Gets the destNumber value for this RateEntryType.
     * 
     * @return destNumber
     */
    public java.lang.String getDestNumber() {
        return destNumber;
    }


    /**
     * Sets the destNumber value for this RateEntryType.
     * 
     * @param destNumber
     */
    public void setDestNumber(java.lang.String destNumber) {
        this.destNumber = destNumber;
    }


    /**
     * Gets the destNumberDesc value for this RateEntryType.
     * 
     * @return destNumberDesc
     */
    public java.lang.String getDestNumberDesc() {
        return destNumberDesc;
    }


    /**
     * Sets the destNumberDesc value for this RateEntryType.
     * 
     * @param destNumberDesc
     */
    public void setDestNumberDesc(java.lang.String destNumberDesc) {
        this.destNumberDesc = destNumberDesc;
    }


    /**
     * Gets the rate value for this RateEntryType.
     * 
     * @return rate
     */
    public long getRate() {
        return rate;
    }


    /**
     * Sets the rate value for this RateEntryType.
     * 
     * @param rate
     */
    public void setRate(long rate) {
        this.rate = rate;
    }


    /**
     * Gets the setupCost value for this RateEntryType.
     * 
     * @return setupCost
     */
    public long getSetupCost() {
        return setupCost;
    }


    /**
     * Sets the setupCost value for this RateEntryType.
     * 
     * @param setupCost
     */
    public void setSetupCost(long setupCost) {
        this.setupCost = setupCost;
    }


    /**
     * Gets the freeTime value for this RateEntryType.
     * 
     * @return freeTime
     */
    public long getFreeTime() {
        return freeTime;
    }


    /**
     * Sets the freeTime value for this RateEntryType.
     * 
     * @param freeTime
     */
    public void setFreeTime(long freeTime) {
        this.freeTime = freeTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RateEntryType)) return false;
        RateEntryType other = (RateEntryType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.agentId==null && other.getAgentId()==null) || 
             (this.agentId!=null &&
              this.agentId.equals(other.getAgentId()))) &&
            ((this.rateId==null && other.getRateId()==null) || 
             (this.rateId!=null &&
              this.rateId.equals(other.getRateId()))) &&
            ((this.destNumber==null && other.getDestNumber()==null) || 
             (this.destNumber!=null &&
              this.destNumber.equals(other.getDestNumber()))) &&
            ((this.destNumberDesc==null && other.getDestNumberDesc()==null) || 
             (this.destNumberDesc!=null &&
              this.destNumberDesc.equals(other.getDestNumberDesc()))) &&
            this.rate == other.getRate() &&
            this.setupCost == other.getSetupCost() &&
            this.freeTime == other.getFreeTime();
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
        if (getAgentId() != null) {
            _hashCode += getAgentId().hashCode();
        }
        if (getRateId() != null) {
            _hashCode += getRateId().hashCode();
        }
        if (getDestNumber() != null) {
            _hashCode += getDestNumber().hashCode();
        }
        if (getDestNumberDesc() != null) {
            _hashCode += getDestNumberDesc().hashCode();
        }
        _hashCode += new Long(getRate()).hashCode();
        _hashCode += new Long(getSetupCost()).hashCode();
        _hashCode += new Long(getFreeTime()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RateEntryType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "rateEntryType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rateId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "rateId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "destNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destNumberDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "destNumberDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "rate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("setupCost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "setupCost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("freeTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "freeTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
