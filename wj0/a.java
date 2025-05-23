package wj0;

import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderShop;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ShopInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$ShopSnapshot;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_common/ECOrderCommon$ShopInfo;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/b;", "a", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr_sample_data/ECSampleData$ShopSnapshot;", "b", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {
    public static final OrderShop a(ECOrderCommon$ShopInfo eCOrderCommon$ShopInfo) {
        return new OrderShop(eCOrderCommon$ShopInfo.shop_id.get(), eCOrderCommon$ShopInfo.shop_title.get(), eCOrderCommon$ShopInfo.shop_icon.get(), eCOrderCommon$ShopInfo.shop_link.get(), null, 16, null);
    }

    public static final OrderShop b(ECSampleData$ShopSnapshot eCSampleData$ShopSnapshot) {
        return new OrderShop(eCSampleData$ShopSnapshot.shop_id.get(), eCSampleData$ShopSnapshot.shop_title.get(), eCSampleData$ShopSnapshot.shop_icon.get(), eCSampleData$ShopSnapshot.shop_link.get(), eCSampleData$ShopSnapshot.contact_details.get());
    }
}
