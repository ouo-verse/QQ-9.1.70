package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FrdSysMsg$FriendHelloInfo extends MessageMicro<FrdSysMsg$FriendHelloInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_source_name"}, new Object[]{""}, FrdSysMsg$FriendHelloInfo.class);
    public final PBStringField str_source_name = PBField.initString("");
}
