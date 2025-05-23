package tencent.im.oidb.cmd0xea3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xea3$BackMsg extends MessageMicro<oidb_0xea3$BackMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"addition_seq", "msg"}, new Object[]{0L, ByteStringMicro.EMPTY}, oidb_0xea3$BackMsg.class);
    public final PBUInt64Field addition_seq = PBField.initUInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f435995msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
