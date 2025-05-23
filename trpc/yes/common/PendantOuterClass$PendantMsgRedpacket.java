package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class PendantOuterClass$PendantMsgRedpacket extends MessageMicro<PendantOuterClass$PendantMsgRedpacket> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 56}, new String[]{"activity_id", "status", "init_pic", "active_pic", "anchor_hint_text", "audience_hint_text", "progress_full_time"}, new Object[]{"", 0, null, null, "", "", 0L}, PendantOuterClass$PendantMsgRedpacket.class);
    public final PBStringField activity_id = PBField.initString("");
    public final PBInt32Field status = PBField.initInt32(0);
    public CommonOuterClass$ImageItem init_pic = new CommonOuterClass$ImageItem();
    public CommonOuterClass$ImageItem active_pic = new CommonOuterClass$ImageItem();
    public final PBStringField anchor_hint_text = PBField.initString("");
    public final PBStringField audience_hint_text = PBField.initString("");
    public final PBUInt64Field progress_full_time = PBField.initUInt64(0);
}
