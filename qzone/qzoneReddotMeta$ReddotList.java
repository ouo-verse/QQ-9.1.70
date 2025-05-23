package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneReddotMeta$ReddotList extends MessageMicro<qzoneReddotMeta$ReddotList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"reddot_infos"}, new Object[]{null}, qzoneReddotMeta$ReddotList.class);
    public final PBRepeatMessageField<qzoneReddotMeta$ReddotInfo> reddot_infos = PBField.initRepeatMessage(qzoneReddotMeta$ReddotInfo.class);
}
