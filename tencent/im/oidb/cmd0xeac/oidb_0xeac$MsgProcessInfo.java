package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0xeac$MsgProcessInfo extends MessageMicro<oidb_0xeac$MsgProcessInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"msg", "error_code", "digest_uin", "digest_time"}, new Object[]{null, 0, 0L, 0}, oidb_0xeac$MsgProcessInfo.class);

    /* renamed from: msg, reason: collision with root package name */
    public oidb_0xeac$MsgInfo f435996msg = new oidb_0xeac$MsgInfo();
    public final PBUInt32Field error_code = PBField.initUInt32(0);
    public final PBUInt64Field digest_uin = PBField.initUInt64(0);
    public final PBUInt32Field digest_time = PBField.initUInt32(0);
}
