package tencent.im.oidb.cmd0x6ef;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x6ef$ReqBody extends MessageMicro<oidb_cmd0x6ef$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"gc", "event_id", "seq"}, new Object[]{0L, "", 0L}, oidb_cmd0x6ef$ReqBody.class);

    /* renamed from: gc, reason: collision with root package name */
    public final PBUInt64Field f435975gc = PBField.initUInt64(0);
    public final PBStringField event_id = PBField.initString("");
    public final PBUInt64Field seq = PBField.initUInt64(0);
}
