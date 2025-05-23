package trpc.qq_av.avatar2d_aidata;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SuperAvatarAIData$AvatarAIInfo extends MessageMicro<SuperAvatarAIData$AvatarAIInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField body;
    public final PBEnumField compress_type;
    public final PBRepeatMessageField<SuperAvatarAIData$AvatarAIEvent> events;

    /* renamed from: face, reason: collision with root package name */
    public final PBBytesField f437235face;
    public final PBUInt32Field frame_id;
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBRepeatField<Float> sky_box_transform = PBField.initRepeat(PBFloatField.__repeatHelper__);

    static {
        String[] strArr = {"version", "sky_box_transform", PreDetect.FACE_DETECT, "body", LinkReportConstant$GlobalKey.EVENTS, "compress_type", "frame_id"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21, 26, 34, 42, 48, 56}, strArr, new Object[]{0, Float.valueOf(0.0f), byteStringMicro, byteStringMicro, null, 0, 0}, SuperAvatarAIData$AvatarAIInfo.class);
    }

    public SuperAvatarAIData$AvatarAIInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.f437235face = PBField.initBytes(byteStringMicro);
        this.body = PBField.initBytes(byteStringMicro);
        this.events = PBField.initRepeatMessage(SuperAvatarAIData$AvatarAIEvent.class);
        this.compress_type = PBField.initEnum(0);
        this.frame_id = PBField.initUInt32(0);
    }
}
