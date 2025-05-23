package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneReddotMeta$ReddotCache extends MessageMicro<qzoneReddotMeta$ReddotCache> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"last_get_time", "reddot"}, new Object[]{0L, null}, qzoneReddotMeta$ReddotCache.class);
    public final PBInt64Field last_get_time = PBField.initInt64(0);
    public qzoneReddotMeta$ReddotInfo reddot = new qzoneReddotMeta$ReddotInfo();
}
