package tencent.intimate_relation;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class intimate_relation$IntimateParentChild extends MessageMicro<intimate_relation$IntimateParentChild> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 802}, new String[]{"time", "source", "level", "chat_days", "birthdate", "buffer"}, new Object[]{0, 0, 0, 0, 0, ByteStringMicro.EMPTY}, intimate_relation$IntimateParentChild.class);
    public final PBUInt32Field time = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field level = PBField.initUInt32(0);
    public final PBUInt32Field chat_days = PBField.initUInt32(0);
    public final PBUInt32Field birthdate = PBField.initUInt32(0);
    public final PBBytesField buffer = PBField.initBytes(ByteStringMicro.EMPTY);
}
