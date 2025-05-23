package tencent.im.oidb.cloud_print;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class cloud_print$C2COfflineFileReqParams extends MessageMicro<cloud_print$C2COfflineFileReqParams> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_uuid", "str_fileidcrc", "str_file_name"}, new Object[]{ByteStringMicro.EMPTY, "", ""}, cloud_print$C2COfflineFileReqParams.class);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_fileidcrc = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
}
