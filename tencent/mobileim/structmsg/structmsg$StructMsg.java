package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class structmsg$StructMsg extends MessageMicro<structmsg$StructMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 402}, new String[]{"version", QQHealthReportApiImpl.MSG_TYPE_KEY, "msg_seq", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "req_uin", "uint32_unread_flag", "msg"}, new Object[]{0, 1, 0L, 0L, 0L, 0, null}, structmsg$StructMsg.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBEnumField msg_type = PBField.initEnum(1);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field msg_time = PBField.initUInt64(0);
    public final PBUInt64Field req_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_unread_flag = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public structmsg$SystemMsg f436065msg = new structmsg$SystemMsg();
}
