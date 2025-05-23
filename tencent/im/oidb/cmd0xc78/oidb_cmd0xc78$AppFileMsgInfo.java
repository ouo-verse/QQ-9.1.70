package tencent.im.oidb.cmd0xc78;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc78$AppFileMsgInfo extends MessageMicro<oidb_cmd0xc78$AppFileMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"md5", "sha1", "file_size"}, new Object[]{"", "", 0}, oidb_cmd0xc78$AppFileMsgInfo.class);
    public final PBStringField md5 = PBField.initString("");
    public final PBStringField sha1 = PBField.initString("");
    public final PBUInt32Field file_size = PBField.initUInt32(0);
}
