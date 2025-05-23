package tencent.im.oidb.cmd0xfa4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xfa4$SourceInfo extends MessageMicro<oidb_cmd0xfa4$SourceInfo> {
    public static final int TYPE_COMMUNITY = 2;
    public static final int TYPE_HOMEPAGE = 3;
    public static final int TYPE_TAG_TOPIC = 1;
    public static final int TYPE_UNKNOWN = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "key"}, new Object[]{0, ""}, oidb_cmd0xfa4$SourceInfo.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField key = PBField.initString("");
}
