package com.ooooo.quake.service.impl;

import com.kamo.market.base.model.BaseCurrencyInfo;
import com.kamo.market.base.model.Result;
import com.kamo.market.order.iface.OrderInterface;
import com.kamo.market.order.model.order.CreateOrderResult;
import com.kamo.market.order.model.order.OrderProductSkuBean;
import com.kamo.market.order.model.order.PreCreateOrderResult;
import com.kamo.market.order.request.CalculationCartCouponRequest;
import com.kamo.market.order.request.CreateOrderRequest;
import com.kamo.market.order.request.PreCreateOrderRequest;
import com.kamo.market.product.iface.bean.product.ProductSkuInfo;
import com.kamo.market.product.iface.bean.sku.ProductSkuSpesc;
import com.kamo.market.product.iface.inter.ProductSkuService;
import com.kamo.market.user.iface.bean.AddressBean;
import com.kamo.market.user.iface.bean.UserSelfBean;
import com.kamo.market.user.iface.inter.UserAddressInterface;
import com.kamo.market.user.iface.inter.UserInterface;
import com.ooooo.quake.dao.TransactionFlowDao;
import com.ooooo.quake.dao.UserOrderDao;
import com.ooooo.quake.dto.JsonData;
import com.ooooo.quake.exception.ErrorCode;
import com.ooooo.quake.model.TransactionFlow;
import com.ooooo.quake.model.UserOrder;
import com.ooooo.quake.request.UserOrderPayRequest;
import com.ooooo.quake.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @DubboReference(check = false)
    private ProductSkuService productSkuService;

    @DubboReference(check = false)
    private UserAddressInterface userAddressService;

    @DubboReference(check = false)
    UserInterface userInterface;

    @DubboReference(check = false)
    OrderInterface orderService;

    @Resource
    private UserOrderDao userOrderDao;

    @Resource
    private TransactionFlowDao transactionFlowDao;

    /**
     * sku 列表
     *
     * @param productId
     * @return
     */
    public Object productSkulist(String productId) {
        ProductSkuSpesc productSkuSpesc = productSkuService.listSellSkuWithSpecs(productId);
        List<ProductSkuInfo> skuList = productSkuSpesc.getSkuList();
        int Random = (int) (Math.random() * skuList.size());
        ProductSkuInfo productSkuInfo = skuList.get(Random);
        return productSkuInfo;
    }


    public Object addressesList(String userId) {
        List<AddressBean> addresses = userAddressService.addresses(userId);
        AddressBean addressBean = addresses.get(0);
        String addressId = addressBean.getAddressId();
        return addressId;
    }


    public Object userEmail(String userId) {
        UserSelfBean userSelfBean = userInterface.userInfoSelf(userId);
        String email = userSelfBean.getEmail();
        return email;
    }

    public Object preCreateOrderNew(PreCreateOrderRequest preCreateOrderRequest) {
        Result<PreCreateOrderResult> preCreateOrderResultResult = orderService.preCreateOrderNew(preCreateOrderRequest);
        return preCreateOrderResultResult;
    }


    public Object PaymentOrder(String productId, String userId, Integer productNum, Integer type, String liveId, Boolean flashSell) {
        ProductSkuSpesc productSkuSpesc = productSkuService.listSellSkuWithSpecs(productId);
        List<ProductSkuInfo> skuList = productSkuSpesc.getSkuList();
        int Random = (int) (Math.random() * skuList.size());
        ProductSkuInfo productSkuInfo = skuList.get(Random);
        String skuId = productSkuInfo.getSkuId();
        BigDecimal price = productSkuInfo.getPrice();
        BigDecimal discountPrice = productSkuInfo.getDiscountPrice();
        Long stock = productSkuInfo.getStock();
        Boolean isSampleSku = productSkuInfo.getIsSampleSku();
        Boolean isSupportSell = productSkuInfo.getIsSupportSell();

        List<AddressBean> addresses = userAddressService.addresses(userId);
        AddressBean addressBean = addresses.get(0);
        String addressId = addressBean.getAddressId();
        String userIds = addressBean.getUserId();
        String province = addressBean.getProvince();
        String city = addressBean.getCity();
        String zipCode = addressBean.getZipCode();
        String phoneNumber = addressBean.getPhoneNumber();
        String mobileCountryCode = addressBean.getMobileCountryCode();
        String streetNumber = addressBean.getStreetNumber();
        String contactName = addressBean.getContactName();
        String mainAddress = addressBean.getMainAddress();
        String isoCode = addressBean.getIsoCode();

//        Math.min(price,discountPrice);
        BigDecimal minPrice = price.min(discountPrice);

        UserSelfBean userSelfBean = userInterface.userInfoSelf(userId);
        String email = userSelfBean.getEmail();


        PreCreateOrderRequest preCreateOrderRequest = new PreCreateOrderRequest();
        preCreateOrderRequest.setUserId(userId);
        preCreateOrderRequest.setAddressId(addressId);
        preCreateOrderRequest.setFlashSell(flashSell);

        List<OrderProductSkuBean> products = new ArrayList();
        OrderProductSkuBean orderProductSkuBean = new OrderProductSkuBean();
        orderProductSkuBean.setProductId(productId);
        orderProductSkuBean.setSkuId(skuId);
        orderProductSkuBean.setPrice(minPrice.toString());
        orderProductSkuBean.setNum(productNum);
        orderProductSkuBean.setType(type);
        orderProductSkuBean.setLiveId(liveId);
        products.add(orderProductSkuBean);

        BaseCurrencyInfo baseCurrencyInfo = new BaseCurrencyInfo();

        baseCurrencyInfo.setCurrency("GBP");
        baseCurrencyInfo.setCurrencySymbol("£");
        baseCurrencyInfo.setSimRegion("GB");
        baseCurrencyInfo.setSystemRegion("CN");
        baseCurrencyInfo.setExchangeRate("0.75002");
        preCreateOrderRequest.setBaseCurrencyInfo(baseCurrencyInfo);
        preCreateOrderRequest.setProducts(products);

        Result<PreCreateOrderResult> preCreateOrderResultResult = orderService.preCreateOrderNew(preCreateOrderRequest);


        CalculationCartCouponRequest calculationCartCouponRequest = new CalculationCartCouponRequest();
        calculationCartCouponRequest.setUserId(userId);
        calculationCartCouponRequest.setFlashSell(flashSell);
        calculationCartCouponRequest.setProducts(products);
        calculationCartCouponRequest.setBaseCurrencyInfo(baseCurrencyInfo);
        calculationCartCouponRequest.setNeedAvailableCouponList(true);
        Result<PreCreateOrderResult> preCreateOrderResultResult1 = orderService.calculationCartCoupon(calculationCartCouponRequest);

        List<PreCreateOrderResult.AvailableCoupon> availableCouponList = preCreateOrderResultResult1.getData().getAvailableCouponList();
        String userCouponId = "";
        if (availableCouponList.size() > 0) {
            if (availableCouponList.get(0).isBest()) {
                String userCouponIds = availableCouponList.get(0).getUserCouponId();
                userCouponId = userCouponIds;
            }
        }

        String orderToken = orderService.preOrder(userId);

        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setUserId(userId);
        createOrderRequest.setOrderToken(orderToken);
        createOrderRequest.setOrderChannel(type);
        createOrderRequest.setEmail(email);
        createOrderRequest.setAddressId(addressId);
        createOrderRequest.setBaseCurrencyInfo(baseCurrencyInfo);
        createOrderRequest.setPayChannel(3);
        createOrderRequest.setUserPlatformCouponId(userCouponId);
        createOrderRequest.setIsUserCart(false);
        createOrderRequest.setProducts(products);
        createOrderRequest.setFlashSell(flashSell);

        Result<CreateOrderResult> orderNew = orderService.createOrderNew(createOrderRequest);

        String clientSecret = orderNew.getData().getClientSecret();

        return clientSecret;
    }

    /**
     * 根据订单id 和orderId查询订单详情
     *
     * @param userOrderPayRequest
     * @return
     */
    @Override
    public UserOrder queryOrderInfo(UserOrderPayRequest userOrderPayRequest) {

        UserOrder userOrder = userOrderDao.queryOrderInfo(userOrderPayRequest);

        return userOrder;
    }




    /**
     * 更改支付状态
     *
     * @param userOrderPayRequest
     * @return
     */
    @Override
    public JsonData updatePayOrderState(UserOrderPayRequest userOrderPayRequest) {
        UserOrder userOrder = queryOrderInfo(userOrderPayRequest);
        if (userOrder == null) {
            return JsonData.buildError(ErrorCode.ORDER_NOT_EXIST);
        }

        // 订单状态
        Integer orderState = userOrder.getOrderState();
        String orderId = userOrder.getId();
        String parentId = userOrder.getParentId();

        if (orderState != 1) {
//            return "订单状态必须为1";
            return JsonData.buildError(ErrorCode.ORDER_STATUS_MUST_PAID);
        }

        if (orderId != null) {
            UserOrder uo = new UserOrder();
            uo.setId(orderId);
            // 更改订单状态
            userOrderDao.updatePayOrderState(uo);
        }

        TransactionFlow transactionFlow = transactionFlowDao.queryByReferOrderId(parentId);

        String transactionId = transactionFlow.getId();

        if (orderId != null) {
            UserOrder order = new UserOrder();
            order.setId(orderId);
            order.setTransactionId(transactionId);
            // 更改订单状态
            userOrderDao.updateOrderTransactionId(order);
        }

        // 再次查询订单详情
        UserOrder uo = userOrderDao.queryOrderInfo(userOrderPayRequest);
        return JsonData.buildSuccess(uo);
    }

    @Override
    public UserOrder queryRecentOrder(int offset, int limit) {
        UserOrder userOrder = userOrderDao.queryRecentOrder(offset, limit);
        return userOrder;
    }


}
