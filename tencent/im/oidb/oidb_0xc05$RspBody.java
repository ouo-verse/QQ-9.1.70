package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc05$RspBody extends MessageMicro<oidb_0xc05$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82, 90}, new String[]{"wording", "get_create_app_list_rsp", "get_auth_app_list_rsp"}, new Object[]{"", null, null}, oidb_0xc05$RspBody.class);
    public final PBStringField wording = PBField.initString("");
    public oidb_0xc05$GetCreateAppListRsp get_create_app_list_rsp = new MessageMicro<oidb_0xc05$GetCreateAppListRsp>() { // from class: tencent.im.oidb.oidb_0xc05$GetCreateAppListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"total_count", "appinfos"}, new Object[]{0, null}, oidb_0xc05$GetCreateAppListRsp.class);
        public final PBUInt32Field total_count = PBField.initUInt32(0);
        public final PBRepeatMessageField<qqconnect$Appinfo> appinfos = PBField.initRepeatMessage(qqconnect$Appinfo.class);
    };
    public oidb_0xc05$GetAuthAppListRsp get_auth_app_list_rsp = new oidb_0xc05$GetAuthAppListRsp();
}
