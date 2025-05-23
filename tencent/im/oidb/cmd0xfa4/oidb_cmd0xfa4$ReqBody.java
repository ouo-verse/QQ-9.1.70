package tencent.im.oidb.cmd0xfa4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xfa4$ReqBody extends MessageMicro<oidb_cmd0xfa4$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"req_red", "rpt_req_list"}, new Object[]{null, null}, oidb_cmd0xfa4$ReqBody.class);
    public oidb_cmd0xfa4$ReqMsgBoardInfo req_red = new MessageMicro<oidb_cmd0xfa4$ReqMsgBoardInfo>() { // from class: tencent.im.oidb.cmd0xfa4.oidb_cmd0xfa4$ReqMsgBoardInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"type", "id", "lst_time_stamp"}, new Object[]{0, null, 0L}, oidb_cmd0xfa4$ReqMsgBoardInfo.class);
        public final PBEnumField type = PBField.initEnum(0);

        /* renamed from: id, reason: collision with root package name */
        public oidb_cmd0xfa4$SourceInfo f436001id = new oidb_cmd0xfa4$SourceInfo();
        public final PBUInt64Field lst_time_stamp = PBField.initUInt64(0);
    };
    public final PBRepeatMessageField<oidb_cmd0xfa4$ReqMsgBoardInfo> rpt_req_list = PBField.initRepeatMessage(oidb_cmd0xfa4$ReqMsgBoardInfo.class);
}
