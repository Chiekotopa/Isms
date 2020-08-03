/**
 * CompanyDetailsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI.types;

public class CompanyDetailsType  implements java.io.Serializable {
    private java.lang.String shortName;

    private java.lang.String longName;

    private boolean limitService;

    private java.lang.String languageId;

    private short maxUser;

    private boolean sendC;

    private boolean priority;

    private short maxDuration;

    private java.lang.String weekProfile;

    private java.lang.String weekendProfile;

    private java.lang.String fridayProfile;

    private boolean timeLimit;

    private int timeBalance;

    private byte cbDelay;

    private java.lang.String cbDefault;

    private java.lang.Short cbCcode;

    private java.lang.String announce;

    private java.lang.String routeId;

    private java.lang.String dataId;

    private java.lang.String payphoneId;

    private long adminChg;

    private byte adminInt;

    private java.lang.String currency;

    private java.lang.String swDomainId;

    private java.lang.String rounding;

    private java.lang.String register;

    private short region;

    public CompanyDetailsType() {
    }

    public CompanyDetailsType(
           java.lang.String shortName,
           java.lang.String longName,
           boolean limitService,
           java.lang.String languageId,
           short maxUser,
           boolean sendC,
           boolean priority,
           short maxDuration,
           java.lang.String weekProfile,
           java.lang.String weekendProfile,
           java.lang.String fridayProfile,
           boolean timeLimit,
           int timeBalance,
           byte cbDelay,
           java.lang.String cbDefault,
           java.lang.Short cbCcode,
           java.lang.String announce,
           java.lang.String routeId,
           java.lang.String dataId,
           java.lang.String payphoneId,
           long adminChg,
           byte adminInt,
           java.lang.String currency,
           java.lang.String swDomainId,
           java.lang.String rounding,
           java.lang.String register,
           short region) {
           this.shortName = shortName;
           this.longName = longName;
           this.limitService = limitService;
           this.languageId = languageId;
           this.maxUser = maxUser;
           this.sendC = sendC;
           this.priority = priority;
           this.maxDuration = maxDuration;
           this.weekProfile = weekProfile;
           this.weekendProfile = weekendProfile;
           this.fridayProfile = fridayProfile;
           this.timeLimit = timeLimit;
           this.timeBalance = timeBalance;
           this.cbDelay = cbDelay;
           this.cbDefault = cbDefault;
           this.cbCcode = cbCcode;
           this.announce = announce;
           this.routeId = routeId;
           this.dataId = dataId;
           this.payphoneId = payphoneId;
           this.adminChg = adminChg;
           this.adminInt = adminInt;
           this.currency = currency;
           this.swDomainId = swDomainId;
           this.rounding = rounding;
           this.register = register;
           this.region = region;
    }


    /**
     * Gets the shortName value for this CompanyDetailsType.
     * 
     * @return shortName
     */
    public java.lang.String getShortName() {
        return shortName;
    }


    /**
     * Sets the shortName value for this CompanyDetailsType.
     * 
     * @param shortName
     */
    public void setShortName(java.lang.String shortName) {
        this.shortName = shortName;
    }


    /**
     * Gets the longName value for this CompanyDetailsType.
     * 
     * @return longName
     */
    public java.lang.String getLongName() {
        return longName;
    }


    /**
     * Sets the longName value for this CompanyDetailsType.
     * 
     * @param longName
     */
    public void setLongName(java.lang.String longName) {
        this.longName = longName;
    }


    /**
     * Gets the limitService value for this CompanyDetailsType.
     * 
     * @return limitService
     */
    public boolean isLimitService() {
        return limitService;
    }


    /**
     * Sets the limitService value for this CompanyDetailsType.
     * 
     * @param limitService
     */
    public void setLimitService(boolean limitService) {
        this.limitService = limitService;
    }


    /**
     * Gets the languageId value for this CompanyDetailsType.
     * 
     * @return languageId
     */
    public java.lang.String getLanguageId() {
        return languageId;
    }


    /**
     * Sets the languageId value for this CompanyDetailsType.
     * 
     * @param languageId
     */
    public void setLanguageId(java.lang.String languageId) {
        this.languageId = languageId;
    }


    /**
     * Gets the maxUser value for this CompanyDetailsType.
     * 
     * @return maxUser
     */
    public short getMaxUser() {
        return maxUser;
    }


    /**
     * Sets the maxUser value for this CompanyDetailsType.
     * 
     * @param maxUser
     */
    public void setMaxUser(short maxUser) {
        this.maxUser = maxUser;
    }


    /**
     * Gets the sendC value for this CompanyDetailsType.
     * 
     * @return sendC
     */
    public boolean isSendC() {
        return sendC;
    }


    /**
     * Sets the sendC value for this CompanyDetailsType.
     * 
     * @param sendC
     */
    public void setSendC(boolean sendC) {
        this.sendC = sendC;
    }


    /**
     * Gets the priority value for this CompanyDetailsType.
     * 
     * @return priority
     */
    public boolean isPriority() {
        return priority;
    }


    /**
     * Sets the priority value for this CompanyDetailsType.
     * 
     * @param priority
     */
    public void setPriority(boolean priority) {
        this.priority = priority;
    }


    /**
     * Gets the maxDuration value for this CompanyDetailsType.
     * 
     * @return maxDuration
     */
    public short getMaxDuration() {
        return maxDuration;
    }


    /**
     * Sets the maxDuration value for this CompanyDetailsType.
     * 
     * @param maxDuration
     */
    public void setMaxDuration(short maxDuration) {
        this.maxDuration = maxDuration;
    }


    /**
     * Gets the weekProfile value for this CompanyDetailsType.
     * 
     * @return weekProfile
     */
    public java.lang.String getWeekProfile() {
        return weekProfile;
    }


    /**
     * Sets the weekProfile value for this CompanyDetailsType.
     * 
     * @param weekProfile
     */
    public void setWeekProfile(java.lang.String weekProfile) {
        this.weekProfile = weekProfile;
    }


    /**
     * Gets the weekendProfile value for this CompanyDetailsType.
     * 
     * @return weekendProfile
     */
    public java.lang.String getWeekendProfile() {
        return weekendProfile;
    }


    /**
     * Sets the weekendProfile value for this CompanyDetailsType.
     * 
     * @param weekendProfile
     */
    public void setWeekendProfile(java.lang.String weekendProfile) {
        this.weekendProfile = weekendProfile;
    }


    /**
     * Gets the fridayProfile value for this CompanyDetailsType.
     * 
     * @return fridayProfile
     */
    public java.lang.String getFridayProfile() {
        return fridayProfile;
    }


    /**
     * Sets the fridayProfile value for this CompanyDetailsType.
     * 
     * @param fridayProfile
     */
    public void setFridayProfile(java.lang.String fridayProfile) {
        this.fridayProfile = fridayProfile;
    }


    /**
     * Gets the timeLimit value for this CompanyDetailsType.
     * 
     * @return timeLimit
     */
    public boolean isTimeLimit() {
        return timeLimit;
    }


    /**
     * Sets the timeLimit value for this CompanyDetailsType.
     * 
     * @param timeLimit
     */
    public void setTimeLimit(boolean timeLimit) {
        this.timeLimit = timeLimit;
    }


    /**
     * Gets the timeBalance value for this CompanyDetailsType.
     * 
     * @return timeBalance
     */
    public int getTimeBalance() {
        return timeBalance;
    }


    /**
     * Sets the timeBalance value for this CompanyDetailsType.
     * 
     * @param timeBalance
     */
    public void setTimeBalance(int timeBalance) {
        this.timeBalance = timeBalance;
    }


    /**
     * Gets the cbDelay value for this CompanyDetailsType.
     * 
     * @return cbDelay
     */
    public byte getCbDelay() {
        return cbDelay;
    }


    /**
     * Sets the cbDelay value for this CompanyDetailsType.
     * 
     * @param cbDelay
     */
    public void setCbDelay(byte cbDelay) {
        this.cbDelay = cbDelay;
    }


    /**
     * Gets the cbDefault value for this CompanyDetailsType.
     * 
     * @return cbDefault
     */
    public java.lang.String getCbDefault() {
        return cbDefault;
    }


    /**
     * Sets the cbDefault value for this CompanyDetailsType.
     * 
     * @param cbDefault
     */
    public void setCbDefault(java.lang.String cbDefault) {
        this.cbDefault = cbDefault;
    }


    /**
     * Gets the cbCcode value for this CompanyDetailsType.
     * 
     * @return cbCcode
     */
    public java.lang.Short getCbCcode() {
        return cbCcode;
    }


    /**
     * Sets the cbCcode value for this CompanyDetailsType.
     * 
     * @param cbCcode
     */
    public void setCbCcode(java.lang.Short cbCcode) {
        this.cbCcode = cbCcode;
    }


    /**
     * Gets the announce value for this CompanyDetailsType.
     * 
     * @return announce
     */
    public java.lang.String getAnnounce() {
        return announce;
    }


    /**
     * Sets the announce value for this CompanyDetailsType.
     * 
     * @param announce
     */
    public void setAnnounce(java.lang.String announce) {
        this.announce = announce;
    }


    /**
     * Gets the routeId value for this CompanyDetailsType.
     * 
     * @return routeId
     */
    public java.lang.String getRouteId() {
        return routeId;
    }


    /**
     * Sets the routeId value for this CompanyDetailsType.
     * 
     * @param routeId
     */
    public void setRouteId(java.lang.String routeId) {
        this.routeId = routeId;
    }


    /**
     * Gets the dataId value for this CompanyDetailsType.
     * 
     * @return dataId
     */
    public java.lang.String getDataId() {
        return dataId;
    }


    /**
     * Sets the dataId value for this CompanyDetailsType.
     * 
     * @param dataId
     */
    public void setDataId(java.lang.String dataId) {
        this.dataId = dataId;
    }


    /**
     * Gets the payphoneId value for this CompanyDetailsType.
     * 
     * @return payphoneId
     */
    public java.lang.String getPayphoneId() {
        return payphoneId;
    }


    /**
     * Sets the payphoneId value for this CompanyDetailsType.
     * 
     * @param payphoneId
     */
    public void setPayphoneId(java.lang.String payphoneId) {
        this.payphoneId = payphoneId;
    }


    /**
     * Gets the adminChg value for this CompanyDetailsType.
     * 
     * @return adminChg
     */
    public long getAdminChg() {
        return adminChg;
    }


    /**
     * Sets the adminChg value for this CompanyDetailsType.
     * 
     * @param adminChg
     */
    public void setAdminChg(long adminChg) {
        this.adminChg = adminChg;
    }


    /**
     * Gets the adminInt value for this CompanyDetailsType.
     * 
     * @return adminInt
     */
    public byte getAdminInt() {
        return adminInt;
    }


    /**
     * Sets the adminInt value for this CompanyDetailsType.
     * 
     * @param adminInt
     */
    public void setAdminInt(byte adminInt) {
        this.adminInt = adminInt;
    }


    /**
     * Gets the currency value for this CompanyDetailsType.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this CompanyDetailsType.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the swDomainId value for this CompanyDetailsType.
     * 
     * @return swDomainId
     */
    public java.lang.String getSwDomainId() {
        return swDomainId;
    }


    /**
     * Sets the swDomainId value for this CompanyDetailsType.
     * 
     * @param swDomainId
     */
    public void setSwDomainId(java.lang.String swDomainId) {
        this.swDomainId = swDomainId;
    }


    /**
     * Gets the rounding value for this CompanyDetailsType.
     * 
     * @return rounding
     */
    public java.lang.String getRounding() {
        return rounding;
    }


    /**
     * Sets the rounding value for this CompanyDetailsType.
     * 
     * @param rounding
     */
    public void setRounding(java.lang.String rounding) {
        this.rounding = rounding;
    }


    /**
     * Gets the register value for this CompanyDetailsType.
     * 
     * @return register
     */
    public java.lang.String getRegister() {
        return register;
    }


    /**
     * Sets the register value for this CompanyDetailsType.
     * 
     * @param register
     */
    public void setRegister(java.lang.String register) {
        this.register = register;
    }


    /**
     * Gets the region value for this CompanyDetailsType.
     * 
     * @return region
     */
    public short getRegion() {
        return region;
    }


    /**
     * Sets the region value for this CompanyDetailsType.
     * 
     * @param region
     */
    public void setRegion(short region) {
        this.region = region;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CompanyDetailsType)) return false;
        CompanyDetailsType other = (CompanyDetailsType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.shortName==null && other.getShortName()==null) || 
             (this.shortName!=null &&
              this.shortName.equals(other.getShortName()))) &&
            ((this.longName==null && other.getLongName()==null) || 
             (this.longName!=null &&
              this.longName.equals(other.getLongName()))) &&
            this.limitService == other.isLimitService() &&
            ((this.languageId==null && other.getLanguageId()==null) || 
             (this.languageId!=null &&
              this.languageId.equals(other.getLanguageId()))) &&
            this.maxUser == other.getMaxUser() &&
            this.sendC == other.isSendC() &&
            this.priority == other.isPriority() &&
            this.maxDuration == other.getMaxDuration() &&
            ((this.weekProfile==null && other.getWeekProfile()==null) || 
             (this.weekProfile!=null &&
              this.weekProfile.equals(other.getWeekProfile()))) &&
            ((this.weekendProfile==null && other.getWeekendProfile()==null) || 
             (this.weekendProfile!=null &&
              this.weekendProfile.equals(other.getWeekendProfile()))) &&
            ((this.fridayProfile==null && other.getFridayProfile()==null) || 
             (this.fridayProfile!=null &&
              this.fridayProfile.equals(other.getFridayProfile()))) &&
            this.timeLimit == other.isTimeLimit() &&
            this.timeBalance == other.getTimeBalance() &&
            this.cbDelay == other.getCbDelay() &&
            ((this.cbDefault==null && other.getCbDefault()==null) || 
             (this.cbDefault!=null &&
              this.cbDefault.equals(other.getCbDefault()))) &&
            ((this.cbCcode==null && other.getCbCcode()==null) || 
             (this.cbCcode!=null &&
              this.cbCcode.equals(other.getCbCcode()))) &&
            ((this.announce==null && other.getAnnounce()==null) || 
             (this.announce!=null &&
              this.announce.equals(other.getAnnounce()))) &&
            ((this.routeId==null && other.getRouteId()==null) || 
             (this.routeId!=null &&
              this.routeId.equals(other.getRouteId()))) &&
            ((this.dataId==null && other.getDataId()==null) || 
             (this.dataId!=null &&
              this.dataId.equals(other.getDataId()))) &&
            ((this.payphoneId==null && other.getPayphoneId()==null) || 
             (this.payphoneId!=null &&
              this.payphoneId.equals(other.getPayphoneId()))) &&
            this.adminChg == other.getAdminChg() &&
            this.adminInt == other.getAdminInt() &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.swDomainId==null && other.getSwDomainId()==null) || 
             (this.swDomainId!=null &&
              this.swDomainId.equals(other.getSwDomainId()))) &&
            ((this.rounding==null && other.getRounding()==null) || 
             (this.rounding!=null &&
              this.rounding.equals(other.getRounding()))) &&
            ((this.register==null && other.getRegister()==null) || 
             (this.register!=null &&
              this.register.equals(other.getRegister()))) &&
            this.region == other.getRegion();
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
        if (getShortName() != null) {
            _hashCode += getShortName().hashCode();
        }
        if (getLongName() != null) {
            _hashCode += getLongName().hashCode();
        }
        _hashCode += (isLimitService() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getLanguageId() != null) {
            _hashCode += getLanguageId().hashCode();
        }
        _hashCode += getMaxUser();
        _hashCode += (isSendC() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isPriority() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getMaxDuration();
        if (getWeekProfile() != null) {
            _hashCode += getWeekProfile().hashCode();
        }
        if (getWeekendProfile() != null) {
            _hashCode += getWeekendProfile().hashCode();
        }
        if (getFridayProfile() != null) {
            _hashCode += getFridayProfile().hashCode();
        }
        _hashCode += (isTimeLimit() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getTimeBalance();
        _hashCode += getCbDelay();
        if (getCbDefault() != null) {
            _hashCode += getCbDefault().hashCode();
        }
        if (getCbCcode() != null) {
            _hashCode += getCbCcode().hashCode();
        }
        if (getAnnounce() != null) {
            _hashCode += getAnnounce().hashCode();
        }
        if (getRouteId() != null) {
            _hashCode += getRouteId().hashCode();
        }
        if (getDataId() != null) {
            _hashCode += getDataId().hashCode();
        }
        if (getPayphoneId() != null) {
            _hashCode += getPayphoneId().hashCode();
        }
        _hashCode += new Long(getAdminChg()).hashCode();
        _hashCode += getAdminInt();
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getSwDomainId() != null) {
            _hashCode += getSwDomainId().hashCode();
        }
        if (getRounding() != null) {
            _hashCode += getRounding().hashCode();
        }
        if (getRegister() != null) {
            _hashCode += getRegister().hashCode();
        }
        _hashCode += getRegion();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CompanyDetailsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "companyDetailsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shortName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "shortName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "longName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limitService");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "limitService"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("languageId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "languageId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxUser");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "maxUser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "sendC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priority");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "priority"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxDuration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "maxDuration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weekProfile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "weekProfile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weekendProfile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "weekendProfile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fridayProfile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "fridayProfile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeLimit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "timeLimit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "timeBalance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cbDelay");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cbDelay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cbDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cbDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cbCcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cbCcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("announce");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "announce"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("routeId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "routeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "dataId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payphoneId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "payphoneId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adminChg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "adminChg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adminInt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "adminInt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("swDomainId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "swDomainId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rounding");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "rounding"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("register");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "register"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("region");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "region"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
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
