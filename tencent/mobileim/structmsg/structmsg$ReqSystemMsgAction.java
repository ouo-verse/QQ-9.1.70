package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class structmsg$ReqSystemMsgAction extends MessageMicro<structmsg$ReqSystemMsgAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 72}, new String[]{QQHealthReportApiImpl.MSG_TYPE_KEY, "msg_seq", "req_uin", "sub_type", "src_id", "sub_src_id", "group_msg_type", "action_info", IjkMediaMeta.IJKM_KEY_LANGUAGE}, new Object[]{1, 0L, 0L, 0, 0, 0, 0, null, 0}, structmsg$ReqSystemMsgAction.class);
    public final PBEnumField msg_type = PBField.initEnum(1);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field req_uin = PBField.initUInt64(0);
    public final PBUInt32Field sub_type = PBField.initUInt32(0);
    public final PBUInt32Field src_id = PBField.initUInt32(0);
    public final PBUInt32Field sub_src_id = PBField.initUInt32(0);
    public final PBUInt32Field group_msg_type = PBField.initUInt32(0);
    public structmsg$SystemMsgActionInfo action_info = new structmsg$SystemMsgActionInfo();
    public final PBUInt32Field language = PBField.initUInt32(0);
}
