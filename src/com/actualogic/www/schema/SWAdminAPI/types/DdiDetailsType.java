/**
 * DdiDetailsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI.types;

public class DdiDetailsType  implements java.io.Serializable {
    private java.lang.String agentId;

    private java.lang.String companyId;

    private boolean inUse;

    private java.lang.String service;

    private int hzTone;

    private java.lang.String languageId;

    private java.lang.String destinationNumber;

    private java.lang.String announce;

    private java.lang.String provider;

    private short accLength;

    private short pinLength;

    private long cost;

    private boolean ext;

    private java.lang.String profileX;

    private java.lang.String operatorQueue;

    private java.lang.String operatorWait;

    private java.lang.String prefix;

    private java.lang.String operatorLanguageId;

    private boolean debitCLI;

    private java.lang.String mode;

    private java.lang.String quickNumber;

    private java.lang.String routeX;

    private java.lang.String pin;

    private java.lang.String payphoneX;

    private short region;

    private java.lang.String swDomainId;

    private java.lang.String ingress;

    private java.lang.String payphoneId;

    private java.lang.String pinService;

    private java.lang.String routeId;

    public DdiDetailsType() {
    }

    public DdiDetailsType(
           java.lang.String agentId,
           java.lang.String companyId,
           boolean inUse,
           java.lang.String service,
           int hzTone,
           java.lang.String languageId,
           java.lang.String destinationNumber,
           java.lang.String announce,
           java.lang.String provider,
           short accLength,
           short pinLength,
           long cost,
           boolean ext,
           java.lang.String profileX,
           java.lang.String operatorQueue,
           java.lang.String operatorWait,
           java.lang.String prefix,
           java.lang.String operatorLanguageId,
           boolean debitCLI,
           java.lang.String mode,
           java.lang.String quickNumber,
           java.lang.String routeX,
           java.lang.String pin,
           java.lang.String payphoneX,
           short region,
           java.lang.String swDomainId,
           java.lang.String ingress,
           java.lang.String payphoneId,
           java.lang.String pinService,
           java.lang.String routeId) {
           this.agentId = agentId;
           this.companyId = companyId;
           this.inUse = inUse;
           this.service = service;
           this.hzTone = hzTone;
           this.languageId = languageId;
           this.destinationNumber = destinationNumber;
           this.announce = announce;
           this.provider = provider;
           this.accLength = accLength;
           this.pinLength = pinLength;
           this.cost = cost;
           this.ext = ext;
           this.profileX = profileX;
           this.operatorQueue = operatorQueue;
           this.operatorWait = operatorWait;
           this.prefix = prefix;
           this.operatorLanguageId = operatorLanguageId;
           this.debitCLI = debitCLI;
           this.mode = mode;
           this.quickNumber = quickNumber;
           this.routeX = routeX;
           this.pin = pin;
           this.payphoneX = payphoneX;
           this.region = region;
           this.swDomainId = swDomainId;
           this.ingress = ingress;
           this.payphoneId = payphoneId;
           this.pinService = pinService;
           this.routeId = routeId;
    }


    /**
     * Gets the agentId value for this DdiDetailsType.
     * 
     * @return agentId
     */
    public java.lang.String getAgentId() {
        return agentId;
    }


    /**
     * Sets the agentId value for this DdiDetailsType.
     * 
     * @param agentId
     */
    public void setAgentId(java.lang.String agentId) {
        this.agentId = agentId;
    }


    /**
     * Gets the companyId value for this DdiDetailsType.
     * 
     * @return companyId
     */
    public java.lang.String getCompanyId() {
        return companyId;
    }


    /**
     * Sets the companyId value for this DdiDetailsType.
     * 
     * @param companyId
     */
    public void setCompanyId(java.lang.String companyId) {
        this.companyId = companyId;
    }


    /**
     * Gets the inUse value for this DdiDetailsType.
     * 
     * @return inUse
     */
    public boolean isInUse() {
        return inUse;
    }


    /**
     * Sets the inUse value for this DdiDetailsType.
     * 
     * @param inUse
     */
    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }


    /**
     * Gets the service value for this DdiDetailsType.
     * 
     * @return service
     */
    public java.lang.String getService() {
        return service;
    }


    /**
     * Sets the service value for this DdiDetailsType.
     * 
     * @param service
     */
    public void setService(java.lang.String service) {
        this.service = service;
    }


    /**
     * Gets the hzTone value for this DdiDetailsType.
     * 
     * @return hzTone
     */
    public int getHzTone() {
        return hzTone;
    }


    /**
     * Sets the hzTone value for this DdiDetailsType.
     * 
     * @param hzTone
     */
    public void setHzTone(int hzTone) {
        this.hzTone = hzTone;
    }


    /**
     * Gets the languageId value for this DdiDetailsType.
     * 
     * @return languageId
     */
    public java.lang.String getLanguageId() {
        return languageId;
    }


    /**
     * Sets the languageId value for this DdiDetailsType.
     * 
     * @param languageId
     */
    public void setLanguageId(java.lang.String languageId) {
        this.languageId = languageId;
    }


    /**
     * Gets the destinationNumber value for this DdiDetailsType.
     * 
     * @return destinationNumber
     */
    public java.lang.String getDestinationNumber() {
        return destinationNumber;
    }


    /**
     * Sets the destinationNumber value for this DdiDetailsType.
     * 
     * @param destinationNumber
     */
    public void setDestinationNumber(java.lang.String destinationNumber) {
        this.destinationNumber = destinationNumber;
    }


    /**
     * Gets the announce value for this DdiDetailsType.
     * 
     * @return announce
     */
    public java.lang.String getAnnounce() {
        return announce;
    }


    /**
     * Sets the announce value for this DdiDetailsType.
     * 
     * @param announce
     */
    public void setAnnounce(java.lang.String announce) {
        this.announce = announce;
    }


    /**
     * Gets the provider value for this DdiDetailsType.
     * 
     * @return provider
     */
    public java.lang.String getProvider() {
        return provider;
    }


    /**
     * Sets the provider value for this DdiDetailsType.
     * 
     * @param provider
     */
    public void setProvider(java.lang.String provider) {
        this.provider = provider;
    }


    /**
     * Gets the accLength value for this DdiDetailsType.
     * 
     * @return accLength
     */
    public short getAccLength() {
        return accLength;
    }


    /**
     * Sets the accLength value for this DdiDetailsType.
     * 
     * @param accLength
     */
    public void setAccLength(short accLength) {
        this.accLength = accLength;
    }


    /**
     * Gets the pinLength value for this DdiDetailsType.
     * 
     * @return pinLength
     */
    public short getPinLength() {
        return pinLength;
    }


    /**
     * Sets the pinLength value for this DdiDetailsType.
     * 
     * @param pinLength
     */
    public void setPinLength(short pinLength) {
        this.pinLength = pinLength;
    }


    /**
     * Gets the cost value for this DdiDetailsType.
     * 
     * @return cost
     */
    public long getCost() {
        return cost;
    }


    /**
     * Sets the cost value for this DdiDetailsType.
     * 
     * @param cost
     */
    public void setCost(long cost) {
        this.cost = cost;
    }


    /**
     * Gets the ext value for this DdiDetailsType.
     * 
     * @return ext
     */
    public boolean isExt() {
        return ext;
    }


    /**
     * Sets the ext value for this DdiDetailsType.
     * 
     * @param ext
     */
    public void setExt(boolean ext) {
        this.ext = ext;
    }


    /**
     * Gets the profileX value for this DdiDetailsType.
     * 
     * @return profileX
     */
    public java.lang.String getProfileX() {
        return profileX;
    }


    /**
     * Sets the profileX value for this DdiDetailsType.
     * 
     * @param profileX
     */
    public void setProfileX(java.lang.String profileX) {
        this.profileX = profileX;
    }


    /**
     * Gets the operatorQueue value for this DdiDetailsType.
     * 
     * @return operatorQueue
     */
    public java.lang.String getOperatorQueue() {
        return operatorQueue;
    }


    /**
     * Sets the operatorQueue value for this DdiDetailsType.
     * 
     * @param operatorQueue
     */
    public void setOperatorQueue(java.lang.String operatorQueue) {
        this.operatorQueue = operatorQueue;
    }


    /**
     * Gets the operatorWait value for this DdiDetailsType.
     * 
     * @return operatorWait
     */
    public java.lang.String getOperatorWait() {
        return operatorWait;
    }


    /**
     * Sets the operatorWait value for this DdiDetailsType.
     * 
     * @param operatorWait
     */
    public void setOperatorWait(java.lang.String operatorWait) {
        this.operatorWait = operatorWait;
    }


    /**
     * Gets the prefix value for this DdiDetailsType.
     * 
     * @return prefix
     */
    public java.lang.String getPrefix() {
        return prefix;
    }


    /**
     * Sets the prefix value for this DdiDetailsType.
     * 
     * @param prefix
     */
    public void setPrefix(java.lang.String prefix) {
        this.prefix = prefix;
    }


    /**
     * Gets the operatorLanguageId value for this DdiDetailsType.
     * 
     * @return operatorLanguageId
     */
    public java.lang.String getOperatorLanguageId() {
        return operatorLanguageId;
    }


    /**
     * Sets the operatorLanguageId value for this DdiDetailsType.
     * 
     * @param operatorLanguageId
     */
    public void setOperatorLanguageId(java.lang.String operatorLanguageId) {
        this.operatorLanguageId = operatorLanguageId;
    }


    /**
     * Gets the debitCLI value for this DdiDetailsType.
     * 
     * @return debitCLI
     */
    public boolean isDebitCLI() {
        return debitCLI;
    }


    /**
     * Sets the debitCLI value for this DdiDetailsType.
     * 
     * @param debitCLI
     */
    public void setDebitCLI(boolean debitCLI) {
        this.debitCLI = debitCLI;
    }


    /**
     * Gets the mode value for this DdiDetailsType.
     * 
     * @return mode
     */
    public java.lang.String getMode() {
        return mode;
    }


    /**
     * Sets the mode value for this DdiDetailsType.
     * 
     * @param mode
     */
    public void setMode(java.lang.String mode) {
        this.mode = mode;
    }


    /**
     * Gets the quickNumber value for this DdiDetailsType.
     * 
     * @return quickNumber
     */
    public java.lang.String getQuickNumber() {
        return quickNumber;
    }


    /**
     * Sets the quickNumber value for this DdiDetailsType.
     * 
     * @param quickNumber
     */
    public void setQuickNumber(java.lang.String quickNumber) {
        this.quickNumber = quickNumber;
    }


    /**
     * Gets the routeX value for this DdiDetailsType.
     * 
     * @return routeX
     */
    public java.lang.String getRouteX() {
        return routeX;
    }


    /**
     * Sets the routeX value for this DdiDetailsType.
     * 
     * @param routeX
     */
    public void setRouteX(java.lang.String routeX) {
        this.routeX = routeX;
    }


    /**
     * Gets the pin value for this DdiDetailsType.
     * 
     * @return pin
     */
    public java.lang.String getPin() {
        return pin;
    }


    /**
     * Sets the pin value for this DdiDetailsType.
     * 
     * @param pin
     */
    public void setPin(java.lang.String pin) {
        this.pin = pin;
    }


    /**
     * Gets the payphoneX value for this DdiDetailsType.
     * 
     * @return payphoneX
     */
    public java.lang.String getPayphoneX() {
        return payphoneX;
    }


    /**
     * Sets the payphoneX value for this DdiDetailsType.
     * 
     * @param payphoneX
     */
    public void setPayphoneX(java.lang.String payphoneX) {
        this.payphoneX = payphoneX;
    }


    /**
     * Gets the region value for this DdiDetailsType.
     * 
     * @return region
     */
    public short getRegion() {
        return region;
    }


    /**
     * Sets the region value for this DdiDetailsType.
     * 
     * @param region
     */
    public void setRegion(short region) {
        this.region = region;
    }


    /**
     * Gets the swDomainId value for this DdiDetailsType.
     * 
     * @return swDomainId
     */
    public java.lang.String getSwDomainId() {
        return swDomainId;
    }


    /**
     * Sets the swDomainId value for this DdiDetailsType.
     * 
     * @param swDomainId
     */
    public void setSwDomainId(java.lang.String swDomainId) {
        this.swDomainId = swDomainId;
    }


    /**
     * Gets the ingress value for this DdiDetailsType.
     * 
     * @return ingress
     */
    public java.lang.String getIngress() {
        return ingress;
    }


    /**
     * Sets the ingress value for this DdiDetailsType.
     * 
     * @param ingress
     */
    public void setIngress(java.lang.String ingress) {
        this.ingress = ingress;
    }


    /**
     * Gets the payphoneId value for this DdiDetailsType.
     * 
     * @return payphoneId
     */
    public java.lang.String getPayphoneId() {
        return payphoneId;
    }


    /**
     * Sets the payphoneId value for this DdiDetailsType.
     * 
     * @param payphoneId
     */
    public void setPayphoneId(java.lang.String payphoneId) {
        this.payphoneId = payphoneId;
    }


    /**
     * Gets the pinService value for this DdiDetailsType.
     * 
     * @return pinService
     */
    public java.lang.String getPinService() {
        return pinService;
    }


    /**
     * Sets the pinService value for this DdiDetailsType.
     * 
     * @param pinService
     */
    public void setPinService(java.lang.String pinService) {
        this.pinService = pinService;
    }


    /**
     * Gets the routeId value for this DdiDetailsType.
     * 
     * @return routeId
     */
    public java.lang.String getRouteId() {
        return routeId;
    }


    /**
     * Sets the routeId value for this DdiDetailsType.
     * 
     * @param routeId
     */
    public void setRouteId(java.lang.String routeId) {
        this.routeId = routeId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DdiDetailsType)) return false;
        DdiDetailsType other = (DdiDetailsType) obj;
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
            ((this.companyId==null && other.getCompanyId()==null) || 
             (this.companyId!=null &&
              this.companyId.equals(other.getCompanyId()))) &&
            this.inUse == other.isInUse() &&
            ((this.service==null && other.getService()==null) || 
             (this.service!=null &&
              this.service.equals(other.getService()))) &&
            this.hzTone == other.getHzTone() &&
            ((this.languageId==null && other.getLanguageId()==null) || 
             (this.languageId!=null &&
              this.languageId.equals(other.getLanguageId()))) &&
            ((this.destinationNumber==null && other.getDestinationNumber()==null) || 
             (this.destinationNumber!=null &&
              this.destinationNumber.equals(other.getDestinationNumber()))) &&
            ((this.announce==null && other.getAnnounce()==null) || 
             (this.announce!=null &&
              this.announce.equals(other.getAnnounce()))) &&
            ((this.provider==null && other.getProvider()==null) || 
             (this.provider!=null &&
              this.provider.equals(other.getProvider()))) &&
            this.accLength == other.getAccLength() &&
            this.pinLength == other.getPinLength() &&
            this.cost == other.getCost() &&
            this.ext == other.isExt() &&
            ((this.profileX==null && other.getProfileX()==null) || 
             (this.profileX!=null &&
              this.profileX.equals(other.getProfileX()))) &&
            ((this.operatorQueue==null && other.getOperatorQueue()==null) || 
             (this.operatorQueue!=null &&
              this.operatorQueue.equals(other.getOperatorQueue()))) &&
            ((this.operatorWait==null && other.getOperatorWait()==null) || 
             (this.operatorWait!=null &&
              this.operatorWait.equals(other.getOperatorWait()))) &&
            ((this.prefix==null && other.getPrefix()==null) || 
             (this.prefix!=null &&
              this.prefix.equals(other.getPrefix()))) &&
            ((this.operatorLanguageId==null && other.getOperatorLanguageId()==null) || 
             (this.operatorLanguageId!=null &&
              this.operatorLanguageId.equals(other.getOperatorLanguageId()))) &&
            this.debitCLI == other.isDebitCLI() &&
            ((this.mode==null && other.getMode()==null) || 
             (this.mode!=null &&
              this.mode.equals(other.getMode()))) &&
            ((this.quickNumber==null && other.getQuickNumber()==null) || 
             (this.quickNumber!=null &&
              this.quickNumber.equals(other.getQuickNumber()))) &&
            ((this.routeX==null && other.getRouteX()==null) || 
             (this.routeX!=null &&
              this.routeX.equals(other.getRouteX()))) &&
            ((this.pin==null && other.getPin()==null) || 
             (this.pin!=null &&
              this.pin.equals(other.getPin()))) &&
            ((this.payphoneX==null && other.getPayphoneX()==null) || 
             (this.payphoneX!=null &&
              this.payphoneX.equals(other.getPayphoneX()))) &&
            this.region == other.getRegion() &&
            ((this.swDomainId==null && other.getSwDomainId()==null) || 
             (this.swDomainId!=null &&
              this.swDomainId.equals(other.getSwDomainId()))) &&
            ((this.ingress==null && other.getIngress()==null) || 
             (this.ingress!=null &&
              this.ingress.equals(other.getIngress()))) &&
            ((this.payphoneId==null && other.getPayphoneId()==null) || 
             (this.payphoneId!=null &&
              this.payphoneId.equals(other.getPayphoneId()))) &&
            ((this.pinService==null && other.getPinService()==null) || 
             (this.pinService!=null &&
              this.pinService.equals(other.getPinService()))) &&
            ((this.routeId==null && other.getRouteId()==null) || 
             (this.routeId!=null &&
              this.routeId.equals(other.getRouteId())));
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
        if (getCompanyId() != null) {
            _hashCode += getCompanyId().hashCode();
        }
        _hashCode += (isInUse() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getService() != null) {
            _hashCode += getService().hashCode();
        }
        _hashCode += getHzTone();
        if (getLanguageId() != null) {
            _hashCode += getLanguageId().hashCode();
        }
        if (getDestinationNumber() != null) {
            _hashCode += getDestinationNumber().hashCode();
        }
        if (getAnnounce() != null) {
            _hashCode += getAnnounce().hashCode();
        }
        if (getProvider() != null) {
            _hashCode += getProvider().hashCode();
        }
        _hashCode += getAccLength();
        _hashCode += getPinLength();
        _hashCode += new Long(getCost()).hashCode();
        _hashCode += (isExt() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getProfileX() != null) {
            _hashCode += getProfileX().hashCode();
        }
        if (getOperatorQueue() != null) {
            _hashCode += getOperatorQueue().hashCode();
        }
        if (getOperatorWait() != null) {
            _hashCode += getOperatorWait().hashCode();
        }
        if (getPrefix() != null) {
            _hashCode += getPrefix().hashCode();
        }
        if (getOperatorLanguageId() != null) {
            _hashCode += getOperatorLanguageId().hashCode();
        }
        _hashCode += (isDebitCLI() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getMode() != null) {
            _hashCode += getMode().hashCode();
        }
        if (getQuickNumber() != null) {
            _hashCode += getQuickNumber().hashCode();
        }
        if (getRouteX() != null) {
            _hashCode += getRouteX().hashCode();
        }
        if (getPin() != null) {
            _hashCode += getPin().hashCode();
        }
        if (getPayphoneX() != null) {
            _hashCode += getPayphoneX().hashCode();
        }
        _hashCode += getRegion();
        if (getSwDomainId() != null) {
            _hashCode += getSwDomainId().hashCode();
        }
        if (getIngress() != null) {
            _hashCode += getIngress().hashCode();
        }
        if (getPayphoneId() != null) {
            _hashCode += getPayphoneId().hashCode();
        }
        if (getPinService() != null) {
            _hashCode += getPinService().hashCode();
        }
        if (getRouteId() != null) {
            _hashCode += getRouteId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DdiDetailsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ddiDetailsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("inUse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "inUse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("service");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "service"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hzTone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "hzTone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("destinationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "destinationNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("announce");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "announce"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provider");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "provider"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accLength");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "accLength"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pinLength");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "pinLength"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ext");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ext"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profileX");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "profileX"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operatorQueue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "operatorQueue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operatorWait");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "operatorWait"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prefix");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "prefix"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operatorLanguageId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "operatorLanguageId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitCLI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "debitCLI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "mode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quickNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "quickNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("routeX");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "routeX"));
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
        elemField.setFieldName("payphoneX");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "payphoneX"));
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
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payphoneId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "payphoneId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pinService");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "pinService"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("routeId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "routeId"));
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
