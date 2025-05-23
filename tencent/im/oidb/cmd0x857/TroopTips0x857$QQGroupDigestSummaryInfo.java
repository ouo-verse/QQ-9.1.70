package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$QQGroupDigestSummaryInfo extends MessageMicro<TroopTips0x857$QQGroupDigestSummaryInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"msg_seq", "msg_random", "error_code"}, new Object[]{0, 0, 0}, TroopTips0x857$QQGroupDigestSummaryInfo.class);
    public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field msg_random = PBField.initUInt32(0);
    public final PBUInt32Field error_code = PBField.initUInt32(0);
}
