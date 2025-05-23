package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$Info extends MessageMicro<common$Info> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"id", "name", "color", "hoist"}, new Object[]{0L, ByteStringMicro.EMPTY, 0, 0}, common$Info.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f435942id = PBField.initUInt64(0);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field color = PBField.initUInt32(0);
    public final PBUInt32Field hoist = PBField.initUInt32(0);
}
