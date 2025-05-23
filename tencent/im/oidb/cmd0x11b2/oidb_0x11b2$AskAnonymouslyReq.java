package tencent.im.oidb.cmd0x11b2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x11b2$AskAnonymouslyReq extends MessageMicro<oidb_0x11b2$AskAnonymouslyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"jump_url"}, new Object[]{""}, oidb_0x11b2$AskAnonymouslyReq.class);
    public final PBStringField jump_url = PBField.initString("");
}
