package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkCommon$CategoryInfo extends MessageMicro<StoragePhotoSdkCommon$CategoryInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"album_class", "total_album", "album_infos"}, new Object[]{0, 0, null}, StoragePhotoSdkCommon$CategoryInfo.class);
    public final PBUInt32Field album_class = PBField.initUInt32(0);
    public final PBUInt32Field total_album = PBField.initUInt32(0);
    public final PBRepeatMessageField<StoragePhotoSdkCommon$StorageAlbumInfo> album_infos = PBField.initRepeatMessage(StoragePhotoSdkCommon$StorageAlbumInfo.class);
}
