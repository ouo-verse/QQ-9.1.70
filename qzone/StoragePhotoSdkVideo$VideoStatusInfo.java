package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoStatusInfo extends MessageMicro<StoragePhotoSdkVideo$VideoStatusInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bizid;
    public final PBBytesField cateid;
    public final PBBytesField file_name;
    public final PBBytesField file_type;
    public final PBBytesField formatid;
    public final PBUInt32Field req_time;
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBBytesField ret_msg;
    public final PBUInt32Field status;

    static {
        String[] strArr = {"ret_code", "ret_msg", TPReportKeys.VodExKeys.VOD_EX_BIZ_ID, "cateid", "formatid", "file_name", "file_type", "req_time", "status"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64, 72}, strArr, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0}, StoragePhotoSdkVideo$VideoStatusInfo.class);
    }

    public StoragePhotoSdkVideo$VideoStatusInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.ret_msg = PBField.initBytes(byteStringMicro);
        this.bizid = PBField.initBytes(byteStringMicro);
        this.cateid = PBField.initBytes(byteStringMicro);
        this.formatid = PBField.initBytes(byteStringMicro);
        this.file_name = PBField.initBytes(byteStringMicro);
        this.file_type = PBField.initBytes(byteStringMicro);
        this.req_time = PBField.initUInt32(0);
        this.status = PBField.initUInt32(0);
    }
}
