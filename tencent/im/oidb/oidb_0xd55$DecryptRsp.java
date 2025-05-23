package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd55$DecryptRsp extends MessageMicro<oidb_0xd55$DecryptRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"plain_text"}, new Object[]{""}, oidb_0xd55$DecryptRsp.class);
    public final PBStringField plain_text = PBField.initString("");
}
