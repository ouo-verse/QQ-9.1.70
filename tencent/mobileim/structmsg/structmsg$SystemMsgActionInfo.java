package tencent.mobileim.structmsg;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class structmsg$SystemMsgActionInfo extends MessageMicro<structmsg$SystemMsgActionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 402, 408, 418, 424, 434, 440}, new String[]{"type", "group_code", PreloadTRTCPlayerParams.KEY_SIG, "msg", "group_id", "remark", "blacklist", "addFrdSNInfo", "uint32_req_msg_type"}, new Object[]{1, 0L, ByteStringMicro.EMPTY, "", 0, "", Boolean.FALSE, null, 0}, structmsg$SystemMsgActionInfo.class);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f436066msg = PBField.initString("");
    public final PBUInt32Field group_id = PBField.initUInt32(0);
    public final PBStringField remark = PBField.initString("");
    public final PBBoolField blacklist = PBField.initBool(false);
    public structmsg$AddFrdSNInfo addFrdSNInfo = new structmsg$AddFrdSNInfo();
    public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);
}
