package tencent.im.oidb.oidb_0xd9e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd9e$RspBody extends MessageMicro<oidb_0xd9e$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_topic_item"}, new Object[]{null}, oidb_0xd9e$RspBody.class);
    public final PBRepeatMessageField<oidb_0xd9e$UserTopicItem> rpt_topic_item = PBField.initRepeatMessage(oidb_0xd9e$UserTopicItem.class);
}
