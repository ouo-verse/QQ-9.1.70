package trpc.zplan.avatar_mall;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class MallSendGift$GiftItemReply extends MessageMicro<MallSendGift$GiftItemReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"rsp_header", "pay_res", "to_uin", ReportDataBuilder.KEY_PRODUCT_ID}, new Object[]{null, 0, "", 0L}, MallSendGift$GiftItemReply.class);
    public MallSendGift$RspHeader rsp_header = new MallSendGift$RspHeader();
    public final PBUInt32Field pay_res = PBField.initUInt32(0);
    public final PBStringField to_uin = PBField.initString("");
    public final PBUInt64Field product_id = PBField.initUInt64(0);
}
