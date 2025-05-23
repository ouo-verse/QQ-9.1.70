package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoQueryPlayInfoRsp extends MessageMicro<StoragePhotoSdkVideo$VideoQueryPlayInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"play_infos"}, new Object[]{null}, StoragePhotoSdkVideo$VideoQueryPlayInfoRsp.class);
    public final PBRepeatMessageField<StoragePhotoSdkVideo$VideoPlayInfo> play_infos = PBField.initRepeatMessage(StoragePhotoSdkVideo$VideoPlayInfo.class);
}
