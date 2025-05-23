package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class kua_kua_hb_srv$TopicMatchReply extends MessageMicro<kua_kua_hb_srv$TopicMatchReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"retCode", "retMsg", "refuseInterval", "matchToken"}, new Object[]{0L, "", 0L, ""}, kua_kua_hb_srv$TopicMatchReply.class);
    public final PBInt64Field retCode = PBField.initInt64(0);
    public final PBStringField retMsg = PBField.initString("");
    public final PBInt64Field refuseInterval = PBField.initInt64(0);
    public final PBStringField matchToken = PBField.initString("");
}
