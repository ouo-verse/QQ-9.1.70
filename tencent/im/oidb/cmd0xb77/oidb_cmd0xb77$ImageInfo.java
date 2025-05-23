package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb77$ImageInfo extends MessageMicro<oidb_cmd0xb77$ImageInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 808, 816, 824}, new String[]{"md5", "uuid", "img_type", "file_size", "width", "height", "original", "file_id", "server_ip", "server_port"}, new Object[]{"", "", 0, 0, 0, 0, 0, 0, 0, 0}, oidb_cmd0xb77$ImageInfo.class);
    public final PBStringField md5 = PBField.initString("");
    public final PBStringField uuid = PBField.initString("");
    public final PBUInt32Field img_type = PBField.initUInt32(0);
    public final PBUInt32Field file_size = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBUInt32Field original = PBField.initUInt32(0);
    public final PBUInt32Field file_id = PBField.initUInt32(0);
    public final PBUInt32Field server_ip = PBField.initUInt32(0);
    public final PBUInt32Field server_port = PBField.initUInt32(0);
}
