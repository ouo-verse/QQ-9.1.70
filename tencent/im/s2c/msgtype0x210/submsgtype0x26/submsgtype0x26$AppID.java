package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x26$AppID extends MessageMicro<submsgtype0x26$AppID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_app_id"}, new Object[]{0L}, submsgtype0x26$AppID.class);
    public final PBUInt64Field uint64_app_id = PBField.initUInt64(0);
}
