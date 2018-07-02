//
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.gwall.ods.platform.framework.bean.items.ItemBean;
//import com.gwall.ods.platform.framework.bean.items.SkuBean;
//import com.gwall.ods.platform.framework.bean.orders.ReceiverInfoBean;
//import com.gwall.ods.platform.framework.bean.orders.SaleOrderBean;
//import com.gwall.ods.platform.framework.bean.orders.SaleOrderLinesBean;
//import com.gwall.ods.platform.framework.bean.refund.RefundOrderBean;
//import com.gwall.ods.util.StringUtils;
///**
// * 
//* @ClassName: YouzanConvert 
//* @Description: 将有赞返回的参数转化成oms的格式
//* @author  liupan 
//* @date 2017年5月25日 上午9:33:24 
//* @version V1.0
// */
//public class YouzanConvert {
//	/**
//	 * 
//	* @Title: convertSingleItem 
//	* @Description: 1 在售商品列表转化成oms格式的方法
//	* @date 2017年5月25日 上午9:34:35 
//	* @version V1.0
//	 */
//	public static List<ItemBean> convertItems(Iterator<JsonNode> items) {
//		//  "num_iid,outer_id,title,num,desc,price,created,,,,stock_locaked"
//		/**
//		 * 批量:将有赞平台的商品信息转换成OMS统一的格式
//		 */
//			
//			if(items == null){
//				return null;
//				
//			}
//			List<ItemBean> list = new ArrayList<ItemBean>();//转化了他的东西
//			while(items.hasNext()){
//				JsonNode jsonNodeItem = items.next();
//				ItemBean itemBean=new ItemBean();
//				if(jsonNodeItem.get("item_id")!=null&&!StringUtils.isBlank(jsonNodeItem.get("item_id").toString()) ){
//					itemBean.setItemId(jsonNodeItem.get("item_id").asText());
//				}
//				//商家维护的编码
//				if(jsonNodeItem.get("item_no")!=null&&!StringUtils.isBlank(jsonNodeItem.get("item_no").toString()) ){
//					itemBean.setOuterId(jsonNodeItem.get("item_no").asText().replace("\"", ""));
//				}
//				if(jsonNodeItem.get("created_time")!=null&&!StringUtils.isBlank(jsonNodeItem.get("created_time").toString()) ){
//					itemBean.setListTime(jsonNodeItem.get("created_time").asText());//上架时间
//				}
//				if(jsonNodeItem.get("title")!=null&&!StringUtils.isBlank(jsonNodeItem.get("title").toString()) ){
//					itemBean.setTitle(jsonNodeItem.get("title").toString().replace("\"", ""));
//				}
//				if(jsonNodeItem.get("quantity")!=null&&!StringUtils.isBlank(jsonNodeItem.get("quantity").toString()) ){
//					itemBean.setQuantity(jsonNodeItem.get("quantity").asText());
//				}
//				if(jsonNodeItem.get("update_time")!=null&&!StringUtils.isBlank(jsonNodeItem.get("update_time").toString()) ){
//					itemBean.setUpdateTime((jsonNodeItem.get("update_time").asText()));
//				}
//				list.add(itemBean);
//			}
//			
//			return list;
//		
//	}
//
//	
//	/**
//	 * 
//	* @Title: convertSingleItem 
//	* @Description: 2  对有赞的 单个商品详情信息做转化
//	* @param @param result    入参
//	* @return void    返回类型
//	* @author  liupan 
//	* @throws
//	* @date 2017年5月25日 下午2:24:54 
//	* @version V1.0
//	 */
//	public static ItemBean  convertSingleItem(JsonNode item){
//		if(item == null)
//		{
//			return null;
//		}
//		ItemBean entity = new ItemBean();
//		if(item.get("created")!=null&&!StringUtils.isBlank(item.get("created").toString()) ){
//			entity.setDelistTime(item.get("created").toString());
//		}
//		if(item.get("item_id") != null&&!StringUtils.isBlank(item.get("item_id").toString())){
//			entity.setItemId(item.get("item_id").toString());
//		}
//		//外部id
//		if(item.get("item_no") != null&&!StringUtils.isBlank(item.get("item_no").toString())){
//			entity.setOuterId(item.get("item_no").toString().replace("\"", ""));
//		}
//		if(item.get("title") != null&&!StringUtils.isBlank(item.get("title").toString()) ){
//			entity.setTitle(item.get("title").toString().replace("\"", ""));
//		}
//		if(item.get("price") != null&&!StringUtils.isBlank(item.get("price").toString()) ){
//			entity.setPrice(item.get("price").toString());
//		}
//		if(item.get("quantity") != null&&!StringUtils.isBlank(item.get("quantity").toString()) ){
//			entity.setQuantity(item.get("quantity").toString());
//		}
//			
//		if(item.get("skus") == null){
//			return entity;
//		}
//		List<SkuBean> skuList = new ArrayList<SkuBean>();
//		//sku信息    现在就是要把接口文档中要的值都拼装出来
//		Iterator<JsonNode> skus = item.get("skus").elements();
//		while(skus.hasNext()){
//			SkuBean s = new SkuBean();
//			JsonNode sku = skus.next();
//			if(sku.get("sku_id")!= null&&!StringUtils.isBlank(sku.get("sku_id").toString()) ){
//				s.setSkuId(sku.get("sku_id").asText());
//			}
//			if(sku.get("quantity")!= null&&!StringUtils.isBlank(sku.get("quantity").toString()) ){
//				s.setQuantity(sku.get("quantity").asText()+"");
//			}
//			if(sku.get("item_no")!= null&&!StringUtils.isBlank(sku.get("item_no").toString()) ){
//				s.setOuterId(sku.get("item_no").toString().replace("\"", ""));
//			}
//			if(sku.get("price")!= null&&!StringUtils.isBlank(sku.get("price").toString()) ){
//				s.setPrice(sku.get("price").asText()+"");
//			}
//			
//			
//			/**
//			 * 下面的这些代码先别删除了，因为没有sdk可以用，并且没有网站的连接 https://www.youzanyun.com/apilist/detail/item?name=youzan.item.get
//			 * 并没有给具体的json值，很难去判断，只能真的有店铺了才能去做
//			 */
//			skuList.add(s);
//		}
//		entity.setSkuList(skuList);
//		
//		return entity;
//	}
//
///**
// * 
//* @Title: ConvertTradesList 
//* @Description: 4 有赞的销售订单列表转化为oms的格式
//* @param @param trades
//* @param @return    入参
//* @return List<SaleOrderBean>    返回类型
//* @author  liupan 
//* @throws
//* @date 2017年5月27日 下午3:10:46 
//* @version V1.0
// */
//	public static List<SaleOrderBean> ConvertTradesList(Iterator<JsonNode> trades) {
//		List<SaleOrderBean> orderList = new ArrayList<SaleOrderBean>();
//		while(trades.hasNext()){
////			JsonNode next = trades.next();
//			orderList.add(ConvertOrders(trades.next()));
//		}
//		
//		return orderList;
//	}	
//	/**
//	 * 有赞订单对像转换    这个就是把有赞返回的类转化成我们oms要对接的类。。。
//	 */
//	public static SaleOrderBean ConvertOrders(JsonNode order){
//		
//		return ConvertTradeDetail(order);
//		
//	}
//	/**
//	 * 
//	* @Title: ConvertTradeDetail
//	* @Description: 5 单个销售订单详情的转化
//	* @param @param order
//	* @param @return    入参
//	* @return SaleOrderBean    返回类型
//	* @author  liupan 
//	* @throws
//	* @date 2017年5月27日 下午3:11:56 
//	* @version V1.0
//	 */
//		public static SaleOrderBean ConvertTradeDetail(JsonNode order) {//页面是TradeDetail v2版本的
//			SaleOrderBean o = new SaleOrderBean();		
//			o.setOrderCode(order.get("tid").asText());//订单号，这个就是交易号码
//			//o.setOrderStatus(order.get("status").asText());//采购单交易状态
//			o.setOrderType("JYCK");
//			
//			if(order.get("created")!= null&&!StringUtils.isBlank(order.get("created").toString())){
//				o.setCreateTime(order.get("created").asText());//
//			}
//			
////			if(order.getUpdateTime() != null){
////				o.setUpdateTime(SimpleDateUtils.toDateTime(order.getUpdateTime()));
////			}
//			if(order.get("pay_time") != null&&!StringUtils.isBlank(order.get("pay_time").toString()) ){
//				o.setPayTime(order.get("pay_time").toString().replace("\"", "") );
//			}
//			if(order.get("fans_info").get("fans_nickname") != null&&!StringUtils.isBlank(order.get("fans_info").get("fans_nickname").toString()) ){
//				
//				o.setBuyerNick(order.get("fans_info").get("fans_nickname").toString().replace("\"",""));
//			}
//			
//			//两边的参数是不一样的不能直接传递的
////			if(order.getPayType() != null){
////				o.setPayType(order.getPayType());
////			}
//			if(order.get("pay_type")!= null&&!StringUtils.isBlank(order.get("pay_type").toString())){
//				String payType =order.get("pay_type").asText() ;
//				if("WEIXIN".equals(payType)||"ECARD".equals(payType)||"WEIXIN_DAIXIAO".equals(payType)||"BANKCARDPAY".equals(payType)||"PEERPAY".equals(payType)
//						||"BAIDUPAY".equals(payType)||"WEIXIN_DAIXIAO".equals(payType)){
//					o.setPayType("在线支付");
//				}else if("CODPAY".equals(payType)){
//					o.setPayType("线下支付");
//				}else if("COUPONPAY".equals(payType)){
//					o.setPayType("积分支付");
//				}else if("PRESENTTAKE".equals(payType)||"ECARD".equals(payType)){
//					o.setPayType("礼品卡支付");
//				}else if("ALIPAY ".equals(payType)){
//					o.setPayType("支付宝支付");
//				}
//			}
//			     
////			if(order.getOuterTid() != null){
////				o.setPayNo(order.getOuterTid());
////			}
//			if(order.get("status")!= null&&!StringUtils.isBlank(order.get("status").toString())){//订单的状态
//				String orderStatus = order.get("status").asText();
//				if("WAIT_SELLER_SEND_GOODS".equals(orderStatus)){
//					o.setOrderStatus("WAIT_SELLER_SEND_GOODS");
//				}else if("WAIT_BUYER_CONFIRM_GOODS".equals(orderStatus)){
//					o.setOrderStatus("WAIT_BUYER_CONFIRM_GOODS");
//				}else if("TRADE_BUYER_SIGNED".equals(orderStatus)){
//					o.setOrderStatus("TRADE_BUYER_SIGNED");
//				}else if("TRADE_FINISHED".equals(orderStatus)){
//					o.setOrderStatus("TRADE_CLOSED");
//				}else if("TRADE_CLOSED".equals(orderStatus)){
//					o.setOrderStatus("ALL_CLOSED");
//				}
//			}
//			if(order.get("total_fee") != null&&!StringUtils.isBlank(order.get("total_fee").toString())){
//				o.setTotalAmount(Double.parseDouble(order.get("total_fee").toString().replace("\"","")));
//			}
//			if(order.get("payment") != null&&!StringUtils.isBlank(order.get("payment").toString())){
//				o.setGotAmount(Double.parseDouble(order.get("payment").toString().replace("\"","")));
//			}
//			//收货人信息 
//			ReceiverInfoBean receiverInfoBean=new ReceiverInfoBean();
//			if(order.get("receiver_name") != null&&!StringUtils.isBlank(order.get("receiver_name").toString())){
//				receiverInfoBean.setName(order.get("receiver_name").asText());
//			}
//			if(order.get("receiver_mobile")!= null&&!StringUtils.isBlank(order.get("receiver_mobile").toString())){
//				receiverInfoBean.setMobile(order.get("receiver_mobile").asText());
//			}
//			if(order.get("receiver_zip")!= null&&!StringUtils.isBlank(order.get("receiver_zip").toString())){
//				receiverInfoBean.setZip(order.get("receiver_zip").asText());
//			}
//			if(order.get("receiver_state")!= null&&!StringUtils.isBlank(order.get("receiver_state").toString())){
//				receiverInfoBean.setProvince(order.get("receiver_state").asText());
//			}
//			if(order.get("receiver_city") != null&&!StringUtils.isBlank(order.get("receiver_city").toString())){
//				receiverInfoBean.setCity(order.get("receiver_city").asText());
//			}
//			if(order.get("receiver_district")!= null&&!StringUtils.isBlank(order.get("receiver_district").toString())){
//				receiverInfoBean.setArea(order.get("receiver_district").asText());
//			}
//			if(order.get("receiver_address")!= null&&!StringUtils.isBlank(order.get("receiver_address").toString())){
//				receiverInfoBean.setDetailAddress(order.get("receiver_address").asText());
//			}
//			
//			o.setReceiver(receiverInfoBean);
////			
////			//
//			if(order.get("buyer_message")!= null&&!StringUtils.isBlank(order.get("buyer_message").toString())){
//				o.setRemark(order.get("buyer_message").asText());
//			}
////			if(order.getTradeMemo() != null){
////				o.setRemark(order.getTradeMemo());
////			}
//			//子订单详情
//			Iterator<JsonNode> orders = order.path("orders").elements();
//			List<SaleOrderLinesBean> list=new ArrayList<SaleOrderLinesBean>();
//			while(orders.hasNext()){
//				JsonNode detail = orders.next();
//				SaleOrderLinesBean saleOrderLinesBean = new SaleOrderLinesBean();
//				//子订单编码
//				if(detail.get("oid")!=null&&!StringUtils.isBlank(detail.get("oid").toString())){
//					saleOrderLinesBean.setOrderCode((detail.get("oid").asText()));
//				}
//				if(detail.get("item_id")!=null&&!StringUtils.isBlank(detail.get("item_id").toString())){
//					saleOrderLinesBean.setItemCode(detail.get("item_id").asText());
//				}
//				if(detail.get("sku_id")!=null&&!StringUtils.isBlank(detail.get("sku_id").toString())){
//					saleOrderLinesBean.setSkuId(detail.get("sku_id").toString().replace("\"",""));
//				}
//				
//				if(detail.get("outer_sku_id")!=null&&!StringUtils.isBlank(detail.get("outer_sku_id").toString())){
//					saleOrderLinesBean.setOuterSkuId(detail.get("outer_sku_id").toString().replace("\"",""));
//				}
//				if(detail.get("title")!=null&&!StringUtils.isBlank(detail.get("title").toString())){
//					saleOrderLinesBean.setTitle(detail.get("title").toString().replace("\"",""));
//				}
//				if(detail.get("price")!=null&&!StringUtils.isBlank(detail.get("price").toString())){
//					saleOrderLinesBean.setPrice(detail.get("price").asText());
//				}
//				if(detail.get("num")!=null&&!StringUtils.isBlank(detail.get("num").toString())){
//					saleOrderLinesBean.setNum(detail.get("num").asText());
//				}
//				if(detail.get("payment")!=null&&!StringUtils.isBlank(detail.get("payment").toString())){
//					saleOrderLinesBean.setPayment(detail.get("payment").toString().replace("\"",""));
//				}
//				if(detail.get("total_fee")!=null&&!StringUtils.isBlank(detail.get("total_fee").toString())){
//					saleOrderLinesBean.setTotalPrice(detail.get("total_fee").toString().replace("\"",""));
//				}
//				if(detail.get("buyer_messages")!=null){
//					StringBuilder sb=new StringBuilder();
//					Iterator<JsonNode> elements = detail.get("buyer_messages").elements();
//					while(elements.hasNext()){
//						JsonNode jsonNode = elements.next();
//						String title = jsonNode.get("title").toString();
//						String content = jsonNode.get("content").toString();
//						sb.append(title).append(":").append(content).append(";");
//					}
//					o.setBuyerMessage(sb.toString().replace("\"", ""));
//				}
//				list.add(saleOrderLinesBean);
//			}
//			o.setDetail(list);
//			
//			return o;
//			
//		}
//	
///**
// * 
//* @Title: ConvertTradeDetail
//* @Description: 5 单个销售订单详情的转化
//* @param @param order
//* @param @return    入参
//* @return SaleOrderBean    返回类型
//* @author  liupan 
//* @throws
//* @date 2017年5月27日 下午3:11:56 
//* @version V1.0
// */
//	public static SaleOrderBean ConvertTradeDetail4(JsonNode order) {//页面是TradeDetail v2版本的
//		SaleOrderBean o = new SaleOrderBean();		
//		// order_info 订单信息
//		JsonNode order_info = order.path("order_info");
//		
//		o.setOrderCode(order_info.get("tid").asText());//订单号，这个就是交易号码
//		o.setOrderType("JYCK");
//		
//		if(order_info.get("created")!= null&&!StringUtils.isBlank(order_info.get("created").toString())){
//			o.setCreateTime(order_info.get("created").asText());//
//		}
//		if(order_info.get("update_time")!= null&&!StringUtils.isBlank(order_info.get("update_time").toString())){
//			o.setUpdateTime(order_info.get("update_time").asText());//
//		}
//		
//		if(order_info.get("pay_time") != null&&!StringUtils.isBlank(order_info.get("pay_time").toString()) ){
//			o.setPayTime(order_info.get("pay_time").toString().replace("\"", "") );
//		}
//		
////		if(order_info.get("pay_type")!= null&&!StringUtils.isBlank(order_info.get("pay_type").toString())){
////			String payType =order_info.get("pay_type").asText() ;
////			if("WEIXIN".equals(payType)||"ECARD".equals(payType)||"WEIXIN_DAIXIAO".equals(payType)||"BANKCARDPAY".equals(payType)||"PEERPAY".equals(payType)
////					||"BAIDUPAY".equals(payType)||"WEIXIN_DAIXIAO".equals(payType)){
////				o.setPayType("在线支付");
////			}else if("CODPAY".equals(payType)){
////				o.setPayType("线下支付");
////			}else if("COUPONPAY".equals(payType)){
////				o.setPayType("积分支付");
////			}else if("PRESENTTAKE".equals(payType)||"ECARD".equals(payType)){
////				o.setPayType("礼品卡支付");
////			}else if("ALIPAY ".equals(payType)){
////				o.setPayType("支付宝支付");
////			}
////		}
//		     
//		if(order_info.get("status")!= null&&!StringUtils.isBlank(order_info.get("status").toString())){//订单的状态
//			String orderStatus = order_info.get("status").asText();
//			if("WAIT_SELLER_SEND_GOODS".equals(orderStatus)){
//				o.setOrderStatus("WAIT_SELLER_SEND_GOODS");
//			}else if("WAIT_BUYER_CONFIRM_GOODS".equals(orderStatus)){
//				o.setOrderStatus("WAIT_BUYER_CONFIRM_GOODS");
//			}else if("TRADE_BUYER_SIGNED".equals(orderStatus)){
//				o.setOrderStatus("TRADE_BUYER_SIGNED");
//			}else if("TRADE_FINISHED".equals(orderStatus)){
//				o.setOrderStatus("TRADE_CLOSED");
//			}else if("TRADE_CLOSED".equals(orderStatus)){
//				o.setOrderStatus("ALL_CLOSED");
//			}
//		}
//		//buyer_info
//		JsonNode buyer_info = order.path("buyer_info");
//		if(buyer_info.get("fans_nickname") != null&&!StringUtils.isBlank(buyer_info.get("fans_nickname").toString()) ){
//			o.setBuyerNick(buyer_info.get("fans_nickname").toString().replace("\"",""));
//		}
//		
//		
//		//pay_info
//		JsonNode pay_info = order.path("pay_info");
//		if(pay_info.get("total_fee") != null&&!StringUtils.isBlank(pay_info.get("total_fee").toString())){
//			o.setTotalAmount(Double.parseDouble(pay_info.get("total_fee").toString().replace("\"","")));
//		}
//		if(pay_info.get("payment") != null&&!StringUtils.isBlank(pay_info.get("payment").toString())){
//			o.setGotAmount(Double.parseDouble(pay_info.get("payment").toString().replace("\"","")));
//		}
//		//收货人信息 address_info
//		JsonNode receiverinfo = order.path("address_info");
//		ReceiverInfoBean receiverInfoBean=new ReceiverInfoBean();
//		if(receiverinfo.get("receiver_name") != null&&!StringUtils.isBlank(receiverinfo.get("receiver_name").toString())){
//			receiverInfoBean.setName(receiverinfo.get("receiver_name").asText());
//		}
//		if(receiverinfo.get("receiver_tel")!= null&&!StringUtils.isBlank(receiverinfo.get("receiver_tel").toString())){
//			receiverInfoBean.setMobile(receiverinfo.get("receiver_tel").asText());
//		}
////		if(receiverinfo.get("receiver_zip")!= null&&!StringUtils.isBlank(receiverinfo.get("receiver_zip").toString())){
////			receiverInfoBean.setZip(receiverinfo.get("receiver_zip").asText());
////		}
//		if(receiverinfo.get("delivery_province")!= null&&!StringUtils.isBlank(receiverinfo.get("delivery_province").toString())){
//			receiverInfoBean.setProvince(receiverinfo.get("delivery_province").asText());
//		}
//		if(receiverinfo.get("delivery_city") != null&&!StringUtils.isBlank(receiverinfo.get("delivery_city").toString())){
//			receiverInfoBean.setCity(receiverinfo.get("delivery_city").asText());
//		}
//		if(receiverinfo.get("delivery_district")!= null&&!StringUtils.isBlank(receiverinfo.get("delivery_district").toString())){
//			receiverInfoBean.setArea(receiverinfo.get("delivery_district").asText());
//		}
//		if(receiverinfo.get("delivery_address")!= null&&!StringUtils.isBlank(receiverinfo.get("delivery_address").toString())){
//			receiverInfoBean.setDetailAddress(receiverinfo.get("delivery_address").asText());
//		}
//		
//		o.setReceiver(receiverInfoBean);
//		//remarkinfo
//		JsonNode remarkinfo = order.path("remark_info");
//		if(remarkinfo.get("buyer_message")!= null&&!StringUtils.isBlank(remarkinfo.get("buyer_message").toString())){
//			o.setRemark(remarkinfo.get("buyer_message").asText());
//		}
//		//子订单详情
//		Iterator<JsonNode> orders = order.path("orders").elements();
//		List<SaleOrderLinesBean> list=new ArrayList<SaleOrderLinesBean>();
//		while(orders.hasNext()){
//			JsonNode detail = orders.next();
//			SaleOrderLinesBean saleOrderLinesBean = new SaleOrderLinesBean();
//			//子订单编码
//			if(detail.get("oid")!=null&&!StringUtils.isBlank(detail.get("oid").toString())){
//				saleOrderLinesBean.setOrderCode((detail.get("oid").asText()));
//			}
//			if(detail.get("item_id")!=null&&!StringUtils.isBlank(detail.get("item_id").toString())){
//				saleOrderLinesBean.setItemCode(detail.get("item_id").asText());
//			}
//			if(detail.get("sku_id")!=null&&!StringUtils.isBlank(detail.get("sku_id").toString())){
//				saleOrderLinesBean.setSkuId(detail.get("sku_id").toString().replace("\"",""));
//			}
//			
//			if(detail.get("outer_sku_id")!=null&&!StringUtils.isBlank(detail.get("outer_sku_id").toString())){
//				saleOrderLinesBean.setOuterSkuId(detail.get("outer_sku_id").toString().replace("\"",""));
//			}
//			if(detail.get("title")!=null&&!StringUtils.isBlank(detail.get("title").toString())){
//				saleOrderLinesBean.setTitle(detail.get("title").toString().replace("\"",""));
//			}
//			if(detail.get("price")!=null&&!StringUtils.isBlank(detail.get("price").toString())){
//				saleOrderLinesBean.setPrice(detail.get("price").asText());
//			}
//			if(detail.get("num")!=null&&!StringUtils.isBlank(detail.get("num").toString())){
//				saleOrderLinesBean.setNum(detail.get("num").asText());
//			}
//			if(detail.get("payment")!=null&&!StringUtils.isBlank(detail.get("payment").toString())){
//				saleOrderLinesBean.setPayment(detail.get("payment").toString().replace("\"",""));
//			}
//			if(detail.get("total_fee")!=null&&!StringUtils.isBlank(detail.get("total_fee").toString())){
//				saleOrderLinesBean.setTotalPrice(detail.get("total_fee").toString().replace("\"",""));
//			}
////			if(detail.get("buyer_messages")!=null){
////				StringBuilder sb=new StringBuilder();
////				Iterator<JsonNode> elements = detail.get("buyer_messages").elements();
////				while(elements.hasNext()){
////					JsonNode jsonNode = elements.next();
////					String title = jsonNode.get("title").toString();
////					String content = jsonNode.get("content").toString();
////					sb.append(title).append(":").append(content).append(";");
////				}
////				o.setBuyerMessage(sb.toString().replace("\"", ""));
////			}
//			list.add(saleOrderLinesBean);
//		}
//		o.setDetail(list);
//		
//		return o;
//		
//	}
////退款退货的转化
//public static List<RefundOrderBean> ConvertRefundsList(Iterator<JsonNode> trades) {
//	List<RefundOrderBean> refundOrders= new ArrayList<RefundOrderBean>();
//	while(trades.hasNext()){
//		refundOrders.add(ConvertRefund(trades.next()));
//	}
//	return refundOrders;
//}
////自己要注意这里了 
//public static RefundOrderBean ConvertRefund(JsonNode refundNode) {
//	RefundOrderBean refund = new RefundOrderBean();		
//	if(refundNode.get("refundId")!=null&&!StringUtils.isBlank(refundNode.get("refundId").toString())){
//		refund.setRefundId(refundNode.get("refundId").toString().replace("\"",""));
//	}
//	if(refundNode.get("tid")!=null&&!StringUtils.isBlank(refundNode.get("tid").toString())){
//		refund.setOrderCode(refundNode.get("tid").toString().replace("\"",""));
//	}
//	if(refundNode.get("refunded_fee")!=null&&!StringUtils.isBlank(refundNode.get("refunded_fee").toString())){
//		refund.setRefundFee(refundNode.get("refunded_fee").toString().replace("\"",""));
//	}
//	if(refundNode.get("reason")!=null&&!StringUtils.isBlank(refundNode.get("reason").toString())){
//		refund.setReason(refundNode.get("reason").toString().replace("\"",""));
//	}
//	if(refundNode.get("created")!=null&&!StringUtils.isBlank(refundNode.get("created").toString())){
//		refund.setCreateTime(refundNode.get("created").toString().replace("\"",""));
//	}
//	if(refundNode.get("modified")!=null&&!StringUtils.isBlank(refundNode.get("modified").toString())){
//		refund.setUpdateTime(refundNode.get("modified").toString().replace("\"",""));
//	}
//	//退款状态: WAIT_SELLER_AGREE(买家已经申请退款，等待卖家同意)，
////	WAIT_BUYER_RETURN_GOODS(卖家已经同意退款，等待买家退货)，
////	WAIT_SELLER_CONFIRM_GOODS(买家已经退货，等待卖家确认收货)，
////	SELLER_REFUSE_BUYER(卖家拒绝退款)， CLOSED(退款关闭)， SUCCESS(退款成功)。
//	if(refundNode.get("status")!=null&&refundNode.get("status").asText() != null){
//		String status = refundNode.get("status").asText();
//		refund.setStatus(status);//退款费用
//	}
//	
//	
//	return refund;
//}	
//}
