package tencent.im.oidb.cmd0xea0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xea0$RspBody extends MessageMicro<oidb_cmd0xea0$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"channel_id", "dynamic_banner_list"}, new Object[]{0L, null}, oidb_cmd0xea0$RspBody.class);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_cmd0xea0$DynamicBannerItem> dynamic_banner_list = PBField.initRepeatMessage(oidb_cmd0xea0$DynamicBannerItem.class);
}
