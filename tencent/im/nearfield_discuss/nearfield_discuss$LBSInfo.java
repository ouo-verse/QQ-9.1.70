package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_discuss$LBSInfo extends MessageMicro<nearfield_discuss$LBSInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_gps", "rpt_msg_wifis", "rpt_msg_cells"}, new Object[]{null, null, null}, nearfield_discuss$LBSInfo.class);
    public nearfield_discuss$GPS msg_gps = new nearfield_discuss$GPS();
    public final PBRepeatMessageField<nearfield_discuss$Wifi> rpt_msg_wifis = PBField.initRepeatMessage(nearfield_discuss$Wifi.class);
    public final PBRepeatMessageField<nearfield_discuss$Cell> rpt_msg_cells = PBField.initRepeatMessage(nearfield_discuss$Cell.class);
}
