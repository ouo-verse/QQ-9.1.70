package tencent.im.group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_member_info$InfoCardVideoInfo extends MessageMicro<group_member_info$InfoCardVideoInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"cover", "vid", "feed_id"}, new Object[]{ByteStringMicro.EMPTY, "", ""}, group_member_info$InfoCardVideoInfo.class);
    public final PBBytesField cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField vid = PBField.initString("");
    public final PBStringField feed_id = PBField.initString("");
}
