package tencent.im.troop.flock;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QeventPB$FeedOpInfo extends MessageMicro<QeventPB$FeedOpInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"latest_modify_time"}, new Object[]{0L}, QeventPB$FeedOpInfo.class);
    public final PBUInt64Field latest_modify_time = PBField.initUInt64(0);
}
