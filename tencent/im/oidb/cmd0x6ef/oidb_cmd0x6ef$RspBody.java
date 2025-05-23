package tencent.im.oidb.cmd0x6ef;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x6ef$RspBody extends MessageMicro<oidb_cmd0x6ef$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"gc", "seq", "remind_brief", "is_create", "is_join"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY, 0, 0}, oidb_cmd0x6ef$RspBody.class);

    /* renamed from: gc, reason: collision with root package name */
    public final PBUInt64Field f435976gc = PBField.initUInt64(0);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBBytesField remind_brief = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_create = PBField.initUInt32(0);
    public final PBUInt32Field is_join = PBField.initUInt32(0);
}
