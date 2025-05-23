package tencent.im.oidb.cmd0xbab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xbab$UserInfo extends MessageMicro<cmd0xbab$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "privilege_flag"}, new Object[]{0L, 0}, cmd0xbab$UserInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field privilege_flag = PBField.initUInt32(0);
}
