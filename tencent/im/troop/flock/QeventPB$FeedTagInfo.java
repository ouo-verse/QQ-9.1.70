package tencent.im.troop.flock;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QeventPB$FeedTagInfo extends MessageMicro<QeventPB$FeedTagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"tag_id", "tag_name"}, new Object[]{0, ""}, QeventPB$FeedTagInfo.class);
    public final PBUInt32Field tag_id = PBField.initUInt32(0);
    public final PBStringField tag_name = PBField.initString("");
}
