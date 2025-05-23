package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoQueryStatusInfoRsp extends MessageMicro<StoragePhotoSdkVideo$VideoQueryStatusInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"status_infos"}, new Object[]{null}, StoragePhotoSdkVideo$VideoQueryStatusInfoRsp.class);
    public final PBRepeatMessageField<StoragePhotoSdkVideo$VideoStatusInfo> status_infos = PBField.initRepeatMessage(StoragePhotoSdkVideo$VideoStatusInfo.class);
}
