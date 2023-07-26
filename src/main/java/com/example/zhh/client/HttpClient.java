package com.example.zhh.client;

import com.example.zhh.pojo.DanganZhuti;
import com.example.zhh.pojo.SusongDangan;
import com.example.zhh.pojo.ZhutiXinxi;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @ClassName: HttpURLConectionMode
 * @Description: TODO(通过HttpURLConnection发送http请求)
 *   sope协议，比较麻烦的是需要拼接xml格式的请求数据
 * @author
 * @date 2017年11月8日 上午9:18:24
 *
 */
public class HttpClient {

    public static void main(String[] args) throws IOException {
        //第一步：创建服务地址，不是WSDL地址
        URL url = new URL("http://127.0.0.1:8033/web/webservice/userService");
        //2：打开到服务地址的一个连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //3：设置连接参数
        //3.1设置发送方式：POST必须大写
        connection.setRequestMethod("POST");
        //3.2设置数据格式：Content-type
        connection.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
        //3.3设置输入输出，新创建的connection默认是没有读写权限的，
        connection.setDoInput(true);
        connection.setDoOutput(true);

        connection.setRequestProperty("SOAPAction", "");
//        connection.setRequestProperty("SOAPAction", "http://tempuri.org/actionName");
        //4：组织SOAP协议数据，发送给服务端
        String soapXML = getXML(getXmlBody());
        OutputStream os = connection.getOutputStream();
        os.write(soapXML.getBytes());

        //5：接收服务端的响应
        int responseCode = connection.getResponseCode();
        if(200 == responseCode){//表示服务端响应成功
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String temp = null;

            while(null != (temp = br.readLine())){
                sb.append(temp);
            }

            System.out.println(sb.toString());

            is.close();
            isr.close();
            br.close();
        }

        os.close();
    }

    /**
     * <?xml version="1.0" encoding="utf-8"?>
     <soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
     <soap:Body>
     <getMobileCodeInfo xmlns="http://WebXml.com.cn/">
     <mobileCode>string</mobileCode>
     <userID>string</userID>
     </getMobileCodeInfo>
     </soap:Body>
     </soap:Envelope>
     * @param body
     * @return
     */
    public static String getXML(String body){
        String soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                +"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                +"<soap:Body>"
//                +"<getMobileCodeInfo xmlns=\"http://WebXml.com.cn/\">"
//                +"<mobileCode>"+phoneNum+"</mobileCode>"
//                +"<userID></userID>"
//                +"</getMobileCodeInfo>"
                +body
                +" </soap:Body>"
                +"</soap:Envelope>";
        return soapXML;
    }

    public static String getXmlBody(){
        DanganZhuti danganZhuti = new DanganZhuti();
        danganZhuti.setDHDM("3201001234567");

        ZhutiXinxi zhutiXinxi = new ZhutiXinxi();
        zhutiXinxi.setNNDD("2015");
        zhutiXinxi.setDABM("刑终");
        zhutiXinxi.setDH("(2015)宁刑终字第00171号");
        zhutiXinxi.setQZH("");
        zhutiXinxi.setJZH("171");
        zhutiXinxi.setBGQX("长期");
        zhutiXinxi.setLJBM("立案庭");
        zhutiXinxi.setLJR("马小量");
        zhutiXinxi.setLJRQ("20121223");
        zhutiXinxi.setGDBM("刑庭");
        zhutiXinxi.setGDR("李伟");
        zhutiXinxi.setGDRQ("20130220");
        zhutiXinxi.setYJR("YJR");
        zhutiXinxi.setJSR("刘杉");
        zhutiXinxi.setJSRQ("20130224");

        SusongDangan susongDangan = new SusongDangan();
        susongDangan.setDanganZhuti(danganZhuti);
        susongDangan.setZhutiXinxi(zhutiXinxi);


        JAXBContext context = null;
        StringWriter writer = new StringWriter();
        try {
            context = JAXBContext.newInstance(SusongDangan.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "GB2312");
//            1. 激活JAXB_FRAGMENT为true, 隐去jaxb自动生成xml报文头.默认为false 2. 自定义输出报文头信息
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,"http://dataexchange.court.gov.cn/2005/data http://203.130.80.9:82/da/open/SS_SSDA.xsd");
//            File file = new File("D:\\user.xml");
//            writer.write("<?xml version=\"1.0\" encoding=\"GB2312\" ?>\n");
            marshaller.marshal(susongDangan, writer);
//            marshaller.marshal(susongDangan,file);
            System.out.println(writer.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }
}