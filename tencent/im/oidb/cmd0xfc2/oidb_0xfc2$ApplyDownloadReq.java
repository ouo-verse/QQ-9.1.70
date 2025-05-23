package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xfc2$ApplyDownloadReq extends MessageMicro<oidb_0xfc2$ApplyDownloadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"str_fileid", "uint32_support_encrypt", "bool_thumbnail"}, new Object[]{"", 0, Boolean.FALSE}, oidb_0xfc2$ApplyDownloadReq.class);
    public final PBStringField str_fileid = PBField.initString("");
    public final PBUInt32Field uint32_support_encrypt = PBField.initUInt32(0);
    public final PBBoolField bool_thumbnail = PBField.initBool(false);
}
