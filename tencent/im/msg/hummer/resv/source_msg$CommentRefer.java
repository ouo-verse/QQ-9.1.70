package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class source_msg$CommentRefer extends MessageMicro<source_msg$CommentRefer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"root_seq", "parent_seq", "refer_seq"}, new Object[]{0L, 0L, 0L}, source_msg$CommentRefer.class);
    public final PBUInt64Field root_seq = PBField.initUInt64(0);
    public final PBUInt64Field parent_seq = PBField.initUInt64(0);
    public final PBUInt64Field refer_seq = PBField.initUInt64(0);
}
