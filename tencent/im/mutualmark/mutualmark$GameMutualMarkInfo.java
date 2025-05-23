package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$GameMutualMarkInfo extends MessageMicro<mutualmark$GameMutualMarkInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_subsource", "uint32_time"}, new Object[]{0, 0}, mutualmark$GameMutualMarkInfo.class);
    public final PBUInt32Field uint32_subsource = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
}
