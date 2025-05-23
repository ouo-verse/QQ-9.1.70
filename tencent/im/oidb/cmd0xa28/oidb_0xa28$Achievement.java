package tencent.im.oidb.cmd0xa28;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa28$Achievement extends MessageMicro<oidb_0xa28$Achievement> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_mvp_level", "uint64_super", "bytes_score", "uint64_round"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY, 0L}, oidb_0xa28$Achievement.class);
    public final PBUInt64Field uint64_mvp_level = PBField.initUInt64(0);
    public final PBUInt64Field uint64_super = PBField.initUInt64(0);
    public final PBBytesField bytes_score = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_round = PBField.initUInt64(0);
}
