package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoFinishUploadReq extends MessageMicro<StoragePhotoSdkVideo$VideoFinishUploadReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField echo_msg;
    public final PBBytesField file_name;
    public final PBRepeatMessageField<StoragePhotoSdkVideo$VideoPartInfo> part_infos;
    public final PBUInt32Field skip_audit;
    public StoragePhotoSdkVideo$VideoTransInfo trans_info;
    public final PBBytesField ukey;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50}, new String[]{"ukey", "file_name", "part_infos", "trans_info", "skip_audit", "echo_msg"}, new Object[]{byteStringMicro, byteStringMicro, null, null, 0, byteStringMicro}, StoragePhotoSdkVideo$VideoFinishUploadReq.class);
    }

    public StoragePhotoSdkVideo$VideoFinishUploadReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.ukey = PBField.initBytes(byteStringMicro);
        this.file_name = PBField.initBytes(byteStringMicro);
        this.part_infos = PBField.initRepeatMessage(StoragePhotoSdkVideo$VideoPartInfo.class);
        this.trans_info = new StoragePhotoSdkVideo$VideoTransInfo();
        this.skip_audit = PBField.initUInt32(0);
        this.echo_msg = PBField.initBytes(byteStringMicro);
    }
}
