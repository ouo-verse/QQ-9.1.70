package tencent.im.oidb.cmd0xd23;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xd23$CacheKey extends MessageMicro<Oidb_0xd23$CacheKey> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"cache_prefix", "appid"}, new Object[]{"sdk_group_bind_data", 0}, Oidb_0xd23$CacheKey.class);
    public final PBStringField cache_prefix = PBField.initString("sdk_group_bind_data");
    public final PBUInt32Field appid = PBField.initUInt32(0);
}
