/**
 * ServiceDetailsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI.types;

public class ServiceDetailsType  implements java.io.Serializable {
    private long nLines;

    private boolean limitService;

    private boolean tracing;

    private boolean jobNumber;

    private java.lang.String sendA;

    private boolean lastOK;

    private boolean security;

    private boolean redial;

    private java.lang.String cli;

    private java.lang.String cliUse;

    private byte cliRes;

    private byte cliNat;

    private byte cliScr;

    private java.lang.String aoc;

    private short coef;

    private long unit;

    private java.lang.String languageId;

    private java.lang.String vMail;

    private java.lang.String swDomainId;

    private java.lang.String ingress;

    private java.lang.String password;

    private java.lang.String zone;

    private java.lang.String profileX;

    public ServiceDetailsType() {
    }

    public ServiceDetailsType(
           long nLines,
           boolean limitService,
           boolean tracing,
           boolean jobNumber,
           java.lang.String sendA,
           boolean lastOK,
           boolean security,
           boolean redial,
           java.lang.String cli,
           java.lang.String cliUse,
           byte cliRes,
           byte cliNat,
           byte cliScr,
           java.lang.String aoc,
           short coef,
           long unit,
           java.lang.String languageId,
           java.lang.String vMail,
           java.lang.String swDomainId,
           java.lang.String ingress,
           java.lang.String password,
           java.lang.String zone,
           java.lang.String profileX) {
           this.nLines = nLines;
           this.limitService = limitService;
           this.tracing = tracing;
           this.jobNumber = jobNumber;
           this.sendA = sendA;
           this.lastOK = lastOK;
           this.security = security;
           this.redial = redial;
           this.cli = cli;
           this.cliUse = cliUse;
           this.cliRes = cliRes;
           this.cliNat = cliNat;
           this.cliScr = cliScr;
           this.aoc = aoc;
           this.coef = coef;
           this.unit = unit;
           this.languageId = languageId;
           this.vMail = vMail;
           this.swDomainId = swDomainId;
           this.ingress = ingress;
           this.password = password;
           this.zone = zone;
           this.profileX = profileX;
    }


    /**
     * Gets the nLines value for this ServiceDetailsType.
     * 
     * @return nLines
     */
    public long getNLines() {
        return nLines;
    }


    /**
     * Sets the nLines value for this ServiceDetailsType.
     * 
     * @param nLines
     */
    public void setNLines(long nLines) {
        this.nLines = nLines;
    }


    /**
     * Gets the limitService value for this ServiceDetailsType.
     * 
     * @return limitService
     */
    public boolean isLimitService() {
        return limitService;
    }


    /**
     * Sets the limitService value for this ServiceDetailsType.
     * 
     * @param limitService
     */
    public void setLimitService(boolean limitService) {
        this.limitService = limitService;
    }


    /**
     * Gets the tracing value for this ServiceDetailsType.
     * 
     * @return tracing
     */
    public boolean isTracing() {
        return tracing;
    }


    /**
     * Sets the tracing value for this ServiceDetailsType.
     * 
     * @param tracing
     */
    public void setTracing(boolean tracing) {
        this.tracing = tracing;
    }


    /**
     * Gets the jobNumber value for this ServiceDetailsType.
     * 
     * @return jobNumber
     */
    public boolean isJobNumber() {
        return jobNumber;
    }


    /**
     * Sets the jobNumber value for this ServiceDetailsType.
     * 
     * @param jobNumber
     */
    public void setJobNumber(boolean jobNumber) {
        this.jobNumber = jobNumber;
    }


    /**
     * Gets the sendA value for this ServiceDetailsType.
     * 
     * @return sendA
     */
    public java.lang.String getSendA() {
        return sendA;
    }


    /**
     * Sets the sendA value for this ServiceDetailsType.
     * 
     * @param sendA
     */
    public void setSendA(java.lang.String sendA) {
        this.sendA = sendA;
    }


    /**
     * Gets the lastOK value for this ServiceDetailsType.
     * 
     * @return lastOK
     */
    public boolean isLastOK() {
        return lastOK;
    }


    /**
     * Sets the lastOK value for this ServiceDetailsType.
     * 
     * @param lastOK
     */
    public void setLastOK(boolean lastOK) {
        this.lastOK = lastOK;
    }


    /**
     * Gets the security value for this ServiceDetailsType.
     * 
     * @return security
     */
    public boolean isSecurity() {
        return security;
    }


    /**
     * Sets the security value for this ServiceDetailsType.
     * 
     * @param security
     */
    public void setSecurity(boolean security) {
        this.security = security;
    }


    /**
     * Gets the redial value for this ServiceDetailsType.
     * 
     * @return redial
     */
    public boolean isRedial() {
        return redial;
    }


    /**
     * Sets the redial value for this ServiceDetailsType.
     * 
     * @param redial
     */
    public void setRedial(boolean redial) {
        this.redial = redial;
    }


    /**
     * Gets the cli value for this ServiceDetailsType.
     * 
     * @return cli
     */
    public java.lang.String getCli() {
        return cli;
    }


    /**
     * Sets the cli value for this ServiceDetailsType.
     * 
     * @param cli
     */
    public void setCli(java.lang.String cli) {
        this.cli = cli;
    }


    /**
     * Gets the cliUse value for this ServiceDetailsType.
     * 
     * @return cliUse
     */
    public java.lang.String getCliUse() {
        return cliUse;
    }


    /**
     * Sets the cliUse value for this ServiceDetailsType.
     * 
     * @param cliUse
     */
    public void setCliUse(java.lang.String cliUse) {
        this.cliUse = cliUse;
    }


    /**
     * Gets the cliRes value for this ServiceDetailsType.
     * 
     * @return cliRes
     */
    public byte getCliRes() {
        return cliRes;
    }


    /**
     * Sets the cliRes value for this ServiceDetailsType.
     * 
     * @param cliRes
     */
    public void setCliRes(byte cliRes) {
        this.cliRes = cliRes;
    }


    /**
     * Gets the cliNat value for this ServiceDetailsType.
     * 
     * @return cliNat
     */
    public byte getCliNat() {
        return cliNat;
    }


    /**
     * Sets the cliNat value for this ServiceDetailsType.
     * 
     * @param cliNat
     */
    public void setCliNat(byte cliNat) {
        this.cliNat = cliNat;
    }


    /**
     * Gets the cliScr value for this ServiceDetailsType.
     * 
     * @return cliScr
     */
    public byte getCliScr() {
        return cliScr;
    }


    /**
     * Sets the cliScr value for this ServiceDetailsType.
     * 
     * @param cliScr
     */
    public void setCliScr(byte cliScr) {
        this.cliScr = cliScr;
    }


    /**
     * Gets the aoc value for this ServiceDetailsType.
     * 
     * @return aoc
     */
    public java.lang.String getAoc() {
        return aoc;
    }


    /**
     * Sets the aoc value for this ServiceDetailsType.
     * 
     * @param aoc
     */
    public void setAoc(java.lang.String aoc) {
        this.aoc = aoc;
    }


    /**
     * Gets the coef value for this ServiceDetailsType.
     * 
     * @return coef
     */
    public short getCoef() {
        return coef;
    }


    /**
     * Sets the coef value for this ServiceDetailsType.
     * 
     * @param coef
     */
    public void setCoef(short coef) {
        this.coef = coef;
    }


    /**
     * Gets the unit value for this ServiceDetailsType.
     * 
     * @return unit
     */
    public long getUnit() {
        return unit;
    }


    /**
     * Sets the unit value for this ServiceDetailsType.
     * 
     * @param unit
     */
    public void setUnit(long unit) {
        this.unit = unit;
    }


    /**
     * Gets the languageId value for this ServiceDetailsType.
     * 
     * @return languageId
     */
    public java.lang.String getLanguageId() {
        return languageId;
    }


    /**
     * Sets the languageId value for this ServiceDetailsType.
     * 
     * @param languageId
     */
    public void setLanguageId(java.lang.String languageId) {
        this.languageId = languageId;
    }


    /**
     * Gets the vMail value for this ServiceDetailsType.
     * 
     * @return vMail
     */
    public java.lang.String getVMail() {
        return vMail;
    }


    /**
     * Sets the vMail value for this ServiceDetailsType.
     * 
     * @param vMail
     */
    public void setVMail(java.lang.String vMail) {
        this.vMail = vMail;
    }


    /**
     * Gets the swDomainId value for this ServiceDetailsType.
     * 
     * @return swDomainId
     */
    public java.lang.String getSwDomainId() {
        return swDomainId;
    }


    /**
     * Sets the swDomainId value for this ServiceDetailsType.
     * 
     * @param swDomainId
     */
    public void setSwDomainId(java.lang.String swDomainId) {
        this.swDomainId = swDomainId;
    }


    /**
     * Gets the ingress value for this ServiceDetailsType.
     * 
     * @return ingress
     */
    public java.lang.String getIngress() {
        return ingress;
    }


    /**
     * Sets the ingress value for this ServiceDetailsType.
     * 
     * @param ingress
     */
    public void setIngress(java.lang.String ingress) {
        this.ingress = ingress;
    }


    /**
     * Gets the password value for this ServiceDetailsType.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this ServiceDetailsType.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the zone value for this ServiceDetailsType.
     * 
     * @return zone
     */
    public java.lang.String getZone() {
        return zone;
    }


    /**
     * Sets the zone value for this ServiceDetailsType.
     * 
     * @param zone
     */
    public void setZone(java.lang.String zone) {
        this.zone = zone;
    }


    /**
     * Gets the profileX value for this ServiceDetailsType.
     * 
     * @return profileX
     */
    public java.lang.String getProfileX() {
        return profileX;
    }


    /**
     * Sets the profileX value for this ServiceDetailsType.
     * 
     * @param profileX
     */
    public void setProfileX(java.lang.String profileX) {
        this.profileX = profileX;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceDetailsType)) return false;
        ServiceDetailsType other = (ServiceDetailsType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.nLines == other.getNLines() &&
            this.limitService == other.isLimitService() &&
            this.tracing == other.isTracing() &&
            this.jobNumber == other.isJobNumber() &&
            ((this.sendA==null && other.getSendA()==null) || 
             (this.sendA!=null &&
              this.sendA.equals(other.getSendA()))) &&
            this.lastOK == other.isLastOK() &&
            this.security == other.isSecurity() &&
            this.redial == other.isRedial() &&
            ((this.cli==null && other.getCli()==null) || 
             (this.cli!=null &&
              this.cli.equals(other.getCli()))) &&
            ((this.cliUse==null && other.getCliUse()==null) || 
             (this.cliUse!=null &&
              this.cliUse.equals(other.getCliUse()))) &&
            this.cliRes == other.getCliRes() &&
            this.cliNat == other.getCliNat() &&
            this.cliScr == other.getCliScr() &&
            ((this.aoc==null && other.getAoc()==null) || 
             (this.aoc!=null &&
              this.aoc.equals(other.getAoc()))) &&
            this.coef == other.getCoef() &&
            this.unit == other.getUnit() &&
            ((this.languageId==null && other.getLanguageId()==null) || 
             (this.languageId!=null &&
              this.languageId.equals(other.getLanguageId()))) &&
            ((this.vMail==null && other.getVMail()==null) || 
             (this.vMail!=null &&
              this.vMail.equals(other.getVMail()))) &&
            ((this.swDomainId==null && other.getSwDomainId()==null) || 
             (this.swDomainId!=null &&
              this.swDomainId.equals(other.getSwDomainId()))) &&
            ((this.ingress==null && other.getIngress()==null) || 
             (this.ingress!=null &&
              this.ingress.equals(other.getIngress()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.zone==null && other.getZone()==null) || 
             (this.zone!=null &&
              this.zone.equals(other.getZone()))) &&
            ((this.profileX==null && other.getProfileX()==null) || 
             (this.profileX!=null &&
              this.profileX.equals(other.getProfileX())));
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
        _hashCode += new Long(getNLines()).hashCode();
        _hashCode += (isLimitService() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTracing() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isJobNumber() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSendA() != null) {
            _hashCode += getSendA().hashCode();
        }
        _hashCode += (isLastOK() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSecurity() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isRedial() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCli() != null) {
            _hashCode += getCli().hashCode();
        }
        if (getCliUse() != null) {
            _hashCode += getCliUse().hashCode();
        }
        _hashCode += getCliRes();
        _hashCode += getCliNat();
        _hashCode += getCliScr();
        if (getAoc() != null) {
            _hashCode += getAoc().hashCode();
        }
        _hashCode += getCoef();
        _hashCode += new Long(getUnit()).hashCode();
        if (getLanguageId() != null) {
            _hashCode += getLanguageId().hashCode();
        }
        if (getVMail() != null) {
            _hashCode += getVMail().hashCode();
        }
        if (getSwDomainId() != null) {
            _hashCode += getSwDomainId().hashCode();
        }
        if (getIngress() != null) {
            _hashCode += getIngress().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getZone() != null) {
            _hashCode += getZone().hashCode();
        }
        if (getProfileX() != null) {
            _hashCode += getProfileX().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceDetailsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "serviceDetailsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NLines");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "nLines"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limitService");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "limitService"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tracing");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "tracing"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "jobNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "sendA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastOK");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "lastOK"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("security");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "security"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("redial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "redial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("cliUse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cliUse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliRes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cliRes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliNat");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cliNat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliScr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cliScr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aoc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "aoc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coef");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "coef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "unit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("VMail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "vMail"));
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
        elemField.setFieldName("ingress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ingress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "zone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profileX");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "profileX"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
