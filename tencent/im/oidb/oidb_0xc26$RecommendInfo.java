package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc26$RecommendInfo extends MessageMicro<oidb_0xc26$RecommendInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_woring", "msg_groups"}, new Object[]{ByteStringMicro.EMPTY, null}, oidb_0xc26$RecommendInfo.class);
    public final PBBytesField bytes_woring = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0xc26$RgroupInfo> msg_groups = PBField.initRepeatMessage(oidb_0xc26$RgroupInfo.class);
}
