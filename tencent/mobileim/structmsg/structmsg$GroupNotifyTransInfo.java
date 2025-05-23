package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class structmsg$GroupNotifyTransInfo extends MessageMicro<structmsg$GroupNotifyTransInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"join_group_susp_sec_code"}, new Object[]{0L}, structmsg$GroupNotifyTransInfo.class);
    public final PBUInt64Field join_group_susp_sec_code = PBField.initUInt64(0);
}
