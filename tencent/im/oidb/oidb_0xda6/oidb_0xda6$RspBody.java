package tencent.im.oidb.oidb_0xda6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xda6$RspBody extends MessageMicro<oidb_0xda6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_topic_item"}, new Object[]{null}, oidb_0xda6$RspBody.class);
    public final PBRepeatMessageField<oidb_0xda6$UserTopicItem> rpt_topic_item = PBField.initRepeatMessage(oidb_0xda6$UserTopicItem.class);
}
