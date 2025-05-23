package tencent.im.oidb.cmd0x7c4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7c4$RecommendReason extends MessageMicro<cmd0x7c4$RecommendReason> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_reason_id", "bytes_recommend_reason"}, new Object[]{0, ByteStringMicro.EMPTY}, cmd0x7c4$RecommendReason.class);
    public final PBUInt32Field uint32_reason_id = PBField.initUInt32(0);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
}
