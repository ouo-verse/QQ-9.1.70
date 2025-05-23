package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xbcb$RspBody extends MessageMicro<oidb_0xbcb$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82}, new String[]{"wording", "check_url_rsp"}, new Object[]{"", null}, oidb_0xbcb$RspBody.class);
    public final PBStringField wording = PBField.initString("");
    public oidb_0xbcb$CheckUrlRsp check_url_rsp = new oidb_0xbcb$CheckUrlRsp();
}
