package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$GroupNotifyInfo extends MessageMicro<TroopTips0x857$GroupNotifyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"opt_uint32_auto_pull_flag", "opt_bytes_feeds_id"}, new Object[]{0, ByteStringMicro.EMPTY}, TroopTips0x857$GroupNotifyInfo.class);
    public final PBUInt32Field opt_uint32_auto_pull_flag = PBField.initUInt32(0);
    public final PBBytesField opt_bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
