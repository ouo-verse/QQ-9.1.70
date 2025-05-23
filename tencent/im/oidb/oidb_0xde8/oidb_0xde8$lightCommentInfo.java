package tencent.im.oidb.oidb_0xde8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xde8$lightCommentInfo extends MessageMicro<oidb_0xde8$lightCommentInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_total_num", "rpt_items"}, new Object[]{0L, null}, oidb_0xde8$lightCommentInfo.class);
    public final PBUInt64Field uint64_total_num = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0xde8$lightCommentItem> rpt_items = PBField.initRepeatMessage(oidb_0xde8$lightCommentItem.class);
}
