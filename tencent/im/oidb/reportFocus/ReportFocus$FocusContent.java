package tencent.im.oidb.reportFocus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ReportFocus$FocusContent extends MessageMicro<ReportFocus$FocusContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"appid", "items", "is_msg_tab_focus", "active_status"}, new Object[]{0, null, 0, 0}, ReportFocus$FocusContent.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBRepeatMessageField<ReportFocus$FocuesChannelItem> items = PBField.initRepeatMessage(ReportFocus$FocuesChannelItem.class);
    public final PBUInt32Field is_msg_tab_focus = PBField.initUInt32(0);
    public final PBUInt32Field active_status = PBField.initUInt32(0);
}
