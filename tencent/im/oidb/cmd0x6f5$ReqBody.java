package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x6f5$ReqBody extends MessageMicro<cmd0x6f5$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"str_qq_version", "uint32_qq_platform"}, new Object[]{"", 0}, cmd0x6f5$ReqBody.class);
    public final PBStringField str_qq_version = PBField.initString("");
    public final PBUInt32Field uint32_qq_platform = PBField.initUInt32(0);
}
