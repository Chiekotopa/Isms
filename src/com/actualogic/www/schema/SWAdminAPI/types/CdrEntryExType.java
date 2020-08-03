/**
 * CdrEntryExType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI.types;

public class CdrEntryExType  implements java.io.Serializable {
    private long cdrId;

    private java.util.Calendar cdrDate;

    private java.lang.String agentId;

    private java.lang.String companyId;

    private java.lang.String destNumber;

    private java.lang.String destNumberDesc;

    private long duration;

    private long cost;

    private java.lang.String cli;

    private java.lang.String pin;

    private java.lang.String dnis;

    private short carrier;

    private short inboundCarrier;

    private long rate;

    private long balance;

    private long agentBalance;

    private long agentCost;

    private long termCost;

    private long collectCost;

    private short balanceType;

    private java.lang.String pinType;

    private java.lang.String callbackNumber;

    public CdrEntryExType() {
    }

    public CdrEntryExType(
           long cdrId,
           java.util.Calendar cdrDate,
           java.lang.String agentId,
           java.lang.String companyId,
           java.lang.String destNumber,
           java.lang.String destNumberDesc,
           long duration,
           long cost,
           java.lang.String cli,
           java.lang.String pin,
           java.lang.String dnis,
           short carrier,
           short inboundCarrier,
           long rate,
           long balance,
           long agentBalance,
           long agentCost,
           long termCost,
           long collectCost,
           short balanceType,
           java.lang.String pinType,
           java.lang.String callbackNumber) {
           this.cdrId = cdrId;
           this.cdrDate = cdrDate;
           this.agentId = agentId;
           this.companyId = companyId;
           this.destNumber = destNumber;
           this.destNumberDesc = destNumberDesc;
           this.duration = duration;
           this.cost = cost;
           this.cli = cli;
           this.pin = pin;
           this.dnis = dnis;
           this.carrier = carrier;
           this.inboundCarrier = inboundCarrier;
           this.rate = rate;
           this.balance = balance;
           this.agentBalance = agentBalance;
           this.agentCost = agentCost;
           this.termCost = termCost;
           this.collectCost = collectCost;
           this.balanceType = balanceType;
           this.pinType = pinType;
           this.callbackNumber = callbackNumber;
    }


    /**
     * Gets the cdrId value for this CdrEntryExType.
     * 
     * @return cdrId
     */
    public long getCdrId() {
        return cdrId;
    }


    /**
     * Sets the cdrId value for this CdrEntryExType.
     * 
     * @param cdrId
     */
    public void setCdrId(long cdrId) {
        this.cdrId = cdrId;
    }


    /**
     * Gets the cdrDate value for this CdrEntryExType.
     * 
     * @return cdrDate
     */
    public java.util.Calendar getCdrDate() {
        return cdrDate;
    }


    /**
     * Sets the cdrDate value for this CdrEntryExType.
     * 
     * @param cdrDate
     */
    public void setCdrDate(java.util.Calendar cdrDate) {
        this.cdrDate = cdrDate;
    }


    /**
     * Gets the agentId value for this CdrEntryExType.
     * 
     * @return agentId
     */
    public java.lang.String getAgentId() {
        return agentId;
    }


    /**
     * Sets the agentId value for this CdrEntryExType.
     * 
     * @param agentId
     */
    public void setAgentId(java.lang.String agentId) {
        this.agentId = agentId;
    }


    /**
     * Gets the companyId value for this CdrEntryExType.
     * 
     * @return companyId
     */
    public java.lang.String getCompanyId() {
        return companyId;
    }


    /**
     * Sets the companyId value for this CdrEntryExType.
     * 
     * @param companyId
     */
    public void setCompanyId(java.lang.String companyId) {
        this.companyId = companyId;
    }


    /**
     * Gets the destNumber value for this CdrEntryExType.
     * 
     * @return destNumber
     */
    public java.lang.String getDestNumber() {
        return destNumber;
    }


    /**
     * Sets the destNumber value for this CdrEntryExType.
     * 
     * @param destNumber
     */
    public void setDestNumber(java.lang.String destNumber) {
        this.destNumber = destNumber;
    }


    /**
     * Gets the destNumberDesc value for this CdrEntryExType.
     * 
     * @return destNumberDesc
     */
    public java.lang.String getDestNumberDesc() {
        return destNumberDesc;
    }


    /**
     * Sets the destNumberDesc value for this CdrEntryExType.
     * 
     * @param destNumberDesc
     */
    public void setDestNumberDesc(java.lang.String destNumberDesc) {
        this.destNumberDesc = destNumberDesc;
    }


    /**
     * Gets the duration value for this CdrEntryExType.
     * 
     * @return duration
     */
    public long getDuration() {
        return duration;
    }


    /**
     * Sets the duration value for this CdrEntryExType.
     * 
     * @param duration
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }


    /**
     * Gets the cost value for this CdrEntryExType.
     * 
     * @return cost
     */
    public long getCost() {
        return cost;
    }


    /**
     * Sets the cost value for this CdrEntryExType.
     * 
     * @param cost
     */
    public void setCost(long cost) {
        this.cost = cost;
    }


    /**
     * Gets the cli value for this CdrEntryExType.
     * 
     * @return cli
     */
    public java.lang.String getCli() {
        return cli;
    }


    /**
     * Sets the cli value for this CdrEntryExType.
     * 
     * @param cli
     */
    public void setCli(java.lang.String cli) {
        this.cli = cli;
    }


    /**
     * Gets the pin value for this CdrEntryExType.
     * 
     * @return pin
     */
    public java.lang.String getPin() {
        return pin;
    }


    /**
     * Sets the pin value for this CdrEntryExType.
     * 
     * @param pin
     */
    public void setPin(java.lang.String pin) {
        this.pin = pin;
    }


    /**
     * Gets the dnis value for this CdrEntryExType.
     * 
     * @return dnis
     */
    public java.lang.String getDnis() {
        return dnis;
    }


    /**
     * Sets the dnis value for this CdrEntryExType.
     * 
     * @param dnis
     */
    public void setDnis(java.lang.String dnis) {
        this.dnis = dnis;
    }


    /**
     * Gets the carrier value for this CdrEntryExType.
     * 
     * @return carrier
     */
    public short getCarrier() {
        return carrier;
    }


    /**
     * Sets the carrier value for this CdrEntryExType.
     * 
     * @param carrier
     */
    public void setCarrier(short carrier) {
        this.carrier = carrier;
    }


    /**
     * Gets the inboundCarrier value for this CdrEntryExType.
     * 
     * @return inboundCarrier
     */
    public short getInboundCarrier() {
        return inboundCarrier;
    }


    /**
     * Sets the inboundCarrier value for this CdrEntryExType.
     * 
     * @param inboundCarrier
     */
    public void setInboundCarrier(short inboundCarrier) {
        this.inboundCarrier = inboundCarrier;
    }


    /**
     * Gets the rate value for this CdrEntryExType.
     * 
     * @return rate
     */
    public long getRate() {
        return rate;
    }


    /**
     * Sets the rate value for this CdrEntryExType.
     * 
     * @param rate
     */
    public void setRate(long rate) {
        this.rate = rate;
    }


    /**
     * Gets the balance value for this CdrEntryExType.
     * 
     * @return balance
     */
    public long getBalance() {
        return balance;
    }


    /**
     * Sets the balance value for this CdrEntryExType.
     * 
     * @param balance
     */
    public void setBalance(long balance) {
        this.balance = balance;
    }


    /**
     * Gets the agentBalance value for this CdrEntryExType.
     * 
     * @return agentBalance
     */
    public long getAgentBalance() {
        return agentBalance;
    }


    /**
     * Sets the agentBalance value for this CdrEntryExType.
     * 
     * @param agentBalance
     */
    public void setAgentBalance(long agentBalance) {
        this.agentBalance = agentBalance;
    }


    /**
     * Gets the agentCost value for this CdrEntryExType.
     * 
     * @return agentCost
     */
    public long getAgentCost() {
        return agentCost;
    }


    /**
     * Sets the agentCost value for this CdrEntryExType.
     * 
     * @param agentCost
     */
    public void setAgentCost(long agentCost) {
        this.agentCost = agentCost;
    }


    /**
     * Gets the termCost value for this CdrEntryExType.
     * 
     * @return termCost
     */
    public long getTermCost() {
        return termCost;
    }


    /**
     * Sets the termCost value for this CdrEntryExType.
     * 
     * @param termCost
     */
    public void setTermCost(long termCost) {
        this.termCost = termCost;
    }


    /**
     * Gets the collectCost value for this CdrEntryExType.
     * 
     * @return collectCost
     */
    public long getCollectCost() {
        return collectCost;
    }


    /**
     * Sets the collectCost value for this CdrEntryExType.
     * 
     * @param collectCost
     */
    public void setCollectCost(long collectCost) {
        this.collectCost = collectCost;
    }


    /**
     * Gets the balanceType value for this CdrEntryExType.
     * 
     * @return balanceType
     */
    public short getBalanceType() {
        return balanceType;
    }


    /**
     * Sets the balanceType value for this CdrEntryExType.
     * 
     * @param balanceType
     */
    public void setBalanceType(short balanceType) {
        this.balanceType = balanceType;
    }


    /**
     * Gets the pinType value for this CdrEntryExType.
     * 
     * @return pinType
     */
    public java.lang.String getPinType() {
        return pinType;
    }


    /**
     * Sets the pinType value for this CdrEntryExType.
     * 
     * @param pinType
     */
    public void setPinType(java.lang.String pinType) {
        this.pinType = pinType;
    }


    /**
     * Gets the callbackNumber value for this CdrEntryExType.
     * 
     * @return callbackNumber
     */
    public java.lang.String getCallbackNumber() {
        return callbackNumber;
    }


    /**
     * Sets the callbackNumber value for this CdrEntryExType.
     * 
     * @param callbackNumber
     */
    public void setCallbackNumber(java.lang.String callbackNumber) {
        this.callbackNumber = callbackNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CdrEntryExType)) return false;
        CdrEntryExType other = (CdrEntryExType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cdrId == other.getCdrId() &&
            ((this.cdrDate==null && other.getCdrDate()==null) || 
             (this.cdrDate!=null &&
              this.cdrDate.equals(other.getCdrDate()))) &&
            ((this.agentId==null && other.getAgentId()==null) || 
             (this.agentId!=null &&
              this.agentId.equals(other.getAgentId()))) &&
            ((this.companyId==null && other.getCompanyId()==null) || 
             (this.companyId!=null &&
              this.companyId.equals(other.getCompanyId()))) &&
            ((this.destNumber==null && other.getDestNumber()==null) || 
             (this.destNumber!=null &&
              this.destNumber.equals(other.getDestNumber()))) &&
            ((this.destNumberDesc==null && other.getDestNumberDesc()==null) || 
             (this.destNumberDesc!=null &&
              this.destNumberDesc.equals(other.getDestNumberDesc()))) &&
            this.duration == other.getDuration() &&
            this.cost == other.getCost() &&
            ((this.cli==null && other.getCli()==null) || 
             (this.cli!=null &&
              this.cli.equals(other.getCli()))) &&
            ((this.pin==null && other.getPin()==null) || 
             (this.pin!=null &&
              this.pin.equals(other.getPin()))) &&
            ((this.dnis==null && other.getDnis()==null) || 
             (this.dnis!=null &&
              this.dnis.equals(other.getDnis()))) &&
            this.carrier == other.getCarrier() &&
            this.inboundCarrier == other.getInboundCarrier() &&
            this.rate == other.getRate() &&
            this.balance == other.getBalance() &&
            this.agentBalance == other.getAgentBalance() &&
            this.agentCost == other.getAgentCost() &&
            this.termCost == other.getTermCost() &&
            this.collectCost == other.getCollectCost() &&
            this.balanceType == other.getBalanceType() &&
            ((this.pinType==null && other.getPinType()==null) || 
             (this.pinType!=null &&
              this.pinType.equals(other.getPinType()))) &&
            ((this.callbackNumber==null && other.getCallbackNumber()==null) || 
             (this.callbackNumber!=null &&
              this.callbackNumber.equals(other.getCallbackNumber())));
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
        _hashCode += new Long(getCdrId()).hashCode();
        if (getCdrDate() != null) {
            _hashCode += getCdrDate().hashCode();
        }
        if (getAgentId() != null) {
            _hashCode += getAgentId().hashCode();
        }
        if (getCompanyId() != null) {
            _hashCode += getCompanyId().hashCode();
        }
        if (getDestNumber() != null) {
            _hashCode += getDestNumber().hashCode();
        }
        if (getDestNumberDesc() != null) {
            _hashCode += getDestNumberDesc().hashCode();
        }
        _hashCode += new Long(getDuration()).hashCode();
        _hashCode += new Long(getCost()).hashCode();
        if (getCli() != null) {
            _hashCode += getCli().hashCode();
        }
        if (getPin() != null) {
            _hashCode += getPin().hashCode();
        }
        if (getDnis() != null) {
            _hashCode += getDnis().hashCode();
        }
        _hashCode += getCarrier();
        _hashCode += getInboundCarrier();
        _hashCode += new Long(getRate()).hashCode();
        _hashCode += new Long(getBalance()).hashCode();
        _hashCode += new Long(getAgentBalance()).hashCode();
        _hashCode += new Long(getAgentCost()).hashCode();
        _hashCode += new Long(getTermCost()).hashCode();
        _hashCode += new Long(getCollectCost()).hashCode();
        _hashCode += getBalanceType();
        if (getPinType() != null) {
            _hashCode += getPinType().hashCode();
        }
        if (getCallbackNumber() != null) {
            _hashCode += getCallbackNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CdrEntryExType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrEntryExType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdrId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdrDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "companyId"));
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
        elemField.setFieldName("duration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "duration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cli");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cli"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "pin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dnis");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "dnis"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carrier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "carrier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inboundCarrier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "inboundCarrier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "rate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("balance");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "balance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentBalance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentCost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("termCost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "termCost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("collectCost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "collectCost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("balanceType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "balanceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pinType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "pinType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("callbackNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "callbackNumber"));
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
