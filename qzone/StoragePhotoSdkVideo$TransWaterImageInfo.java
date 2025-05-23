package qzone;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tl.h;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$TransWaterImageInfo extends MessageMicro<StoragePhotoSdkVideo$TransWaterImageInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 66, 74}, new String[]{"url", "w", h.F, HippyTKDListViewAdapter.X, "y", "modid", "cmdid", "refpos", "time_line"}, new Object[]{"", 0, 0, 0, 0, 0, 0, "", null}, StoragePhotoSdkVideo$TransWaterImageInfo.class);
    public final PBStringField url = PBField.initString("");

    /* renamed from: w, reason: collision with root package name */
    public final PBUInt32Field f430348w = PBField.initUInt32(0);

    /* renamed from: h, reason: collision with root package name */
    public final PBUInt32Field f430347h = PBField.initUInt32(0);

    /* renamed from: x, reason: collision with root package name */
    public final PBUInt32Field f430349x = PBField.initUInt32(0);

    /* renamed from: y, reason: collision with root package name */
    public final PBUInt32Field f430350y = PBField.initUInt32(0);
    public final PBUInt32Field modid = PBField.initUInt32(0);
    public final PBUInt32Field cmdid = PBField.initUInt32(0);
    public final PBStringField refpos = PBField.initString("");
    public StoragePhotoSdkVideo$TimeLineInfo time_line = new StoragePhotoSdkVideo$TimeLineInfo();
}
