package tencent.im.oidb.oidb_0xde8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xde8$CommentItem extends MessageMicro<oidb_0xde8$CommentItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48}, new String[]{"uint64_comment_id", "str_comment", "uint64_target_comment_id", "uint64_target_uin", "uint64_comment_uin", "uint64_time"}, new Object[]{0L, "", 0L, 0L, 0L, 0L}, oidb_0xde8$CommentItem.class);
    public final PBUInt64Field uint64_comment_id = PBField.initUInt64(0);
    public final PBStringField str_comment = PBField.initString("");
    public final PBUInt64Field uint64_target_comment_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_target_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_comment_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
}
