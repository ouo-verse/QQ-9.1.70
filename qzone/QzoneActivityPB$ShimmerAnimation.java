package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$ShimmerAnimation extends MessageMicro<QzoneActivityPB$ShimmerAnimation> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"owner_anim_level", "guest_anim_enable"}, new Object[]{0, Boolean.FALSE}, QzoneActivityPB$ShimmerAnimation.class);
    public final PBUInt32Field owner_anim_level = PBField.initUInt32(0);
    public final PBBoolField guest_anim_enable = PBField.initBool(false);
}
