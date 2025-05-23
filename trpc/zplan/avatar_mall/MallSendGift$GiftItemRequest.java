package trpc.zplan.avatar_mall;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class MallSendGift$GiftItemRequest extends MessageMicro<MallSendGift$GiftItemRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50}, new String[]{"req_header", "uin_name", "to_uin", ReportDataBuilder.KEY_PRODUCT_ID, "icon_url", "to_uin_name"}, new Object[]{null, "", "", 0L, "", ""}, MallSendGift$GiftItemRequest.class);
    public MallSendGift$ReqHeader req_header = new MessageMicro<MallSendGift$ReqHeader>() { // from class: trpc.zplan.avatar_mall.MallSendGift$ReqHeader
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40}, new String[]{"client_version", "trace_id", "client_seq", "client_cpp_version", ReportDataBuilder.KEY_PROTOCOL_VERSION}, new Object[]{"", 0L, 0L, "", 0}, MallSendGift$ReqHeader.class);
        public final PBStringField client_version = PBField.initString("");
        public final PBUInt64Field trace_id = PBField.initUInt64(0);
        public final PBUInt64Field client_seq = PBField.initUInt64(0);
        public final PBStringField client_cpp_version = PBField.initString("");
        public final PBInt32Field protocol_version = PBField.initInt32(0);
    };
    public final PBStringField uin_name = PBField.initString("");
    public final PBStringField to_uin = PBField.initString("");
    public final PBUInt64Field product_id = PBField.initUInt64(0);
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField to_uin_name = PBField.initString("");
}
