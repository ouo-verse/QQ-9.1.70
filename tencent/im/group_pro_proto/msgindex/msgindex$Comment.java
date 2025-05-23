package tencent.im.group_pro_proto.msgindex;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msgindex$Comment extends MessageMicro<msgindex$Comment> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"msg_seq", "root_seq", "parent_seq", "refer_seq", "comment_cnt"}, new Object[]{0L, 0L, 0L, 0L, 0L}, msgindex$Comment.class);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field root_seq = PBField.initUInt64(0);
    public final PBUInt64Field parent_seq = PBField.initUInt64(0);
    public final PBUInt64Field refer_seq = PBField.initUInt64(0);
    public final PBUInt64Field comment_cnt = PBField.initUInt64(0);
}
