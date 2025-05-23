package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc05$ReqBody extends MessageMicro<oidb_0xc05$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90}, new String[]{"get_create_app_list_req", "get_auth_app_list_req"}, new Object[]{null, null}, oidb_0xc05$ReqBody.class);
    public oidb_0xc05$GetCreateAppListReq get_create_app_list_req = new MessageMicro<oidb_0xc05$GetCreateAppListReq>() { // from class: tencent.im.oidb.oidb_0xc05$GetCreateAppListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"start", "limit"}, new Object[]{0, 0}, oidb_0xc05$GetCreateAppListReq.class);
        public final PBUInt32Field start = PBField.initUInt32(0);
        public final PBUInt32Field limit = PBField.initUInt32(0);
    };
    public oidb_0xc05$GetAuthAppListReq get_auth_app_list_req = new oidb_0xc05$GetAuthAppListReq();
}
