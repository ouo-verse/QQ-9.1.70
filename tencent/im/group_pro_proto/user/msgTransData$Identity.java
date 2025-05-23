package tencent.im.group_pro_proto.user;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msgTransData$Identity extends MessageMicro<msgTransData$Identity> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "value"}, new Object[]{0, ""}, msgTransData$Identity.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField value = PBField.initString("");
    public final PBUInt32Field identityType = PBField.initUInt32(0);
    public final PBBytesField plateData = PBField.initBytes(ByteStringMicro.EMPTY);
}
