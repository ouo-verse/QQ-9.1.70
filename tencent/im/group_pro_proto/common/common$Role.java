package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$Role extends MessageMicro<common$Role> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"id", "info", "flag"}, new Object[]{0L, ByteStringMicro.EMPTY, 0}, common$Role.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f435943id = PBField.initUInt64(0);
    public final PBBytesField info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field flag = PBField.initUInt32(0);
}
