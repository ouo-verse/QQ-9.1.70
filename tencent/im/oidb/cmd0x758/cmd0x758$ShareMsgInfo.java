package tencent.im.oidb.cmd0x758;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x758$ShareMsgInfo extends MessageMicro<cmd0x758$ShareMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_msg_timestamp", "uint64_msg_seq"}, new Object[]{0L, 0L}, cmd0x758$ShareMsgInfo.class);
    public final PBUInt64Field uint64_msg_timestamp = PBField.initUInt64(0);
    public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0);
}
