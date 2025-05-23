package qzone;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$TransWaterTextInfo extends MessageMicro<StoragePhotoSdkVideo$TransWaterTextInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 56, 64, 72, 80, 90}, new String[]{"text", "refpos", "font_color", "font_file", "font_size", "shadow_color", "shadow_x", "shadow_y", HippyTKDListViewAdapter.X, "y", "time_line"}, new Object[]{ByteStringMicro.EMPTY, "", "", "", 0, "", 0, 0, 0, 0, null}, StoragePhotoSdkVideo$TransWaterTextInfo.class);
    public final PBBytesField text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField refpos = PBField.initString("");
    public final PBStringField font_color = PBField.initString("");
    public final PBStringField font_file = PBField.initString("");
    public final PBUInt32Field font_size = PBField.initUInt32(0);
    public final PBStringField shadow_color = PBField.initString("");
    public final PBUInt32Field shadow_x = PBField.initUInt32(0);
    public final PBUInt32Field shadow_y = PBField.initUInt32(0);

    /* renamed from: x, reason: collision with root package name */
    public final PBUInt32Field f430351x = PBField.initUInt32(0);

    /* renamed from: y, reason: collision with root package name */
    public final PBUInt32Field f430352y = PBField.initUInt32(0);
    public StoragePhotoSdkVideo$TimeLineInfo time_line = new StoragePhotoSdkVideo$TimeLineInfo();
}
