package tencent.im.group.group_label;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GroupLabel$RspBody extends MessageMicro<GroupLabel$RspBody> {
    public static final int BYTES_ERROR_FIELD_NUMBER = 1;
    public static final int RPT_GROUP_INFO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_error", "rpt_group_info"}, new Object[]{ByteStringMicro.EMPTY, null}, GroupLabel$RspBody.class);
    public final PBBytesField bytes_error = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<GroupLabel$GroupInfo> rpt_group_info = PBField.initRepeatMessage(GroupLabel$GroupInfo.class);
}
