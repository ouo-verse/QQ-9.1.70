package tencent.im.s2c.msgtype0x210.submsgtype0x14e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x14e$ChatNodeInfo extends MessageMicro<submsgtype0x14e$ChatNodeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"to_tinyid"}, new Object[]{0L}, submsgtype0x14e$ChatNodeInfo.class);
    public final PBUInt64Field to_tinyid = PBField.initUInt64(0);
}
