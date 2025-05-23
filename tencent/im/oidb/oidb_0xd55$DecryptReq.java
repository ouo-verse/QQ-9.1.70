package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd55$DecryptReq extends MessageMicro<oidb_0xd55$DecryptReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"cipher_text"}, new Object[]{""}, oidb_0xd55$DecryptReq.class);
    public final PBStringField cipher_text = PBField.initString("");
}
