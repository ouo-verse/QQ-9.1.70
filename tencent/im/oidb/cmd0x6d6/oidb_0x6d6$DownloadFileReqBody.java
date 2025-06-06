package tencent.im.oidb.cmd0x6d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d6$DownloadFileReqBody extends MessageMicro<oidb_0x6d6$DownloadFileReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBBoolField bool_thumbnail_req = PBField.initBool(false);
    public final PBUInt32Field uint32_url_type = PBField.initUInt32(0);
    public final PBBoolField bool_preview_req = PBField.initBool(false);
    public final PBUInt32Field uint32_src = PBField.initUInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56, 64}, new String[]{"uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_file_id", "bool_thumbnail_req", "uint32_url_type", "bool_preview_req", "uint32_src"}, new Object[]{0L, 0, 0, "", bool, 0, bool, 0}, oidb_0x6d6$DownloadFileReqBody.class);
    }
}
