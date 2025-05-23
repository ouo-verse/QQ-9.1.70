package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class qqshop_act$SQQSHPActRsp extends MessageMicro<qqshop_act$SQQSHPActRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"code", "act_info", "act_show_info"}, new Object[]{0, null, null}, qqshop_act$SQQSHPActRsp.class);
    public final PBUInt32Field code = PBField.initUInt32(0);
    public qqshop_act$SQQSHPActInfo act_info = new MessageMicro<qqshop_act$SQQSHPActInfo>() { // from class: tencent.im.oidb.qqshop.qqshop_act$SQQSHPActInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"act_id", "beg_ts", "end_ts", "status", "fail_pic"}, new Object[]{0, 0, 0, 0, ""}, qqshop_act$SQQSHPActInfo.class);
        public final PBUInt32Field act_id = PBField.initUInt32(0);
        public final PBUInt32Field beg_ts = PBField.initUInt32(0);
        public final PBUInt32Field end_ts = PBField.initUInt32(0);
        public final PBUInt32Field status = PBField.initUInt32(0);
        public final PBStringField fail_pic = PBField.initString("");
    };
    public qqshop_act$SQQSHPActShowInfo act_show_info = new MessageMicro<qqshop_act$SQQSHPActShowInfo>() { // from class: tencent.im.oidb.qqshop.qqshop_act$SQQSHPActShowInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"title", "logo", "subtext", "btn_text", "btn_url", "detail_url", "gift_text", "act_text"}, new Object[]{"", "", "", "", "", "", "", ""}, qqshop_act$SQQSHPActShowInfo.class);
        public final PBStringField title = PBField.initString("");
        public final PBStringField logo = PBField.initString("");
        public final PBStringField subtext = PBField.initString("");
        public final PBStringField btn_text = PBField.initString("");
        public final PBStringField btn_url = PBField.initString("");
        public final PBStringField detail_url = PBField.initString("");
        public final PBStringField gift_text = PBField.initString("");
        public final PBStringField act_text = PBField.initString("");
    };
}
