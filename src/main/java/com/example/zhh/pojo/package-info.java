@XmlSchema(
//        namespace = "http://dataexchange.court.gov.cn/2005/data",
        xmlns={
                @XmlNs(prefix="xsi", namespaceURI="http://www.w3.org/2001/XMLSchema-instance")/*,
                @XmlNs(prefix="", namespaceURI="http://dataexchange.court.gov.cn/2005/data"),*/
        }

)
package com.example.zhh.pojo;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;