//
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.springframework.stereotype.Service;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.gwall.ods.platform.framework.bean.base.BaseExecuteParams;
//import com.gwall.ods.platform.framework.bean.base.BaseExecuteResponse;
//import com.gwall.ods.platform.framework.bean.orders.SaleOrderBean;
//import com.gwall.ods.platform.framework.bean.service.OrderFullInfoServiceGetRequest;
//import com.gwall.ods.platform.framework.bean.service.OrderFullInfoServiceGetResponse;
//import com.gwall.ods.platform.framework.util.ConfigContants;
//import com.gwall.ods.youzan.service.OrderFullInfoGet;
//import com.gwall.ods.youzan.util.YouzanConvert;
//import com.mzlion.okhttp.HttpClient;
//
///**
// * 
//* @ClassName: ItemSingleServiceGet 
//* @Description:订单详情
//* @author  liupan 
//* @date 2017年5月24日 下午2:10:12 
//* @version V1.0
// */
//@Service(value="youzan_gwall.ods.order.fullinfo.get")
//public class OrderFullInfoGetImpl implements OrderFullInfoGet {
//
//	@Override
//	public BaseExecuteResponse execute(BaseExecuteParams executeParams) throws Exception {
//		// API接口请求参数
//		OrderFullInfoServiceGetRequest requestParams=new OrderFullInfoServiceGetRequest();
//		BeanUtils.copyProperties(requestParams, executeParams);
//		requestParams.analysis(executeParams.getParams());
//		
//		//业务响应实体
//		OrderFullInfoServiceGetResponse response = new OrderFullInfoServiceGetResponse();
//				
//		//做业务处理
//		try {
//			String result = downOrder(requestParams);
//			ObjectMapper mapper = new ObjectMapper();
//			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//			JsonNode root = mapper.readTree(result);
//			if(result.contains("error_response")){
//				response.setFlag(ConfigContants.FAILURE);
//				response.setMessage("error_response，服务器错误");
//				return response;
//			}
//			JsonNode order = root.get("response").get("full_order_info");
//			SaleOrderBean orderBean = YouzanConvert.ConvertTradeDetail4(order);
//			if(orderBean.getOrderCode()==null||"".equals(orderBean.getOrderCode())){
//				response.setFlag(ConfigContants.FAILURE);
//				response.setMessage("订单无明细，默认失败");
//			}else{
//				response.setOrder(orderBean);
//				response.setFlag(ConfigContants.SUCCESS);
//			}
//		}catch(Exception e){
//			log.error("有赞订单详情出错",e);
//			response.setFlag(ConfigContants.FAILURE);
//			response.setMessage(e.getMessage());
//		}
//		return response;
//	}
//	/**
//	 * 下载单笔订单详情
//	 * @param requestParams
//	 * @return
//	 * https://open.youzan.com/api/oauthentry/youzan.trade/3.0.0/get
//	 * @throws Exception
//	 */
//	private String downOrder(OrderFullInfoServiceGetRequest requestParams) throws Exception{
////		String sessionKey =requestParams.getExtendProps().get("token");
//		String sessionKey = requestParams.getAppkey().getSessionKey();
//		String tid = requestParams.getOrderCode();//"https://open.youzan.com/api/oauthentry/youzan.trade/3.0.0/get?"
//		String responseStr = HttpClient.get( requestParams.getAppkey().getUrl()+"/youzan.trade/4.0.0/get"
//				+ "?access_token="+sessionKey+"&tid="+tid.trim()
//				).asString();
//		log.info("有赞订单详情请求数据"+requestParams.getAppkey().getUrl()+"/youzan.trade/4.0.0/get"
//				+ "?access_token="+sessionKey+"&tid="+tid.trim());
//		log.info("有赞订单详情返回数据"+responseStr);
//		return responseStr;
//	}
//	
//	public static void main(String[] args) throws UnsupportedEncodingException {
////		log.info("有赞订单详情请求数据"+https://open.youzan.com/api/oauthentry/youzan.trade/3.0.0/get"
////				+ "?access_token="+sessionKey+"&tid="+tid);
////		log.info("有赞订单详情返回数据"+responseStr);
//		String tid = "E20180629093313057900002";
//		String responseStr = HttpClient.get( "https://open.youzan.com/api/oauthentry/youzan.trade/4.0.0/get"
//				+ "?access_token=bb09e3946aca3716b539cc9959bd32fa"+"&tid="+tid
//				).asString();
//		System.out.println("https://open.youzan.com/api/oauthentry/youzan.trade/4.0.0/get"
//				+ "?access_token=bb09e3946aca3716b539cc9959bd32fa"+"&tid="+tid);
//		System.out.println(responseStr);
////		if(responseStr.contains("\")){
////			
////		}
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
//		JsonNode root = null;
//		try {
//			root = mapper.readTree(responseStr);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JsonNode order = root.path("response").get("trade");
//		SaleOrderBean orderBean = YouzanConvert.ConvertTradeDetail(order);
//		String buyerNick = orderBean.getBuyerNick();
//		String testStr2=new String(buyerNick.getBytes("iso-8859-1"),"UTF-8");
////		String testStr2=new String(buyerNick.getBytes("UTF-8"),"iso-8859-1"); 
//		System.out.println(testStr2);
//	}
//}
