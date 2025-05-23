package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class StorageNTSdkExtInfo$AsyncCallbackInfo extends MessageMicro<StorageNTSdkExtInfo$AsyncCallbackInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 802}, new String[]{"photo_rsp_ext", "photo_info", "echo_msg"}, new Object[]{null, null, ByteStringMicro.EMPTY}, StorageNTSdkExtInfo$AsyncCallbackInfo.class);
    public StorageNTSdkExtInfo$PhotoDataUploadRspExtInfo photo_rsp_ext = new StorageNTSdkExtInfo$PhotoDataUploadRspExtInfo();
    public StoragePhotoSdkCommon$StoragePhotoInfo photo_info = new StoragePhotoSdkCommon$StoragePhotoInfo();
    public final PBBytesField echo_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
