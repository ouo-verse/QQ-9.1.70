package tencent.im.group.nearbybanner;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearbybanner$Banners extends MessageMicro<nearbybanner$Banners> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_banner_info", "uint32_slide_time"}, new Object[]{null, 0}, nearbybanner$Banners.class);
    public final PBRepeatMessageField<nearbybanner$BannerInfo> rpt_banner_info = PBField.initRepeatMessage(nearbybanner$BannerInfo.class);
    public final PBUInt32Field uint32_slide_time = PBField.initUInt32(0);
}
