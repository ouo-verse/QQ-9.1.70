package tencent.im.oidb.cmd0xa6e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xa6e$RspBody extends MessageMicro<oidb_cmd0xa6e$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_topicinfo"}, new Object[]{null}, oidb_cmd0xa6e$RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0xa6e$TopicInfo> rpt_topicinfo = PBField.initRepeatMessage(oidb_cmd0xa6e$TopicInfo.class);
}
