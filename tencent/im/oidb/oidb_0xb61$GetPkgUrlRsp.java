package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0xb61$GetPkgUrlRsp extends MessageMicro<oidb_0xb61$GetPkgUrlRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"app_version", "pkg_url"}, new Object[]{0, ""}, oidb_0xb61$GetPkgUrlRsp.class);
    public final PBUInt32Field app_version = PBField.initUInt32(0);
    public final PBStringField pkg_url = PBField.initString("");
}
