

/**
 * AllServices.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */

    package com.gtplimited;

    /*
     *  AllServices java interface
     */

    public interface AllServices {
          

        /**
          * Auto generated method signature
          * 
                    * @param baseRequest23
                
                    * @param requestHeader24
                
         */

         
                     public com.gtplimited.BaseResponse submit(

                        com.gtplimited.BaseRequest baseRequest23,com.gtplimited.RequestHeader requestHeader24)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param baseRequest23
            
                * @param requestHeader24
            
          */
        public void startsubmit(

            com.gtplimited.BaseRequest baseRequest23,com.gtplimited.RequestHeader requestHeader24,
                

            final com.gtplimited.AllServicesCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    