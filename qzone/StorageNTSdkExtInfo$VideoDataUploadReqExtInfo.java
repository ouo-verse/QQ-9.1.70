package qzone;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class StorageNTSdkExtInfo$VideoDataUploadReqExtInfo extends MessageMicro<StorageNTSdkExtInfo$VideoDataUploadReqExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField class_name;
    public final PBBytesField echo_msg;
    public final PBStringField sha1;
    public final PBUInt32Field terminal_type;
    public final PBStringField terminal_ver;
    public final PBStringField fileid_prefix = PBField.initString("");
    public StoragePhotoSdkVideo$VideoTransInfo trans_info = new StoragePhotoSdkVideo$VideoTransInfo();
    public final PBUInt32Field skip_audit = PBField.initUInt32(0);

    static {
        String[] strArr = {"fileid_prefix", "trans_info", "skip_audit", "echo_msg", PictureConst.KEY_CLASSNAME, "sha1", AudienceReportConst.TERMINAL_TYPE, "terminal_ver"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 56, 66}, strArr, new Object[]{"", null, 0, byteStringMicro, byteStringMicro, "", 0, ""}, StorageNTSdkExtInfo$VideoDataUploadReqExtInfo.class);
    }

    public StorageNTSdkExtInfo$VideoDataUploadReqExtInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.echo_msg = PBField.initBytes(byteStringMicro);
        this.class_name = PBField.initBytes(byteStringMicro);
        this.sha1 = PBField.initString("");
        this.terminal_type = PBField.initUInt32(0);
        this.terminal_ver = PBField.initString("");
    }
}
