package tencent.im.oidb.cmd0xc32;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc32$ReqBody extends MessageMicro<oidb_cmd0xc32$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"enum_op", "msg_set_req_body", "msg_get_req_body", "msg_check_req_body"}, new Object[]{1, null, null, null}, oidb_cmd0xc32$ReqBody.class);
    public final PBEnumField enum_op = PBField.initEnum(1);
    public oidb_cmd0xc32$SetVisibleListReqBody msg_set_req_body = new MessageMicro<oidb_cmd0xc32$SetVisibleListReqBody>() { // from class: tencent.im.oidb.cmd0xc32.oidb_cmd0xc32$SetVisibleListReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_operator", "uint64_feeds_id", "rpt_uint64_visible_uins"}, new Object[]{0L, 0L, 0L}, oidb_cmd0xc32$SetVisibleListReqBody.class);
        public final PBUInt64Field uint64_operator = PBField.initUInt64(0);
        public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0);
        public final PBRepeatField<Long> rpt_uint64_visible_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
    public oidb_cmd0xc32$GetVisibleListReqBody msg_get_req_body = new MessageMicro<oidb_cmd0xc32$GetVisibleListReqBody>() { // from class: tencent.im.oidb.cmd0xc32.oidb_cmd0xc32$GetVisibleListReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_feeds_id", "uint32_start_ix", "uint32_want_num"}, new Object[]{0L, 0, 0}, oidb_cmd0xc32$GetVisibleListReqBody.class);
        public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0);
        public final PBUInt32Field uint32_start_ix = PBField.initUInt32(0);
        public final PBUInt32Field uint32_want_num = PBField.initUInt32(0);
    };
    public oidb_cmd0xc32$CheckVisibilityReqBody msg_check_req_body = new MessageMicro<oidb_cmd0xc32$CheckVisibilityReqBody>() { // from class: tencent.im.oidb.cmd0xc32.oidb_cmd0xc32$CheckVisibilityReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_triads"}, new Object[]{null}, oidb_cmd0xc32$CheckVisibilityReqBody.class);
        public final PBRepeatMessageField<oidb_cmd0xc32$CheckTriad> rpt_triads = PBField.initRepeatMessage(oidb_cmd0xc32$CheckTriad.class);
    };
}
