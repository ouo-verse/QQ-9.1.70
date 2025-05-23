package tencent.im.oidb.cmd0xc78;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc78$RspBody extends MessageMicro<oidb_cmd0xc78$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82}, new String[]{"wording", "check_share_extension_rsp"}, new Object[]{"", null}, oidb_cmd0xc78$RspBody.class);
    public final PBStringField wording = PBField.initString("");
    public oidb_cmd0xc78$CheckShareExtensionRsp check_share_extension_rsp = new oidb_cmd0xc78$CheckShareExtensionRsp();
}
