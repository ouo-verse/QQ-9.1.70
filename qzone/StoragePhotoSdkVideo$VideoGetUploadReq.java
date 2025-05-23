package qzone;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoGetUploadReq extends MessageMicro<StoragePhotoSdkVideo$VideoGetUploadReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field cateid;
    public final PBBytesField file_sha;
    public final PBUInt64Field file_size;
    public final PBBytesField file_type;
    public final PBBytesField fileid;
    public final PBUInt32Field fileid_as_prefix;

    static {
        String[] strArr = {QCircleSchemeAttr.Detail.FEED_VIDEO_ID, "file_type", "file_size", "file_sha", "cateid", "fileid_as_prefix"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48}, strArr, new Object[]{byteStringMicro, byteStringMicro, 0L, byteStringMicro, 0, 0}, StoragePhotoSdkVideo$VideoGetUploadReq.class);
    }

    public StoragePhotoSdkVideo$VideoGetUploadReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.fileid = PBField.initBytes(byteStringMicro);
        this.file_type = PBField.initBytes(byteStringMicro);
        this.file_size = PBField.initUInt64(0L);
        this.file_sha = PBField.initBytes(byteStringMicro);
        this.cateid = PBField.initUInt32(0);
        this.fileid_as_prefix = PBField.initUInt32(0);
    }
}
