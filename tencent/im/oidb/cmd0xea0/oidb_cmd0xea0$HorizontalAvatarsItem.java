package tencent.im.oidb.cmd0xea0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xea0$HorizontalAvatarsItem extends MessageMicro<oidb_cmd0xea0$HorizontalAvatarsItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"pts_page_name", "show_more", "more_url", "subscriber"}, new Object[]{"", 0, "", null}, oidb_cmd0xea0$HorizontalAvatarsItem.class);
    public final PBStringField pts_page_name = PBField.initString("");
    public final PBUInt32Field show_more = PBField.initUInt32(0);
    public final PBStringField more_url = PBField.initString("");
    public final PBRepeatMessageField<oidb_cmd0xea0$Subscriber> subscriber = PBField.initRepeatMessage(oidb_cmd0xea0$Subscriber.class);
}
