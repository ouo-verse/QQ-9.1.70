package tencent.im.group_pro_proto.msgindex;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group_pro_proto.common.common$Event;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msgindex$Msg extends MessageMicro<msgindex$Msg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"seq", LinkReportConstant$GlobalKey.EVENTS}, new Object[]{0L, null}, msgindex$Msg.class);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBRepeatMessageField<common$Event> events = PBField.initRepeatMessage(common$Event.class);
}
