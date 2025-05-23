package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class ShopOuterClass$BuyAndGiveGiftRsp extends MessageMicro<ShopOuterClass$BuyAndGiveGiftRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56}, new String[]{"change_money_type", "cur_money_num", "recv_list", "gift_id", "total_num", "base_num", "gift_price"}, new Object[]{0, 0, null, 0, 0, 0, 0}, ShopOuterClass$BuyAndGiveGiftRsp.class);
    public final PBInt32Field change_money_type = PBField.initInt32(0);
    public final PBInt32Field cur_money_num = PBField.initInt32(0);
    public final PBRepeatMessageField<CommonOuterClass$QQUserId> recv_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
    public final PBInt32Field gift_id = PBField.initInt32(0);
    public final PBInt32Field total_num = PBField.initInt32(0);
    public final PBInt32Field base_num = PBField.initInt32(0);
    public final PBInt32Field gift_price = PBField.initInt32(0);
}
