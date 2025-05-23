package tencent.im.oidb.cmd0xa6e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xa6e$TopicInfo extends MessageMicro<oidb_cmd0xa6e$TopicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 80, 88, 96}, new String[]{"uint64_topic_id", "uint32_pv", "uint32_followed_count", "uint32_ugc_count"}, new Object[]{0L, 0, 0, 0}, oidb_cmd0xa6e$TopicInfo.class);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_pv = PBField.initUInt32(0);
    public final PBUInt32Field uint32_followed_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ugc_count = PBField.initUInt32(0);
}
