package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoTransInfo extends MessageMicro<StoragePhotoSdkVideo$VideoTransInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50}, new String[]{"trans_codes", "snapshot_codes", "echo_msg", "trans_water", "trans_items", "snapshot_items"}, new Object[]{0, 0, ByteStringMicro.EMPTY, null, null, null}, StoragePhotoSdkVideo$VideoTransInfo.class);
    public final PBBytesField echo_msg;
    public final PBRepeatField<Integer> snapshot_codes;
    public final PBRepeatMessageField<StoragePhotoSdkVideo$TransItemInfo> snapshot_items;
    public final PBRepeatField<Integer> trans_codes;
    public final PBRepeatMessageField<StoragePhotoSdkVideo$TransItemInfo> trans_items;
    public final PBRepeatMessageField<StoragePhotoSdkVideo$TransWaterInfo> trans_water;

    public StoragePhotoSdkVideo$VideoTransInfo() {
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.trans_codes = PBField.initRepeat(pBUInt32Field);
        this.snapshot_codes = PBField.initRepeat(pBUInt32Field);
        this.echo_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        this.trans_water = PBField.initRepeatMessage(StoragePhotoSdkVideo$TransWaterInfo.class);
        this.trans_items = PBField.initRepeatMessage(StoragePhotoSdkVideo$TransItemInfo.class);
        this.snapshot_items = PBField.initRepeatMessage(StoragePhotoSdkVideo$TransItemInfo.class);
    }
}
