package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class qzoneUnifiedStore$GetPayProfileRsp extends MessageMicro<qzoneUnifiedStore$GetPayProfileRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"coin_num", "cost_coin_per_signing", "member_signing", "member_prices"}, new Object[]{0, 0, 0, null}, qzoneUnifiedStore$GetPayProfileRsp.class);
    public final PBInt32Field coin_num = PBField.initInt32(0);
    public final PBInt32Field cost_coin_per_signing = PBField.initInt32(0);
    public final PBInt32Field member_signing = PBField.initInt32(0);
    public final PBRepeatMessageField<qzoneUnifiedStore$MemberPrice> member_prices = PBField.initRepeatMessage(qzoneUnifiedStore$MemberPrice.class);
}
