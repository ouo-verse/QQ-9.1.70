package tencent.im.oidb.cmdBlacklist;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RelationBlacklist$CountBlockListRsp extends MessageMicro<RelationBlacklist$CountBlockListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"code", "msg", "count"}, new Object[]{0L, "", 0L}, RelationBlacklist$CountBlockListRsp.class);
    public final PBUInt64Field code = PBField.initUInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f436003msg = PBField.initString("");
    public final PBUInt64Field count = PBField.initUInt64(0);
}
